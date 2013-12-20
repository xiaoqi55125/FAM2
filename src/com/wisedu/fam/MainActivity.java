package com.wisedu.fam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wisedu.fam.add.AddActivity;
import com.wisedu.fam.add.hostcomputer.AddHostComputer;
import com.wisedu.fam.check.CheckAsset;
import com.wisedu.fam.help.MyToast;
import com.zxing.activity.CaptureActivity;

public class MainActivity extends Activity {

	MyToast myToast = new MyToast();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void hechaClick(View v) {
		//打开扫描界面扫描条形码或二维码
		Intent openCameraIntent = new Intent(this,CaptureActivity.class);
		startActivityForResult(openCameraIntent, 0);
	}

	public void zcrkClick(View v) {
		//打开新增页面
//		Intent openAssetAddIntent = new Intent(this,AddActivity.class);
//		startActivity(openAssetAddIntent);
		Intent intent = new Intent(getApplicationContext(),
				AddHostComputer.class);
		startActivity(intent);
		
	}

	public void zjbfClick(View v) {
		myToast.showToast(this, "功能暂未开放");
	}

	public void zcglClick(View v) {
		myToast.showToast(this, "功能暂未开放");
	}

	/**
	 * 处理返回按钮触发时，toast提示立即消失
	 */
	public void onBackPressed() {
		myToast.cancelToast();
		super.onBackPressed();
	}

	/**
	 * deal with menu item selected event
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		int item_id = item.getItemId();
		switch (item_id) {
		case R.id.action_settings:
			new AlertDialog.Builder(this)
					.setMessage("确认退出吗?")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									setResult(RESULT_OK);
									finish();
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									// myToast.showToast(MainActivity.this,
									// "nothing");
								}
							}).setTitle("提示：").show();
			break;
		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			Intent intent = new Intent(getApplicationContext(),CheckAsset.class);
			intent.putExtra("assetId", scanResult);
			startActivity(intent);
		}
	}
	
}
