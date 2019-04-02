package com.example.marcin.projectv1;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;
/**
 * Created by Marcin on 13.05.2018.
 */

public class Connect extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "records.db";
    private static final int    DATABASE_VERSION = 1;

    private boolean isIt=false;

    public Connect(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
       try{
        TableUtils.createTable(connectionSource, Record.class);
        }
        catch (Exception e) {
            Log.e("DATABASE","CANT'T CREATE DB", e);}
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) throws SQLException {
        try {
            TableUtils.dropTable(connectionSource, Record.class, true);
            onCreate(database, connectionSource);
        } catch (Exception e) {
            Log.e("DATABASE","CAN'T UPGRADE DB",e);
        }
    }

    public void insertRecord(Record record){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            dao.create(record);
        }
        catch (Exception e){
            Log.e("DATABASE","CAN'T INSERT INTO DB",e);
        }
    }

    public List<Record> getAll() {
        try {
            Dao<Record, Integer> dao = getDao(Record.class);
            List<Record> recs = dao.queryForAll();
            return recs;
        } catch (Exception e) {
            Log.e("DATABASE", "CAN'T GET ALL FROM DB", e);
            return null;
        }
    }

     public List<Record> getSpecific(){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            QueryBuilder<Record, Integer> qb = dao.queryBuilder();
            Where where = qb.where();
            if(Find.parameters.get(1)!=0) {where.eq("QUALITY",Find.parameters.get(1)); isIt=true;}

            if(Find.parameters.get(2)!=0 && isIt) {where.and(); where.eq("REPORT",Find.parameters.get(2));}
            if(Find.parameters.get(2)!=0 && !isIt) {where.eq("REPORT",Find.parameters.get(2)); isIt=true;}

            if(Find.parameters.get(3)!=0 && isIt) {where.and(); where.eq("PROMPTNESS",Find.parameters.get(3));}
            if(Find.parameters.get(3)!=0 && !isIt) {where.eq("PROMPTNESS",Find.parameters.get(3)); isIt=true;}

            if(Find.parameters.get(4)!=0 && isIt) {where.and(); where.eq("COMPLAINT",Find.parameters.get(4));}
            if(Find.parameters.get(4)!=0 && !isIt) {where.eq("COMPLAINT",Find.parameters.get(4)); isIt=true;}

            if(Find.parameters.get(5)!=0 && isIt) {where.and(); where.eq("CURRENT_COOPERATION",Find.parameters.get(5));}
            if(Find.parameters.get(5)!=0 && !isIt) {where.eq("CURRENT_COOPERATION",Find.parameters.get(5)); isIt=true;}

            if(Find.parameters.get(6)!=0 && isIt) {where.and(); where.eq("CONTACT",Find.parameters.get(6));}
            if(Find.parameters.get(6)!=0 && !isIt) {where.eq("CONTACT",Find.parameters.get(6));isIt=true;}

            if(!Find.emptyNick && isIt) {where.and().eq("NICK",Find.nick);}
            if(!Find.emptyNick && !isIt) {where.eq("NICK",Find.nick);}

            PreparedQuery<Record> preparedQuery = qb.prepare();
           List<Record> recs = dao.query(preparedQuery);
           return recs;
            }
        catch (Exception e){

           Log.e("DATABASE","NIE MA W BAZIE",e);
           return null;
            }
        }

        public void deleteAllRecords(){
         try{
             List<Record> r = getAll();
             if(r!=null) {
                 TableUtils.clearTable(getConnectionSource(), Record.class);
             }
         }
         catch (Exception e){
             Log.e("DATABASE","DELETE ALL ERROR",e);
         }
        }

    public void deleteSpecific(Integer a){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            DeleteBuilder<Record,Integer> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.where().eq("ID",a);
            deleteBuilder.delete();
        }
        catch (Exception e){
            Log.e("DATABASE","DELETES ERROR",e);
        }
    }

    public boolean ifIdExists(Integer a){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            Record r = dao.queryForId(a);
            if(r==null) return false; else return true;
        }
        catch (Exception e){
            Log.e("DATABASE","BRAK PODANEGO ID W BAZIE",e);
            return false;
        }
    }

    public Record getRecortToChange(Integer a){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            Record r = dao.queryForId(a);
            Main3Activity.dataToChange = r;
            return Main3Activity.dataToChange;
        }
        catch (Exception e){
            Log.e("DATABASE","PROBLEM W ZDOBYCIU REKORDU",e);
            return null;
        }
    }

    public void updateRecord(Integer a0, Integer a1, Integer a2, Integer a3, Integer a4, Integer a5, Integer a6, String s1, String s2){
        try{
            Dao<Record, Integer> dao = getDao(Record.class);
            UpdateBuilder<Record,Integer> updateBuilder = dao.updateBuilder();
            updateBuilder.updateColumnValue("QUALITY",a1);
            updateBuilder.updateColumnValue("REPORT",a2);
            updateBuilder.updateColumnValue("PROMPTNESS",a3);
            updateBuilder.updateColumnValue("COMPLAINT",a4);
            updateBuilder.updateColumnValue("CURRENT_COOPERATION",a5);
            updateBuilder.updateColumnValue("CONTACT",a6);
            updateBuilder.updateColumnValue("NICK",s1);
            updateBuilder.updateColumnValue("WARNINGS",s2);
            updateBuilder.where().eq("ID",a0);
            updateBuilder.update();
        }
        catch (Exception e){
            Log.e("DATABASE","UPDATE ERROR",e);
        }
    }
}

