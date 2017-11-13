package com.redartedgames.kulki.rendering;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.redartedgames.kulki.atoms.Atom;
import com.redartedgames.kulki.atoms.AtomTriangle;

import io.github.jdiemke.triangulation.DelaunayTriangulator;
import io.github.jdiemke.triangulation.NotEnoughPointsException;
import io.github.jdiemke.triangulation.Triangle2D;
import io.github.jdiemke.triangulation.Vector2D;

public class Trianglation {
	boolean flaga = false;
	private ArrayList<Atom> atoms;
	
	private float maxL = 100;
	public DelaunayTriangulator delaunayTriangulator;
	
	private ArrayList<AtomTriangle> atomTriangles;
	
	public Trianglation (ArrayList<Atom> atoms) {
		this.atoms = atoms;
		atomTriangles = new ArrayList<AtomTriangle>();
		calculate();
	}
	
	
	public ArrayList<Atom> getAtoms() {
		return atoms;
	}

	public ArrayList<AtomTriangle> getAtomTriangles() {
		return atomTriangles;
	}
	
	public void calculate() {
		ArrayList<AtomTriangle> atomTriangles = new ArrayList<AtomTriangle>();
		//TODO
		
	    List<Vector2D> pointSet = new ArrayList<Vector2D>();
	    
	    for(Atom a : atoms) {
	    	pointSet.add(new Vector2D(a.movement.getPosition().x, a.movement.getPosition().y, new Color(a.R, a.G, a.B, 1)));
	    }
	    
	    delaunayTriangulator = new DelaunayTriangulator(pointSet);
	    
	    try {
			delaunayTriangulator.triangulate();
		} catch (NotEnoughPointsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<Triangle2D> trianglesToRem = new ArrayList<Triangle2D>();
	    
	    for (Triangle2D t : delaunayTriangulator.getTriangles()) {
	    	double dx, dy, dr;
	    	dx = t.a.x - t.b.x;
	    	dy = t.a.y - t.b.y;
	    	dr = Math.sqrt(dx*dx + dy*dy);
	    	
	    	if (dr > maxL) {
	    		trianglesToRem.add(t);
	    		continue;
	    	}
	    	
	    	dx = t.c.x - t.b.x;
	    	dy = t.c.y - t.b.y;
	    	dr = Math.sqrt(dx*dx + dy*dy);
	    	
	    	if (dr > maxL) {
	    		trianglesToRem.add(t);
	    		continue;
	    	}
	    	
	    	dx = t.a.x - t.c.x;
	    	dy = t.a.y - t.c.y;
	    	dr = Math.sqrt(dx*dx + dy*dy);
	    	
	    	if (dr > maxL) {
	    		trianglesToRem.add(t);
	    		continue;
	    	}
	    }
	    
	    delaunayTriangulator.getTriangles().removeAll(trianglesToRem);
		
		this.atomTriangles = atomTriangles;
		
	}
	
	void trian(ArrayList<AtomTriangle> atomtriangles, ArrayList<Atom> atoms, Atom atom1, Atom atom2, Atom atom3, Atom atom) {
		ArrayList<Atom> atoms1, atoms2, atoms3;
		atoms1 = new ArrayList<Atom>();
		atoms2 = new ArrayList<Atom>();
		atoms3 = new ArrayList<Atom>();
		
		atoms.remove(atom);
		atoms.remove(atom1);
		atoms.remove(atom2);
		atoms.remove(atom3);
		
		for (Atom a : atoms) {
			if (PointInTriangle(a, atom1, atom2, atom)) atoms3.add(a);
			else if (PointInTriangle(a, atom3, atom2, atom)) atoms1.add(a);
			else if (PointInTriangle(a, atom1, atom3, atom)) atoms2.add(a);
		}
		
		if (atoms1.size() > 0) {
			trian(atomtriangles, atoms1, atom3, atom2, atom, atoms1.get(0));
		}
		else if (atom3.toRender && atom2.toRender){
			atomtriangles.add(new AtomTriangle(atom3, atom2, atom));
			//Gdx.app.log("trian", "atom3 : " + atom3.id + " atom2 : " + atom2.id + " atom : " + atom.id);
		}
		
		if (atoms2.size() > 0) {
			trian(atomtriangles, atoms2, atom3, atom1, atom, atoms2.get(0));
		}
		else if (atom3.toRender && atom1.toRender){
			atomtriangles.add(new AtomTriangle(atom3, atom1, atom));
			//Gdx.app.log("trian", "atom1 : " + atom1.id + " atom3 : " + atom3.id + " atom : " + atom.id);
		}
		
		if (atoms3.size() > 0) {
			trian(atomtriangles, atoms3, atom1, atom2, atom, atoms3.get(0));
		}
		else if (atom2.toRender && atom1.toRender){
			atomtriangles.add(new AtomTriangle(atom1, atom2, atom));
			//Gdx.app.log("trian", "atom1 : " + atom1.id + " atom2 : " + atom2.id + " atom : " + atom.id);
		}
	}
	
	float sign (Atom p1, Atom p2, Atom p3)
	{
	    return (p1.movement.getPosition().x - p3.movement.getPosition().x) * (p2.movement.getPosition().y - p3.movement.getPosition().y) - (p2.movement.getPosition().x - p3.movement.getPosition().x) * (p1.movement.getPosition().y - p3.movement.getPosition().y);
	}

	boolean PointInTriangle (Atom pt, Atom v1, Atom v2, Atom v3)
	{
	    boolean b1, b2, b3;

	    b1 = sign(pt, v1, v2) < 0.0f;
	    b2 = sign(pt, v2, v3) < 0.0f;
	    b3 = sign(pt, v3, v1) < 0.0f;

	    return ((b1 == b2) && (b2 == b3));
	}

}
