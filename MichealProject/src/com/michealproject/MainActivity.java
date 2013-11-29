package com.michealproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.testdb.Dbfactory;
import com.testdb.Hospital;

public class MainActivity extends Activity {
	private ViewGroup areaLayout;
	private TextView userDefined;
	private ViewGroup hospitalLayout;
	private ViewGroup departmentLayout;
	private PopupWindow hospitalPopupWindow;
	private ListView hospitalListView;
	private Dbfactory db = Dbfactory.getInstance();
	private View parentView;
	private TextView hospitalTextView;
	
	private String hospitalString = null;
	private Hospital hospitalBean;
	
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("DBTest", "onPause");
	}

	@Override
	protected void onCreate(
			Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		initData();
	}

	private void initViews(){
		areaLayout = (ViewGroup)findViewById(R.id.search_select_area_layout);
		hospitalLayout = (ViewGroup) findViewById(R.id.search_select_hospital_layout);
		departmentLayout = (ViewGroup) findViewById(R.id.search_select_department_layout);
		userDefined = (TextView) findViewById(R.id.search_byself_txt_btn);
		parentView = findViewById(R.id.main_parent_layout);
		hospitalTextView = (TextView) findViewById(R.id.main_hospital_textview);
	}
	
	private void initData(){
		areaLayout.setEnabled(false);
		userDefined.setOnClickListener(new searchByselfTextButton());
		hospitalLayout.setOnClickListener(searchSelect);
		departmentLayout.setOnClickListener(searchSelect);
		
		if (hospitalString == null) {
			departmentLayout.setEnabled(false);
		}else {
			departmentLayout.setEnabled(true);
		}
	}
	
	private final OnClickListener searchSelect = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.search_select_hospital_layout:
				if (hospitalPopupWindow != null && hospitalPopupWindow.isShowing()) {
					hospitalPopupWindow.isShowing();
				}else {
					hospitalPopupWindow(parentView);
				}
				break;
			case R.id.search_select_department_layout:
				Log.i("DBTest", hospitalTextView.getText().toString());
				break;
			default:
				break;
			}
		}
	};
	
	private void hospitalPopupWindow(View parent) {
		if(hospitalPopupWindow == null){
			LayoutInflater lay = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = lay.inflate(R.layout.select_hospital_activity, null);
			
			hospitalListView = (ListView) v.findViewById(R.id.hospital_listView);
			
			hospitalPopupWindow = new PopupWindow(v, parent.getWidth(), parent.getHeight() ,true);
			hospitalPopupWindow.setAnimationStyle(R.style.updownPopupAnim);
			
			//º”‘ÿ ˝æ›
			List<Hospital> hospitals = db.getHospitals();
			final List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
			for (Hospital hospital : hospitals) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("name", hospital.getName());
				data.add(item);
			}
			
			SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, data, 
					R.layout.item_hospital_activity, 
					new String[]{"name"}, new int[]{R.id.hospital_textView});
			
			hospitalListView.setAdapter(adapter);
			hospitalListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					hospitalPopupWindow.dismiss();
					hospitalTextView.setText((String)data.get(arg2).get("name"));
				}
			});
		}
		hospitalPopupWindow.update();
		hospitalPopupWindow.showAtLocation(parent, Gravity.CENTER_VERTICAL, 0, 0);
		
	}
	
	private final class searchByselfTextButton implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, UserDefinedSelect.class);
			startActivityForResult(intent, 1);
		}
		
	}
	
}
