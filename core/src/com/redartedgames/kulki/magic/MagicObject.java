package com.redartedgames.kulki.magic;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.kulki.atoms.Atom;
import com.redartedgames.kulki.objectsystem.GameObject;
import com.redartedgames.kulki.physics.Movement;

public class MagicObject extends GameObject{

	private Movement movement;
	
	public MagicObject (float x, float y, float vx, float vy) {
		movement = new Movement(new Vector2(x, y), new Vector2(vx, vy), new Vector2(0, 0));
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		movement.update(delta);
	}
	
	public void colidate(Atom atom) {
		
	}
	
	
}
