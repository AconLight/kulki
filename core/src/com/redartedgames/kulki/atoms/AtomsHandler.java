package com.redartedgames.kulki.atoms;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class AtomsHandler {
	private ArrayList<Atom> atoms;
	private ArrayList<Atom> atomsToAdd;

	public AtomsHandler() {
		atoms = new ArrayList<Atom>();
		atomsToAdd = new ArrayList<Atom>();
		Random g = new Random();
		for (int i = 0; i < 93; i++) {
			atoms.add(new Atom( 150 + i%10*60 + g.nextInt(60) - 30, 30*(i/10) + 3+ g.nextInt(10), this,  i));
		}
	}
	
	public void update(float delta) {
			ListIterator<Atom> itr = atoms.listIterator();
			while(itr.hasNext()) {
				Atom e = itr.next();
				//if (e.id != 95)
				e.update(delta);
				if (e.checkCreation()) {
					e.eject(this);
				}
			}
			if (atomsToAdd.size() > 0) {
				atoms.addAll(atomsToAdd);
				atomsToAdd = new ArrayList<Atom>();
			}
	}
	
	public void colidate() {
		for (int i = 0; i < atoms.size(); i++) {
			for (int j = 0; j < atoms.size(); j++) {
				if (i != j) {
					atoms.get(i).collidate(atoms.get(j));
				}
			}
		}
	}
	
	public void addAtom(float x, float y, float vx, float vy, double k, double a, double b, double h) {
		atomsToAdd.add(new Atom(x, y, vx, vy, k, a, b, h, this, atoms.size()));
	}
	
	public ArrayList<Atom> getAtoms() {
		return atoms;
	}
}
