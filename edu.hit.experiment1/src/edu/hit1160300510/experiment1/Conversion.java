package edu.hit1160300510.experiment1;

import java.util.Scanner;

public class Conversion {

	public static void main(String[] args)
	{
		System.out.println("Hi,I'm Jack,What's your name?");
		Scanner in = new Scanner(System.in);
		String myName = in.nextLine();
		System.out.printf("My name is %s.Nice to meet you!%n", myName);
	}
}
