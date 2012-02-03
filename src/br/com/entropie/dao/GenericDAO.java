package br.com.entropie.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDAO<T> extends SQLiteOpenHelper {

	private static final int APP_VERSION = 1;
	private static final String DATA_BASE_NAME = "frevodroid";

	private Class<T> clazz;
	
	public GenericDAO(Context context) {
		super(context, DATA_BASE_NAME, null, APP_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void insert(ContentValues cv) {
		SQLiteDatabase db = getWritableDatabase();
		db.insert(this.clazz.getSimpleName(), null, cv);
		db.close();
	}

	public void update(Long id, ContentValues cv) {

		SQLiteDatabase db = getWritableDatabase();
		db.update(this.clazz.getSimpleName(), cv, "_id=?", new String[] { String.valueOf(id) });
		db.close();
	}

	public void delete(long id) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(this.getClass().getSimpleName(), "_id=" + id, null);
		db.close();
	}

	public List<T> findAll() {
		List<T> entity = new ArrayList<T>();

		SQLiteDatabase db = getWritableDatabase();
		Cursor results = db.query(this.getClass().getSimpleName(), null, null, null, null, null,
				null);

		while (results.moveToNext()) {
			
//			long id = results.getLong(0);
//			String nome = results.getString(1);
//			String placa = results.getString(results.getColumnIndex("placa"));
//
//			Carro c = new Carro(id, nome, placa);
//			carros.add(c);
		}

		results.close();
		db.close();
		return entity;
	}

}
