package br.com.entropie.dao;

import br.com.entropie.entity.Calendar;
import android.content.ContentValues;
import android.content.Context;

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
