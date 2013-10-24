package com.wisedu.fam.check;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.wisedu.fam.R;
//
public class TeacherProfessorKind4 {

}
//	private ListView listView;
//	private ProgressDialog progressDialog;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.teacher_professor4);
//		Intent intent = getIntent();
//		String url;
//		String kindId = intent.getStringExtra("kindId");
//		String kindName = intent.getStringExtra("kindName");
//		String whereFrom = intent.getStringExtra("whereFrom");
//		String code = intent.getStringExtra("code");
//		if (!code.equals("-10")) {
//			Log.v("###", whereFrom + "_" + kindId + "_" + code);
//			url = this.getString(R.string.homeurl)
//					+ "getService.do?sid=szdwService&mid=getPersonListByDoctorType&type="
//					+ kindId + "&code=" + code;
//			TextView tt;
//			tt = (TextView) findViewById(R.id.text_teacher_professor4);
//			tt.setText("博士生导师");
//
//		} else {
//			url = this.getString(R.string.homeurl)
//					+ "getService.do?sid=szdwService&mid=getPersonListByProfessorType&idType="
//					+ kindId;
//			Log.v("###!!!!!!!!!!!", url);
//		}
//		Log.v("###", url);
//		Log.v("###", whereFrom + "_" + kindId + "_" + code);
//
//		listView = (ListView) findViewById(R.id.list_teacher_professor4);
//		List<TeacherProfessorKind4List> dataArray = new ArrayList<TeacherProfessorKind4List>();
//		TextView textKindName = (TextView) findViewById(R.id.text_teacher_professor4_type);
//		textKindName.setText(kindName);
//		// 解析json
//		JSONArray teacherArray = null;
//		JSONObject jsonObject = null;
//		Json2String j2s = new Json2String();
//		String jsonString = j2s.getContent(TeacherProfessorKind4.this, url);
//		JSONObject jsonObject1 = null;
//		JSONObject jsonObject2 = null;
//		String dataString = "";
//		try {
//			jsonObject = new JSONObject(jsonString);
//			jsonObject1 = jsonObject.getJSONObject("json");
//			dataString = jsonObject1.getString("data");
//		} catch (JSONException e1) {
//			e1.printStackTrace();
//		}
//		Log.v("###", "JSON" + jsonString);
//		if (jsonString.length() < 1) {
//			Toast.makeText(this, "请求超时", Toast.LENGTH_SHORT).show();
//			this.finish();
//
//		} else if (dataString.equals("") || dataString == "") {
//			Toast toast = Toast.makeText(getApplicationContext(), "暂无教师数据",
//					Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.CENTER, 0, 0);
//			toast.show();
//			this.finish();
//		} else {
//			try {
//				// JSONObject jsonObject1 = jsonObject.getJSONObject("json");
//				teacherArray = jsonObject1.getJSONArray("data");
//				Log.v("###", "知名教授个数" + teacherArray.length());
//				if (teacherArray.length() == 0) {
//					Log.v("###", "暂无教师数据");
//					Toast toast = Toast.makeText(getApplicationContext(),
//							"暂无教师数据", Toast.LENGTH_SHORT);
//					toast.setGravity(Gravity.CENTER, 0, 0);
//					toast.show();
//				}
//			} catch (JSONException e) {
//				e.printStackTrace();
//				Log.v("###", "网络异常");
//			}
//			for (int i = 0; i < teacherArray.length(); i++) {
//				JSONObject jsonTeacher = (JSONObject) teacherArray.opt(i);
//
//				try {
//					if (!code.equals("-10")) {
//						TeacherProfessorKind4List test = new TeacherProfessorKind4List(
//								jsonTeacher.getString("id"),
//								jsonTeacher.getString("name"), null, null, null);
//						dataArray.add(test);
//
//					} else {
//						TeacherProfessorKind4List test = new TeacherProfessorKind4List(
//								jsonTeacher.getString("id"),
//								jsonTeacher.getString("name"),
//								jsonTeacher.getString("approveTime"),
//								jsonTeacher.getString("desc").split("\n")[0],
//								jsonTeacher.getString("desc").split("\n")[1]);
//						dataArray.add(test);
//					}
//
//				} catch (JSONException e) {
//					e.printStackTrace();
//					Log.v("###", "异常");
//				}
//			}
//
//			TeacherProfessorList4Adapter adapter = new TeacherProfessorList4Adapter(
//					this, dataArray, listView);
//			listView.setAdapter(adapter);
//			listView.setOnItemClickListener(new OnItemClickListener() {
//				@Override
//				public void onItemClick(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					loadDataing();
//					String iiidString = ((TextView) arg1
//							.findViewById(R.id.teacher_professor4_text_id))
//							.getText().toString();
//					Log.v("###", "ID:::" + iiidString);
//					// 传值至教师详情界面
//					Intent intent = new Intent(TeacherProfessorKind4.this,
//							TeacherWebView.class);
//					intent.putExtra("id", iiidString);
//					startActivity(intent);
//				}
//			});
//		}
//
//	}
//
//	/**
//	 * 用Handler来更新UI
//	 */
//	private Handler handler = new Handler() {
//
//		@Override
//		public void handleMessage(Message msg) {
//			
//			
//
//			// 关闭ProgressDialog
//			progressDialog.dismiss();
//
//			// 更新UI
//			// statusTextView.setText("Completed!");
//		}
//	};
//
//	private void loadDataing() {
//		// //显示ProgressDialog
//		progressDialog = ProgressDialog.show(TeacherProfessorKind4.this, "",
//				"加载中...", true, false);
//		//
//		// //新建线程
//		new Thread() {
//
//			@Override
//			public void run() {
//				// 需要花时间计算的方法
//				Calculation.calculate(4);
//
//				// 向handler发消息
//				handler.sendEmptyMessage(0);
//			}
//		}.start();
//	}
//}