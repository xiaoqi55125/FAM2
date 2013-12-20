package com.wisedu.fam.check;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wisedu.fam.R;
import com.wisedu.fam.R.layout;
import com.wisedu.fam.R.menu;
import com.wisedu.fam.help.EquipHelper;
import com.wisedu.fam.help.HttpUtil;
import com.wisedu.fam.help.MyToast;
import com.wisedu.fam.model.AssetType;
import com.wisedu.fam.model.Assets;
import com.wisedu.fam.model.Department;
import com.wisedu.fam.model.Equipment;
import com.wisedu.fam.model.User;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;
/**
 * 设备详情
 * @author zhicheng
 *
 */
public class AssetDetails extends Activity {
	MyToast myToast = new MyToast();
	private String equipId = null;
	private String checkCodeUrl = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asset_details);
		Intent assetId = getIntent();
		equipId = assetId.getStringExtra("equipId");
		checkCodeUrl = this.getString(R.string.homeurl)
				+ "/fixedasset/"+equipId+"/info/";
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
				Gson gson = new Gson();
				JsonParser jsonParser = new JsonParser();
				JsonObject jsonObject = (JsonObject) jsonParser.parse(val);
				int statusCodeString =  Integer.parseInt(jsonObject.get("statusCode").toString()) ;
				if (statusCodeString == 0) {
					JsonObject dataObject = (JsonObject)jsonObject.get("data");
					JsonObject userObject = (JsonObject) dataObject
							.get("userInfo");
					JsonObject equipObject = (JsonObject) dataObject
							.get("faDetail");
					JsonObject typeObject = (JsonObject) dataObject
							.get("typeInfo");
					JsonObject departObject = (JsonObject) dataObject
							.get("deptInfo");
					Assets assets = gson.fromJson(equipObject, Assets.class);
					User user = gson.fromJson(userObject, User.class);
					AssetType assetType = gson.fromJson(typeObject,AssetType.class);
					Department department = gson.fromJson(departObject, Department.class);
					String tempString = "";
					tempString+= EquipHelper.assetDetailsFromQrcode(assets,user,department,assetType);
					TextView textView1 = (TextView)findViewById(R.id.textViewDetails);
					//tempString+=detailString;
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
			String json2 = httpUtil.get(checkCodeUrl);
			data.putString("value",json2);
		    msg.setData(data);
		    handler.sendMessage(msg);
	    }
	};


}
