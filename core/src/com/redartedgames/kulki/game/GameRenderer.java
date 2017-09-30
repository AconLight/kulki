package com.redartedgames.kulki.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.kulki.atoms.AtomsHandler;
import com.redartedgames.kulki.atoms.Consts;
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
		
		
		trianglation.calculate();
		for (int i = 0; i < trianglation.delaunayTriangulator.getTriangles().size(); i++) {
			shapeRenderer.triangle((float)trianglation.delaunayTriangulator.getTriangles().get(i).a.x,
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).a.y,
					
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.x,
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.y,
					
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).c.x,
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).c.y,
					
					usrednianieKolorow1(trianglation.delaunayTriangulator.getTriangles().get(i).a.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).b.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).c.color, Consts.zachowanie),
					
					usrednianieKolorow2(trianglation.delaunayTriangulator.getTriangles().get(i).a.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).b.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).c.color, Consts.zachowanie),
					
					usrednianieKolorow3(trianglation.delaunayTriangulator.getTriangles().get(i).a.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).b.color, 
							trianglation.delaunayTriangulator.getTriangles().get(i).c.color, Consts.zachowanie));
			
		}
		
		shapeRenderer.setColor(0f/255, 0f/255, 0f/255, 1);
		
		for (int i = 0; i < trianglation.delaunayTriangulator.getTriangles().size(); i++) {
			shapeRenderer.rectLine((float)trianglation.delaunayTriangulator.getTriangles().get(i).a.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).a.y, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.y, 1);
			
			shapeRenderer.rectLine((float)trianglation.delaunayTriangulator.getTriangles().get(i).a.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).a.y, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).c.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).c.y, 1);
			
			shapeRenderer.rectLine((float)trianglation.delaunayTriangulator.getTriangles().get(i).c.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).c.y, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.x, 
					(float)trianglation.delaunayTriangulator.getTriangles().get(i).b.y, 1);
		
		}
		
		shapeRenderer.setColor(0f/255, 0f/255, 153f/255, 1);
		for (int i = 0; i < atomsHandler.getAtoms().size(); i++) {
			shapeRenderer.circle(atomsHandler.getAtoms().get(i).movement.getPosition().x, 
					atomsHandler.getAtoms().get(i).movement.getPosition().y, 5);
		}
		
		shapeRenderer.end();
		
	}
	
	Color usrednianieKolorow1(Color c1, Color c2, Color c3, float zachowanie) {
		return new Color((c1.r + zachowanie*c2.r + zachowanie*c3.r)/(2*zachowanie+1), (c1.g + zachowanie*c2.g + zachowanie*c3.g)/(zachowanie*2+1), (c1.b + zachowanie*c2.b + zachowanie*c3.b)/(zachowanie*2+1), 1);
	}
	Color usrednianieKolorow2(Color c1, Color c2, Color c3, float zachowanie) {
		return new Color((zachowanie*c1.r + c2.r + zachowanie*c3.r)/(zachowanie*2+1), (zachowanie*c1.g + c2.g + zachowanie*c3.g)/(zachowanie*2+1), (zachowanie*c1.b + c2.b + zachowanie*c3.b)/(zachowanie*2+1), 1);
	}
	Color usrednianieKolorow3(Color c1, Color c2, Color c3, float zachowanie) {
		return new Color((zachowanie*c1.r + zachowanie*c2.r + c3.r)/(zachowanie*2+1), (zachowanie*c1.g + zachowanie*c2.g + c3.g)/(zachowanie*2+1), (zachowanie*c1.b + zachowanie*c2.b + c3.b)/(zachowanie*2+1), 1);
}
}