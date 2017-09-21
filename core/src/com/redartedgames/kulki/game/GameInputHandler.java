package com.redartedgames.kulki.game;

import com.badlogic.gdx.Input.Keys;
import com.redartedgames.kulki.atoms.Atom;
import com.redartedgames.kulki.atoms.Consts;
import com.redartedgames.kulki.screenhandle.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class GameInputHandler implements InputProcessor{

	private GameWorld world;
	
	public GameInputHandler(World world) {
		this.world = (GameWorld) world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.Q: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.h += 5;
			}
			Gdx.app.log("h", "" + world.getAtomsHandler().getAtoms().get(0).h);
			break;
		}
		
		case Keys.W: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.h -= 5;
			}
			Gdx.app.log("h", "" + world.getAtomsHandler().getAtoms().get(0).h);
			break;
		}	
		case Keys.A: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.a += 0.5f;
			}
			Gdx.app.log("a", "" + world.getAtomsHandler().getAtoms().get(0).a);
			break;
		}
		
		case Keys.S: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.a -= 0.5f;
			}
			Gdx.app.log("a", "" + world.getAtomsHandler().getAtoms().get(0).a);
			break;
		}	
		case Keys.Z: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.k += 5;
			}
			Gdx.app.log("k", "" + world.getAtomsHandler().getAtoms().get(0).k);
			break;
		}
		
		case Keys.X: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.k -= 5;
			}
			Gdx.app.log("k", "" + world.getAtomsHandler().getAtoms().get(0).k);
			break;
		}	
		case Keys.C: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.b += 0.1f;
			}
			Gdx.app.log("b", "" + world.getAtomsHandler().getAtoms().get(0).b);
			break;
		}
		
		case Keys.V: {
			for (Atom atom : world.getAtomsHandler().getAtoms()) {
				atom.b -= 0.1f;
			}
			Gdx.app.log("b", "" + world.getAtomsHandler().getAtoms().get(0).b);
			break;
		}	
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
