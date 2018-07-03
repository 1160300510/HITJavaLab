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
		System.out.println("������ѧ������:");
		Scanner en = new Scanner(System.in);
		int num = en.nextInt();
		System.out.println("������ѧ��,����,���(��),����(����):");
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
		
		System.out.println("������:(0Ϊ�˳�,1Ϊѧ������,2Ϊ��������,3Ϊ�������,4Ϊ��������,5ΪBMI����)");
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int n = in.nextInt();
			if(n==0)
				System.exit(0);
			else if(n==1)
			{
				System.out.println("����ǰ��");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("�����");
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
				System.out.println("����ǰ��");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("�����");
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
				System.out.println("����ǰ��");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("�����");
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
				System.out.println("����ǰ��");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("�����");
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
				System.out.println("����ǰ��");
				for(int i=0;i<num;i++)
				{
					System.out.println("id:"+ids[sortedIndex[i]]+"\t"+"name:"+names[sortedIndex[i]]
							+"\t"+"height:"+heights[sortedIndex[i]]+"\t"+"weight:"+weights[sortedIndex[i]]+"\t"
							+"BMI:"+bmis[sortedIndex[i]]);
				}
				System.out.println("�����");
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
	//��ѧ������
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
	
	//����������
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
	
	//���������
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
	
	//����������
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
	
	//��BMI����
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
	
	public static void input()//���뺯��
	{
		Scanner in = new Scanner(System.in);
		System.out.println("������ѧ��,����,���(��),����(����):");
		String id = in.nextLine();//ѧ��
		String name = in.nextLine();//����
		float height = in.nextFloat();//��ߣ��ף�
		float weight = in.nextFloat();//���أ����
		float bmi = weight/(height*height);
		String s1 = "��ѧ���Ľ���״��Ϊ��" + checkHealth(bmi);
		String str = "ѧ��:"+id+",����:"+name+",���:"+(height*100)
				+"����,����:" + (weight*2)+"��,BMI:"+bmi+".";
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
