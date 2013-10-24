package com.wisedu.fam.check;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wisedu.fam.R;
import com.wisedu.fam.help.EquipHelper;
import com.wisedu.fam.help.HttpUtil;
import com.wisedu.fam.help.MyToast;
import com.wisedu.fam.model.Equipment;
import com.wisedu.fam.model.User;

public class CheckAsset extends Activity  {
	MyToast myToast = new MyToast();
	private String checkCodeAboutUrl = "";
	private String equipId = null;
	private String userid = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_asset);
		Intent assetId = getIntent();
		equipId = assetId.getStringExtra("assetId");
		checkCodeAboutUrl = this.getString(R.string.homeurl)
				+ "/fixedAsset/inspection";
		new Thread(runnable).start();
	}
	
	Handler handler = new Handler(){
	    @Override
	    public void handleMessage(Message msg) {
	        super.handleMessage(msg);
	        Bundle data = msg.getData();
	        String val = data.getString("value");
	        if (val.equals("TIMEOUTERROR") || val.equals("OTHERERROR")  || val.equals("ERROR")) {
	        	myToast.showToast(getApplicationContext(), "网络超时");
			}else {
				//myToast.showToast(getApplicationContext(), val);
				Gson gson = new Gson();
				JsonParser jsonParser = new JsonParser();
				JsonObject jsonObject = (JsonObject) jsonParser.parse(val);
				int statusCodeString =  Integer.parseInt(jsonObject.get("statusCode").toString()) ;
				if (statusCodeString == 0) {
					JsonObject dataObject = (JsonObject)jsonObject.get("data");
					JsonObject userObject = (JsonObject)dataObject.get("userDetail");
					JsonObject equipObject = (JsonObject)dataObject.get("faDetail");
					Equipment equipment = gson.fromJson(equipObject, Equipment.class);
					User user = gson.fromJson(userObject, User.class);
					TextView textView1 = (TextView)findViewById(R.id.textViewId);
					String tempString = "";
					tempString+=EquipHelper.equipString(equipment,"p");
					if (user.getUserName()!=null) {
						tempString+="<p>领用人:"+user.getUserName()+"</p>";
					}
					if (user.getUserId()!=null) {
						tempString+="<p>工 号:"+user.getUserId()+"</p>";
						userid=user.getUserId();
					}
					if (user.getPhone()!=null) {
						tempString+="<p>电 话:"+user.getPhone()+"</p>";
					}
					if (user.getMail()!=null) {
						tempString+="<p>邮 箱:"+user.getMail()+"</p>";
					}
					if (user.getDepartment()!=null) {
						tempString+="部 门:"+"<br>"+user.getDepartment().replace("@", "<br>")+"<br>";
					}
					CharSequence richText = Html.fromHtml(tempString);
					textView1.setText(richText);
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
			HashMap<String, String> map = new HashMap<String, String>() ;
			map.put("qrCode", equipId);
			String json2 = httpUtil.post(checkCodeAboutUrl, map);
			data.putString("value",json2);
		    msg.setData(data);
		    handler.sendMessage(msg);
	    }
	};
	
	public void detailClick(View view){
		Intent intent = new Intent(CheckAsset.this,AssetDetails.class);
		intent.putExtra("equipId", equipId);
		startActivity(intent);
	}
	public void searchClick(View view){
		Intent intent = new Intent(CheckAsset.this,UnderName.class);
		intent.putExtra("userId", userid);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.check_asset, menu);
		return true;
	}

}
