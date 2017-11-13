package com.redartedgames.kulki.brain;

import java.util.ArrayList;

public class BrainTest2 {

	public static void main(String[] args) {
		Brain brain = new Brain();		
		//System.out.println(cost(brain, 0.2f, 0, 3.15f*2, (float x) -> (float)(Math.sin(x))));
		float s = 90000000, s2;
		System.out.println("wyniki aproksymowanego sinusa");
		for (float i = 0; i < Math.PI; i+=0.1f) {
			System.out.println(brain.tryCalculate(i));
		}
		int q = 0;
		for (int i = 0; i < 100; i++) {
			liczGradient(brain, 0.1f);
			s2 = cost(brain, 0.1f, 0, 3.15f*2, (float x) -> (float)(Math.sin(x)));
			System.out.println((int)(i/100f*100) + "% " + s2);
			if (s2<s) { 
				s = s2;
				q = i;
			}
		}
		/*brain = new Brain();		
		for (int i = 0; i <= q; i++) {
			liczGradient(brain, 0.1f);
			s2 = cost(brain, 0.1f, 0, 3.15f*2, (float x) -> (float)(100*Math.sin(x)));
			System.out.println((int)(i/100f*100) + "%");
			if (s2<s) { 
				s = s2;
				q = i;
			}
		}*/
		
		System.out.println("");
		System.out.println("osi¹gniêta dokladnoœæ");
		System.out.println(s);
		System.out.println("");
		System.out.println("wyniki aproksymowanego sinusa");
		for (float i = 0; i < 100; i+=1f) {
			System.out.println(brain.tryCalculate(i));
		}
		
		System.out.println("");
		System.out.println("ostatnie wagi");
		for (int i = 0; i < brain.nodes.size(); i++) {
			System.out.println(brain.nodes.get(i).weight);
		}
		
		//liczGradient(brain, 10f);
		
	}
	
	static float cost(Brain brain, float d, float a, float b, NeuralFunction function) {
		float s = 0;
		float q;
		int iterations = 0;
		for (int i = 0; i < (b-a)/d; i++) {
			q = function.function(a+i*d)-brain.tryCalculate(a+i*d);
			s += q*q;
			//System.out.println("dupa " + a+i*d);
			//System.out.println("iteration: " + function.function(a+i*d) + ", " + brain.calculate(a+i*d));
			iterations++;
		}
		//System.out.println("iterations: " + iterations);
		
		return s/iterations;
	}
	
	static void liczGradient(Brain brain, float d) {
		float y1, y2;
		ArrayList<Float> gradient = new ArrayList<Float>();
		for (NeuralCell cell : brain.nodes) {
			cell.tryWeight = cell.weight;
			y1 = cost(brain, 0.05f, 0, 3.15f*2, (float x) -> (float)(Math.sin(x)));
			//System.out.println("y1 = " + y1);
			cell.tryWeight = cell.weight + d;
			y2 = cost(brain, 0.05f, 0, 3.15f*2, (float x) -> (float)(Math.sin(x)));
			//System.out.println("y2 = " + y2);
			cell.tryWeight = cell.weight;
			gradient.add((y2-y1)/d);
		}
		for (int i = 0; i < brain.nodes.size(); i++) {
			brain.nodes.get(i).weight -= Math.abs(gradient.get(i));
			//System.out.println(gradient.get(i) + ", " + brain.nodes.size());
		}
		//System.out.println("");
		//System.out.println("gradient");
		for (int i = 0; i < brain.nodes.size(); i++) {
			//System.out.println(brain.nodes.get(i).weight);
			//System.out.println(gradient.get(i));
		}
	}

}
