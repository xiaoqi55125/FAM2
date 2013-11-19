package com.wisedu.fam.add;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wisedu.fam.R;

public class EquipTypeSelectListAdapter extends
		ArrayAdapter<EquipTypeSelectList> {
	private ListView listView;
	private LayoutInflater inflater;
	private Context context;

	public EquipTypeSelectListAdapter(Activity activity,
			List<EquipTypeSelectList> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);
		this.listView = listView;
		inflater = activity.getLayoutInflater();
		this.context = activity;

	}

	public View getView(int position,View convertView,ViewGroup parent) {
		Holder holder;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.asset_type_select_list, null);
			holder=new Holder();
			holder.imageView=(ImageView)convertView.findViewById(R.id.imageView_type);
			holder.textID=(TextView)convertView.findViewById(R.id.asset_type_id);
			holder.textType=(TextView)convertView.findViewById(R.id.asset_type_info);
			convertView.setTag(holder);
		}else{
			holder=(Holder)convertView.getTag();
		}
		EquipTypeSelectList imageAndText = getItem(position);
        AssetManager manager = context.getAssets();
        try {
            InputStream open = manager.open(imageAndText.getTypeImage());
            Bitmap bitmap = BitmapFactory.decodeStream(open);
            holder.imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        holder.textID.setText(imageAndText.getTypeId());
        holder.textType.setText(imageAndText.getTypeName());
		return convertView;
	}

	static class Holder {
		TextView textID;
		TextView textType;
		ImageView imageView;
	}

}
