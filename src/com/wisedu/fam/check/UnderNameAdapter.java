package com.wisedu.fam.check;

import java.util.List;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wisedu.fam.R;

public class UnderNameAdapter extends
		ArrayAdapter<AssetOneList> {

	private LayoutInflater inflater;

	public UnderNameAdapter(Activity activity,
			List<AssetOneList> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);
		inflater = activity.getLayoutInflater();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.asset_one_list,
					null);
			holder = new Holder();
			holder.textID = (TextView) convertView
					.findViewById(R.id.asset_about_id);
			holder.valueString = (TextView) convertView
					.findViewById(R.id.asset_info);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		AssetOneList imageAndText = getItem(position);
		holder.textID.setText(imageAndText.getTextID());
		CharSequence richText = Html.fromHtml(imageAndText.getValueString().substring(0, imageAndText.getValueString().length()-4));
		holder.valueString.setText(richText);
		//holder.valueString.setText(imageAndText.getValueString());
		return convertView;
	}

	static class Holder {
		TextView textID;
		TextView valueString;
	}

}
