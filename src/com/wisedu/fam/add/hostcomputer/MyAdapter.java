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

public class MyAdapter extends BaseAdapter {

	private Context ctx;
	private int drawableIDs[];
	private int stringIDs[];

	public MyAdapter(Context ctx, int DrawableIDs[], int StringIDs[]) {
		this.ctx = ctx;
		this.drawableIDs = DrawableIDs;
		this.stringIDs = StringIDs;
	}

	public int getCount() {
		return drawableIDs.length;
	}

	public Object getItem(int position) {
		return drawableIDs[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout ll = new LinearLayout(ctx);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.setGravity(Gravity.CENTER);
		//ll.setPadding(0, 0, 0, 0);
		ImageView iv = new ImageView(ctx);
		iv.setImageResource(drawableIDs[position]);
		iv.setLayoutParams(new ViewGroup.LayoutParams(100, 70));
		ll.addView(iv);
		TextView tv = new TextView(ctx);
		tv.setText(stringIDs[position]);
		tv.setTextSize(14);
		tv.setTextColor(Color.BLACK);
		tv.setTag("tagTextView");
		ll.addView(tv);
		return ll;
	}
}
