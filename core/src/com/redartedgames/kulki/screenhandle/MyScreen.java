package com.redartedgames.kulki.screenhandle;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyScreen {
	
	private Viewport viewport;
	
	protected OrthographicCamera camera;
	
	protected ScreenRenderer screenRenderer;
	
	protected World world;
	
	public MyScreen(int width, int height) {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		viewport = new ScreenViewport();
		viewport.setWorldSize(width, height);
		viewport.setCamera(camera);
		viewport.setScreenSize(width, height);
		screenRenderer = new ScreenRenderer();
		world = new World();
	}
	
	public void render() {
		screenRenderer.render();
	}
	
	public void update(float delta) {
		world.update(delta);
	}

	public OrthographicCamera getCamera() {
		return camera;
	}


	
}
