package com.example.livros;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

    public class BdTableLivros implements BaseColumns{
        private final SQLiteDatabase db;
        public BdTableLivros(SQLiteDatabase db){
            this.db = db;
        }
        public void cria(){

        }
    }

