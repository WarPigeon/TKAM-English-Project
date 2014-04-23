package com.runetooncraft.TKAM;

import java.io.File;
import java.util.Random;

import com.runetooncraft.warpigeon.engine.level.RandomLevel;

public class RandomLevelTKAM extends RandomLevel {

	private static final Random random = new Random();
	public RandomLevelTKAM(int width, int height, File workingDir,String LevelName) {
		super(width, height, workingDir, LevelName);
	}
	
	public void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int d = random.nextInt(4);
				if(d == 0 || d == 1 || d == 2) {
					tiles[x+y*width] = random.nextInt(2);
				} else if(d == 3){
					tiles[x+y*width] = random.nextInt(3);
				} 
				for(int[] Layer: LayerList) {
					Layer[x+y*width] = EmptyTile.getTileID();
				}
			}
		}
		SaveLevel();
	}

}
