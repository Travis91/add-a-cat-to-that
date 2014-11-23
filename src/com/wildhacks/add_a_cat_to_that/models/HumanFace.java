package com.wildhacks.add_a_cat_to_that.models;

import java.util.ArrayList;
import java.util.Arrays;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.FaceDetector.Face;
import android.media.FaceDetector;

public class HumanFace {
	private static final int MAX_FACES = 100;
	public HumanFace(){
		
	}
	static public ArrayList<Face> getFace(Bitmap bmp){
		Face[] faces = new Face[MAX_FACES];
		FaceDetector fd = new FaceDetector(bmp.getWidth(),bmp.getHeight(),MAX_FACES);
		int numOfFaces = fd.findFaces(fixSize(bmp),faces);
		ArrayList<Face> faceList = new ArrayList<Face>();
		for(int i =0; i<numOfFaces; i++){
			faceList.add(faces[i]);
		}
		return faceList;
	}
	static private Bitmap fixSize(Bitmap bmp){
		if(bmp.getWidth()%2==1){
			bmp.reconfigure(bmp.getWidth()-1, bmp.getHeight(), bmp.getConfig());
		}
		return bmp;
	}
	
}
