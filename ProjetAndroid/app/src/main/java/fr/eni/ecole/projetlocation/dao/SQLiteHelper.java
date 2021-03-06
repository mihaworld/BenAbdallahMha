package fr.eni.ecole.projetlocation.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.eni.ecole.projetlocation.dao.agence.IAgenceContract;
import fr.eni.ecole.projetlocation.dao.agent.IAgentContract;
import fr.eni.ecole.projetlocation.dao.client.IClientContract;
import fr.eni.ecole.projetlocation.dao.edl.IEDLContract;
import fr.eni.ecole.projetlocation.dao.location.ILocationContract;
import fr.eni.ecole.projetlocation.dao.photo.IPhotoContract;
import fr.eni.ecole.projetlocation.dao.vehicule.IVehiculeContract;

/**
 * Created by Administrateur on 20/10/2017.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "location.db";
    private static final int DATABASE_VERSION = 15;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(IAgenceContract.CREATE_TABLE_AGENCE);
        sqLiteDatabase.execSQL(IAgenceContract.INSERT_AGENCE);
        Log.wtf("Création de l'agence", "===>"+IAgenceContract.INSERT_AGENCE);
        sqLiteDatabase.execSQL(IAgentContract.CREATE_TABLE_AGENTS);
        sqLiteDatabase.execSQL(IAgentContract.INSERT_AGENT);
        Log.wtf("Création de l'agent", "===>"+IAgentContract.INSERT_AGENT);
        sqLiteDatabase.execSQL(IClientContract.CREATE_TABLE_CLIENTS);
        sqLiteDatabase.execSQL(IEDLContract.CREATE_TABLE_EDLS);
        sqLiteDatabase.execSQL(ILocationContract.CREATE_TABLE_LOCATIONS);
        sqLiteDatabase.execSQL(IPhotoContract.CREATE_TABLE_PHOTOS);
        sqLiteDatabase.execSQL(IVehiculeContract.CREATE_TABLE_VEHICULES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IAgenceContract.TABLE_AGENCE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IAgentContract.TABLE_AGENTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IClientContract.TABLE_CLIENTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IEDLContract.TABLE_EDLS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ILocationContract.TABLE_LOCATIONS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IPhotoContract.TABLE_PHOTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + IVehiculeContract.TABLE_VEHICULES);
        onCreate(sqLiteDatabase);
    }
}
