package com.wisedu.fam.check;

import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wisedu.fam.R;
import com.wisedu.fam.add.hostcomputer.AddHostComputer;
import com.wisedu.fam.add.hostcomputer.AssetsTypeAdapter;
import com.wisedu.fam.help.EquipHelper;
import com.wisedu.fam.help.HttpUtil;
import com.wisedu.fam.help.MyToast;
import com.wisedu.fam.model.AssetType;
import com.wisedu.fam.model.Assets;
import com.wisedu.fam.model.Department;
import com.wisedu.fam.model.User;


/**
 * 根据二维码信息查找
 * 
 * @author zhicheng@mail.com
 * 
 */
public class CheckAsset extends Activity {
	MyToast myToast = new MyToast();
	private String checkCodeAboutUrl = "";
	private String equipId = null;
	private String userid = null;
	private String deptId = null;
	TextView textViewSearchAndAdd = null;
	private String assetTypeName[];
	private int assetTypeId[];
	private Assets assets;
	private Spinner spinner = null;
	private String getUrlAt = null;
	View textEntryView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_asset);
		Intent assetId = getIntent();
		equipId = assetId.getStringExtra("assetId");
		checkCodeAboutUrl = this.getString(R.string.homeurl)
				+ "/fixedAsset/inspection";
		getUrlAt = this.getString(R.string.homeurl) + "/departments";
		
		new Thread(runSearchAsset).start();
	}

	Handler serachAssetHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle data = msg.getData();
			String val = data.getString("value");
			if (val.equals("TIMEOUTERROR") || val.equals("OTHERERROR")
					|| val.equals("ERROR")) {
				myToast.showToast(getApplicationContext(), "网络超时");
			} else {
				Gson gson2 = new Gson();
				JsonParser jsonParser = new JsonParser();
				JsonObject jsonObject = (JsonObject) jsonParser.parse(val);
				int statusCodeString = Integer.parseInt(jsonObject.get(
						"statusCode").toString());
				if (statusCodeString == 0) {
					JsonObject dataObject = (JsonObject) jsonObject.get("data");
					JsonObject userObject = (JsonObject) dataObject
							.get("userInfo");
					JsonObject equipObject = (JsonObject) dataObject
							.get("faDetail");
					JsonObject typeObject = (JsonObject) dataObject
							.get("typeInfo");
					JsonObject departObject = (JsonObject) dataObject
							.get("deptInfo");
					TextView textView1 = (TextView) findViewById(R.id.textViewId);
					String tempString = "";
					assets = gson2.fromJson(equipObject, Assets.class);
					User user = gson2.fromJson(userObject, User.class);
					AssetType assetType = gson2.fromJson(typeObject,
							AssetType.class);
					Department department = gson2.fromJson(departObject,
							Department.class);
					tempString += EquipHelper.assetDetailsFromQrcode(assets,
							user, department, assetType);
					try {
						userid = user.getUserId();
					} catch (NullPointerException e) {
						userid = null;
					}
					if (userid == null) {
						textViewSearchAndAdd = (TextView) findViewById(R.id.textViewsearchandaddshare);
						textViewSearchAndAdd.setText(R.string.addtouser);
						Drawable drawable = getResources().getDrawable(
								R.drawable.addshare);
						drawable.setBounds(0, 0, drawable.getMinimumWidth(),
								drawable.getMinimumHeight());
						textViewSearchAndAdd.setCompoundDrawables(drawable,
								null, null, null);
						textViewSearchAndAdd
								.setOnClickListener(new OnClickListener() {
									@Override
									public void onClick(View arg0) {
										showAddDialog();
									}
								});
					} else {
						// Button button = (Button)findViewById(R.id.cancelAdd);
						// button.setVisibility(View.VISIBLE);
					}
					CharSequence richText = Html.fromHtml(tempString);
					textView1.setText(richText);
				}
			}
		}
	};

	/**
	 * 取消设备和人员关系
	 * 
	 * @param v
	 */
	public void cancelAddShare(View v) {

	}

	protected void showAddDialog() {
		
		LayoutInflater factory = LayoutInflater.from(this);
		textEntryView = factory.inflate(R.layout.dialogview, null);
		
		final EditText editTextName = (EditText) textEntryView
				.findViewById(R.id.editTextName);
		AlertDialog.Builder ad1 = new AlertDialog.Builder(this);
		ad1.setTitle(R.string.addtouser);
		ad1.setIcon(android.R.drawable.ic_dialog_info);
		ad1.setView(textEntryView);
		
		new Thread(runnableGet).start();
		
		ad1.setPositiveButton("确认派发", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				userid = editTextName.getText().toString();
				
				new Thread(runAllocAsset).start();
			}
		});
		ad1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {

			}
		});
		ad1.show();
	}

	/**
	 * run AllocAsset , add an asset to a user
	 */
	Runnable runAllocAsset = new Runnable() {
		@Override
		public void run() {
			Message msg = new Message();
			Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("faId", equipId);
			map.put("userId", userid);
			map.put("deptId", deptId);
			String json2 = httpUtil.post(
					CheckAsset.this.getString(R.string.homeurl)
							+ "/fixedasset/" + equipId + "/allocation", map);
			data.putString("value", json2);
			msg.setData(data);
			handlerAllocAsset.sendMessage(msg);
			// action completed , return the search underName Button
		}
	};

	Handler handlerAllocAsset = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle data = msg.getData();
			String val = data.getString("value");
			Gson gson2 = new Gson();
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(val);
			int statusCodeString = Integer.parseInt(jsonObject
					.get("statusCode").toString());
			if (statusCodeString == 0) {
				myToast.showToast(getApplicationContext(), "派发成功");
				new Thread(runSearchAsset).start();
			}
			textViewSearchAndAdd = (TextView) findViewById(R.id.textViewsearchandaddshare);
			textViewSearchAndAdd.setText(R.string.searchhim);
			Drawable drawable = getResources()
					.getDrawable(R.drawable.searchsel);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(),
					drawable.getMinimumHeight());
			textViewSearchAndAdd.setCompoundDrawables(drawable, null, null,
					null);

			textViewSearchAndAdd.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(CheckAsset.this, UnderName.class);
					intent.putExtra("userId", userid);
					startActivity(intent);
				}
			});
		}
	};

	Runnable runSearchAsset = new Runnable() {
		@Override
		public void run() {
			Message msg = new Message();
			Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("qrCode", equipId);
			String json2 = httpUtil.post(checkCodeAboutUrl, map);
			data.putString("value", json2);
			msg.setData(data);
			serachAssetHandler.sendMessage(msg);
		}
	};
	/**
	 * edit 
	 * @param view
	 */
	public void detailClick(View view) {
		// Intent intent = new Intent(CheckAsset.this, AssetDetails.class);
		// startActivity(intent);
		Intent intent = new Intent(CheckAsset.this, AddHostComputer.class);
		intent.putExtra("equipId", assets);
		startActivityForResult(intent, 100);

	}
	
	Handler handlerGet = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle data = msg.getData();
			String valAt = data.getString("valueAT");
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(valAt);
			int statusCodeString = Integer.parseInt(jsonObject
					.get("statusCode").toString());
			if (statusCodeString == 0) {
				JsonArray dataArray = (JsonArray) jsonObject.get("data");
				assetTypeName = new String[dataArray.size()];
				assetTypeId = new int[dataArray.size()];
				for (int i = 0; i < dataArray.size(); i++) {
					JsonObject type = (JsonObject) dataArray.get(i);
					String value = type.get("departmentName").toString();
					assetTypeName[i] = value;
					int key = Integer.parseInt(type.get("departmentId").toString());
					assetTypeId[i] = key;
				}
			}else{
				myToast.showToast(getApplicationContext(), "服务器异常");
			}
			initMySpinner();
		}
	};

	Runnable runnableGet = new Runnable() {
		@Override
		public void run() {
			Message msg = new Message();
			Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			String valueAt = httpUtil.get(getUrlAt);
			data.putString("valueAT", valueAt);
			msg.setData(data);
			handlerGet.sendMessage(msg);
		}
	};
	
	
	/**
	 * 初始化Spinner
	 */
	private void initMySpinner() {
		
		AssetsTypeAdapter adapter2 = new AssetsTypeAdapter(
				this, assetTypeName, assetTypeId);
		spinner = (Spinner)textEntryView.findViewById(R.id.mySpinner2);
		spinner.setAdapter(adapter2);
		spinner.setSelection(0, true);
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int position, long id) {
				if (adapterView.getId() == R.id.mySpinner2) {
					LinearLayout ll = (LinearLayout) view;
					TextView tv = (TextView) ll
							.findViewWithTag("tagTextViewID");
					myToast.showToast(getApplicationContext(),
							(String) tv.getText());
					deptId = (String) tv.getText();
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (20 == resultCode) {
			new Thread(runSearchAsset).start();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void searchClick(View view) {
		Intent intent = new Intent(CheckAsset.this, UnderName.class);
		intent.putExtra("userId", userid);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.check_asset, menu);
		return true;
	}

}
