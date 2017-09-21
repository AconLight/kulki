package com.redartedgames.kulki.editor;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.redartedgames.kulki.game.GameInputHandler;
import com.redartedgames.kulki.game.GameScreen;
import com.redartedgames.kulki.screenhandle.MyScreen;

public class EditorGame extends Game{
ArrayList<MyScreen> myScreens;
	
	
	@Override
	public void create() {
		myScreens = new ArrayList<MyScreen>();
		MyScreen ms = new GameScreen(640*2, 360*2);
		myScreens.add(ms);
		//Gdx.gl.glClearColor( 153f/255, 76f/255, 0f/255, 1 );
		Gdx.input.setInputProcessor(new GameInputHandler(myScreens.get(0).getWorld()));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		ListIterator<MyScreen> itr = myScreens.listIterator();
		
		while (itr.hasNext()) {
			MyScreen e = itr.next();
			e.update(Gdx.graphics.getDeltaTime());
			e.render();
		}
	}
	
	@Override
	public void dispose() {
		
	}
}
