package com.redartedgames.kulki.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.redartedgames.kulki.brain.Brain;
import com.redartedgames.kulki.brain.Validation;

public class GameTest {

	GameWorld gameWorld;
	GameScreen gameScreen;
	Brain brain;
	Validation validation;
	float time;
	
	public GameTest() {
		gameWorld = new GameWorld();
		gameScreen = new GameScreen(640*2, 360*2, gameWorld);
		brain = new Brain();
		validation = new Validation(gameWorld);
		Gdx.input.setInputProcessor(new GameInputHandler(gameWorld));
	}
	
	public void start() {
		time = 0;
	}
	
	public void simulate(int i, float delta) {
		for (int x = 0; x < i; x++) {
			update(delta);
		}
	}
	
	public void conductExperiment() {
		start();
		simulate(40, 0.03f);
		validation.validate();
		//brain.u
	}
	
	
	public void update(float delta) {
		delta /= 10;
		time += delta;
		for (int i = 0; i < 100; i++) {
			gameScreen.update(delta);
		}
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		gameScreen.render();
	}
}
