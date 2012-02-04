package br.com.entropie.frevodroid;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class HelloOverlay extends ItemizedOverlay {

	private List<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context ctx;

	public HelloOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	public HelloOverlay(Drawable defaultMarker, Context ctx) {
		super(defaultMarker);
		this.ctx = ctx;
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
}
