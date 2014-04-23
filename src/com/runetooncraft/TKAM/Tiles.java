package com.runetooncraft.TKAM;

import com.runetooncraft.TKAM.tiletypes.*;
import com.runetooncraft.warpigeon.engine.level.Level;
import com.runetooncraft.warpigeon.engine.level.Tile;
import com.runetooncraft.warpigeon.testengine.tiles.GrassTile;
import com.runetooncraft.warpigeon.testengine.tiles.VoidTile;

public class Tiles {
	//Void
	public static Tile Void = new VoidTile(Sprites.Void,3);
	
	//Grass
	public static Tile Grass1 = new GrassTile(Sprites.Grass1,0);
	public static Tile Grass2 = new GrassTile(Sprites.Grass2,1);
	public static Tile Grass3 = new GrassTile(Sprites.Grass3,2);
	
	//Wood
	public static Tile WoodFloor = new WoodFloorTile(Sprites.WoodFloor, 4);
	
	//Doors
	public static Tile Door1Top = new DoorTile(Sprites.Door1Top, 5, "Door1Top");
	public static Tile Door1Bottom = new DoorTile(Sprites.Door1Bottom, 6, "Door1Bottom");
	
	public Tiles() {
		Level.TileIDS.put(0, Grass1);
		Level.TileIDS.put(1, Grass2);
		Level.TileIDS.put(2, Grass3);
		Level.TileIDS.put(3, Void);
		Level.TileIDS.put(4, WoodFloor);
		Level.TileIDS.put(5, Door1Top);
		Level.TileIDS.put(6, Door1Bottom);
		Level.VoidTile = Void;
	}

}
