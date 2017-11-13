package com.redartedgames.kulki.brain;

import java.util.ArrayList;

public class NeuralCell {
	
	private ArrayList<NeuralCell> prevs;
	public ArrayList<NeuralCell> nexts;
	
	private int prevsI;
	
	public float weight, tryWeight;
	private float value, bias;
	
	private NeuralFunction function;
	
	public NeuralCell(float weight, float bias, NeuralFunction function) {
		prevsI = 0;
		this.prevs = new ArrayList<NeuralCell>();
		this.nexts = new ArrayList<NeuralCell>();
		this.weight = weight;
		tryWeight = weight;
		value = 0;
		this.function = function;
	}
	
	public float getValue( ) {
		return value;
	}
	
	public void addPrev(NeuralCell prev) {
		this.prevs.add(prev);
	}
	
	public void addNext(NeuralCell next) {
		this.nexts.add(next);
	}
	
	public void addPrevs(ArrayList<NeuralCell> prevs) {
		this.prevs.addAll(prevs);
	}
	
	public void addNexts(ArrayList<NeuralCell> nexts) {
		this.nexts.addAll(nexts);
	}
	
	public void trySignal(float value) {
		prevsI++;
		//System.out.println("sig, " + nexts.size() + ", " + prevsI + " / " + prevs.size());
		
		this.value += value*tryWeight;
		if (prevsI >= prevs.size()) {
			for(NeuralCell cell : nexts) {
				cell.trySignal(function.function(this.value));
			}
			if (nexts.size() == 0) {
				//System.out.println("last");
				this.value = function.function(this.value);
			}
		}
	}
	
	public void signal(float value) {
		prevsI++;
		//System.out.println("sig, " + nexts.size() + ", " + prevsI + " / " + prevs.size());
		
		this.value += value*weight;
		if (prevsI >= prevs.size()) {
			for(NeuralCell cell : nexts) {
				cell.signal(function.function(this.value));
			}
			if (nexts.size() == 0) {
				//System.out.println("last");
				this.value = function.function(this.value);
			}
		}
	}
	
	public void connect(NeuralCell cell) {
		
	}
}
