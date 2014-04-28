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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.runetooncraft.warpigeon.engine.GameType;
import com.runetooncraft.warpigeon.engine.WPEngine4;
import com.runetooncraft.warpigeon.engine.entity.mob.Npc;
import com.runetooncraft.warpigeon.engine.entity.mob.Player;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.graphics.SpriteSheet;
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
		SetWindowTitle("TKAM Game Project by Marcus Dubreuil and Ethan DeFrank");
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
						printText("Marcus/Ethan","Welcome to our TKAM game made by Marcus Dubreuil and Ethan DeFrank. We will be going through several" +
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
				Level = 50;
				printText("Marcus Dubreuil", "Now we are going to transition to another Scene in the Finch house where Atticus is questioned on why he      supports Tom Robbinson.");
				Wait();
				Atticus = new Npc(sprites.AtticusRightAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 4, 7, 16);
				Jem = new Npc(sprites.JemLeftAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 5, 7, 16);
				player.x = 5 * 16;
				player.y = 10 * 15;
				Level = 4;
				printText("Scout", "If you shouldn't be defendin' him, then why are you doin' it?");
				Wait();
				Atticus = new Npc(sprites.AtticusForwardAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 4, 7, 16);
				printText("Atticus", "For a number of reasons. The main one is, if I didn’t I couldn’t hold up my head in town, I couldn’t represent this county in the legislature, I couldn’t even tell you or Jem not to do something again.");
				Wait();
				printText("Scout", "You mean if you didn’t defend that man, Jem and me wouldn’t have to mind you any more?");
				Wait();
				printText("Atticus", "That’s about right.");
				Wait();
				printText("Scout", "Why?");
				Wait();
				printText("Atticus", "Because I could never ask you to mind me again. Scout, simply by the nature of the work, every lawyer gets    at least one case in his lifetime that affects him personally. This one’s mine, I guess. You might hear some     ugly talk about it at school, but do one thing for me if you will: you just hold your head high and keep    those fists down. No matter what anybody says to you, don’t you let ‘em get your goat. Try fighting with your head for a change… it’s a good one, even if it does resist learning.");
				Wait();
				printText("Marcus Dubreuil", "Here is another example of Atticus Showing morality through multiple ways. He first explains why he must      accept the case, that he must hold his head up in town. The fact that Atticus cares so much about why he      must hold his head up in town and act like a gentleman is what makes him unique. Most may not even care       what   others think of them but Atticus must, showing him as a moral and strong person. Atticus also tells Scout to hold  her head up high and not to \"let 'em get your goat\"or let others effect her.");
				Wait();
				printText("Atticus","Now we will transition to another example that occurs after Jem cuts off all of Mrs. Dubose's Camalias.");
				Wait();
				Atticus = new Npc(sprites.AtticusRightAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 4, 7, 16);
				printText("Atticus", "Jem, Are you responsible for this.");
				Wait();
				printText("Jem", "Yes sir.");
				Wait();
				printText("Atticus", "Why’d you do it?");
				Wait();
				printText("Jem", "She said you lawed for niggers and trash.");
				Wait();
				printText("Atticus", "You did this because she said that?");
				Wait();
				printText("Jem", "Yes sir");
				Wait();
				printText("Atticus", "Son, I have no doubt that you’ve been annoyed by your contemporaries about me lawing for niggers, as you     say, but to do something like this to a sick old lady is inexcusable. I strongly advise you to go down and have a  talk with Mrs. Dubose, Come straight home afterward.");
				Wait();
				printText("Marcus Dubreuil", "Despite how horrible Mrs. Dubose is Atticus stresses that Jem should treat her well because she is a sick    old lady. Atticus is showing his children that no matter how horrible someone is, they must be treated with the same respect you give to anyone. This a very valuable moral lesson.");
				Wait();
				Level = 4;
				KL.stallListen = false;
				System.out.println(KL.stallListen);
				NameToPrint = "Marcus Dubreuil";
				TextToPrint = "Use the w,a,s,d keys or the arrow keys to walk to Scout's Bedroom to the right.";
				done = false;
				while(!done) {
					System.out.println("X: " + player.x + "y: " + player.y);
					if(player.x >= 174 && player.x <= 184 && player.y >= 92 && player.y <= 122) {
						done = true;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				level.LoadLevelFile(DataFolder, "Level3");
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				reset();
				Level = 5;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Atticus = new Npc(sprites.AtticusRightAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 4, 3, 16);
				player = new TKAMPlayer(6, 4, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				printText("Scout", "Atticus, you must be wrong....");
				Wait();
				printText("Atticus", "How's that?");
				Wait();
				printText("Scout", "Well, most folks seem to think they're right and you're wrong....");
				Wait();
				printText("Atticus","They're certainly entitled to think that, and they're entitled to full respect for their opinions, but before I can live with other folks I've got to live with myself. The one thing that doesn't abide by majority rule is a person's conscience.");
				Wait();
				printText("Marcus Dubreuil", "Atticus once again brings up the \"Living with himself\" idea and that he must be able to live with himself     before he can live with others. This shows that he has a strong conscience and cares more about what he       thinks about himself than what others think about him. This idea of caring more about what you want youself to be that what will allow you to fit in to society is a big idea in defining morality.");
				Wait();
				printText("Marcus Dubreuil", "It's currently 12:13 PM at night and I have been coding since 12:00 AM without breaks so I didn't have time to build this next level. But here is the quote");
				Wait();
				printText("Atticus", "You know the truth, and the truth is this: some Negroes lie, some Negroes are immoral, some Negro men are    not to be trusted around women—black or white. But this is a truth that applies to the human race and to no    particular race of men. There is not a person in this courtroom who has never told a lie, who has never done an  immoral thing, and there is no man living who has never looked upon a woman without desire.");
				Wait();
				printText("Marcus Dubreuil", "Atticus uses the real main idea of morality which is relating someones life and decisions to someone elses in order to prove that everyone is equal. By saying that \"The truth is [these ideas] apply to the human race and no particular race of men\" Atticus is truly proving his equality idea.");
				Wait();
				printText("Marcus Dubreuil", "The reason I chose the morality theme relating to Atticus is because his whole persona is based on the idea   of maintaining you conscience and putting yourselves in others shoes. In the end of the book, he even tried to put his own son under the bus in order to prove that Ewell did not die in Vain because even though he was one  of the worst people who walked the earth, Atticus put himself in Ewell's shoes and thought about how he       would of thought dying like that.");
				Wait();
				printText("Ethan DeFrank", "Now we will shift gears to how Jem impacts the theme of Maturity");
				Wait();
				Level = 6;
				level.LoadLevelFile(DataFolder, "Level1");
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				reset();
				player = new TKAMPlayer(57, 12, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 52, 16, 16);
				Jem.init(level, level.engine);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				NameToPrint = "Ethan DeFrank";
				TextToPrint = "We see Jem run across the screen up to the Radley house, touch the door, and run out of the screen again.";
				while(Jem.y > 108) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Jem.up = true;
				}
				Jem.up = false;
				printText("Jem", "*Touch*");
				Wait();
				while(Jem.y < 310) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Jem.down = true;
				}
				Jem.down = false;
				printText("Ethan DeFrank", "We begin seeing Jem acting upon a dare to touch the Radley house. The only reason this dare is significant is because the children of Maycomb see this house as the \"haunted house\" (so to speak) of Maycomb County.         This is an immature idea that Jem will soon leave behind.");
				Wait();
				printText("Ethan DeFrank", "In this next scene Scout is standing outside the Finch house and Jem comes walking by.");
				Wait();
				player = new TKAMPlayer(35, 10, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemEgyptianLeftAnims, sprites.JemEgyptianRightAnims, 44, 10, 16);
				Jem.init(level, level.engine);
				while(Jem.x != 561) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Jem.left = true;
				}
				Jem.left = false;
				printText("Scout", "What are you doing?");
				Wait();
				printText("Jem", "Walking like an Egyptian.");
				Wait();
				printText("Scout", "I don’t see how they got anything done walking like that.");
				Wait();
				printText("Jem", "They accomplished more than Americans ever did. They invented toilet paper and perpetual embalming. Now       where would we be if they hadn’t?");
				Wait();
				printText("Ethan DeFrank", "This being what Scout refers to as Jem’s brief \"Egyptian Period\" shows a certain childlike obsession. This is a common characteristic of those who have not quite matured and are still trying new things to find their interests.");
				Wait();
				Level = 7;
				level.LoadLevelFile(DataFolder, "Level4");
				Atticus = new Npc(sprites.AtticusLeftAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 14, 11, 16);
				Atticus.init(level, level.engine);
				Jem = new Npc(sprites.JemBackWardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 14, 12, 16);
				Jem.init(level, level.engine);
				player = new TKAMPlayer(14, 12, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				reset();
				printText("Scout","H-ey, Atticus!");
				Wait();
				Atticus = new Npc(sprites.AtticusForwardAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 14, 11, 16);
				printText("Atticus", "Go home, Jem. Take Scout home");
				Wait();
				printText("Jem", "...");
				Wait();
				printText("Atticus", "Go home, I said.");
				Wait();
				printText("Jem", "*Shakes Head*");
				Wait();
				printText("Man", "I'll send him home.");
				Wait();
				player = new TKAMPlayer(14, 12, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				printText("Scout", "Don't you touch him!");
				Wait();
				printText("Man", "All right, Mr. Finch, get ‘em outa here. You got fifteen seconds to get ‘em outa here.");
				Wait();
				printText("Jem", "I ain’t going.");
				Wait();
				printText("Atticus", "Please, Jem.");
				Wait();
				printText("Ethan DeFrank", "Jem finally takes Scout home (after Scout breaks up the mob, of course). Jem’s resistance in blindly following Atticus’s orders shows that he is maturing to make his own decisions.");
				Wait();
				Level = 3;
				level.LoadLevelFile(DataFolder, "Level2");
				Atticus = new Npc(sprites.AtticusRightAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 4, 7, 16);
				Jem = new Npc(sprites.JemLeftAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 5, 7, 16);
				Jem.init(level, level.engine);
				player = new  TKAMPlayer(5, 10, sprites.ScoutBackWardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				player.x = 5 * 16;
				player.y = 10 * 15;
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				reset();
				printText("Jem", "*Sob*... It ain’t right, Atticus.");
				Wait();
				printText("Atticus", "No son, it’s not right.");
				Wait();
				while(Jem.x != 130) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Jem.right = true;
				}
				Jem.right = false;
				Level = 8;
				printText("Atticus", "It was a little too strong for him.");
				Wait();
				printText("Ethan DeFrank", "Jem was so confident that Tom would be found innocent that he is in complete shock. Although he has           matured so much from the beginning of the novel, he is still learning so much about society. He is only now    mentally maturing and learning the horrors of racial prejudice.");
				Wait();
				printText("Ethan DeFrank", "We will now cut to our final scene where Jem is trying to understand the verdict.");
				Wait();
				Atticus = new Npc(sprites.AtticusForwardAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 7, 16);
				Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 2, 7, 16);
				player.x = 9 * 16;
				player.y = 11 * 15;
				KL.stallListen = true;
				KL.down = false;
				KL.left = false;
				KL.right = false;
				KL.up = false;
				Level = 9;
				reset();
				printText("Atticus", "There’s something in our world that makes men lose their heads - they couldn’t be fair if they tried. In our courts, when it’s a white man’s word against a black man’s, the white man always wins.");
				Wait();
				Atticus = new Npc(sprites.AtticusLeftAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 7, 16);
				printText("Jem", "Doesn’t make it right… You just can’t convict a man on evidence like that - you can’t.");
				Wait();
				printText("Atticus", "You couldn’t, but they could and did. The older you grow the more of it you’ll see...");
				Wait();
				Atticus = new Npc(sprites.AtticusForwardAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 7, 16);
				printText("Ethan DeFrank", "Although Jem is still defiant, he discusses the situation with Atticus in order to understand it. This is a very mature thing to do, to seek out understanding where you have none.");
				Wait();
				printText("Ethan DeFrank", "I chose to focus on the theme of Maturity because TKAM is definitely a coming-of-age book. Jem was an obvious choice of the character who impacts this theme because he is the big brother to the narrator. A “big brother” is a symbol of maturity because he is the leader of the siblings. He has to act mature even where he isn’t. Throughout the novel, we watch Jem go from a young boy who is pretending to be a man to a young man who knows and understands his place in society. There is not a more fitting character; Jem’s character is the epitome of the theme of Maturity in TKAM.");
				Wait();
				TextToPrint = "That's it! Now you can free-roam and if you wish to restart the game, simply restart the .jar file.";
				NameToPrint = "Marcus/Ethan";
				KL.stallListen = false;
				FreeRoam();
			}
			
			private void FreeRoam() {
				Level = 50;
				level.LoadLevelFile(DataFolder, "Level1");
				Level = 0;
				player = new TKAMPlayer(35, 10, sprites.ScoutForwardAnims, sprites.ScoutBackWardAnims, sprites.ScoutLeftAnims, sprites.ScoutRightAnims, KL);
				player.init(level, level.engine);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
				Level = 50;
				level.LoadLevelFile(DataFolder, "Level2");
				Level = 3;
				Atticus = new Npc(sprites.AtticusLeftAnims, sprites.AtticusBackWardAnims, sprites.AtticusLeftAnims, sprites.AtticusRightAnims, 3, 7, 16);
				Jem = new Npc(sprites.JemForwardAnims, sprites.JemBackWardAnims, sprites.JemLeftAnims, sprites.JemRightAnims, 2, 7, 16);
				player.x = 9 * 16;
				player.y = 11 * 15;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				done = false;
				while(!done) {
					System.out.println("X: " + player.x + "y: " + player.y);
					if(player.x >= 138 && player.x <= 152 && player.y >= 159 && player.y <= 170) {
						done = true;
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				FreeRoam();
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
		} else if(Level == 4) {
			player.update();
			Atticus.update();
			Jem.update();
		} else if(Level == 5) {
			player.update();
			Atticus.update();
		} else if(Level == 6) {
			player.update();
			Jem.update();
		} else if(Level == 7) {
			Atticus.update();
			player.update();
			Jem.update();
		}
	}
	
	public void privateRender() {
		int xScroll = player.x + screen.width /2 - 16;
		int yScroll = player.y + screen.height /2 - 16;
		if(Level < 4 && Level != 0) {
			player.render(xScroll, yScroll, screen);
		}
		if(Level == 1) {
			dubose.render(screen);
			Jem.render(screen);
			Atticus.render(screen);
		} else if(Level == 0) {
			dubose.render(screen);
		} else if(Level == 3) {
			Jem.render(screen);
			Atticus.render(screen);
		} else if(Level == 4) {
			Jem.render(screen);
			Atticus.render(screen);
		} else if(Level == 5) {
			Atticus.render(screen);
		} else if(Level == 7) {
			Atticus.render(screen);
			Jem.render(screen);
		} else if(Level == 8) {
			Atticus.render(screen);
			player.render(xScroll, yScroll, screen);
		} else if(Level == 9) {
			Atticus.render(screen);
			Jem.render(screen);
		}
		
		if(Level >= 4 && Level < 5) {
			player.render(xScroll, yScroll, screen);
		}
	}
	
	
	public void privateRenderAfterUpperLayers() {
		int xScroll = player.x + screen.width /2 - 16;
		int yScroll = player.y + screen.height /2 - 16;
		if(Level == 6) {
			Jem.render(screen);
		}
		if(Level >= 5 && Level < 8 || Level == 0) {
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
//		workingDirectory = "/WarPigeon/TKAMGame";
		workingDirectory = System.getProperty("user.home") + "/TKAMGame";
		File DataFolder = new File(workingDirectory); 
//		try {
//			InputStream is = Main.class.getResourceAsStream("/Levels");
//			Channel src = Channels.newChannel(is);
//			FileChannel dest = (new FileOutputStream(DataFolder + "/Levels")).getChannel();
//			dest.transferFrom((ReadableByteChannel) src, 0, is.available());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
