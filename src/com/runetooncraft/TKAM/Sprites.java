package com.runetooncraft.TKAM;

import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.graphics.SpriteSheet;

public class Sprites {
	
	//Sheet
	public static SpriteSheet Sheet1 = new SpriteSheet("/Sheet1.png", 272);
	
	//Void Sprite
	public static Sprite Void = new Sprite(16, 0, 0, Sheet1);
	
	//Grass Sprites
	public static Sprite Grass1 = new Sprite(16, 1, 0, Sheet1);
	public static Sprite Grass2 = new Sprite(16, 2, 0, Sheet1);
	public static Sprite Grass3 = new Sprite(16, 3, 0, Sheet1);

}
