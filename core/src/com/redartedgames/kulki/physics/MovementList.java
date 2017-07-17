package com.redartedgames.kulki.physics;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class MovementList {
	
	// the main mov is the last one
	private int strength;
	private ArrayList<Movement> movements;
	
	public MovementList(int size, int strength) {
		
		this.strength = strength;
		
		movements = new ArrayList<Movement>();
		
		if (size < 1) size = 1;
		
		for (int i = 0; i < size; i++) {
			movements.add(new Movement());
		}
	}
	
	public void update(float delta) {

		for (int i = 0; i < movements.size()-1; i++) {
			movements.get(i).set(movements.get(i+1));
		}
		
		
		
		movements.get(movements.size()-1).update(delta);
		
		
		
		//for (int j = 0; j < strength; j++)
		for (int i = 0; i < movements.size()-1; i++) {
			movements.get(movements.size()-1).add(movements.get(i));
		}
		
		movements.get(movements.size()-1).scl(1f/movements.size());
		
	}
	
	public Movement getFirstMovement() {
		return movements.get(movements.size()-1);
	}
	
	public void setFirst(Movement mov) {
		movements.get(movements.size()-1).set(mov);
	}
	
	public void setFirstAcceleration(float ax, float ay) {
		movements.get(movements.size()-1).setAcceleration(ax, ay);;
	}
	
	public void setFirstVelocity(float ax, float ay) {
		movements.get(movements.size()-1).setVelocity(ax, ay);;
	}
	
	public void setFirstPosition(float ax, float ay) {
		movements.get(movements.size()-1).setPosition(ax, ay);;
	}
	
	public Vector2 getFirstPosition() {
		return movements.get(movements.size()-1).getPosition();
	}
	
	public void addFirstAcceleration(float ax, float ay) {
		movements.get(movements.size()-1).addAcceleration(ax, ay);;
	}
}
