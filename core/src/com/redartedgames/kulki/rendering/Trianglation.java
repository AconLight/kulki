package com.redartedgames.kulki.rendering;

import java.util.ArrayList;

import com.redartedgames.kulki.atoms.Atom;
import com.redartedgames.kulki.atoms.AtomTriangle;

public class Trianglation {

	private ArrayList<Atom> atoms;

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
		atomTriangles.add(new AtomTriangle(atoms.get(0), atoms.get(1), atoms.get(2))); // tak napisa³em, ¿eby zobaczyæ, czy dzia³a wszystko
		/*
				Jêdrzeju, potrzebujê algorytmu, który stworzy z punktów trójk¹ty
			trójk¹ty powinny powstawaæ, jeœli atomy s¹ dostatecznie blisko siebie
			tzn bok trojk¹ta nie mo¿e przekraczaæ jakiejœ d³ugoœci - powiedzmy 200
			masz referencjê do atomów (atoms) oraz pust¹ listê na trójk¹ty (atomTriangles)
			w klasie Atom jest nieu¿ywana lista atoms, polecam w niej trzymaæ atomy, które s¹ dostatecznie blisko
			zale¿y mi na jak najwy¿szej sprawnoœci czasowej algorytmu
			mo¿esz sb tutaj dodaæ jakieœ funkcje pomocnicze, albo w klasie AtomTriangle (np. equals)
			w razie czego ctr + lpm, aby podejrzeæ klasê
			atomy i trójk¹ty bêd¹ automatycznie siê wyœwietlaæ, ¿ebyœ móg³ zobaczyæ, czy dzia³a
			gl & hf
		*/
		this.atomTriangles = atomTriangles;
		
	}
}
