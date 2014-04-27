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
	DuboseNPC dubose = new DuboseNPC(sprites.DuboseIdleAnims, sprites.DuboseIdleAnims, sprites.DuboseIdleAnims, sprites.DuboseIdleAnims, 16, 6, 16);
	Npc Atticus = new Npc(sprites.AtticusForwardAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 10, 16);
	Npc Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 21, 10, 16);
	BufferedImage TextBox, NameBox;
	boolean printRunning = false;
	int Level = 1;
	String TextToPrint = "";
	String NameToPrint = "";
	public Main(int Height, int Width, int Scale, int PixelWidth, int PixelHeight, int ImageToPixelRatio, File DataFolder) {
		super(Height, Width, Scale, PixelWidth, PixelHeight, ImageToPixelRatio, DataFolder, GameType.FREE_ROAM_TILE_BASED);
		DataFolder.mkdirs();
		setIconImage();
		setTextBoxImage();
		SetWindowResizable(false);
		SetWindowTitle("TKAM Game Project by Marcus Dubreuil and Ethan Defrank");
		KL = new KeyListener();
		SetClassInstance(this,false);
		//level = new RandomLevelTKAM(12,12, DataFolder, "Level2", this);
		level = new Level(DataFolder, "Level1", this);
		setEngineKeyListener(KL);
		player = new TKAMPlayer(21, 11, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
//		npc = new Npc(sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, 3, 6, 16);
		player.init(level,this);
		PackFrame();
		start();
		Atticus.init(level, this);
		Jem.init(level, this);
		InitiateLevel();
	}
	
	private void printText(final String name, final String Text) {
//		Thread printthread = new Thread() {
//			public void run() {
				try {
						for(int i = 1; i <= name.length(); i++) {
							if(!KL.KeyPressed) {
								Thread.sleep(25);
								NameToPrint = name.substring(0, i);
							}
						}
						
						for(int i = 1; i <= Text.length(); i++) {
							if(!KL.KeyPressed) {
								Thread.sleep(25);
								TextToPrint = Text.substring(0, i);
							}
						}
						
						KL.KeyPressed = false;
				} catch (InterruptedException e) {						
					e.printStackTrace();
				}
				NameToPrint = name;
				TextToPrint = Text;
			}
//		};
//		printthread.start();
//	}

	private void InitiateLevel() {
		Level = 1;
		Thread Level1 = new Thread(){
			String skipline = "                                                  ";
			public void run() {
				KL.stallListen = true;
						printText("Marcus/Ethan","Welcome to our TKAM game made by Marcus Dubreuil and Ethan Defrank. We will be going through several" +
									"          scenes to represent our individual themes throughout the game.                                                         " +
									"(Press any key to continue)");
						Wait();
						printText("Marcus Dubreuil", "We will start with my theme, which is the depiction of Morality shown through Atticus. " +
									"Our first scene is     when Scout is walking by Mrs. Dubose's house. I will send you through the scene and then explain.             " + skipline +
									"(Press any key to be sent through the scene)");
						Wait();
						//Walk Scout to x = 16
						
						WalkLeftwithJem(player.getXTilePos() - 16);
						printText("Scout", "Hey, Mrs. Dubose.");
						Wait();
						dubose.BeginAnim();
						printText("Mrs. Dubose","Don’t you say hey to me, you ugly girl! You say good afternoon!");
						Wait();
						DuboseNPC.anim = false;
						WalkAtticusRight((Atticus.x / 16) + 4);
						printText("Scout/Jem", "Atticus!");
						WalkLeftwithJem(player.getXTilePos() - 11);
						Wait();
						printText("Atticus", "Hello Scout and Jem and Good afternoon, Mrs. Dubose! You look like a picture this afternoon.");
						int PlayerXArrive = player.getXTilePos() + 6;
						while(player.getXTilePos() != PlayerXArrive) {
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							KL.right = true;
							Atticus.right = true;
							Jem.right = true;
						}
						Jem.right = false;
						Atticus.right = false;
						KL.right = false;
						KL.ReleasedRight = true;
						Wait();
						WalkAtticusRight((Atticus.x / 16) + 5);
						dubose.BeginAnim();
						printText("Mrs. Dubose", "How dare you call your father by this name you disrespectful mutts!");
						Wait();
						DuboseNPC.anim = false;
						int JemXArrive = ((Jem.x / 16) + 17);
						while((Jem.x / 16) != JemXArrive) {
							try {
								Thread.sleep(5);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							Jem.right = true;
						}
						Jem.right = false;
						Level = 0;
						
						
				KL.stallListen = false;
				System.out.println(KL.stallListen);
				NameToPrint = "Marcus Dubreuil";
				TextToPrint = "Use the w,a,s,d keys or the arrow keys to walk to the front door of the Finch house next door";
				boolean done = false;
				while(!done) {
					System.out.println("X: " + player.x + "y: " + player.y);
					if(player.x >= 547 && player.x <= 572 && player.y >= 108 && player.y <= 114) {
						done = true;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				level.LoadLevelFile(DataFolder, "Level2");
				Atticus = new Npc(sprites.AtticusLeftAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 7, 16);
				Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 2, 7, 16);
				player.x = 9 * 16;
				player.y = 11 * 15;
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				reset();
				Level = 3;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printText("Marcus Dubreuil", "You enter the house and see that Jem is furious about Mrs. Dubose's comments...");
				Wait();
				printText("Atticus", "Easy does it, son. She is an old lady and she’s ill. You just hold your head high and be a gentleman. Whatever she says to you, it’s your job not to let her make you mad.");
				Wait();
				printText("Marcus Dubreuil", "As we can see Atticus is explaining to Jem how he must act like a gentleman despite what Mrs. Dubose          says to him. He is teaching Jem important morals concerning what is right to do as a gentleman.");
				Wait();
				
				
			}

			private void WalkAtticusRight(int x) {
				int AtticusXArrive = (Atticus.x / 16) + x;
				while((Atticus.x / 16) != AtticusXArrive) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Atticus.right = true;
				}
				Atticus.right = false;
			}

			private void WalkLeftwithJem(int x) {
				int PlayerXArrive = player.getXTilePos() - x;
				while(player.getXTilePos() != PlayerXArrive) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					KL.left = true;
					Jem.left = true;
				}
				Jem.left = false;
				KL.left = false;
				KL.ReleasedLeft = true;
			}
			
			private void WalkLeft(int x) {
				int PlayerXArrive = player.getXTilePos() - x;
				while(player.getXTilePos() != PlayerXArrive) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					KL.left = true;
				}
				KL.left = false;
				KL.ReleasedLeft = true;
			}

			private void Wait() {
				KL.KeyPressed = false;
				while(!KL.KeyPressed) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				reset();
			}

			private void reset() {
				KL.KeyPressed = false;
				NameToPrint = "";
				TextToPrint = "";
			}
		};
		Level1.start();
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
		if(Level == 1) {
			player.update();
			Atticus.update();
			Jem.update();
		} else if(Level == 0) {
			player.update();
		} else if(Level == 3) {
			player.update();
			Atticus.update();
			Jem.update();
		}
	}
	
	public void privateRender() {
		int xScroll = player.x + screen.width /2 - 16;
		int yScroll = player.y + screen.height /2 - 16;
		if(Level == 1) {
			dubose.render(screen);
			Jem.render(screen);
			Atticus.render(screen);
		} else if(Level == 0) {
			dubose.render(screen);
		} else if(Level == 3) {
			Atticus.render(screen);
			Jem.render(screen);
		}
		player.render(xScroll, yScroll, screen);
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
