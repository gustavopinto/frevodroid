package br.com.entropie.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Calendar {

	private String dayOfWeek, description;
	private int icon;

	public Calendar(Context ctx, int icon, String dayOfWeek, String description) {
		this.dayOfWeek = dayOfWeek;
		this.description = description;
		this.icon = icon;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getDescription(){
		return description;
	}
	
	public int getIcon() {
		return icon;
	}
	

}
