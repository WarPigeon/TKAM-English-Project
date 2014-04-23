package com.runetooncraft.TKAM.tiletypes;

import com.runetooncraft.warpigeon.engine.graphics.ScreenEngine2D;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.level.Level;
import com.runetooncraft.warpigeon.engine.level.Tile;

public class BasicTile extends Tile  {

	public BasicTile(Sprite sprite, int TileID, String name) {
		super(sprite, TileID, name);
	}
	
	public void render(int x, int y, ScreenEngine2D screen, int Layer) {
		int PDR = screen.ImageToPixelRatio;
		screen.renderTile(x << Level.PDR, y << Level.PDR, this);
	}

}
