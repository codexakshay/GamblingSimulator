package com.codex.sim;

import java.util.Random;
import java.math.*;

public class GamblingSimulation {
	static int gambler = 100;
	public static final int WIN = 1;
	static int days = 1;
	static int totalWon=0,totalLost=0; 

	public void InitialMoney() {
		System.out.println("Gambler Money : " + gambler + "$");
	}

	public void bet() {
		gambler = gambler - 1;
		System.out.print("\n\tDAY : " + days);
		int bet = (int) Math.round(Math.random());
		int reward = gambler * 1 / 2;
		if (gambler > 0) {
			if (bet == WIN) {
				gambler = gambler + reward;
				System.out.println("\nGambler won the bet");
				System.out.println("Gambler Money : " + gambler + "$");
				totalWon = totalWon + reward;
				
			} else {
				gambler = gambler - reward;
				System.out.println("\nGambler lost the bet");
				System.out.println("Gambler Money : " + gambler + "$");
				totalLost = totalLost + reward;
			}
			System.out.println("DAY : " + days + "\nReward : " + reward + "$");
			days = days + 1;
			System.out.println("Total Won : " + totalWon + "$");
			System.out.println("Total Lost : " + totalLost + "$");
			
		} else {
			System.out.println("\nHAHA... YOU ARE BROKE");
			System.out.println("Total Won : " + totalWon + "$");
			System.out.println("Total Lost : " + totalLost + "$");
			System.exit(0);
		}
	}

	public void betDays() {
		do {
			bet();
		} while (days <= 20);
	}

	public void Gambling() {
		InitialMoney();
		betDays();
	}

	public static void main(String[] args) {
		GamblingSimulation gamble = new GamblingSimulation();
		gamble.Gambling();
	}
}
