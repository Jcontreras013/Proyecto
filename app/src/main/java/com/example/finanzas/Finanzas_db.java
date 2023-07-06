package com.example.finanzas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Finanzas_db extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "Finanzas.db";
    private static final int VERSION_BD;

    static {
        VERSION_BD = 1;
    }
    private static final String TABLA_INGRESOS ="CREATE TABLE ingresos (id INTEGER PRIMARY KEY, INTEGER ingresos, TEXT descripcion, INTEGER monto, DATE fecha )";
    private static final String TABLA_EGRESOS ="CREATE TABLE egresos (id INTEGER PRIMARY KEY, INTEGER egresos , TEXT descripcion, INTEGER monto, DATE fecha )";

    public Finanzas_db(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_INGRESOS);
        sqLiteDatabase.execSQL(TABLA_EGRESOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_INGRESOS);
        sqLiteDatabase.execSQL(TABLA_INGRESOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_EGRESOS);
        sqLiteDatabase.execSQL(TABLA_EGRESOS);

    }

    public void aggIngresos(String ingresos, String descripcion, String monto, String fecha){
        SQLiteDatabase bd= getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO TABLA_INGRESOS VALUES ('"+ingresos+"', '"+descripcion+"', '"+monto+"', '"+fecha+"')");
            String egresos = null;
            bd.execSQL("INSERT INTO TABLA_EGRESOS VALUES ('"+egresos+"', '"+descripcion+"', '"+monto+"', '"+fecha+"')");
            bd.close();
        }
    }

    //@Override
   // public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQLiteDatabase db = null;
        //db.execSQL("CREATE TABLE ingresos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
        //db.execSQL("CREATE TABLE egresos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
        //db.execSQL("CREATE TABLE saldos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
    //}

    //@Override
    //public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //SQLiteDatabase db = null;
        //db.execSQL("DROP  TABLE IF EXISTS ingresos");
        //db.execSQL("DROP  TABLE IF EXISTS egresos");
        //db.execSQL("DROP  TABLE IF EXISTS saldos");

        //onCreate(db);
    //}
}
