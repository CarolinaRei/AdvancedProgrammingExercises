package com.example.livros;

import android.content.ContentValues;
import android.database.Cursor;

public class Converte {
    public static ContentValues categoriaToContentValues(Categoria categoria){
        ContentValues valores = new ContentValues();

        valores.put(BdTableCategorias.CAMPO_DESCRICAO,categoria.getDescricao());
        return valores;
    }
    public static Categoria contentValuesToCategoria(ContentValues valores){
        Categoria categoria = new Categoria();

        categoria.setId(valores.getAsLong(BdTableCategorias._ID));
        categoria.setDescricao(valores.getAsString(BdTableCategorias.CAMPO_DESCRICAO));

        return categoria;
    }
    public static ContentValues livroToContentValues(Livro livro){
        ContentValues valores = new ContentValues();

        valores.put(BdTableLivros.CAMPO_TITULO_COMPLETO,livro.getTitulo());
        valores.put(BdTableLivros.CAMPO_CATEGORIA_COMPLETO,livro.getIdCategoria());

        return valores;
    }
    public static Livro contentValuesToLivro(ContentValues valores){
        Livro livro = new Livro();

        livro.setId(valores.getAsLong(BdTableLivros._ID));
        livro.setTitulo(valores.getAsString(BdTableLivros.CAMPO_TITULO_COMPLETO));
        livro.setIdCategoria(valores.getAsLong(BdTableLivros.CAMPO_CATEGORIA_COMPLETO));
        livro.setCategoria(valores.getAsString(BdTableLivros.CAMPO_CATEGORIA));

        return livro;

    }
    public static Livro cursorToLivro(Cursor cursor) {
        Livro livro = new Livro();

        livro.setId(cursor.getLong(cursor.getColumnIndex(BdTableLivros._ID)));
        livro.setTitulo(cursor.getString(cursor.getColumnIndex(BdTableLivros.CAMPO_TITULO_COMPLETO)));
        livro.setIdCategoria(cursor.getLong(cursor.getColumnIndex(BdTableLivros.CAMPO_CATEGORIA_COMPLETO)));
        livro.setCategoria(cursor.getString(cursor.getColumnIndex(BdTableLivros.CAMPO_CATEGORIA)));

        return livro;
    }
}
