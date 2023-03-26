package com.manin.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

//tell spring to create instance for us
@Component
public class PacManGame implements GamingConsole {

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("go up");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("go down");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("forward");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("back");
	}
	
}
