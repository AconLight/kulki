package com.redartedgames.kulki.brain;

import java.util.ArrayList;

public class NeuralCell {
	
	private ArrayList<NeuralCell> prevs;
	private ArrayList<NeuralCell> nexts;
	
	private int prevsI;
	
	private float weigtht;
	private float value;
	
	private NeuralFunction function;
	
	public NeuralCell(ArrayList<NeuralCell> prevs, ArrayList<NeuralCell> nexts, float weight, NeuralFunction function) {
		prevsI = 0;
		this.prevs = prevs;
		this.nexts = nexts;
		this.weigtht = weight;
		value = 0;
		this.function = function;
	}
	
	public void signal(float value) {
		prevsI++;
		this.value += value*weigtht;
		if (prevsI >= prevs.size()) {
			for(NeuralCell cell : nexts) {
				cell.signal(this.value);
			}
		}
	}
	
	public void connect(NeuralCell cell) {
		
	}
}
