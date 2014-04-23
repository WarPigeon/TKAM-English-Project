package com.runetooncraft.TKAM;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.runetooncraft.warpigeon.engine.GameType;
import com.runetooncraft.warpigeon.engine.WPEngine4;
import com.runetooncraft.warpigeon.engine.entity.mob.Npc;
import com.runetooncraft.warpigeon.engine.entity.mob.Player;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.RandomLevel;
import com.runetooncraft.warpigeon.engine.utils3d.KeyListener;


public class Main extends WPEngine4 {
	KeyListener KL;
	Sprites sprites = new Sprites();
	Tiles tiles = new Tiles();
	Npc npc;
	public Main(int Height, int Width, int Scale, int PixelWidth, int PixelHeight, int ImageToPixelRatio, File DataFolder) {
		super(Height, Width, Scale, PixelWidth, PixelHeight, ImageToPixelRatio, DataFolder, GameType.FREE_ROAM_TILE_BASED);
		DataFolder.mkdirs();
		setIconImage();
		SetWindowResizable(false);
		SetWindowTitle("TKAM Game Project by Marcus Dubreuil and Ethan Defrank");
		KL = new KeyListener();
		SetClassInstance(this,false);
		level = new RandomLevelTKAM(64,64, DataFolder, "Testy");
		setEngineKeyListener(KL);
		player = new Player(32, 32, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
		npc = new Npc(sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, 3, 1, 16);
		player.init(level,this);
		PackFrame();
		start();
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
		player.update();
	}
	
	public void privateRender() {
		int xScroll = player.x + screen.width /2 - 16;
		int yScroll = player.y + screen.height /2 - 16;
		if(player.y >= npc.y + 16) {
			npc.render(screen);
			player.render(xScroll, yScroll, screen);
		} else if(player.y <= npc.y + 16){
			player.render(xScroll, yScroll, screen);
			npc.render(screen);
		} else {
			npc.render(screen);
			player.render(xScroll, yScroll, screen);
		}
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
		new Main(427, 240, 2000, 16, 16, 16, DataFolder);
	}
}
