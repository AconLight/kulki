package com.redartedgames.kulki.atoms;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.kulki.objectsystem.GameObject;
import com.redartedgames.kulki.physics.Movement;

public class Atom extends GameObject{
	
	
	
	
	//NEED TO IMPROVE THIS SHITTY CODE PROTOTYPE
	
	
	
	
	
	
	
	//sin(100*x^2/(x^2+25))/(x^2+25)
		public Movement movement; 
		private Movement myMov;
		public Circle circle1, circle2;
		public double k,a,b,h;
		public double energy, energyV;
		public ArrayList <Atom> atoms;
		public int id;
		public float R,G,B;
		Random gen;
		public int trianglesI = 0;
		public float creationA, creationB, creationEnergyDrag;
		private AtomsHandler atomsHandler;
		
		public Atom(float x, float y, AtomsHandler atomsHandler, int id) {
			creationA = 0.5f;
			creationB = 0.7f;
			creationEnergyDrag = 0;
			gen = new Random();
			R = 0.6f + ((float)gen.nextInt(30))/100.0f;
			G = 0.3f + ((float)gen.nextInt(30))/100.0f;
			B = 0.1f + ((float)gen.nextInt(30))/100.0f;
			atoms = new ArrayList<Atom>();
			movement = new Movement(new Vector2(x, y), new Vector2(0, 0), new Vector2(0, -Consts.physicsG));
			myMov = new Movement(new Vector2(0, 0), new Vector2(0, 0), new Vector2(0, 0));
			circle1 = new Circle(x, y, 60);
			circle2 = new Circle(x, y, 60);
			k = 600; //zmienna = x/k odleg³oœæ przejœcia pomiêdzy stanami
			a = 55; // przesuniêcie funkcji - kszta³t
			b = 1; // wyciszanie funkcji, funkcja wzrasta przy odleg³oœci bliskiej zero gdy b < 1
			h = 150; //mno¿nik wartoœci
			energy = 0;
			energyV = 0;
			this.id = id;
		}
		public Atom(float x, float y, double k, double a, double b, double h, int id) {
			creationA = 0.5f;
			creationB = 0.7f;
			creationEnergyDrag = 0;
			gen = new Random();
			R = 0.6f + ((float)gen.nextInt(30))/100.0f;
			G = 0.3f + ((float)gen.nextInt(30))/100.0f;
			B = 0.1f + ((float)gen.nextInt(30))/100.0f;
			atoms = new ArrayList<Atom>();
			movement = new Movement(new Vector2(x, y), new Vector2(0, 0), new Vector2(0, -Consts.physicsG));
			myMov = new Movement(new Vector2(0, 0), new Vector2(0, 0), new Vector2(0, 0));
			circle1 = new Circle(x, y, 60);
			circle2 = new Circle(x, y, 60);
			this.k = k; //zmienna = x/k odleg³oœæ przejœcia pomiêdzy stanami
			this.a = a; // przesuniêcie funkcji - kszta³t
			this.b = b; // wyciszanie funkcji, funkcja wzrasta przy odleg³oœci bliskiej zero gdy b < 1
			this.h = h; //mno¿nik wartoœci
			energy = 10;
			energyV = 0;
		}
		
		public void checkCreation() {
			if ((creationA + creationB)*(creationA + creationB)*creationEnergyDrag > 1) {
				creationA = 0;
				creationB = 0;
				atomsHandler.addAtom(creationA*10, creationB*10, k, a, b, h);
			}
		}
		
		@Override
		public void update (float delta) {
			delta /= 4;
			if (delta > 0.01f) delta = 0.01f;
			trianglesI = 0;
			energyV = -energy/10;
			energy += energyV*delta;
			
			myMov.update(delta);
			myMov.setAcceleration(0, 0);
			//myMov.setVelocity((myMov.getVelocity().x + energy),
					//(myMov.getVelocity().y + energy));
			float vr = myMov.getVelocity().x*myMov.getVelocity().x + myMov.getVelocity().y*myMov.getVelocity().y;
			vr = (float) Math.sqrt(Math.sqrt(vr));
			myMov.getVelocity().set(myMov.getVelocity().x/vr, myMov.getVelocity().y/vr);
			myMov.getVelocity().set(myMov.getVelocity().x*(1 + (float) energy/100),
					myMov.getVelocity().y*(1 + (float) energy/100));
			if (energy > 400) {
				k += energy/1000 * delta;
				a += energy/1000 * delta;
				b += energy/500 * delta;
				h -= energy/1000 * delta;
			}
			else if (energy > 300) {
				
			}
			movement.add(myMov);
			movement.update(delta);
			myMov.setVelocity(0, 0);
			myMov.setPosition(0, 0);
			
			//odbijanie
			if(movement.getPosition().y<50) {
				movement.getVelocity().y*=-0.94f;
				movement.getPosition().y = 50;
			}
			if(movement.getPosition().x<50) {
				movement.getVelocity().x*=-0.94f;
				movement.getPosition().x = 50;
			}
			if(movement.getPosition().x>2000) {
				movement.getVelocity().x*=-0.94f;
				movement.getPosition().x = 2000;
			}
			movement.getVelocity().x *= 0.999f;
			movement.getVelocity().y *= 0.999f;
		}
		
		public void collidate(Atom atom) {
			double dx = movement.getPosition().x - atom.movement.getPosition().x;
			double dy = movement.getPosition().y - atom.movement.getPosition().y;
			double dr = dx*dx + dy*dy + 0.1; // w celu unikniêcia NaN
			/*
			//////////////////////////////////
			if (dr < 100000) {
				//Gdx.app.log("jest con", "");
				boolean flaga = true;
				double dx2;
				double dy2;
				double dr2;
				for (int i = 0; i < atoms.size(); i++) {
					dx2 = movement.getPosition().x - atoms.get(i).movement.getPosition().x;
					dy2 = movement.getPosition().y - atoms.get(i).movement.getPosition().y;
					dr2 = dx2*dx2 + dy2*dy2 + 0.1; // w celu unikniêcia NaN
					if (atoms.get(i) == atom) {
						flaga = false;
					}
					if (flaga && i == atoms.size() - 1) {
						atoms.add(atom);
						flaga = false;
					}
				}
				if (flaga) {
					atoms.add(atom);

				}
			}
			/////////////////////////////////
			*/
			double k2 = (k+atom.k)/2;
			double a2 = (a+atom.a)/2;
			double b2 = (b+atom.b)/2;
			double h2 = (h+atom.h)/2;
			double f = h2*(Math.sin(((dr/k2+a2)/(dr/k2+1)))/(dr/k2+b2));// + 150/(dr+10));
			myMov.addAcceleration((float)((dx/dr)*f*f*f), (float)((dy/dr)*f*f*f));
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
