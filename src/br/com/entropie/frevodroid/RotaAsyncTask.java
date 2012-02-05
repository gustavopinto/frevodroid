package br.com.entropie.frevodroid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;

public class RotaAsyncTask extends AsyncTask<Double, Void, List<GeoPoint>> {

	private ProgressDialog dialog;
	private MapView mapView;

	public RotaAsyncTask(MapView mapa) {
		mapView = mapa;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		dialog = ProgressDialog.show(mapView.getContext(), "Aguarde",
				"Calculando rota");
	}

	@Override
	protected List<GeoPoint> doInBackground(Double... params) {

		String urlRota = String
				.format(Locale.US,
						"http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f&output=kml",
						params[0], params[1], params[2], params[3]);

		try {
			URL url = new URL(urlRota);
			HttpURLConnection conexao = (HttpURLConnection) url
					.openConnection();
			conexao.connect();

			InputStream is = conexao.getInputStream();
			return getGeoPoints(is);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(List<GeoPoint> result) {
		super.onPostExecute(result);
		if (result != null) {
			GeoPoint p1 = result.get(result.size() / 2);
			RotaOverlay overlay = new RotaOverlay(result);
			mapView.getOverlays().add(overlay);
			mapView.getController().animateTo(p1);
		}
		dialog.dismiss();
	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		return sb.toString();
	}

	private List<GeoPoint> getGeoPoints(InputStream is) {
		try {

			String linhas = convertStreamToString(is);
			int inicio = linhas.indexOf("<LineString><coordinates>") + 25;
			int fim = linhas.indexOf("</coordinates></LineString>");

			String coordenadasStr = linhas.substring(inicio, fim);

			String[] coordenadas = coordenadasStr.split(" ");
			List<GeoPoint> geoPoints = new ArrayList<GeoPoint>();

			for (int i = 0; i < coordenadas.length; i++) {
				String[] coordenada = coordenadas[i].split(",");

				GeoPoint gp = new GeoPoint(
						(int) (Double.parseDouble(coordenada[1]) * 1E6),
						(int) (Double.parseDouble(coordenada[0]) * 1E6));
				geoPoints.add(gp);
			}
			return geoPoints;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
