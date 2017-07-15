package com.redaertedgames.kulki.editor;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.redartedgames.kulki.game.GameRenderer;
import com.redartedgames.kulki.screenhandle.MyScreen;

public class EditorGame extends Game {
	
	ArrayList<MyScreen> myScreens;
	
	
	@Override
	public void create() {
		myScreens = new ArrayList<MyScreen>();
		MyScreen ms = new MyScreen(200, 200);
		ms.setRenderer(new GameRenderer(ms.getCamera()));
		myScreens.add(ms);
	}
	
	@Override
	public void render() {
		ListIterator itr = myScreens.listIterator();
		
		while (itr.hasNext()) {
			MyScreen e = (MyScreen) itr.next();
			e.render();
			Gdx.app.log("asd", "asd");
		}
	}
	
	@Override
	public void dispose() {
		
	}
	

}
