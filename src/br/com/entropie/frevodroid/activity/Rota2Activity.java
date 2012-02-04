package br.com.entropie.frevodroid.activity;

import android.os.Bundle;
import br.com.entropie.frevodroid.R;
import br.com.entropie.frevodroid.RotaAsyncTask;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class Rota2Activity extends MapActivity {

	private MapView mapView;

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.maps);

		mapView = (MapView) findViewById(R.id.map);
		mapView.setBuiltInZoomControls(true);
		mapView.getController().setZoom(8);

		new RotaAsyncTask(mapView).execute(
		// Latitude, Logintude de Origem
				-8.282503, -35.981941,
				// Latitude, Longitude de Destino
				-8.062969, -34.87215);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
