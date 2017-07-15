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
		atomTriangles.add(new AtomTriangle(atoms.get(0), atoms.get(1), atoms.get(2))); // tak napisa�em, �eby zobaczy�, czy dzia�a wszystko
		/*
				J�drzeju, potrzebuj� algorytmu, kt�ry stworzy z punkt�w tr�jk�ty
			tr�jk�ty powinny powstawa�, je�li atomy s� dostatecznie blisko siebie
			tzn bok trojk�ta nie mo�e przekracza� jakiej� d�ugo�ci - powiedzmy 200
			masz referencj� do atom�w (atoms) oraz pust� list� na tr�jk�ty (atomTriangles)
			w klasie Atom jest nieu�ywana lista atoms, polecam w niej trzyma� atomy, kt�re s� dostatecznie blisko
			zale�y mi na jak najwy�szej sprawno�ci czasowej algorytmu
			mo�esz sb tutaj doda� jakie� funkcje pomocnicze, albo w klasie AtomTriangle (np. equals)
			w razie czego ctr + lpm, aby podejrze� klas�
			atomy i tr�jk�ty b�d� automatycznie si� wy�wietla�, �eby� m�g� zobaczy�, czy dzia�a
			gl & hf
		*/
		this.atomTriangles = atomTriangles;
		
	}
}
