package com.redartedgames.kulki.objectsystem;

public class LoggingGameObject {
	
	private int level;
	
	public LoggingGameObject () {
		level = 0;
	}
	
	public void setLogLevel(int level) {
		this.level = level;
	}
	
	public void log1(GameObject object) {
		object.log1();
	}
	public void log2(GameObject object) {
		object.log2();
	}
	public void log3(GameObject object) {
		object.log3();
	}
	public void log4(GameObject object) {
		object.log4();
	}
	public void log5(GameObject object) {
		object.log5();
	}
	
	
	
}
