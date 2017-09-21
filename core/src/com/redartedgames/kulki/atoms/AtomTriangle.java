package com.redartedgames.kulki.atoms;

import java.util.ArrayList;

public class AtomTriangle {
	private ArrayList<Atom> atoms;
	public boolean toRender;
	public AtomTriangle (Atom atom1, Atom atom2, Atom atom3) {
		atoms = new ArrayList<Atom>();
		atoms.add(atom1);
		atoms.add(atom2);
		atoms.add(atom3);
	}
	public AtomTriangle (Atom atom1, Atom atom2, Atom atom3, boolean toRender) {
		atoms = new ArrayList<Atom>();
		atoms.add(atom1);
		atoms.add(atom2);
		atoms.add(atom3);
		this.toRender = toRender;
	}
	
	public ArrayList<Atom> getAtoms() {
		return atoms;
	}

}
