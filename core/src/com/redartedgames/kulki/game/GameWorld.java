package com.redartedgames.kulki.game;

import java.util.ArrayList;

import com.redartedgames.kulki.atoms.AtomsHandler;
import com.redartedgames.kulki.brain.Brainable;
import com.redartedgames.kulki.screenhandle.World;

public class GameWorld extends World implements Brainable{

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

	@Override
	public void updateConnections(ArrayList<Float> values) {
		// TODO Auto-generated method stub
		
	}
}
