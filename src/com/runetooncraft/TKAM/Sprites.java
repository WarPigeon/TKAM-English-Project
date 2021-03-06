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

	//Wall Interior
	public static Sprite WallInterior = new Sprite(16, 0, 2, Sheet1);
	
	//Table
	public static Sprite BigTableTL = new Sprite(16, 8, 0, Sheet1);
	public static Sprite BigTableTR = new Sprite(16, 9, 0, Sheet1);
	public static Sprite BigTableBL = new Sprite(16, 8, 1, Sheet1);
	public static Sprite BigTableBR = new Sprite(16, 9, 1, Sheet1);
	
	//Wood
	public static Sprite WoodFloor = new Sprite(16, 4, 0, Sheet1);
	public static Sprite DarkWoodFloor = new Sprite(16, 4, 1, Sheet1);
	
	//Doors
	public static Sprite Door1Top = new Sprite(16, 5, 0, Sheet1);
	public static Sprite Door1Bottom = new Sprite(16, 5, 1, Sheet1);
	
	//Bookcase
	public static Sprite BookCaseTop = new Sprite(16, 10, 0, Sheet1);
	public static Sprite BookCaseBottom = new Sprite(16, 10, 1, Sheet1);
	
	//Bed
	public static Sprite BedTop = new Sprite(16, 14, 0, Sheet1);
	public static Sprite BedBottom = new Sprite(16, 14, 1, Sheet1);
	
	//Windows
	public static Sprite Window1Top = new Sprite(16, 6, 0, Sheet1);
	public static Sprite Window1Bottom = new Sprite(16, 6, 1, Sheet1);
	
	//Chair
	public static Sprite ChairTop = new Sprite(16, 7, 0, Sheet1);
	public static Sprite ChairBottom = new Sprite(16, 7, 1, Sheet1);
	
	//House
	public static Sprite BrickTile = new Sprite(16, 0, 1, Sheet1);
	public static Sprite Pole = new Sprite(16, 1, 1, Sheet1);
	public static Sprite PoleBot = new Sprite(16, 1, 2, Sheet1);
	public static Sprite Stairs1 = new Sprite(16, 2, 1, Sheet1);
	public static Sprite HouseExt = new Sprite(16, 3, 1, Sheet1);
	
	//Jail
	public static Sprite JailCell = new Sprite(16, 15, 0, Sheet1);
	
	//Man
	public static Sprite ManTop1 = new Sprite(16, 12, 1, Sheet1);
	public static Sprite ManTop2 = new Sprite(16, 13, 1, Sheet1);
	public static Sprite ManBottom = new Sprite(16, 12, 2, Sheet1);
	
	//New Tiles
	public static Sprite TreeTL = new Sprite(16, 2, 2, Sheet1);
	public static Sprite TreeBL = new Sprite(16, 2, 3, Sheet1);
	public static Sprite TreeMT = new Sprite(16, 3, 2, Sheet1);
	public static Sprite TreeMB = new Sprite(16, 3, 3, Sheet1);
	public static Sprite TreeTR = new Sprite(16, 4, 2, Sheet1);
	public static Sprite TreeBR = new Sprite(16, 2, 4, Sheet1);
	public static Sprite TreeBark = new Sprite(16, 3, 4, Sheet1);
	
	
	//Player Sprites
	//Scout
	public static SpriteSheet ScoutSheet = new SpriteSheet("/Characters/Scout.png",69,101);
	public static SpriteSheet DuboseSheet = new SpriteSheet("/Characters/Dubose.png",18,67);
	public static SpriteSheet JemSheet = new SpriteSheet("/Characters/Jem.png",69,109);
	public static SpriteSheet JemEgyptianSheet = new SpriteSheet("/Characters/JemEgyptian.png",35,109);
	public static SpriteSheet AtticusSheet = new SpriteSheet("/Characters/Atticus.png",69,133);
	public static Sprite[] ScoutForwardAnims, ScoutBackWardAnims, ScoutLeftAnims, ScoutRightAnims;
	public static Sprite[] DuboseIdleAnims;
	public static Sprite[] JemForwardAnims, JemBackWardAnims, JemLeftAnims, JemRightAnims, JemEgyptianLeftAnims, JemEgyptianRightAnims;
	public static Sprite[] AtticusForwardAnims, AtticusBackWardAnims, AtticusLeftAnims, AtticusRightAnims;
	public Sprites() {
		ScoutForwardAnims = new Sprite[4];
		ScoutForwardAnims[0] = new Sprite(16, 24, 1, 0, ScoutSheet);
		ScoutForwardAnims[1] = new Sprite(16, 24, 1, 1, ScoutSheet);
		ScoutForwardAnims[2] = new Sprite(16, 24, 1, 2, ScoutSheet);
		ScoutForwardAnims[3] = new Sprite(16, 24, 1, 3, ScoutSheet);
		
		ScoutBackWardAnims = new Sprite[4];
		ScoutBackWardAnims[0] = new Sprite(16, 24, 2, 0, ScoutSheet);
		ScoutBackWardAnims[1] = new Sprite(16, 24, 2, 1, ScoutSheet);
		ScoutBackWardAnims[2] = new Sprite(16, 24, 2, 2, ScoutSheet);
		ScoutBackWardAnims[3] = new Sprite(16, 24, 2, 3, ScoutSheet);
		
		ScoutLeftAnims = new Sprite[4];
		ScoutLeftAnims[0] = new Sprite(16, 24, 0, 0, ScoutSheet);
		ScoutLeftAnims[1] = new Sprite(16, 24, 0, 1, ScoutSheet);
		ScoutLeftAnims[2] = new Sprite(16, 24, 0, 2, ScoutSheet);
		ScoutLeftAnims[3] = new Sprite(16, 24, 0, 3, ScoutSheet);
		
		ScoutRightAnims = new Sprite[4];
		ScoutRightAnims[0] = new Sprite(16, 24, 3, 0, ScoutSheet);
		ScoutRightAnims[1] = new Sprite(16, 24, 3, 1, ScoutSheet);
		ScoutRightAnims[2] = new Sprite(16, 24, 3, 2, ScoutSheet);
		ScoutRightAnims[3] = new Sprite(16, 24, 3, 3, ScoutSheet);

		JemForwardAnims = new Sprite[4];
		JemForwardAnims[0] = new Sprite(16, 26, 1, 0, JemSheet);
		JemForwardAnims[1] = new Sprite(16, 26, 1, 1, JemSheet);
		JemForwardAnims[2] = new Sprite(16, 26, 1, 2, JemSheet);
		JemForwardAnims[3] = new Sprite(16, 26, 1, 3, JemSheet);
		
		JemBackWardAnims = new Sprite[4];
		JemBackWardAnims[0] = new Sprite(16, 26, 2, 0, JemSheet);
		JemBackWardAnims[1] = new Sprite(16, 26, 2, 1, JemSheet);
		JemBackWardAnims[2] = new Sprite(16, 26, 2, 2, JemSheet);
		JemBackWardAnims[3] = new Sprite(16, 26, 2, 3, JemSheet);
		
		JemLeftAnims = new Sprite[4];
		JemLeftAnims[0] = new Sprite(16, 26, 0, 0, JemSheet);
		JemLeftAnims[1] = new Sprite(16, 26, 0, 1, JemSheet);
		JemLeftAnims[2] = new Sprite(16, 26, 0, 2, JemSheet);
		JemLeftAnims[3] = new Sprite(16, 26, 0, 3, JemSheet);
		
		JemRightAnims = new Sprite[4];
		JemRightAnims[0] = new Sprite(16, 26, 3, 0, JemSheet);
		JemRightAnims[1] = new Sprite(16, 26, 3, 1, JemSheet);
		JemRightAnims[2] = new Sprite(16, 26, 3, 2, JemSheet);
		JemRightAnims[3] = new Sprite(16, 26, 3, 3, JemSheet);
		
		JemEgyptianLeftAnims = new Sprite[4];
		JemEgyptianLeftAnims[0] = new Sprite(16, 26, 0, 0, JemEgyptianSheet);
		JemEgyptianLeftAnims[1] = new Sprite(16, 26, 0, 1, JemEgyptianSheet);
		JemEgyptianLeftAnims[2] = new Sprite(16, 26, 0, 2, JemEgyptianSheet);
		JemEgyptianLeftAnims[3] = new Sprite(16, 26, 0, 3, JemEgyptianSheet);
		
		JemEgyptianRightAnims = new Sprite[4];
		JemEgyptianRightAnims[0] = new Sprite(16, 26, 1, 0, JemEgyptianSheet);
		JemEgyptianRightAnims[1] = new Sprite(16, 26, 1, 1, JemEgyptianSheet);
		JemEgyptianRightAnims[2] = new Sprite(16, 26, 1, 2, JemEgyptianSheet);
		JemEgyptianRightAnims[3] = new Sprite(16, 26, 1, 3, JemEgyptianSheet);
		
		AtticusForwardAnims = new Sprite[4];
		AtticusForwardAnims[0] = new Sprite(16, 32, 1, 0, AtticusSheet);
		AtticusForwardAnims[1] = new Sprite(16, 32, 1, 1, AtticusSheet);
		AtticusForwardAnims[2] = new Sprite(16, 32, 1, 2, AtticusSheet);
		AtticusForwardAnims[3] = new Sprite(16, 32, 1, 3, AtticusSheet);
		
		AtticusBackWardAnims = new Sprite[4];
		AtticusBackWardAnims[0] = new Sprite(16, 32, 2, 0, AtticusSheet);
		AtticusBackWardAnims[1] = new Sprite(16, 32, 2, 1, AtticusSheet);
		AtticusBackWardAnims[2] = new Sprite(16, 32, 2, 2, AtticusSheet);
		AtticusBackWardAnims[3] = new Sprite(16, 32, 2, 3, AtticusSheet);
		
		AtticusLeftAnims = new Sprite[4];
		AtticusLeftAnims[0] = new Sprite(16, 32, 0, 0, AtticusSheet);
		AtticusLeftAnims[1] = new Sprite(16, 32, 0, 1, AtticusSheet);
		AtticusLeftAnims[2] = new Sprite(16, 32, 0, 2, AtticusSheet);
		AtticusLeftAnims[3] = new Sprite(16, 32, 0, 3, AtticusSheet);
		
		AtticusRightAnims = new Sprite[4];
		AtticusRightAnims[0] = new Sprite(16, 32, 3, 0, AtticusSheet);
		AtticusRightAnims[1] = new Sprite(16, 32, 3, 1, AtticusSheet);
		AtticusRightAnims[2] = new Sprite(16, 32, 3, 2, AtticusSheet);
		AtticusRightAnims[3] = new Sprite(16, 32, 3, 3, AtticusSheet);
		
		DuboseIdleAnims = new Sprite[2];
		DuboseIdleAnims[0] = new Sprite(16, 32, 0, 0, DuboseSheet);
		DuboseIdleAnims[1] = new Sprite(16, 32, 0, 1, DuboseSheet);
	}
}
