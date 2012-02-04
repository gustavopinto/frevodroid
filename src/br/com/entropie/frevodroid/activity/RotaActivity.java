package br.com.entropie.frevodroid.activity;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.google.android.maps.MapView.LayoutParams;  
import android.widget.LinearLayout;
import br.com.entropie.frevodroid.HelloOverlay;
import br.com.entropie.frevodroid.R;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class RotaActivity extends MapActivity {

	private MapView mapView;
	

	public void onCreate(Bundle instance) {
		super.onCreate(instance);
		setContentView(R.layout.maps);

		mapView = (MapView) findViewById(R.id.map);
		LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
        View zoomView = mapView.getZoomControls(); 
          
		
        zoomLayout.addView(zoomView, 
                new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, 
                    LayoutParams.WRAP_CONTENT)); 
        
        mapView.displayZoomControls(true);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
