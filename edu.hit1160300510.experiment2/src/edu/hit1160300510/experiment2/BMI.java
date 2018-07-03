package edu.hit1160300510.experiment2;

import java.util.Scanner;

public class BMI {
	

	public static void main(String[] args)
	{
		final int N = 100;
		String []ids = new String[N];
		String[] names = new String[N];
		float[] heights = new float[N];
		float[] weights = new float[N];
		float[] bmis = new float[N];
		int[] sortedIndex = new int[N];
		System.out.println("请输入学生人数:");
		Scanner en = new Scanner(System.in);
		int num = en.nextInt();
		System.out.println("请输入学号,姓名,身高(米),体重(公斤):");
		for(int i=0;i<num;i++)
		{
			ids[i] = en.next();
			names[i] = en.next();
			heights[i] = en.nextFloat();
			weights[i] = en.nextFloat();
			bmis[i] = weights[i]/(heights[i]*heights[i]);
			sortedIndex[i] = i;
		}
		printStudents(sortedIndex,ids,names,heights,weights,bmis,num);
	}
	
	public static void printStudents(int sortedIndex[],String ids[],String names[],float heights[], 
					float weights[],float bmis[],int num)
	{
		final int N = 100;
		int Index[] = new int[N];
		
		System.out.println("请输入:(0为退出,1为学号排序,2为姓名排序,3为身高排序,4为体重排序,5为BMI排序)");
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int n = in.nextInt();
			if(n==0)
				System.exit(0);
			else if(n==1)
			{
				System.out.println("排序前：");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("排序后：");
				Index = sortByids(ids,num);
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
			}
			else if(n==2)
			{
				System.out.println("排序前：");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("排序后：");
				Index = sortBynames(names,num);
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
			}
			else if(n==3)
			{
				System.out.println("排序前：");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("排序后：");
				Index = sortByheights(heights,num);
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
			}
			else if(n==4)
			{
				System.out.println("排序前：");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("排序后：");
				Index = sortByweights(weights,num);
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
			}
			else
			{
				System.out.println("排序前：");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("排序后：");
				Index = sortBybmis(bmis,num);
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
			}
		}
		
	}
	//按学号排序
	public static int[] sortByids(String[] ids,int num)
	{
		final int N = 100;
		String[] ids1 = new String[N];
		int sortedIndex[] = new int[N]; 
		for(int i=0;i<num;i++)
		{
			ids1[i] = ids[i];
			sortedIndex[i] = i;
		}
		for (int i=0;i<num-1;i++)
		{
			int k = i;
			for(int j=i+1;j<num;j++)
			{
				if(ids1[k].compareTo(ids1[j]) > 0)
				{
					k = j;
				}
			}
			if (k!=i)
			{
				String str = ids1[i];
				ids1[i] = ids1[k];
				ids1[k] = str;
				int temp = sortedIndex[i];
				sortedIndex[i] = sortedIndex[k];
				sortedIndex[k] = temp;
			}
		}
		return sortedIndex;
	}
	
	//按姓名排序
	public static int[] sortBynames(String[] names,int num)
	{
		final int N = 100;
		String[] names1 = new String[N];
		int sortedIndex[] = new int[N]; 
		for(int i=0;i<num;i++)
		{
			names1[i] = names[i];
			sortedIndex[i] = i;
		}
		for (int i=0;i<num-1;i++)
		{
			int k = i;
			for(int j=i+1;j<num;j++)
			{
				if(names1[k].compareTo(names1[j]) > 0)
				{
					k = j;
				}
			}
			if (k!=i)
			{
				String str = names1[i];
				names1[i] = names1[k];
				names1[k] = str;
				int temp = sortedIndex[i];
				sortedIndex[i] = sortedIndex[k];
				sortedIndex[k] = temp;
			}
		}
		return sortedIndex;
	}
	
	//按身高排序
	public static int[] sortByheights(float[] heights,int num)
	{
		final int N = 100;
		float[] heights1 = new float[N];
		int sortedIndex[] = new int[N]; 
		for(int i=0;i<num;i++)
		{
			heights1[i] = heights[i];
			sortedIndex[i] = i;
		}
		for (int i=0;i<num-1;i++)
		{
			int k = i;
			for(int j=i+1;j<num;j++)
			{
				if(heights1[k] > heights1[j])
				{
					k = j;
				}
			}
			if (k!=i)
			{
				float str = heights1[i];
				heights1[i] = heights1[k];
				heights1[k] = str;
				int temp = sortedIndex[i];
				sortedIndex[i] = sortedIndex[k];
				sortedIndex[k] = temp;
			}
		}
		return sortedIndex;
	}
	
	//按体重排序
	public static int[] sortByweights(float[] weights,int num)
	{
		final int N = 100;
		float[] weights1 = new float[N];
		int sortedIndex[] = new int[N]; 
		for(int i=0;i<num;i++)
		{
			weights1[i] = weights1[i];
			sortedIndex[i] = i;
		}
		for (int i=0;i<num-1;i++)
		{
			int k = i;
			for(int j=i+1;j<num;j++)
			{
				if(weights1[k] > weights1[j])
				{
					k = j;
				}
			}
			if (k!=i)
			{
				float str = weights1[i];
				weights1[i] = weights1[k];
				weights1[k] = str;
				int temp = sortedIndex[i];
				sortedIndex[i] = sortedIndex[k];
				sortedIndex[k] = temp;
			}
		}
		return sortedIndex;
	}
	
	//按BMI排序
	public static int[] sortBybmis(float[] bmis,int num)
	{
		final int N = 100;
		float[] bmis1 = new float[N];
		int sortedIndex[] = new int[N]; 
		for(int i=0;i<num;i++)
		{
			bmis1[i] = bmis[i];
			sortedIndex[i] = i;
		}
		for (int i=0;i<num-1;i++)
		{
			int k = i;
			for(int j=i+1;j<num;j++)
			{
				if(bmis1[k] > bmis1[j])
				{
					k = j;
				}
			}
			if (k!=i)
			{
				float str = bmis1[i];
				bmis1[i] = bmis1[k];
				bmis1[k] = str;
				int temp = sortedIndex[i];
				sortedIndex[i] = sortedIndex[k];
				sortedIndex[k] = temp;
			}
		}
		return sortedIndex;
	}
	
	public static void input()//输入函数
	{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入学号,姓名,身高(米),体重(公斤):");
		String id = in.nextLine();//学号
		String name = in.nextLine();//姓名
		float height = in.nextFloat();//身高（米）
		float weight = in.nextFloat();//体重（公斤）
		float bmi = weight/(height*height);
		String s1 = "该学生的健康状况为：" + checkHealth(bmi);
		String str = "学号:"+id+",姓名:"+name+",身高:"+(height*100)
				+"厘米,体重:" + (weight*2)+"斤,BMI:"+bmi+".";
		System.out.println(str);
		System.out.println(s1);
		
	}
	public static String checkHealth(float n)
	{
		String str;
		if(n < 18.5)
		{
			str = "Underweight";
		}
		else if(n>=18.5 && n<23)
		{
			str = "Normal Range";
		}
		else if(n>=23 && n<25)
		{
			str = "Overweight-At Risk";
		}
		else if(n>=25 && n<30)
		{
			str = "Overweight-Moderately Obese";
		}
		else
		{
			str = "Overweight-Severely Obese";
		}
		return str;
		
	}
}
