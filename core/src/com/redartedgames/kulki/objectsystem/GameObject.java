package com.redartedgames.kulki.objectsystem;

import com.badlogic.gdx.Gdx;

public class GameObject implements Loggable {
	
	private Logging logging;
	
	public GameObject() {
		
	}
	
	public void update() {
		
	}
	
	public void setLogging(Logging logging) {
		this.logging = logging;
	}

	@Override
	public void log1() {
		Gdx.app.log("GameObject", "unimplemented log");
	}

	@Override
	public void log2() {
		Gdx.app.log("GameObject", "unimplemented log");		
	}

	@Override
	public void log3() {
		Gdx.app.log("GameObject", "unimplemented log");
	}

	@Override
	public void log4() {
		Gdx.app.log("GameObject", "unimplemented log");
	}

	@Override
	public void log5() {
		Gdx.app.log("GameObject", "unimplemented log");
	}

}
