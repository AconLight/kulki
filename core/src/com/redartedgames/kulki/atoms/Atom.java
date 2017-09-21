package com.redartedgames.kulki.atoms;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.kulki.objectsystem.GameObject;
import com.redartedgames.kulki.physics.LimitedMovement;
import com.redartedgames.kulki.physics.Movement;
import com.redartedgames.kulki.physics.MovementList;

public class Atom extends GameObject{
	
	
	
	
	//NEED TO IMPROVE THIS SHITTY CODE PROTOTYPE
	
	
	
	
	
	
	
	//sin(100*x^2/(x^2+25))/(x^2+25)
		public LimitedMovement movement; 
		private Movement myMov;
		private MovementList myMoves;
		public Circle circle1, circle2;
		public double k,a,b,h;
		public double energy, energyV;
		public ArrayList <Atom> atoms, atoms2;
		public int id;
		public float R,G,B;
		Random gen;
		public int trianglesI = 0;
		public float creationA, creationB, creationEnergyDrag;
		private float time;
		public boolean toRender;
		
		public Atom(float x, float y, AtomsHandler atomsHandler, int id) {
			if (id == -1) {
				toRender = false;
			}
			else toRender = true;
			time = 0;
			creationA = 0.5f;
			creationB = 0.7f;
			creationEnergyDrag = 0.3f;
			gen = new Random();
			R = 0.3f + ((float)gen.nextInt(600))/1000.0f;
			G = 0.3f + ((float)gen.nextInt(600))/1000.0f;
			B = 0.3f + ((float)gen.nextInt(600))/1000.0f;
			atoms = new ArrayList<Atom>();
			atoms2 = new ArrayList<Atom>();
			movement = new LimitedMovement(new Vector2(x, y), new Vector2(0, 0), new Vector2(0, -Consts.physicsG));
			myMoves = new MovementList(1, 1);
			myMov = new Movement(new Vector2(0, 0), new Vector2(0, 0), new Vector2(0, 0));
			circle1 = new Circle(x, y, 60);
			circle2 = new Circle(x, y, 60);
			k = 600; //zmienna = x/k odleg³oœæ przejœcia pomiêdzy stanami
			a = 55; // przesuniêcie funkcji - kszta³t
			b = 1; // wyciszanie funkcji, funkcja wzrasta przy odleg³oœci bliskiej zero gdy b < 1
			h = 60; //mno¿nik wartoœci
			energy = 0;
			energyV = 0;
			this.id = id;
		}
		public Atom(float x, float y, float vx, float vy, double k, double a, double b, double h, AtomsHandler atomsHandler, int id) {
			time = 0;
			creationA = 0.5f;
			creationB = 0.7f;
			creationEnergyDrag = 0.3f;
			gen = new Random();
			R = 0.6f + ((float)gen.nextInt(30))/100.0f;
			G = 0.3f + ((float)gen.nextInt(30))/100.0f;
			B = 0.1f + ((float)gen.nextInt(30))/100.0f;
			atoms = new ArrayList<Atom>();
			movement = new LimitedMovement(new Vector2(x, y), new Vector2(vx, vy), new Vector2(0, -Consts.physicsG));
			myMoves = new MovementList(1, 1);
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
		
		public boolean checkCreation() {
			if ((creationA + creationB)*(creationA + creationB)*creationEnergyDrag > 1) {
				
				return true;
			}
			return false;
		}
		
		public void eject(AtomsHandler atomsHandler) {
			atomsHandler.addAtom(movement.getPosition().x + creationA*5, movement.getPosition().y + creationB*5,
					movement.getVelocity().x + creationA*500, movement.getVelocity().y+creationB*500, k, a, b, h);
			creationA = 0;
			creationB = 0;
			creationEnergyDrag /= 20;
		}
		
		@Override
		public void update (float delta) {
			time += delta/(5 + time*5);
			//time += time/10;
			if (time > 1)
			time = 1;
			//delta *= time;
			//creationA += delta/10;
			//creationB += delta/20;
			//Gdx.app.log("Atom update", "" + (creationA + creationB)*(creationA + creationB)*creationEnergyDrag);
			checkCreation();
			delta /= 4;
			if (delta > 0.01f) delta = 0.01f;
			trianglesI = 0;
			energyV = -energy/10;
			//energy += energyV*delta;
			
					
					
			//myMov.setPosition((float)Math.sqrt(myMov.getPosition().x), (float)Math.sqrt(myMov.getPosition().y)); 


			
			
			myMoves.update(delta);
			myMoves.setFirstPosition((float)Math.atan(myMoves.getFirstPosition().x), 
					(float)Math.atan(myMoves.getFirstPosition().y));
			myMoves.setFirstAcceleration(0, 0);
			//myMov.setVelocity((myMov.getVelocity().x + energy),
					//(myMov.getVelocity().y + energy));
			/*float vr = myMov.getVelocity().x*myMov.getVelocity().x + myMov.getVelocity().y*myMov.getVelocity().y;
			vr = (float) Math.sqrt(Math.sqrt(vr));
			myMov.getVelocity().set(myMov.getVelocity().x/vr, myMov.getVelocity().y/vr);
			//myMov.getVelocity().set(myMov.getVelocity().x*(1 + (float) energy/100),
					//myMov.getVelocity().y*(1 + (float) energy/100));
					 * 
					 * */
			
			movement.add(myMoves.getFirstMovement());
			
			
	
			
			
			movement.update(delta);
			myMoves.setFirstVelocity(0, 0);
			myMoves.setFirstPosition(0, 0);
			
			//odbijanie
			/*
			if(movement.getPosition().y<50) {
				movement.getVelocity().y*=-0.7f;
				movement.getPosition().y = 50;
			}
			if(movement.getPosition().x<50) {
				movement.getVelocity().x*=-0.7f;
				movement.getPosition().x = 50;
			}
			if(movement.getPosition().x>2000) {
				movement.getVelocity().x*=-0.7f;
				movement.getPosition().x = 2000;
			}
			*/
			//tarcie
			movement.getVelocity().x *= 0.9+time/10f;
			movement.getVelocity().y *= 0.9+time/10f;
		}
		
		public void collidate(Atom atom) {
			double dx = movement.getPosition().x - atom.movement.getPosition().x;
			double dy = movement.getPosition().y - atom.movement.getPosition().y;
			double dr = dx*dx + dy*dy + 0.1; // w celu unikniêcia NaN
			double time2 = time*atom.time + 0.01;
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
			double f = h2*(Math.sin(((dr/k2+a2)/(dr/k2+1)))/(dr/k2+b2))*time2 - 30/(dr*dr/60+10);
			myMoves.addFirstAcceleration((float)((dx/dr)*f*f*f), (float)((dy/dr)*f*f*f));
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
