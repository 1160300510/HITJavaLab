package edu.hit1160300510.experiment1;

import java.util.Scanner;

public class ControlStrcutureTest {
	
	//�ж��Ƿ�Ϊ����
	public static boolean checkLeapYear(int n)
	{
		if(n%400==0 || (n%4==0 && n%100!=0))
			return true;
		else
			return false;
	}
	//��ӡ50���е�����
	public static void printLeapYears(int n)
	{
		if(n==1)
		{
			System.out.println("2001-2050�����е�����Ϊ��");
			for(int i=2001;i<=2050;i++)
			{
				if(i%400==0 || (i%4==0 && i%100!=0))
				{
					System.out.println(i);
				}
				else
					continue;
			}
		}
		else
		{
			System.out.println("2001-2050�еĵ�һ������Ϊ��");
			for(int i=2001;i<=2050;i++)
			{
				if(i%400==0 || (i%4==0 && i%100!=0))
				{
					System.out.println(i);
					break;
				}
				else
					continue;
			}
		}
	}
	//������Ϸ
	public static void guessNumber()
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int choice = in.nextInt();
			if(choice == 1)
			{
				System.out.println("�������Ĳ²�:");
				int realNumber = (int)(Math.random()*100)+1;
				int yourGuess = in.nextInt();
				while(yourGuess != realNumber)
				{
					if(yourGuess > realNumber)
					{
						System.out.println("���ˣ����ٲ£�");
						yourGuess = in.nextInt();
					}
					else if(yourGuess < realNumber)
					{
						System.out.println("С�ˣ����ٲ£�");
						yourGuess = in.nextInt();
					}
				}
				System.out.println("��ϲ�¶���");
				System.out.println("������Ϸ��ѡ��1���˳���Ϸ��ѡ��0");
				
			}
			if(choice == 0)
			{
				System.exit(0);
			}
		}
	}
	//��ӡ������������
	public static void PrintUpper(int n)
	{
		if(n==1)//��ӡ��һ����������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(j>8-i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				System.out.println();
			}
		}
		else if(n==2)//��ӡ�ڶ�����������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9-i;j++)
				{
					System.out.print(" ");
				}
				for(int k=0;k<=i;k++)
				{
					System.out.print("* ");
				}
				System.out.println();
			}
		}
		else if(n==3)//��ӡ��������������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(j<=i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	//��ӡ������������
	public static void PrintLower(int n)
	{
		if(n==4)//��ӡ��һ����������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(j>=i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				System.out.println();
			}
		}
		if(n==5)//��ӡ�ڶ�����������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<=i;j++)
				{
					System.out.print(" ");
				}
				for(int k=0;k<=8-i;k++)
				{
					System.out.print("* ");
				}
				System.out.println();
			}
		}
		if(n==6)//��ӡ��������������
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<=8-i;j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	//��ӡ�������
	public static void ChineseTrangle(int n)
	{
		int as[][] = new int[20][20];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i;j++)
			{
				System.out.printf("%4s","");
			}
			for(int k=0;k<=i;k++)
			{
				if(k==0)
				{
					as[i][k]=1;
				}
				else if(k==i)
				{
					as[i][k]=1;
				}	
				else
				{
					as[i][k] = as[i-1][k-1]+as[i-1][k];
					
				}	
				System.out.printf("%4d", as[i][k]);
				System.out.printf("%4s", "");
			}
			System.out.println();
		}
		
	}
	//������
	public static void main(String[] args)
	{
		ChineseTrangle(10);
		PrintUpper(1);
		PrintLower(4);
		guessNumber();
		/*System.out.println("��ѡ��1Ϊ���2001-2050���������꣬0Ϊ�����һ�����꣩:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printLeapYears(n);*/
		
		/*System.out.println("Please enter the year");
		 * while(true)
		{
			int n = in.nextInt();
			if(checkLeapYear(n))
				System.out.println(n + " is a leapyear");
			else
				System.out.println(n + " isn't a leapyear");
		}*/
	}

}
