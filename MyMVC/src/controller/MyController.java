package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController extends CommonController {

	
	public MyController(View view, Model model) {
		super(view, model);
	}

	@Override
	public void notifyMazeIsReady(String name) {
		view.notifyMazeIsReady(name);
	}
}
