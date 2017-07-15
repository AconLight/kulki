package com.redartedgames.kulki.game;

import com.redartedgames.kulki.screenhandle.MyScreen;
import com.redartedgames.kulki.screenhandle.ScreenRenderer;
import com.redartedgames.kulki.screenhandle.World;

public class GameScreen extends MyScreen{

	
	public GameScreen(int width, int height) {
		super(width, height);
		world = new GameWorld();
		screenRenderer = new GameRenderer(camera, (GameWorld)world);
	}

}
