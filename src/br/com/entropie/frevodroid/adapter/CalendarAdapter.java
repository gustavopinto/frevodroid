package br.com.entropie.frevodroid.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.entropie.frevodroid.R;
import br.com.entropie.frevodroid.entity.Calendar;

public class CalendarAdapter extends BaseAdapter {

	private Context context;
	private List<Calendar> calendar;

	public CalendarAdapter(Context context, List<Calendar> calendar) {
		this.context = context;
		this.calendar = calendar;
	}

	public int getCount() {
		return this.calendar.size();
	}

	public Object getItem(int position) {
		return this.calendar.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup group) {
		Calendar calendar = (Calendar) getItem(position);

		try {

			Holder holder;
			if (convertView == null) {
				convertView = LayoutInflater.from(this.context).inflate(
						R.layout.calendar, null);

				holder = new Holder();

				holder.txtDayOfWeek = (TextView) convertView
						.findViewById(R.id.txtDayOfWeek);
				holder.txtDescription = (TextView) convertView
						.findViewById(R.id.txtDescription);

				holder.imgIcon = (ImageView) convertView
						.findViewById(R.id.imgIcon);
				Bitmap bMap2 = null;

				bMap2 = BitmapFactory.decodeStream(this.context.getAssets()
						.open("Segunda-Feira.png"));
				holder.imgIcon.setImageBitmap(bMap2);

				convertView.setTag(holder);

			} else {
				holder = (Holder) convertView.getTag();
			}

			holder.txtDayOfWeek.setText(calendar.getDayOfWeek());
			holder.txtDescription.setText(calendar.getDescription());

			Bitmap bMap2 = null;
			bMap2 = BitmapFactory.decodeStream(this.context.getAssets().open("Segunda-Feira.png"));

			holder.imgIcon.setImageBitmap(bMap2);

			return convertView;

		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	static class Holder {
		ImageView imgIcon;
		TextView txtDayOfWeek, txtDescription;
	}
}
