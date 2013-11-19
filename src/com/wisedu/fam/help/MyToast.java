package com.wisedu.fam.help;

import android.content.Context;
import android.widget.Toast;

/**
 * @since 2013-10-16 11:05:43
 * @author zhicheng 
 * <br>Toast helper  
 */
public class MyToast {
	private Toast mToast;
	
	public void showToast(Context content , String text) {
		if (mToast == null) {
			mToast = Toast.makeText(content, text,
					Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	public void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}
}
