package com.example.livros;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Fragment fragmentActual = null;
    public void setFragmentActual(Fragment fragmentActual){
        this.fragmentActual=fragmentActual;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_livros, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_inserir_livro){
            ((ListaLivroFragment) fragmentActual).novoLivro();
            //TODO: inserir livro
            return true;
        }else if (id == R.id.action_alterar_livro){
            ((ListaLivroFragment)fragmentActual).alterarLivro();
            //TODO: alterar livro
            return true;
        }else if (id == R.id.action_eliminar_livro){
            //TODO: eliminar livro
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}