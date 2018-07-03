package edu.hit1160300510.experiment1;

import java.util.Scanner;

public class Averager {

	public static void main(String[] args)
	{
		System.out.println("Please enter two floating point numbers:");
		Scanner in = new Scanner(System.in);
		float a = in.nextFloat();
		float b = in.nextFloat();
		String str = "The averager ";
		str = str + "is:%.2f\n";
		System.out.printf(str, (a+b)/2.0);
	}
}
