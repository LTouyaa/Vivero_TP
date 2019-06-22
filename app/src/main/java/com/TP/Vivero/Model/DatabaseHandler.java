package com.TP.Vivero.Model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.widget.LinearLayout;

import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    /**
     * Version de la Base de datos. No importante.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Nombre general de la base de datos.
     */
    private static final String DATABASE_NAME = "vivero";

    /**
     * Primera tabla, planta. Esta es la estrutura de las Plantas que almacena.
     * Solo tiene un edentificador unico (idplanta) que sirve para diferenciar una planta de otra
     * mediante el PRIMERY KEY.
     * También tendrá el nombre, qué es importante para las Etapas y porque será el modo con el que el usuario
     * va a buscar la planta que desea plantar.
     * El usuario ingresara un nombre y la app cargará los datos restantes.
     */
    private static final String CREATE_TABLA1 = "CREATE TABLE planta (" +
            "idplanta TEXT, " +
            "nombre TEXT, " +
            "PRIMARY KEY (idplanta))";

    /**
     * Segunda tabla, etapa. Esta es la estrucutra que tendrá cada etapa.
     * Para asociar una etapa con su respectiva planta se usara nombre.
     * Este nombre será el mismo que tiene la planta de esta manera se sabe que etapa pertenece a cada planta
     * (Las plantas se distinguen entre sí por el idplanta).
     * A su vez cada etapa tiene también su edad. De esta manera se distinguen entre las difrentes
     * etapas de una misma planta.
     * Entonces, la "conexcion" entre plantas y etapas queda de la siguiente manera:
     * Una planta tiene un id propio (idplanta), esto distingue a una de otras en la base de datos.
     * A su vez, esta planta tiene un nombre, la cual coincide con uno de los identificadores de la etapa que le pertence.
     * De esta manera se diferencia entre las etapas que pertenecen a diferentes plantas.
     * Por ultimo, cada etapa con igual nombre tiene diferente edad. De esta manera se diferencia entre diferentes
     * etapas de una misma planta.
     */
    private static final String CREATE_TABLA2 = "CREATE TABLE etapa (" +
            "nombre TEXT, " +
            "tempMax INT, " +
            "tempMin INT, " +
            "humMax INT, " +
            "humMin INT, " +
            "luzMax INT, " +
            "luzMin INT, " +
            "hormona INT, " +
            "sustrato INT, " +
            "duracion INT, " +
            "edad INT, " +
            "PRIMARY KEY (nombre, edad))";

    /**
     * Tercera tabla, plantadas. Esta base de datos será la que almacene las plantas plantadas en el vivero.
     * Al igual que las plantas de la primera tabla tendrá un dientificador unico y propio.
     * Pero además tiene los parametros de lo que estan midiendo los sensores de manera acutal.
     * Como ser temperatura actual (tempActual), el sustrato acutal (sustrato), etc.
     */
    private static final String CREATE_TABLA3 = "CREATE TABLE plantada (" +
            "idplanta TEXT, " +
            "nombre TEXT, " +
            "tempActual INT, " +
            "humedadActual INT, " +
            "luzActual INT, " +
            "hormona INT, " +
            "sustrato INT, " +
            "PRIMARY KEY (idplanta))";


    private Context context;

    /**
     * Contructor de la base de datos, será lo que utilice la activity.
     * @param context
     */
    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLA1);
        db.execSQL(CREATE_TABLA2);
        db.execSQL(CREATE_TABLA3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * Guarda una objeto planta en la base de datos.
     * @param planta
     */
    public void savePlanta(Planta planta){

        SQLiteDatabase db = getWritableDatabase();  //Agarro la base de datos para escribirla.

        ContentValues values = new ContentValues(); //Creo un contenedor con el que le voy a cargar. Sería el equivalente a los Bundle que usamos para transmitir
                                                    // datos entre Activitys.
        values.put("idplanta", planta.getId());     //Le cargo datos. put(key, valor). Muy parecido a un HashMap.
        values.put("nombre", planta.getNombre());

        if(this.existPlanta(planta.getId())) db.update("planta", values, "idplanta=?", new String[]{planta.getId()});
        else db.insert("planta", null, values);
        //Primero veo si el elemento ya existe en la base de datos, si es así lo actualizo y si no lo agrego.

        db.close(); //IMPORTANTISIMO, NO OLVIDAR!!!
    }

    /**
     * Comprueba la exista de dicho planta mediante la bsuqueda por su PRIMARY KEY
     * @param idplanta
     * @return
     */
    public boolean existPlanta(String idplanta){

        boolean aux = false;

        SQLiteDatabase db = getReadableDatabase();  //Ahora lo que hago es 'tomar' la base de datos, pero solo para leer.

        String sql = "SELECT * FROM planta WHERE idplanta=?";   //Comando de SQL: eligo la tabla 'planta', y su PRIMARY KEY se llama 'idplanta'.
        String[] argSql = new String[]{idplanta};   //Creo que array de Strings con el que le podria pasar todos los PRIMARY KEY que fueran necearios.
                                                    //En este caso es solamente idplanta.
        Cursor cursor = db.rawQuery(sql, argSql);   //Creo un cursos, que vendria a ser un puntero a la posicion que encuentre en la tabla con los parametros que le paso.

        if(cursor!=null && cursor.getCount()==1){   //Si lo encuentra ...

            cursor.moveToFirst();   //Muevo el cursor al principio de la tabla, nunca se sabe en donde esta exactamente por eso es necesario hacerlo siempre.
            aux = true;
        }
        return aux;
    }

    /**
     * Devuelve un obj. planta a partir del idplanta que se le pasa.
     * @param idplanta
     * @return
     */
    public Planta getPlantaByIdplanta(String idplanta){

        Planta planta = new Planta();   //Creo un objeto planta que será el que devuelva.

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM planta WHERE idplanta=?";
        String[] argSql = new String[]{idplanta};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()==1){   //Si el cursor encuentra la planta ...

            cursor.moveToFirst();   //Lo muevo al prinicpio, siempre necesario.

            planta.setId(cursor.getString(cursor.getColumnIndex("idplanta"))); //Y le cargo al obj. planta que quiero devolver los parametros que quiero que vaya a tener.
                                                                                            // Para eso, lo que hago es agarrar un valor String al que este apuntando el cursor (cursor.getString(index))
                                                                                            //Después, agarro el valor que se encuentra en la columna cuyo nombre coincide (cursor(getColumnIndex""))
            planta.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
        }
        db.close(); //Ciero la bd, importantisimo, no olvidar.
        return planta;
        //Notese que aunque el cursor no encuentre el obj. planta que buscaba, aun así este metodo medevolvera un obj. planta
        //Pero sus parametros estarán vacios.
        //CUIDADO CON ESO.
    }

    /**
     * Devuelve un List<Plantas> con todas las planas que tiene la base de datos.
     * @return
     */
    public List<Planta> getAllPlanta(){

        List<Planta> plantaList = new ArrayList<>();    //Primero creo el ArrayList que voy a devolver.

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM planta";    //Esta vez selecciono toda la talbla 'planta', note que no uso el PRIMARY KEY

        Cursor cursor = db.rawQuery(sql, null); //El argumento donde le diria la PRIMARY KEY es null porque quiero que agarre toda la tabla.

        if(cursor!=null &&  cursor.getCount()>0){   //Si la tabla no esta vacia ...
            cursor.moveToFirst();
            do{ //Si o si tiene que hacer esto una vez, por eso el do-while

                Planta planta = new Planta();   //obj. planta auxialiar que usare para ir rellenando con List<Plantas> que voy a devolver.

                planta.setId(cursor.getString(cursor.getColumnIndex("idplanta")));
                planta.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));

                plantaList.add(planta);
            } while (cursor.moveToNext());  //Una vez que hace lo que hay en el 'do', pasa a la siguiente posicion si es que existe.

            db.close();
            return plantaList;  //Devuelvo la lista al terminar.
        }

        db.close();
        return null;
        //En ese caso el metodo si que devolvera un NULL cuando la tabla este vacia.
        //OJO
    }

    /**
     *De acá para abajo es basicamente lo mimso, pero con las otras dos tablas.
     */


    public void saveEtapa(Etapa etapa){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nombre", etapa.getNombre());
        values.put("tempMax", etapa.getTempMax());
        values.put("tempMin", etapa.getTempMin());
        values.put("humMax", etapa.getHumMax());
        values.put("humMin", etapa.getHumMin());
        values.put("luzMax", etapa.getLuzMax());
        values.put("luzMin", etapa.getLuzMin());
        values.put("hormona", etapa.getHormona());
        values.put("sustrato", etapa.getSustrato());
        values.put("duracion", etapa.getDuracion());
        values.put("edad", etapa.getEdad());

        if(this.existEtapa(etapa.getNombre(), etapa.getEdad())) db.update("etapa", values, "nombre=? AND edad=?", new String[]{etapa.getNombre(), Integer.toString(etapa.getEdad())});
        else db.insert("etapa", null, values);

        db.close();
    }

    public boolean existEtapa(String nombre, int edad){

        boolean aux = false;

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM etapa WHERE nombre=? AND edad=?";
        String[] argSql = new String[]{nombre, Integer.toString(edad)};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()==1){
            cursor.moveToFirst();
            aux = true;
        }
        return aux;
    }

    public Etapa getEtapaByNombreEdad(String nombre, int edad){

        Etapa etapa = new Etapa();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM etapa WHERE nombre=? AND edad=?";
        String[] argSql = new String[]{nombre, Integer.toString(edad)};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()==1){

            cursor.moveToFirst();

            etapa.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            etapa.setTempMax(cursor.getInt(cursor.getColumnIndex("tempMax")));
            etapa.setTempMin(cursor.getInt(cursor.getColumnIndex("tempMin")));
            etapa.setHumMax(cursor.getInt(cursor.getColumnIndex("humMax")));
            etapa.setHumMin(cursor.getInt(cursor.getColumnIndex("humMin")));
            etapa.setLuzMax(cursor.getInt(cursor.getColumnIndex("luzMax")));
            etapa.setLuzMin(cursor.getInt(cursor.getColumnIndex("luzMin")));
            etapa.setHormona(cursor.getInt(cursor.getColumnIndex("hormona")));
            etapa.setSustrato(cursor.getInt(cursor.getColumnIndex("sustrato")));
            etapa.setDuracion(cursor.getInt(cursor.getColumnIndex("duracion")));
            etapa.setEdad(cursor.getInt(cursor.getColumnIndex("edad")));
        }
        db.close();
        return etapa;
    }

    public List<Etapa> getAllEtapa(){

        List<Etapa> etapaList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM etapa";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{

                Etapa etapa = new Etapa();

                etapa.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                etapa.setTempMax(cursor.getInt(cursor.getColumnIndex("tempMax")));
                etapa.setTempMin(cursor.getInt(cursor.getColumnIndex("tempMin")));
                etapa.setHumMax(cursor.getInt(cursor.getColumnIndex("humMax")));
                etapa.setHumMin(cursor.getInt(cursor.getColumnIndex("humMin")));
                etapa.setLuzMax(cursor.getInt(cursor.getColumnIndex("luzMax")));
                etapa.setLuzMin(cursor.getInt(cursor.getColumnIndex("luzMin")));
                etapa.setHormona(cursor.getInt(cursor.getColumnIndex("hormona")));
                etapa.setSustrato(cursor.getInt(cursor.getColumnIndex("sustrato")));
                etapa.setDuracion(cursor.getInt(cursor.getColumnIndex("duracion")));
                etapa.setEdad(cursor.getInt(cursor.getColumnIndex("edad")));

                etapaList.add(etapa);
            } while (cursor.moveToNext());

            db.close();
            return etapaList;
        }
        db.close();
        return null;
    }

    public List<Etapa> getAllEtapaByName(String nombre){

        List<Etapa> etapaList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM etapa WHERE nombre=?";
        String[] argSql = new String[]{nombre};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{

                Etapa etapa = new Etapa();

                etapa.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                etapa.setTempMax(cursor.getInt(cursor.getColumnIndex("tempMax")));
                etapa.setTempMin(cursor.getInt(cursor.getColumnIndex("tempMin")));
                etapa.setHumMax(cursor.getInt(cursor.getColumnIndex("humMax")));
                etapa.setHumMin(cursor.getInt(cursor.getColumnIndex("humMin")));
                etapa.setLuzMax(cursor.getInt(cursor.getColumnIndex("luzMax")));
                etapa.setLuzMin(cursor.getInt(cursor.getColumnIndex("luzMin")));
                etapa.setHormona(cursor.getInt(cursor.getColumnIndex("hormona")));
                etapa.setSustrato(cursor.getInt(cursor.getColumnIndex("sustrato")));
                etapa.setDuracion(cursor.getInt(cursor.getColumnIndex("duracion")));
                etapa.setEdad(cursor.getInt(cursor.getColumnIndex("edad")));

                etapaList.add(etapa);
            } while (cursor.moveToNext());

            db.close();
            return etapaList;
        }
        db.close();
        return null;
    }

    public void savePlantadas(Planta planta){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("idplanta", planta.getId());
        values.put("nombre", planta.getNombre());
        values.put("tempActual", planta.getTempActual());
        values.put("humedadActual", planta.getHumedadActual());
        values.put("luzActual", planta.getLuzActual());
        values.put("hormona", planta.getHormona());
        values.put("sustrato", planta.getSustrato());

        if(this.existPlantada(planta.getId())) db.update("plantada", values, "idplanta=?", new String[]{planta.getId()});
        else db.insert("plantada", null, values);

        db.close();
    }

    public boolean existPlantada(String idplanta){

        boolean aux = false;

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM plantada WHERE idplanta=?";
        String[] argSql = new String[]{idplanta};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()==1){

            cursor.moveToFirst();
            aux = true;
        }
        return aux;
    }

    public Planta getPlantadaByIdplanta(String idplanta){

        Planta planta = new Planta();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM plantada WHERE idplanta=?";
        String[] argSql = new String[]{idplanta};

        Cursor cursor = db.rawQuery(sql, argSql);

        if(cursor!=null && cursor.getCount()==1){

            cursor.moveToFirst();

            planta.setId(cursor.getString(cursor.getColumnIndex("idplanta")));
            planta.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            planta.setTempActual(cursor.getInt(cursor.getColumnIndex("tempActual")));
            planta.setHumedadActual(cursor.getInt(cursor.getColumnIndex("humedadActual")));
            planta.setLuzActual(cursor.getInt(cursor.getColumnIndex("luzActual")));
            planta.setHormona(cursor.getInt(cursor.getColumnIndex("hormona")));
            planta.setSustrato(cursor.getInt(cursor.getColumnIndex("sustrato")));
        }
        db.close();
        return planta;
    }

    public List<Planta> getAllPlantada(){

        List<Planta> plantadaList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM plantada";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor!=null &&  cursor.getCount()>0){
            cursor.moveToFirst();
            do{

                Planta planta = new Planta();

                planta.setId(cursor.getString(cursor.getColumnIndex("idplanta")));
                planta.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                planta.setTempActual(cursor.getInt(cursor.getColumnIndex("tempActual")));
                planta.setHumedadActual(cursor.getInt(cursor.getColumnIndex("humedadActual")));
                planta.setLuzActual(cursor.getInt(cursor.getColumnIndex("luzActual")));
                planta.setHormona(cursor.getInt(cursor.getColumnIndex("hormona")));
                planta.setSustrato(cursor.getInt(cursor.getColumnIndex("sustrato")));

                plantadaList.add(planta);
            } while (cursor.moveToNext());

            db.close();
            return plantadaList;
        }

        db.close();
        return null;
    }
}








/**
 * En caso de no entender nada o dudas, hagase un bollito y llore.
 */
