package com.manin.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//tell spring to create instance for us
@Component
public class GameRunner {
	//tightly coupleing
	//private MarioGame game;
	//private SuperContraGame game;
	
	//loosely coupling
	private GamingConsole game;

	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
		// TODO Auto-generated constructor stub
		this.game=game;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running Game : "+game);
		game.down();
		game.left();
		game.right();
		game.up();
	}

}
