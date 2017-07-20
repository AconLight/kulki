package com.redartedgames.kulki.editor;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.redartedgames.kulki.game.GameRenderer;
import com.redartedgames.kulki.game.GameScreen;
import com.redartedgames.kulki.game.GameWorld;
import com.redartedgames.kulki.screenhandle.MyScreen;
import com.redartedgames.kulki.screenhandle.World;

public class TriangulationTest extends Game {
	
	ArrayList<MyScreen> myScreens;
	
	
	@Override
	public void create() {
		myScreens = new ArrayList<MyScreen>();
		MyScreen ms = new GameScreen(640*2, 360*2);
		myScreens.add(ms);
	}
	
	@Override
	public void render() {
		ListIterator<MyScreen> itr = myScreens.listIterator();
		
		while (itr.hasNext()) {
			MyScreen e = itr.next();
			e.render();
		}
	}
	
	@Override
	public void dispose() {
		
	}
	

}
