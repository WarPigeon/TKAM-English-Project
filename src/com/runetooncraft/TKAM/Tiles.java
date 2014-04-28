package com.runetooncraft.TKAM;

import com.runetooncraft.TKAM.tiletypes.*;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.Level;
import com.runetooncraft.warpigeon.engine.level.Tile;
import com.runetooncraft.warpigeon.testengine.tiles.GrassTile;
import com.runetooncraft.warpigeon.testengine.tiles.VoidTile;

public class Tiles {
	//Void
	public static Tile Void = new BasicTile(Sprites.Void,3,"VoidTile",true);
	
	//Grass
	public static Tile Grass1 = new GrassTile(Sprites.Grass1,0);
	public static Tile Grass2 = new GrassTile(Sprites.Grass2,1);
	public static Tile Grass3 = new GrassTile(Sprites.Grass3,2);
	
	//Wood
	public static Tile WoodFloor = new BasicTile(Sprites.WoodFloor, 4, "WoodFloor", false);
	public static Tile DarkWoodFloor = new BasicTile(Sprites.DarkWoodFloor, 5, "DarkWood", true);
	
	//Doors
	public static Tile Door1Top = new BasicTile(Sprites.Door1Top, 6, "Door1Top", true);
	public static Tile Door1Bottom = new BasicTile(Sprites.Door1Bottom, 7, "Door1Bottom", true);
	
	//Bookcase
	public static Tile BookcaseTop = new BasicTile(Sprites.BookCaseTop, 22, "BookCaseTop", true);
	public static Tile BookcaseBottom = new BasicTile(Sprites.BookCaseBottom, 23, "BookCaseBottom", true);
	
	//Bed
	public static Tile BedTop = new BasicTile(Sprites.BedTop, 24, "BedTop", false);
	public static Tile BedBottom = new BasicTile(Sprites.BedBottom, 25, "BedBottom", false);
	
	//Wall Interior
	public static Tile WallInterior = new BasicTile(Sprites.WallInterior, 17, "WallInterior", true);
	
	//Table
	public static Tile BigTableTL = new BasicTile(Sprites.BigTableTL, 18, "BigTableTopLeft", true);
	public static Tile BigTableTR = new BasicTile(Sprites.BigTableTR, 19, "BigTableTopRight", true);
	public static Tile BigTableBL = new BasicTile(Sprites.BigTableBL, 20, "BigTableBottomLeft", true);
	public static Tile BigTableBR = new BasicTile(Sprites.BigTableBR, 21, "BigTableBottomRight", true);
	
	//Windows
	public static Tile Window1Top = new BasicTile(Sprites.Window1Top, 13, "Window1Top", true);
	public static Tile Window1Bottom = new BasicTile(Sprites.Window1Bottom, 14, "Window1Bottom", true);
	
	//Chair
	public static Tile ChairTop = new BasicTile(Sprites.ChairTop, 15, "ChairTop", true);
	public static Tile ChairBottom = new BasicTile(Sprites.ChairBottom, 16, "ChairBottom", true);
	
	//House Tiles
	public static Tile BrickTile = new BasicTile(Sprites.BrickTile, 8, "BrickTile", true);
	public static Tile PoleTile = new BasicTile(Sprites.Pole, 9, "Pole", false);
	public static Tile PoleBotTile = new BasicTile(Sprites.PoleBot, 10, "PoleBot", false);
	public static Tile Stairs1 = new BasicTile(Sprites.Stairs1, 11, "Stairs1", false);
	public static Tile HouseExt = new BasicTile(Sprites.HouseExt, 12, "HouseExt", true);
	
	//Man
	public static Tile ManTop1 = new BasicTile(Sprites.ManTop1, 27, "ManTop1", false);
	public static Tile ManTop2 = new BasicTile(Sprites.ManTop2, 28, "ManTop2", false);
	public static Tile ManBottom = new BasicTile(Sprites.ManBottom, 29, "ManBottom", false);
	
	//Jail
	public static Tile JailCell = new BasicTile(Sprites.JailCell, 26, "JailCell", true);
	
	
	//Tree
	public static Tile TreeTL = new BasicTile(Sprites.TreeTL, 30, "TreeTL", true);
	public static Tile TreeBL = new BasicTile(Sprites.TreeBL, 31, "TreeBL", true);
	public static Tile TreeMT = new BasicTile(Sprites.TreeBL, 32, "TreeMT", true);
	public static Tile TreeMB = new BasicTile(Sprites.TreeMB, 33, "TreeMB", true);
	public static Tile TreeTR = new BasicTile(Sprites.TreeTR, 34, "TreeTr", true);
	public static Tile TreeBR = new BasicTile(Sprites.TreeBR, 35, "TreeBR", true);
	public static Tile TreeBark = new BasicTile(Sprites.TreeBark, 36, "TreeBark", true);
	public Tiles() {
		Level.TileIDS.put(0, Grass1);
		Level.TileIDS.put(1, Grass2);
		Level.TileIDS.put(2, Grass3);
		Level.TileIDS.put(3, Void);
		Level.TileIDS.put(4, WoodFloor);
		Level.TileIDS.put(5, DarkWoodFloor);
		Level.TileIDS.put(6, Door1Top);
		Level.TileIDS.put(7, Door1Bottom);
		Level.TileIDS.put(8, BrickTile);
		Level.TileIDS.put(9, PoleTile);
		Level.TileIDS.put(10, PoleBotTile);
		Level.TileIDS.put(11, Stairs1);
		Level.TileIDS.put(12, HouseExt);
		Level.TileIDS.put(13, Window1Top);
		Level.TileIDS.put(14, Window1Bottom);
		Level.TileIDS.put(15, ChairTop);
		Level.TileIDS.put(16, ChairBottom);
		Level.TileIDS.put(17, WallInterior);
		Level.TileIDS.put(18, BigTableTL);
		Level.TileIDS.put(19, BigTableTR);
		Level.TileIDS.put(20, BigTableBL);
		Level.TileIDS.put(21, BigTableBR);
		Level.TileIDS.put(22, BookcaseTop);
		Level.TileIDS.put(23, BookcaseBottom);
		Level.TileIDS.put(24, BedTop);
		Level.TileIDS.put(25, BedBottom);
		Level.TileIDS.put(26, JailCell);
		Level.TileIDS.put(27, ManTop1);
		Level.TileIDS.put(28, ManTop2);
		Level.TileIDS.put(29, ManBottom);
		Level.TileIDS.put(30, TreeTL);
		Level.TileIDS.put(31, TreeBL);
		Level.TileIDS.put(32, TreeMT);
		Level.TileIDS.put(33, TreeMB);
		Level.TileIDS.put(34, TreeTR);
		Level.TileIDS.put(35, TreeBR);
		Level.TileIDS.put(36, TreeBark);
		Level.VoidTile = Void;
		Level.LoadingTile = BrickTile;
	}

}
