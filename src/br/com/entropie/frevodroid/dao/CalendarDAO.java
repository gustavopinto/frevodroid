package br.com.entropie.frevodroid.dao;

import android.content.ContentValues;
import android.content.Context;
import br.com.entropie.frevodroid.entity.Calendar;

public class CalendarDAO extends GenericDAO<Calendar> {

	public CalendarDAO(Context context) {
		super(context);
	}	

	public void insert(Calendar calendar) {
		super.insert(calendarToContent(calendar));
	}

	private ContentValues calendarToContent(Calendar calendar) {
		ContentValues cv = new ContentValues();
		cv.put("dayOfWeek", calendar.getDayOfWeek());
		cv.put("description", calendar.getDescription());
		return cv;
	}

}
