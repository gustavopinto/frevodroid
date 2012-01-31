package br.com.entropie.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.entropie.R;
import br.com.entropie.entity.Calendar;

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

		Holder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(this.context).inflate(
					R.layout.calendar, null);

			holder = new Holder();
//			holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
			holder.txtDayOfWeek = (TextView) convertView.findViewById(R.id.txtDayOfWeek);
			holder.txtDescription = (TextView) convertView.findViewById(R.id.txtDescription);
			convertView.setTag(holder);

		} else {
			holder = (Holder) convertView.getTag();
		}

//		holder.imgIcon.setImageDrawable(calendar.getIcon());
		holder.txtDayOfWeek.setText(calendar.getDayOfWeek());
		holder.txtDescription.setText(calendar.getDescription());
		return convertView;
	}

	static class Holder {
		ImageView imgIcon;
		TextView txtDayOfWeek, txtDescription;
	}
}
