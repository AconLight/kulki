package com.redartedgames.kulki.brain;

import java.util.ArrayList;

public class Brain {
	private ArrayList<NeuralCell> firsts;
	private ArrayList<NeuralCell> medium1;
	private ArrayList<NeuralCell> lasts;
	
	public Brain() {
		firsts = new ArrayList<NeuralCell>();
		medium1 = new ArrayList<NeuralCell>();
		lasts = new ArrayList<NeuralCell>();
		firsts.add(new NeuralCell(new ArrayList<NeuralCell>(), new ArrayList<NeuralCell>(), 1, (float value) -> (float)Math.atan(value)));
				
				
	}
}
