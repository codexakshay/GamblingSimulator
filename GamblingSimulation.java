package com.codex.sim;

import java.util.Random;
import java.math.*;

public class GamblingSimulation {
	static int gambler = 100;
	public static final int win = 1;
	public static final int lose = 0;

	public void bet() {
		gambler = gambler - 1;
		int bet = (int) Math.round(Math.random());
		if (bet == win) {
			gambler = gambler + 2;
			System.out.println("Gambler won the bet");
			System.out.println("Gambler Money : " + gambler + "$");
		} else {
			System.out.println("Gambler lost the bet");
			System.out.println("Gambler Money : " + gambler + "$");
		}
	}

	public static void main(String[] args) {
		GamblingSimulation gamble = new GamblingSimulation();
		gamble.bet();
	}
}
