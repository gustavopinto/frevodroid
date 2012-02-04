package br.com.entropie.frevodroid.activity;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import br.com.entropie.frevodroid.HelloOverlay;
import br.com.entropie.frevodroid.R;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Rota3Activity extends MapActivity {

	private MapView mapView;
	

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.maps);

		mapView = (MapView) findViewById(R.id.map);
		mapView.setBuiltInZoomControls(true);
		mapView.getController().setZoom(8);
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.frevodroid);
		HelloOverlay itemizedoverlay = new HelloOverlay(drawable);
		
		GeoPoint point = new GeoPoint(19240000,-99120000);
		OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
