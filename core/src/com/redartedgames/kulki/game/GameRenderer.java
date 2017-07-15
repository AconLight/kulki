package com.redartedgames.kulki.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.kulki.atoms.AtomsHandler;
import com.redartedgames.kulki.rendering.Trianglation;
import com.redartedgames.kulki.screenhandle.ScreenRenderer;

public class GameRenderer extends ScreenRenderer {
	
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private Trianglation trianglation;
	private AtomsHandler atomsHandler;
	
	public GameRenderer(OrthographicCamera camera, GameWorld gameWorld) {
		this.camera = camera;
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		this.atomsHandler = gameWorld.getAtomsHandler();
		trianglation = new Trianglation(atomsHandler.getAtoms());
	}
	
	@Override
	public void render() {
		shapeRenderer.begin(ShapeType.Filled);
		
		/*shapeRenderer.triangle(10, 10, 10, 100, 100, 10,
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
				*/
		
		
		//trianglation.calculate();
		for (int i = 0; i < trianglation.getAtomTriangles().size(); i++) {
			shapeRenderer.triangle(trianglation.getAtomTriangles().get(i).getAtoms().get(0).movement.getPosition().x,
					trianglation.getAtomTriangles().get(i).getAtoms().get(0).movement.getPosition().y,
					
					trianglation.getAtomTriangles().get(i).getAtoms().get(1).movement.getPosition().x,
					trianglation.getAtomTriangles().get(i).getAtoms().get(1).movement.getPosition().y,
					
					trianglation.getAtomTriangles().get(i).getAtoms().get(2).movement.getPosition().x,
					trianglation.getAtomTriangles().get(i).getAtoms().get(2).movement.getPosition().y,
					
					new Color(trianglation.getAtomTriangles().get(i).getAtoms().get(0).R,
							trianglation.getAtomTriangles().get(i).getAtoms().get(0).G,
							trianglation.getAtomTriangles().get(i).getAtoms().get(0).B,1), 


					new Color(trianglation.getAtomTriangles().get(i).getAtoms().get(1).R,
							trianglation.getAtomTriangles().get(i).getAtoms().get(1).G,
							trianglation.getAtomTriangles().get(i).getAtoms().get(1).B,1), 
					
					new Color(trianglation.getAtomTriangles().get(i).getAtoms().get(2).R,
							trianglation.getAtomTriangles().get(i).getAtoms().get(2).G,
							trianglation.getAtomTriangles().get(i).getAtoms().get(2).B,1));
			
		}
		
		for (int i = 0; i < atomsHandler.getAtoms().size(); i++) {
			shapeRenderer.circle(atomsHandler.getAtoms().get(i).movement.getPosition().x, 
					atomsHandler.getAtoms().get(i).movement.getPosition().y, 10);
		}
		
		shapeRenderer.end();
		
	}
}