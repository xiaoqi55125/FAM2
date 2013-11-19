package com.wisedu.fam.add;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.wisedu.fam.R;
import com.wisedu.fam.add.hostcomputer.AddHostComputer;
import com.wisedu.fam.help.MyToast;

public class AddActivity extends Activity {
	private ListView listView;
	MyToast myToast = new MyToast();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		listView = (ListView) findViewById(R.id.listView_add);
		List<EquipTypeSelectList> dataArray = new ArrayList<EquipTypeSelectList>();
		EquipTypeSelectList l1 = new EquipTypeSelectList("1", "主机",
				"host_1.png");
		EquipTypeSelectList l2 = new EquipTypeSelectList("2", "显示器",
				"moniter_2.png");
		EquipTypeSelectList l3 = new EquipTypeSelectList("3", "笔记本",
				"notebook_1.png");
		EquipTypeSelectList l4 = new EquipTypeSelectList("4", "服务器",
				"server_1.png");
		EquipTypeSelectList l5 = new EquipTypeSelectList("5", "移动设备",
				"mobile_1.png");
		EquipTypeSelectList l6 = new EquipTypeSelectList("6", "办公设备",
				"office_equip.png");
		EquipTypeSelectList l7 = new EquipTypeSelectList("7", "办公家具",
				"chair.png");
		EquipTypeSelectList l8 = new EquipTypeSelectList("8", "其他设备",
				"briefcase.png");
		EquipTypeSelectList l9 = new EquipTypeSelectList("9", "虚拟设备", "vr.png");
		dataArray.add(l1);
		dataArray.add(l2);
		dataArray.add(l3);
		dataArray.add(l4);
		dataArray.add(l5);
		dataArray.add(l6);
		dataArray.add(l7);
		dataArray.add(l8);
		dataArray.add(l9);
		EquipTypeSelectListAdapter adapter = new EquipTypeSelectListAdapter(
				this, dataArray, listView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// myToast.showToast(getApplicationContext(), position + "");
				switch (position) {
				case 0:
					Intent intent = new Intent(getApplicationContext(),
							AddHostComputer.class);
					startActivity(intent);
					break;

				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}

}
