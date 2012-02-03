package br.com.entropie.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import br.com.entropie.R;
import br.com.entropie.adapter.CalendarAdapter;
import br.com.entropie.entity.Calendar;

public class FrevodroidActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List<Calendar> calendar = new ArrayList<Calendar>();
		
		calendar.add(new Calendar(this, R.id.imgIcon, "Quarta-Feira", "Ivete e "));
		calendar.add(new Calendar(this, R.id.imgIcon, "Quinta-Feira", "Calypso"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Sexta-Feira", "Eto, Frevo, Maracatu"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Sábado", "Eto, Frevo, Maracatu"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Domingo", "Eto, Frevo, Maracatu"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Segunda-Feira", "Eto, Frevo, Maracatu"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Terca-Feira", "Pato fu, Alceu valenca, Mundo livre SA, Frevodroid"));
		calendar.add(new Calendar(this, R.id.imgIcon, "Quarta", "Pato fu, Alceu valenca, Mundo livre SA, Frevodroid"));
		
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