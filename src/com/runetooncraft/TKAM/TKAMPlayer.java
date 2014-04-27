package com.runetooncraft.TKAM;

import com.runetooncraft.warpigeon.engine.entity.mob.Player;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;
import com.runetooncraft.warpigeon.engine.utils.KeyBoardEvents;

public class TKAMPlayer extends Player {

	public TKAMPlayer(int x, int y, Sprite[] ForwardAnims, Sprite[] BackwardAnims, Sprite[] LeftAnims, Sprite[] RightAnims, KeyBoardEvents input) {
		super(x * 16, y * 16, ForwardAnims, BackwardAnims, LeftAnims, RightAnims, input);
	}
	
	public boolean collision(int xa, int ya) {
		boolean solid = false;
		
		for(int i = 0; i < 4; i++) {
				int xp = ((x + xa) + i % 2 - 10) / engine.getScreenEngine2D().PixelWidth;
				int yp = ((y + ya) + i / 2 + 4) / engine.getScreenEngine2D().PixelHeight;
				if (level.getTile(xp, yp).collide(i)) solid = true;
			}
		
		return solid;
	}

}
