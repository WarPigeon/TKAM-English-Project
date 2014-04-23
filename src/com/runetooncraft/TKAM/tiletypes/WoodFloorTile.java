package com.runetooncraft.TKAM.tiletypes;

import com.runetooncraft.warpigeon.engine.graphics.ScreenEngine2D;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.Level;
import com.runetooncraft.warpigeon.engine.level.Tile;

public class WoodFloorTile extends Tile {

	public WoodFloorTile(Sprite sprite, int TileID) {
		super(sprite, TileID, "WoodFloor");
		
	}
	
	public void render(int x, int y, ScreenEngine2D screen, int Layer) {
		int PDR = screen.ImageToPixelRatio;
		screen.renderTile(x << Level.PDR, y << Level.PDR, this);
	}

}
