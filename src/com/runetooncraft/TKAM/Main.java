package com.runetooncraft.TKAM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.runetooncraft.warpigeon.engine.GameType;
import com.runetooncraft.warpigeon.engine.WPEngine4;
import com.runetooncraft.warpigeon.engine.entity.mob.Npc;
import com.runetooncraft.warpigeon.engine.entity.mob.Player;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.Level;
import com.runetooncraft.warpigeon.engine.level.RandomLevel;
import com.runetooncraft.warpigeon.engine.utils3d.KeyListener;


public class Main extends WPEngine4 {
	KeyListener KL;
	Sprites sprites = new Sprites();
	Tiles tiles = new Tiles();
	Npc npc;
	BufferedImage TextBox, NameBox;
	String TextToPrint = "";
	String NameToPrint = "";
	public Main(int Height, int Width, int Scale, int PixelWidth, int PixelHeight, int ImageToPixelRatio, File DataFolder) {
		super(Height, Width, Scale, PixelWidth, PixelHeight, ImageToPixelRatio, DataFolder, GameType.FREE_ROAM_TILE_BASED);
		TextToPrint = "This is a very random and long paragraph to test out the current text box. In no way will this be an actual   thing in the game eventually but this is simply to test out the line creating mechanic to render  text in the text box in the bottom of the screen.";
		NameToPrint = "Marcus Dubreuil";
		DataFolder.mkdirs();
		setIconImage();
		setTextBoxImage();
		SetWindowResizable(false);
		SetWindowTitle("TKAM Game Project by Marcus Dubreuil and Ethan Defrank");
		KL = new KeyListener();
		SetClassInstance(this,false);
		//level = new RandomLevelTKAM(64,64, DataFolder, "Testy");
		level = new Level(DataFolder, "Level1", this);
		setEngineKeyListener(KL);
		player = new TKAMPlayer(64, 64, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
		npc = new Npc(sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, 3, 6, 16);
		player.init(level,this);
		PackFrame();
		start();
	}
	
	private void setTextBoxImage() {
		try {
			InputStream imgStream = Main.class.getResourceAsStream("/TextBox.png");
			TextBox = ImageIO.read(imgStream);
			imgStream.close();
			
			InputStream imgStream2 = Main.class.getResourceAsStream("/NameBox.png");
			NameBox = ImageIO.read(imgStream2);
			imgStream2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
//		if (OS.contains("WIN")) {
//		    workingDirectory = System.getenv("AppData");
//		} else {
//		    workingDirectory = System.getProperty("user.home");
//		    workingDirectory += "/Library/Application Support";
//		}
//		workingDirectory = workingDirectory + "/WarPigeon/TKAMGame";
		workingDirectory = System.getProperty("user.home") + "/desktop/TKAMGame";
		//INPUT CODE TO UNPACK LEVELS HERE
		File DataFolder = new File(workingDirectory); 
		new Main(427, 240, 2000, 16, 16, 16, DataFolder);
	}
	
	public void DrawOtherImages(Graphics graphics) {
		graphics.drawImage(TextBox, 100, 320, TextBox.getWidth(), TextBox.getHeight(), null);
		graphics.drawImage(NameBox, 100, 288, NameBox.getWidth(), NameBox.getHeight(), null);
		drawText();
		if(!getLevel().render) {
			Graphics2D g2 = (Graphics2D)graphics;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Font font = new Font("Arial", Font.BOLD, 12);
			g2.setColor(new Color(0xA0A0A0));
			g2.setFont(font);
			g2.drawString("Loading...", getUnscaledWidth() / 2, getUnscaledHeight() / 2);
		}
	}

	private void drawText() {
		Graphics2D g2 = (Graphics2D)graphics;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Arial", Font.BOLD, 12);
		g2.setColor(new Color(0xA0A0A0));
		g2.setFont(font);
		List<String> strings = new ArrayList<String>();
		int index = 0;
		while (index<TextToPrint.length()) {
		    strings.add(TextToPrint.substring(index, Math.min(index+110,TextToPrint.length())));
		    index+=110;
		}
		int textX = 120;
		int textY = 350;
		for(String s: strings) {
			g2.drawString(s, textX, textY);
			textY+=13;
		}
		font = new Font("Arial", Font.ITALIC + Font.BOLD, 12);
		g2.setFont(font);
		g2.drawString(NameToPrint, 120, 310);
	}
}
