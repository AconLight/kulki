package com.redartedgames.kulki.physics;

import com.badlogic.gdx.math.Vector2;

public class Movement {
	private Vector2 position, velocity, acceleration;
	
	public Movement() {
		position = new Vector2(0, 0);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
	}
	public Movement(Vector2 position, Vector2 velocity, Vector2 acceleration) {
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}
	
	public void update(float delta) {
		//velocity.add(acceleration).scl(delta);
		//position.add(velocity).scl(delta);
		velocity.x += acceleration.x*delta;
		velocity.y += acceleration.y*delta;
		position.x += velocity.x*delta;
		position.y += velocity.y*delta;
	}
	
	public void add(Movement mov) {
		position.x += mov.position.x;
		position.y += mov.position.y;
		velocity.x += mov.velocity.x;
		velocity.y += mov.velocity.y;
		acceleration.x += mov.acceleration.x;
		acceleration.y += mov.acceleration.y;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	public void setVelocity(float x, float y) {
		velocity.set(x, y);
	}
	public void setVelocity(double x, double y) {
		velocity.set((float) x, (float) y);
	}
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}
	public void setAcceleration(float x, float y) {
		acceleration.set(x, y);
	}
	public void addAcceleration(float x, float y) {
		acceleration.x+=x;
		acceleration.y+=y;
	}
	
	
	
}

