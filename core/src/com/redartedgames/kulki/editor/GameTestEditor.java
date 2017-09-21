package com.redartedgames.kulki.editor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.redartedgames.kulki.game.GameTest;

public class GameTestEditor extends Game{

	GameTest gameTest;
	
	@Override
	public void create() {
		gameTest = new GameTest();
		
	}
	
	@Override
	public void render() {
		gameTest.update(Gdx.graphics.getDeltaTime());
	}

}
