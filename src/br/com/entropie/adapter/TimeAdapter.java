package br.com.entropie.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.entropie.R;
import br.com.entropie.entity.Time;

public class TimeAdapter extends BaseAdapter {

	private List<Time> time;
	private Context ctx;

	public TimeAdapter(Context ctx, List<Time> time) {
		this.ctx = ctx;
		this.time = time;
	}

	public int getCount() {
		return this.time.size();
	}

	public Object getItem(int position) {
		return this.time.get(position);
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View view, ViewGroup group) {
		if (view == null) {
			view = LayoutInflater.from(this.ctx).inflate(R.layout.time, null);
			view.setTag(time);
		}

		Time time = (Time) getItem(position);

		TextView txtHour = (TextView) view.findViewById(R.id.txtHour);
		txtHour.setText(time.getTime());

		return view;
	}

}
