package br.com.entropie.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import br.com.entropie.adapter.CalendarAdapter;
import br.com.entropie.entity.Calendar;

public class FrevodroidActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List<Calendar> calendar = new ArrayList<Calendar>();
		
//		ImageView icon = (ImageView) findViewById(R.id.imgIcon);
//	    Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.date);	
//        icon.setImageBitmap(bMap);

		calendar.add(new Calendar(this, null, "Segunda-Feira", "Eto, Frevo, Maracatu"));
		calendar.add(new Calendar(this, null, "Terca-Feira", "Pato fu, Alceu valenca, Mundo livre SA, Frevodroid"));
		calendar.add(new Calendar(this, null, "Quarta-Feira", "Ivete e "));
		calendar.add(new Calendar(this, null, "Quinta-Feira", "Calypso"));

		setListAdapter(new CalendarAdapter(this, calendar));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Calendar calendar = (Calendar) l.getAdapter().getItem(position);
		
		Intent it = new Intent(this, TimeActivity.class);
		it.putExtra("calendar", calendar.getDayOfWeek());
		startActivity(it);
	}
}