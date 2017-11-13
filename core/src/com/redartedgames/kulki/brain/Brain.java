package com.redartedgames.kulki.brain;

import java.util.ArrayList;

public class Brain {
	private ArrayList<NeuralCell> firsts;
	private ArrayList<NeuralCell> medium1;
	private ArrayList<NeuralCell> medium2;
	private ArrayList<NeuralCell> medium3;
	private ArrayList<NeuralCell> lasts;
	public ArrayList<NeuralCell> nodes;
	
	public Brain() {
		nodes = new ArrayList<NeuralCell>();
		firsts = new ArrayList<NeuralCell>();
		medium1 = new ArrayList<NeuralCell>();
		medium2 = new ArrayList<NeuralCell>();
		medium3 = new ArrayList<NeuralCell>();
		lasts = new ArrayList<NeuralCell>();
		firsts.add(new NeuralCell(1, 0,  (float value) -> (float)(Math.atan(value)/Math.PI*2 -1)));
		lasts.add(new NeuralCell(1, 0,  (float value) -> (float)(Math.atan(value)/Math.PI*2 -1)));
		int j = 5; float w = 0.01f;
		for(int i = 0; i < j; i++) {
			medium1.add(new NeuralCell(w, 0,  (float value) -> (float)(Math.atan(value)/Math.PI*2 -1)));
			createCon(firsts.get(0), medium1.get(medium1.size()-1));
		}
		for(int i = 0; i < j; i++) {
			medium2.add(new NeuralCell(w, 0,  (float value) -> (float)(Math.atan(value)/Math.PI*2 -1)));
			for (NeuralCell m1 : medium1) {
				createCon(m1, medium2.get(medium2.size()-1));
			}
			
		}
		for(int i = 0; i < j; i++) {
			medium3.add(new NeuralCell(w, 0,  (float value) -> (float)(Math.atan(value)/Math.PI*2 -1)));
			for (NeuralCell m2 : medium2) {
				createCon(m2, medium3.get(medium3.size()-1));
			}	
		}
		for(int i = 0; i < j; i++) {
			//medium3.add(new NeuralCell(1, (float value) -> (float)Math.atan(value)));
			createCon(medium3.get(i), lasts.get(0));
			//System.out.println(medium3.get(i).nexts.size());
		}
		nodes.addAll(firsts);
		nodes.addAll(medium1);
		nodes.addAll(medium2);
		nodes.addAll(medium3);
		nodes.addAll(lasts);
		//System.out.println(medium3.get(0).nexts.size());
				
	}
	
	void createCon(NeuralCell p, NeuralCell n) {
		p.addNext(n);
		n.addPrev(p);
	}
	
	public float calculate(float x) {
		firsts.get(0).signal(x);
		return lasts.get(0).getValue();
	}
	
	public float tryCalculate(float x) {
		firsts.get(0).trySignal(x);
		return lasts.get(0).getValue();
	}
	
	public void updateWeights(ArrayList<Float> weights) {
		
	}
}
