package com.redartedgames.kulki.atoms;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class AtomsHandler {
	
	private ArrayList<Atom> atoms;

	public AtomsHandler() {
		atoms = new ArrayList<Atom>();
		Random g = new Random();
		
		for (int i = 0; i < 100; i++) {
			atoms.add(new Atom( 50 + i%10*70 + g.nextInt(60) - 30, 70*(i/10) + 50 + g.nextInt(60) - 30, i));
		}
	}
	
	public void update(float delta) {
		ListIterator<Atom> itr = atoms.listIterator();
		while(itr.hasNext()) {
			Atom e = itr.next();
			e.update(delta);
		}
	}
	
	public ArrayList<Atom> getAtoms() {
		return atoms;
	}
}
