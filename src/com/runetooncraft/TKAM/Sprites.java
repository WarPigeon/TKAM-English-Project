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

	
	//Player Sprites
	//Scout
	public static SpriteSheet ScoutSheet = new SpriteSheet("/Characters/Scout.png",69,101);
	public static Sprite[] ScoutForwardAnims, ScoutBackWardAnims, ScoutLeftAnims, ScoutRightAnims;
	public Sprites() {
		ScoutForwardAnims = new Sprite[4];
		ScoutForwardAnims[0] = new Sprite(16, 24, 0, 0, ScoutSheet);
		ScoutForwardAnims[1] = new Sprite(16, 24, 0, 1, ScoutSheet);
		ScoutForwardAnims[2] = new Sprite(16, 24, 0, 2, ScoutSheet);
		ScoutForwardAnims[3] = new Sprite(16, 24, 0, 3, ScoutSheet);
		
		ScoutBackWardAnims = new Sprite[4];
		ScoutBackWardAnims[0] = new Sprite(16, 24, 3, 0, ScoutSheet);
		ScoutBackWardAnims[1] = new Sprite(16, 24, 3, 1, ScoutSheet);
		ScoutBackWardAnims[2] = new Sprite(16, 24, 3, 2, ScoutSheet);
		ScoutBackWardAnims[3] = new Sprite(16, 24, 3, 3, ScoutSheet);
		
		ScoutLeftAnims = new Sprite[4];
		ScoutLeftAnims[0] = new Sprite(16, 24, 2, 0, ScoutSheet);
		ScoutLeftAnims[1] = new Sprite(16, 24, 2, 1, ScoutSheet);
		ScoutLeftAnims[2] = new Sprite(16, 24, 2, 2, ScoutSheet);
		ScoutLeftAnims[3] = new Sprite(16, 24, 2, 3, ScoutSheet);
		
		ScoutRightAnims = new Sprite[4];
		ScoutRightAnims[0] = new Sprite(16, 24, 1, 0, ScoutSheet);
		ScoutRightAnims[1] = new Sprite(16, 24, 1, 1, ScoutSheet);
		ScoutRightAnims[2] = new Sprite(16, 24, 1, 2, ScoutSheet);
		ScoutRightAnims[3] = new Sprite(16, 24, 1, 3, ScoutSheet);
	}
}
