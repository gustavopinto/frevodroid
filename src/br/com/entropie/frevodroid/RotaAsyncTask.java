package br.com.entropie.frevodroid;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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

		// Formatando a URL com a latitude e longitude
		// de origem e destino.
		String urlRota = String.format(Locale.US,
				"http://maps.google.com/maps?f=d&hl=en&"
						+ "amp;saddr=%f,%f&daddr=%f,%f&ie=UTF8&"
						+ "amp;0&om=0&output=xml", params[0], params[1],
				params[2], params[3]);

		try {
			// Estabelecendo a conexão com o servidor
			URL url = new URL(urlRota);
			HttpURLConnection conexao = (HttpURLConnection) url
					.openConnection();
			conexao.connect();

			// Obtendo a lista de GeoPoints
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
			// Pega o GeoPoint do meio da lista p/ dar zoom
			GeoPoint p1 = result.get(result.size() / 2);

			// Cria o Overlay que vai desenhar a Rota
			RotaOverlay overlay = new RotaOverlay(result);
			mapView.getOverlays().add(overlay);

			// Centraliza no meio da rota
			mapView.getController().animateTo(p1);
		}
		dialog.dismiss();
	}

	private List<GeoPoint> getGeoPoints(InputStream is) {
		try {
			// Cria o documento XML
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlDocument = builder.parse(is);

			// Procura a TAG com a String que tem
			// todas as coordenadas
			Node coordenadasXML = xmlDocument
					.getElementsByTagName("LineString").item(0);

			// Guarda o conteúdo da TAG
			String coordenadasStr = coordenadasXML.getTextContent();

			// Cada coordenada é separada por espaço.
			// Aqui eu quebro para pegar todas as coordenadas
			String[] coordenadasArrayStr = coordenadasStr.split(" ");

			// Será montada uma lista de GeoPoints
			// a partir da lista de strings
			List<GeoPoint> geoPoints = new ArrayList<GeoPoint>();

			int length = coordenadasArrayStr.length;
			for (int i = 0; i < length; i++) {
				// Cada coordenada tem a latitude e longitude
				// separado por vírgula
				String[] long_lat = coordenadasArrayStr[i].split(",");

				// Criando o GeoPoint
				GeoPoint gp = new GeoPoint(
						(int) (Double.parseDouble(long_lat[1]) * 1E6),
						(int) (Double.parseDouble(long_lat[0]) * 1E6));
				// Adicionando na lista
				geoPoints.add(gp);
			}
			return geoPoints;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
