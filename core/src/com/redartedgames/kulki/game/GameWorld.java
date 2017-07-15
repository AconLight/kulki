package com.redartedgames.kulki.game;

import com.redartedgames.kulki.atoms.AtomsHandler;
import com.redartedgames.kulki.screenhandle.World;

public class GameWorld extends World{

	private AtomsHandler atomsHandler;
	
	public GameWorld() {
		atomsHandler = new AtomsHandler();
	}
	
	@Override
	public void update(float delta) {
		atomsHandler.colidate();
		atomsHandler.update(delta);

	}

	public AtomsHandler getAtomsHandler() {
		return atomsHandler;
	}
}
