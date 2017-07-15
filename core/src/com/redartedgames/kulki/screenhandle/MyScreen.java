package com.redartedgames.kulki.screenhandle;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyScreen {
	
	private Viewport viewport;
	
	private OrthographicCamera camera;
	
	private ScreenRenderer screenRenderer;
	
	public MyScreen(int width, int height) {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		viewport = new ScreenViewport();
		viewport.setWorldSize(width, height);
		viewport.setCamera(camera);
		viewport.setScreenSize(200, 200);
		screenRenderer = new ScreenRenderer();
	}
	
	public void render() {
		screenRenderer.render();
	}
	
	public void setRenderer(ScreenRenderer renderer) {
		screenRenderer = renderer;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}
	
}
