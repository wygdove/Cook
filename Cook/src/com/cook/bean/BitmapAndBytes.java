package com.cook.bean;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapAndBytes {

	public static byte[] Bitmap2Bytes(Bitmap bm) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();
	}

	public static Bitmap Bytes2Bitmap(byte[] bytes) {
		if (bytes.length != 0) {
			return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
		} 
		else {
			return null;
		}
	}

}
