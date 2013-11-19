package com.wisedu.fam.add.hostcomputer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
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

public class AddHostComputer extends Activity {
	private String postUrl = "";
	private String getUrlAt = "";
	private String getUrlDt = "";
	private String assetTypeName[];
	private int assetTypeId[];
	private Spinner spinner = null;
	MyToast myToast = new MyToast();
	private String assetType = "1";
	private EditText assetNewId;
	private EditText assetName;
	private EditText assetBelong;
	private EditText assetBrand;
	private EditText assetModel;
	private EditText assetSpecifications;
	private EditText assetPrice;
	private EditText assetServiceCode;
	private EditText assetMac;
	private EditText assetRemark1;
	private EditText assetRemark2;
	private TextView assetTitle;
	private Assets ass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_host_computer);
		spinner = (Spinner) findViewById(R.id.mySpinner);
		assetNewId = (EditText) findViewById(R.id.assetNewId);
		assetName = (EditText) findViewById(R.id.assetName);
		assetBelong = (EditText) findViewById(R.id.assetBelong);
		assetBrand = (EditText) findViewById(R.id.assetBrand);
		assetModel = (EditText) findViewById(R.id.assetModel);
		assetSpecifications = (EditText) findViewById(R.id.assetSpecifications);
		assetPrice = (EditText) findViewById(R.id.assetPirce);
		assetServiceCode = (EditText) findViewById(R.id.assetServiceCode);
		assetMac = (EditText) findViewById(R.id.assetMac);
		assetRemark1 = (EditText) findViewById(R.id.assetRemark1);
		assetRemark2 = (EditText) findViewById(R.id.assetRemark2);
		assetTitle = (TextView) findViewById(R.id.add_label_title);

		postUrl = this.getString(R.string.homeurl) + "/fixedasset/insertion";
		getUrlAt = this.getString(R.string.homeurl) + "/fatypes";
		getUrlDt = this.getString(R.string.homeurl) + "/departments";
		new Thread(runnableGet).start();

		Intent intent = getIntent();
		ass = (Assets) intent.getSerializableExtra("equipId");
		// edit asset
		if (null != ass) {
			postUrl = this.getString(R.string.homeurl) + "/fixedasset/"
					+ ass.getNewId() + "/modification";
			TableRow tbp = (TableRow) findViewById(R.id.tbtpid);
			TableRow tbid = (TableRow) findViewById(R.id.tbid);
			tbp.setVisibility(View.GONE);
			tbid.setVisibility(View.GONE);
			assetNewId.setText(ass.getNewId());
			assetName.setText(ass.getAssetName());
			assetBelong.setText(ass.getAssetBelong());
			assetBrand.setText(ass.getBrand());
			assetModel.setText(ass.getModel());
			assetSpecifications.setText(ass.getSpecifications());
			assetPrice.setText(ass.getPrice() + "");
			assetServiceCode.setText(ass.getServiceCode());
			assetMac.setText(ass.getMac());
			assetRemark1.setText(ass.getRemark1());
			assetRemark2.setText(ass.getRemark2());
			assetType = ass.getTypeId() + "";
			assetTitle.setText("编辑设备信息");
		}

	}

	/**
	 * 初始化Spinner
	 */
	private void initMySpinner() {
		AssetsTypeAdapter adapter = new AssetsTypeAdapter(
				getApplicationContext(), assetTypeName, assetTypeId);
		spinner.setAdapter(adapter);
		spinner.setSelection(0, true);
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int position, long id) {
				if (adapterView.getId() == R.id.mySpinner) {
					LinearLayout ll = (LinearLayout) view;
					TextView tv = (TextView) ll
							.findViewWithTag("tagTextViewID");
					myToast.showToast(getApplicationContext(),
							(String) tv.getText());
					assetType = (String) tv.getText();
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

	/**
	 * 确认录入(修改)
	 */
	public void insertClick(View v) {
		if (EquipHelper.checkNull(assetNewId.getText().toString())) {
			new Thread(runnableInsert).start();

		} else {
			myToast.showToast(getApplicationContext(), "资产编号不能留空!");
		}

	}

	/**
	 * 取消
	 * 
	 * @param v
	 */
	public void cancelClick(View v) {
		myToast.showToast(getApplicationContext(), assetType);
	}

	Handler handlerInsert = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle data = msg.getData();
			String val = data.getString("value");
			switch (Integer.parseInt(val)) {
			case 200:
				if (null != ass ) {
					myToast.showToast(getApplicationContext(), "编辑成功!");
				}else{
					myToast.showToast(getApplicationContext(), "入库成功!");
				}
				break;

			default:
				if (null != ass ) {
					myToast.showToast(getApplicationContext(), "编辑失败!");
				}else{
					myToast.showToast(getApplicationContext(), "入库失败!");
				}
				break;
			}
			Intent data2 = new Intent();
			data2.putExtra("result", 1);
			setResult(20, data2);
			finish();
		}
	};

	Runnable runnableInsert = new Runnable() {
		@Override
		public void run() {
			Message msg = new Message();
			Bundle data = new Bundle();
			HttpUtil httpUtil = new HttpUtil();
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("typeId", assetType));
			if (EquipHelper.checkNull(assetNewId.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("newId", assetNewId
						.getText().toString()));
			}
			if (EquipHelper.checkNull(assetName.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("assetName",
						assetName.getText().toString()));
			}
			if (EquipHelper.checkNull(assetBelong.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("assetBelong",
						assetBelong.getText().toString()));
			}
			if (EquipHelper.checkNull(assetBrand.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("brand", assetBrand
						.getText().toString()));
			}
			if (EquipHelper.checkNull(assetModel.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("model", assetModel
						.getText().toString()));
			}
			if (EquipHelper.checkNull(assetSpecifications.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("specifications",
						assetSpecifications.getText().toString()));
			}
			if (EquipHelper.checkNull(assetPrice.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("price", assetPrice
						.getText().toString()));
			}
			if (EquipHelper.checkNull(assetServiceCode.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("serviceCode",
						assetServiceCode.getText().toString()));
			}
			if (EquipHelper.checkNull(assetMac.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("mac", assetMac
						.getText().toString()));
			}
			if (EquipHelper.checkNull(assetRemark1.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("remark1",
						assetRemark1.getText().toString()));
			}
			if (EquipHelper.checkNull(assetRemark2.getText().toString())) {
				nameValuePairs.add(new BasicNameValuePair("remark2",
						assetRemark2.getText().toString()));
			}
			//无需修改项
			if (null != ass) {
				nameValuePairs.add(new BasicNameValuePair("purchaseDate", ass.getPurchaseDate()));
				nameValuePairs.add(new BasicNameValuePair("oldId", ass.getOldId()));
				nameValuePairs.add(new BasicNameValuePair("userId", ass.getUserId()));
				nameValuePairs.add(new BasicNameValuePair("departmentId", ass.getDepartmentId()));
				nameValuePairs.add(new BasicNameValuePair("currentStatus", ass.getCurrentStatus()));
				nameValuePairs.add(new BasicNameValuePair("possessDate",ass.getPossessDate()));
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String startTime = sdf.format(new Date());
				nameValuePairs.add(new BasicNameValuePair("purchaseDate",startTime));
			}

			HttpResponse response = null;
			try {
				response = httpUtil.sendObgect(postUrl, nameValuePairs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			data.putString("value", response.getStatusLine().getStatusCode()
					+ "");
			msg.setData(data);
			handlerInsert.sendMessage(msg);
		}
	};
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
					String value = type.get("typeName").toString();
					assetTypeName[i] = value;
					int key = Integer.parseInt(type.get("typeId").toString());
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_host_computer, menu);
		return true;
	}

}
