package com.TP.Vivero.Model;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vivero";
    private static final String CREATE_TABLA1 = "CREATE TABLE planta (" +
            "idplanta TEXT, " +
            "nombre TEXT, " +
            "tempActual INT, " +
            "humedadActual INT, " +
            "luzActual INT, " +
            "hormona INT, " +
            "sustrato INT, " +
            "PRIMARY KEY (idplanta))";
    private static final String CREATE_TABLA2 = "CREATE TABLE etapa (" +
            "nombre TEXT, " +
            "temp"
}
