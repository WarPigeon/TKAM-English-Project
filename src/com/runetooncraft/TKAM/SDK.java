package com.runetooncraft.TKAM;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.runetooncraft.warpigeon.engine.GameType;
import com.runetooncraft.warpigeon.engine.WPEngine4;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.CoordinateHandler;
import com.runetooncraft.warpigeon.engine.level.RandomLevel;
import com.runetooncraft.warpigeon.engine.level.TileCoordinate;
import com.runetooncraft.warpigeon.engine.utils3d.KeyListener;
import com.runetooncraft.warpigeon.testengine.PigionSDK;

public class SDK extends WPEngine4  {
	
	
	Sprites sprites = new Sprites();
	Tiles tiles = new Tiles();
	KeyListener KL;
	CoordinateHandler CH = new CoordinateHandler();
	private boolean up = true,down = true,left = true,right = true;
	private int u,d,l,r = 0;
	public SDK(int Height, int Width, int Scale, int PixelWidth, int PixelHeight, int ImageToPixelRatio, File DataFolder) {
		super(Height, Width, Scale, PixelWidth, PixelHeight, ImageToPixelRatio, DataFolder, GameType.PIGION_SDK);
		DataFolder.mkdirs();
		setIconImage();
		SetWindowResizable(false);
		SetWindowTitle("War-Pigion Engine4");
		KL = new KeyListener();
		SetClassInstance(this,true);
		level = new RandomLevelTKAM(64,64, DataFolder, "UnNamed", this);
		setEngineKeyListener(KL);
		PackFrame();
		start();
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
		File DataFolder = new File(workingDirectory);
		new SDK(427, 240, 2000, 16, 16, 16, DataFolder);
	}
	
	private void setIconImage() {
		try {
			InputStream imgStream = Main.class.getResourceAsStream("/favicon.png");
			BufferedImage myImg = ImageIO.read(imgStream);
			GetFrame().setIconImage(myImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	public void update() {
		KeyEvents.update();
		if(KL.up) {
			if(up) {
				up = false;
				SDKy-=32;
			} else {
				u++;
				if(u >= 15) {
					SDKy-=32;
					u = 0;
				}
			}
		} else {
			u = 0;
			up = true;
		}
		if(KL.down) {
			if(down) {
				down = false;
				SDKy+=32;
			} else {
				d++;
				if(d >= 15) {
					SDKy+=32;
					d = 0;
				}
			}
		} else {
			d = 0;
			down = true;
		}
		if(KL.left) {
			if(left) {
				left = false;
				SDKx-=32;
			} else {
				l++;
				if(l >= 15) {
					SDKx-=32;
					l = 0;
				}
			}
		} else {
			l = 0;
			left = true;
		}
		if(KL.right) {
			if(right) {
				right = false;
				SDKx+=32;
			} else {
				r++;
				if(r >= 15) {
					SDKx+=32;
					r = 0;
				}
			}
		} else {
			r = 0;
			right = true;
		}
	}
	
	public void MouseLeftClicked() {
		int Mousex = mouse.getX();
		int Mousey = mouse.getY();
		TileCoordinate tc = CH.getTileCoordinateAtMouse(Mousex, Mousey, screen, level);
		int Layer = GetSDK().getSelectedLayer();
		level.setTile(tc, GetSDK().GetMouse1SelectedTile(), Layer);
	}

	public void MouseRightClicked() {
		int Mousex = mouse.getX();
		int Mousey = mouse.getY();
		TileCoordinate tc = CH.getTileCoordinateAtMouse(Mousex, Mousey, screen, level);
		int Layer = GetSDK().getSelectedLayer();
		level.setTile(tc, GetSDK().GetMouse2SelectedTile(), Layer);
	}
	
}
