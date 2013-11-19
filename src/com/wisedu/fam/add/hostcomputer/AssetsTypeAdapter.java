package com.wisedu.fam.add.hostcomputer;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AssetsTypeAdapter extends BaseAdapter {

	private Context ctx;
	private String stringName[];
	private int stringIDs[];

	public AssetsTypeAdapter(Context ctx, String DrawableIDs[], int StringIDs[]) {
		this.ctx = ctx;
		this.stringName = DrawableIDs;
		this.stringIDs = StringIDs;
	}

	public int getCount() {
		return stringName.length;
	}

	public Object getItem(int position) {
		return stringName[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout ll = new LinearLayout(ctx);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.setGravity(Gravity.CENTER);
		TextView tv2 = new TextView(ctx);
		tv2.setText(stringName[position].replace('"', ' '));
		tv2.setTextSize(18);
		tv2.setPadding(0, 5, 0, 5);
		tv2.setTextColor(Color.BLACK);
		tv2.setTag("tagTextViewName");
		ll.addView(tv2);
		TextView tv = new TextView(ctx);
		tv.setText(stringIDs[position]+"");
		tv.setTextSize(14);
		tv.setTextColor(Color.BLACK);
		tv.setTag("tagTextViewID");
		ll.addView(tv);
		tv.setVisibility(View.GONE);
		return ll;
	}
}
