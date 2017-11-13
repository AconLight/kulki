package com.redartedgames.kulki.brain;

import com.redartedgames.kulki.game.GameScreen;
import com.redartedgames.kulki.game.GameWorld;

public class Experiment {
	
	GameWorld gameWorld;
	GameScreen gameScreen;
	Brain brain;
	Validation validation;
	
	public Experiment() {
		gameWorld = new GameWorld();
		gameScreen = new GameScreen(640*2, 360*2, gameWorld);
		brain = new Brain();
		validation = new Validation(gameWorld);
		
	}
}
