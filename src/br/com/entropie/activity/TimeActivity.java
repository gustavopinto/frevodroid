package br.com.entropie.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import br.com.entropie.adapter.TimeAdapter;
import br.com.entropie.entity.Time;

public class TimeActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Time> time = new ArrayList<Time>();

		for (int i = 0; i < 9; i++) {
			time.add(new Time("0" + i +":00"));
		}
		
		setListAdapter(new TimeAdapter(this, time));
	}

}
