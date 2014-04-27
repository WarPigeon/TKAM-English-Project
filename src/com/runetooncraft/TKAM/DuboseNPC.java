package com.runetooncraft.TKAM;

import com.runetooncraft.warpigeon.engine.entity.mob.Npc;
import com.runetooncraft.warpigeon.engine.graphics.Sprite;

public class DuboseNPC extends Npc {

	public static boolean anim = false;
	public final Sprite[] Idleanims;
	
	public DuboseNPC(Sprite[] ForwardAnims, Sprite[] BackwardAnims,
			Sprite[] LeftAnims, Sprite[] RightAnims, int XPosition,
			int YPosition, int TileSize) {
		super(ForwardAnims, BackwardAnims, LeftAnims, RightAnims, XPosition, YPosition,
				TileSize);
		Idleanims = ForwardAnims;
	}
	
	public void BeginAnim() {
		anim = true;
		Thread animThread = new Thread() {
			int animloc = 0;
			public void run() {
				while(anim) {
					try {
						Thread.sleep(200);
						if(animloc == 0) {
							sprite = Idleanims[0];
							animloc = 1;
						} else {
							sprite = Idleanims[1];
							animloc = 0;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		animThread.start();
	}

}
