package com.redartedgames.kulki.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.redaertedgames.kulki.editor.TriangulationTest;
import com.redartedgames.kulki.KulkiGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640*2;
		config.height = 360*2;
		new LwjglApplication(new TriangulationTest(), config);
	}
}
