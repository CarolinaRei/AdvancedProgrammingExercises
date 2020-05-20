package com.example.livros;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BdLivrosTest {
    @Before
    public void apagaBaseDados(){
        getTargetContext().deleteDatabase(BdLivrosOpenHelper.NOME_BASE_DADOS);
    }
    @Test
    public void consegueAbrirBaseDados() {
        // Context of the app under test.
        Context appContext = getTargetContext();

        BdLivrosOpenHelper openHelper = new BdLivrosOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getReadableDatabase();

        assertTrue(bd.isOpen());
        bd.close();
    }

    private Context getTargetContext() {
        return InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void consegueInserirCategorias(){
        Context appContext = getTargetContext();

        BdLivrosOpenHelper openHelper = new BdLivrosOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BdTableCategorias tabelaCategorias = new BdTableCategorias(bd);

        Categoria categoria = new Categoria();
        categoria.setDescricao("Ação");

        long id = tabelaCategorias.insert(Converte.categoriaToContentValues(categoria));
        assertNotEquals(-1,id);

       // tabelaCategorias.insert();

        //TODO: inserir categorias e verificar se não houve erros
        bd.close();
    }
    @Test
    public void consegueLerCategorias(){
        Context appContext = getTargetContext();

        BdLivrosOpenHelper openHelper = new BdLivrosOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BdTableCategorias tabelaCategorias = new BdTableCategorias(bd);
        Cursor cursor =  tabelaCategorias.query(BdTableCategorias.TODOS_CAMPOS,null,null,null,null,null);
        int registos = cursor.getCount();
        cursor.close();
        Categoria categoria = new Categoria();
        categoria.setDescricao("Sci-fi");

        long id = tabelaCategorias.insert(Converte.categoriaToContentValues(categoria));
        assertNotEquals(-1,id);

        cursor =tabelaCategorias.query(BdTableCategorias.TODOS_CAMPOS,null,null,null,null,null);
        assertEquals(registos +1,cursor.getCount());
        cursor.close();

        bd.close();
    }
    @Test
    public void consegueAtualizarCategorias(){
        Context appContext = getTargetContext();

        BdLivrosOpenHelper openHelper = new BdLivrosOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BdTableCategorias tabelaCategorias = new BdTableCategorias(bd);

        Categoria categoria = new Categoria();
        categoria.setDescricao("Romanc");

        long id = tabelaCategorias.insert(Converte.categoriaToContentValues(categoria));
        assertNotEquals(-1,id);

        categoria.setDescricao("Romance");
        int registosAlterados = tabelaCategorias.update(Converte.categoriaToContentValues(categoria),BdTableCategorias._ID + "=?",new String[]{String.valueOf(id) });
         assertEquals(1,registosAlterados);

        bd.close();
    }
    @Test
    public void consegueApagarCategoria(){
        Context appContext = getTargetContext();

        BdLivrosOpenHelper openHelper = new BdLivrosOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BdTableCategorias tabelaCategorias = new BdTableCategorias(bd);

        Categoria categoria = new Categoria();
        categoria.setDescricao("TESTE");

        long id = tabelaCategorias.insert(Converte.categoriaToContentValues(categoria));
        assertNotEquals(-1,id);

        int registosApagados =tabelaCategorias.delete(BdTableCategorias._ID + "=?",new String[]{String.valueOf(id) });
        assertEquals(1,registosApagados);

        bd.close();
    }
}
