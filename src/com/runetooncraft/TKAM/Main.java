package com.runetooncraft.TKAM;

import java.io.File;

import com.runetooncraft.warpigeon.engine.GameType;
import com.runetooncraft.warpigeon.engine.WPEngine4;
import com.runetooncraft.warpigeon.testengine.FreeRoam;


public class Main extends WPEngine4 {
	
	public Main(int Height, int Width, int Scale, int PixelWidth, int PixelHeight, int ImageToPixelRatio, File DataFolder) {
		super(Height, Width, Scale, PixelWidth, PixelHeight, ImageToPixelRatio, DataFolder, GameType.FREE_ROAM_TILE_BASED);
		DataFolder.mkdirs();
	}
	public static void main(String[] args) {
		String workingDirectory;
		String OS = (System.getProperty("os.name")).toUpperCase();
		if (OS.contains("WIN")) {
		    workingDirectory = System.getenv("AppData");
		} else {
		    workingDirectory = System.getProperty("user.home");
		    workingDirectory += "/Library/Application Support";
		}
		workingDirectory = workingDirectory + "/WarPigeon/TKAMGame";
		//INPUT CODE TO UNPACK LEVELS HERE
		File DataFolder = new File(workingDirectory); 
		new Main(427, 240, 3000, 16, 16, 16, DataFolder);
	}
}
