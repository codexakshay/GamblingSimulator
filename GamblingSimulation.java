package com.codex.sim;

import java.util.Scanner;

public class GamblingSimulation {
	static int gambler = 100;
	public static final int WIN = 1;
	static int days = 1;
	static int totalWon = 0, totalLost = 0;
	static int winCount = 0, LoseCount = 0;
	static int month = 1, maxReward = 0, luckyDay = 0;

	public void InitialMoney() {
		System.out.println("Gambler Money : " + gambler + "$");
	}

	public void bet() {
		gambler = gambler - 1;
		System.out.print("\n*MONTH : " + month + " DAY : " + days + "*");
		int bet = (int) Math.round(Math.random());
		int reward = gambler * 1 / 2;
		if (gambler > 0) {
			if (bet == WIN) {
				if (reward > maxReward) {
					maxReward = reward;
					luckyDay = days;
				}
				gambler = gambler + reward;
				System.out.println("\n\nGambler won the bet");
				System.out.println("Gambler Money : " + gambler + "$");
				totalWon = totalWon + reward;
				winCount = winCount + 1;

			} else {
				gambler = gambler - reward;
				System.out.println("\n\nGambler lost the bet");
				System.out.println("\nGambler Money : " + gambler + "$");
				totalLost = totalLost + reward;
				LoseCount = LoseCount + 1;
			}
			System.out.println("DAY : " + days + "\nReward : " + reward + "$");
			days = days + 1;

			System.out.println("\nTotal Amount Won : " + totalWon + "$");
			System.out.println("Total Amount Lost : " + totalLost + "$");

			System.out.println("\nTotal Win : " + winCount + " Times");
			System.out.println("Total Lost Times : " + LoseCount + " Times");

		} else {
			System.out.println("\nHAHA... YOU ARE BROKE");

			System.out.println("\nGambler Money : " + gambler + "$");

			System.out.println("\nTotal Amount Won : " + totalWon + "$");
			System.out.println("Total Amount Lost : " + totalLost + "$");

			System.out.println("\nTotal Win : " + winCount + " Times");
			System.out.println("Total Lost : " + LoseCount + " Times");

			System.out.println("\nMax Reward : " + maxReward + "$");
			System.out.println("Luckiest Day : MONTH : " + month + " DAY : " + luckyDay);

			System.exit(0);
		}
		System.out.println("\nMax Reward : " + maxReward + "$");
		System.out.println("Luckiest Day : MONTH : " + month + " DAY : " + luckyDay);
	}

	public void betDays() {
		do {
			bet();
			playAgain();
		} while (days <= 21);

	}

	public void playAgain() {
		if (days == 21) {
			month += 1;
			System.out.println("\n\nWant to play one more month ? ");
			System.out.println("1. Yes ");
			System.out.println("2. No");
			Scanner scan = new Scanner(System.in);
			System.out.println("Your choise : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				days = 1;
				System.out.println("Don't Cry after Getting Broke  ... haha");
				betDays();
				break;
			case 2:
				System.out.println("Too Scared to Lose , huh ? ... haha");
				System.exit(0);
			default:
				System.out.println("Invalid Choice ... Choose Wisely!!!");
				playAgain();
			}
		}
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
//UC7
