package com.manin.in28minutes.learnspringframework.game;

public class AppGameBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//this is tightly coupling มีการแก้ไขโค้ดเยอะ
		//coupling คือตัววัดการแก้ไขโคด เวลามีการเปลี่ยนแปลงต่างๆ
		//loosely coupling ไม่ต้องแก้ GameRunner class เพราะต้องการเพิ่มเกม
		//var marioGame = new MarioGame();
		//var superContraGame = new SuperContraGame();
		var pacmanGame = new PacManGame();//object creation
		GameRunner game = new GameRunner(pacmanGame);
		//object creation + wiring of dependency
		game.run();
	}

}
