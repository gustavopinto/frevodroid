package br.com.entropie.activity;

import android.os.Bundle;
import br.com.entropie.R;

import com.google.android.maps.MapActivity;

public class MapsActivity extends MapActivity {

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.maps);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
}
