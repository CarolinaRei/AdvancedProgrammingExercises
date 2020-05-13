package com.example.livros;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableCategorias implements BaseColumns {
    private SQLiteDatabase db;
    public BdTableCategorias(SQLiteDatabase db){
        this.db = db;
    }
    public void cria (){
        db.execSQL(
                "CREATE Table categorias(" +
                 _ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "descricao TEXT NOT NULL"+
                        ")"
        );
    }
}
