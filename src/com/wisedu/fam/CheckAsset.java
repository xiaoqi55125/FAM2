package com.wisedu.fam;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

import com.wisedu.fam.help.HttpUtil;
import com.wisedu.fam.help.MyToast;

public class CheckAsset extends Activity {
	MyToast myToast = new MyToast();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_asset);
		Intent assetId = getIntent();
		String assetIdString = assetId.getStringExtra("assetId");
//		String url = this.getString(R.string.homeurl)
//				+ "/user/"+assetIdString;
		new Thread(runnable).start();
	}
	
	Handler handler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	        super.handleMessage(msg);
	        Bundle data = msg.getData();
	        String val = data.getString("value");
	        
	    }
	};

	Runnable runnable = new Runnable(){
	    @Override
	    public void run() {
	        Message msg = new Message();
	        Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			String jsonString = httpUtil.get("http://172.16.206.16:8088/user/01312100");
			HashMap<String, String> map = new HashMap<String, String>() ;
			map.put("qrCode", "123");
			String json2 = httpUtil.post("http://172.16.206.16:8088/fixedAsset/inspeck", map);
	        data.putString("value",jsonString);
	        msg.setData(data);
	        handler.sendMessage(msg);
	    }
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_asset, menu);
		return true;
	}

}
