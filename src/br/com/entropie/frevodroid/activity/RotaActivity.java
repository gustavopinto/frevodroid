package br.com.entropie.frevodroid.activity;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import br.com.entropie.frevodroid.R;
import br.com.entropie.frevodroid.RotaAsyncTask;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class RotaActivity extends MapActivity implements LocationListener {

	private MapView mapView;
	private MapController mapController;
	private GeoPoint geoPoint;

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.maps);

		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);
		mapView.displayZoomControls(true);

		mapController = mapView.getController();

		mapController.setCenter(getRecifePoint());
		mapController.setZoom(14);
		
		new RotaAsyncTask(mapView).execute(  
			      -8.282503, -35.981941,  
			      -8.0424, -34.8949);  
	}

	public void onLocationChanged(Location location) {
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			this.geoPoint = new GeoPoint((int) lat * 1000000,
					(int) lng * 1000000);
			mapController.animateTo(geoPoint);
		}
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}

	private GeoPoint getRecifePoint() {
		return new GeoPoint(-8197218, -34904251);
	}

}
