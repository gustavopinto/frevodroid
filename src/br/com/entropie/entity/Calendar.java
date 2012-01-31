package br.com.entropie.entity;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Calendar {

	private String dayOfWeek, description;
	private Drawable icon;

	public Calendar(Context ctx, Drawable icon, String dayOfWeek, String description) {
		this.dayOfWeek = dayOfWeek;
		this.description = description;
		this.icon = icon;
//		PackageManager pm = ctx.getPackageManager();
//		try {
//			this.icon = pm.getActivityIcon(intent);
//		} catch (NameNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getDescription(){
		return description;
	}
	
	public Drawable getIcon() {
		return icon;
	}
	

}
