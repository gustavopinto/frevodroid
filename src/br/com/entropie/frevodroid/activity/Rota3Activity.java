package br.com.entropie.frevodroid.activity;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import br.com.entropie.frevodroid.HelloOverlay;
import br.com.entropie.frevodroid.R;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Rota3Activity extends MapActivity implements LocationListener {

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

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.androidmarker);
		HelloOverlay itemizedoverlay = new HelloOverlay(drawable);

		GeoPoint point = getRecifePoint();
		OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!",
				"I'm in Mexico City!");

		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);

		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f,
				this);
	}

	private GeoPoint getRecifePoint() {
		return new GeoPoint(805428, -3488126);
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_I) {
//			mapView.getController().setZoom(mapView.getZoomLevel() + 1);
//			return true;
//		} else if (keyCode == KeyEvent.KEYCODE_O) {
//			mapView.getController().setZoom(mapView.getZoomLevel() - 1);
//			return true;
//		} else if (keyCode == KeyEvent.KEYCODE_S) {
//			mapView.setSatellite(true);
//			return true;
//		} else if (keyCode == KeyEvent.KEYCODE_M) {
//			mapView.setSatellite(false);
//			return true;
//		}
//		return false;
//	}

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
	}
