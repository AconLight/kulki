package com.redartedgames.kulki.objectsystem;

import com.badlogic.gdx.Gdx;

public class Logging {

	private int level;
	
	public Logging() {
		level = 0;
	}
	
	public void log(int level, String name, String log) {
		if (this.level >= level) Gdx.app.log(name, log);
	}
}
