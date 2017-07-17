package com.redartedgames.kulki.physics;

import com.badlogic.gdx.math.Vector2;

public class LimitedMovement extends Movement{
	
	public LimitedMovement() {
		super();
	}
	
	public LimitedMovement(Vector2 position, Vector2 velocity, Vector2 acceleration) {
		super(position, velocity, acceleration);
	}
	
	@Override
	public void update(float delta) {
		velocity.x += Math.atan(acceleration.x*delta);
		velocity.y += Math.atan(acceleration.y*delta);
		position.x += Math.atan(velocity.x*delta);
		position.y += Math.atan(velocity.y*delta);
	}
}
