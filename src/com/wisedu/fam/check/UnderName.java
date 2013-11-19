package com.wisedu.fam.check;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wisedu.fam.R;
import com.wisedu.fam.help.EquipHelper;
import com.wisedu.fam.help.HttpUtil;
import com.wisedu.fam.help.MyToast;
import com.wisedu.fam.model.Assets;
/**
 * 用户名下
 * @author zhicheng
 *
 */
public class UnderName extends Activity {
	MyToast myToast = new MyToast();
	private String userId = null;
	private String checkCodeUrl = null;
	private ListView listView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_under_name);
		Intent assetId = getIntent();
		userId = assetId.getStringExtra("userId");
		checkCodeUrl = this.getString(R.string.homeurl)
				+ "/user/"+userId+"/fixedassets";
		new Thread(runnable).start();
	}
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	        super.handleMessage(msg);
	        Bundle data = msg.getData();
	        String val = data.getString("value");
	        if (val.equals("TIMEOUTERROR") || val.equals("OTHERERROR")  || val.equals("ERROR")) {
	        	myToast.showToast(getApplicationContext(), "网络超时");
			}else {
				JsonParser jsonParser = new JsonParser();
				JsonObject jsonObject = (JsonObject) jsonParser.parse(val);
				int statusCodeString =  Integer.parseInt(jsonObject.get("statusCode").toString()) ;
				if (statusCodeString == 0) {
					JsonArray jsonArray = (JsonArray)jsonObject.get("data");
					listView = (ListView) findViewById(R.id.listViewUnderName);
					List<AssetOneList> dataArray = new ArrayList<AssetOneList>();
					for (int i = 0; i < jsonArray.size(); i++) {
						JsonObject jsonObject2 = (JsonObject)jsonArray.get(i);
						Gson gson = new Gson();
						Assets asset = gson.fromJson(jsonObject2, Assets.class);
						AssetOneList assetOneList = new AssetOneList(asset.getNewId(),
								EquipHelper.equipStringUnderName(asset,"br"));
						dataArray.add(assetOneList);
					}
					UnderNameAdapter adapter = new UnderNameAdapter(
							UnderName.this, dataArray, listView);
					listView.setAdapter(adapter);
					listView.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int arg2, long arg3) {
							String equipId = ((TextView) arg1
									.findViewById(R.id.asset_about_id))
									.getText().toString();
							Intent intent = new Intent(UnderName.this,
									AssetDetails.class);
							intent.putExtra("equipId", equipId);
							startActivity(intent);
						}
					});
				}
			}
	    }
	};

	Runnable runnable = new Runnable(){
	    @Override
	    public void run() {
	        Message msg = new Message();
	        Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			String json2 = httpUtil.get(checkCodeUrl);
			data.putString("value",json2);
		    msg.setData(data);
		    handler.sendMessage(msg);
	    }
	};

//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.under_name, menu);
//		return true;
//	}

}
