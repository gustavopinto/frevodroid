package br.com.entropie.frevodroid.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Calendar {

	private String dayOfWeek, description, dayIcon;

	public Calendar(Context ctx, String dayIcon, String dayOfWeek, String description) {
		this.dayOfWeek = dayOfWeek;
		this.description = description;
		this.dayIcon= dayIcon;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getDescription(){
		return description;
	}
	
	public String getDayIcon() {
		return dayIcon + ".png";
	}
}
