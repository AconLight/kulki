package com.redartedgames.kulki.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.kulki.screenhandle.ScreenRenderer;

public class GameRenderer extends ScreenRenderer {
	
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	
	public GameRenderer(OrthographicCamera camera) {
		this.camera = camera;
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
	}
	
	@Override
	public void render() {
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.triangle(10, 10, 10, 100, 100, 10,
				new Color(0.2f,0.1f,0.6f,1), 
				new Color(0,0.2f,0.7f,1), 
				new Color(0,0.1f,0.8f,1));
		
		shapeRenderer.triangle(150, 110, 10, 100, 100, 10,
				new Color(0.1f,0.3f,0.8f,1), 
				new Color(0,0.2f,0.7f,1), 
				new Color(0,0.1f,0.8f,1));
		
		shapeRenderer.triangle(150, 110, 120, 160, 10, 100,
				new Color(0.1f,0.3f,0.8f,1), 
				new Color(0.3f,0.4f,0.9f,1), 
				new Color(0,0.2f,0.7f,1));
		
		shapeRenderer.end();
	}
}