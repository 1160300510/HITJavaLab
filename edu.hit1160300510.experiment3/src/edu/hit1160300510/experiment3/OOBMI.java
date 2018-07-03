package edu.hit1160300510.experiment3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


public class OOBMI {

	public class Student{
		String id;
		String name;
		double height;
		double weight;
		double bmi;
		
		public Student(String string, String string2, double parseDouble, double parseDouble2) {
			this.id = string;
			this.name = string2;
			this.height = parseDouble;
			this.weight = parseDouble2;
			// TODO Auto-generated constructor stub
		}
		public void setId(String id)//id���캯��
		{
			this.id = id;
		}
		public String getId()//�õ�id��ֵ
		{
			return this.id;
		}
		public void setName(String name)//name���캯��
		{
			this.name = name;
		}
		public void setHeight(double height)//height���캯��
		{
			this.height = height;
		}
		public void setWeight(double weight)//weight���캯��
		{
			this.weight = weight;
		}
		public void setBmi(double height,double weight)//bmi���캯��
		{
			double a = weight/(height*height);
			BigDecimal b = new BigDecimal(a);
			this.bmi = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
	}

	private ArrayList<Student> students;
	
	public OOBMI()
	{
		students = new ArrayList<Student>();
	}
	/**
	 * ������
	 * @param args
	 */
	public static void main(String[] args)
	{
		int n;
		OOBMI bmi = new OOBMI();
		Scanner in = new Scanner(System.in);
		while(true)
		{
			
			n = in.nextInt();
			if(n==0)
			{
				Student s = bmi.inputStudent();
				System.out.printf("id:%s"+"\t"+"name:%s"+"\t"
						+"height:%.2f"+"\t"+"weight:%.2f"+"\t"
						+"bmi:%.2f"+"%n",s.id,s.name,s.height,s.weight,s.bmi);
				
			}
			if(n==1)//��������ѧ����Ϣ
			{
				bmi.inputStudents();
				bmi.printStatics(bmi.students);
			}
			if(n==2)//�������ѧ��
			{
				bmi.genStudents(10);
				bmi.printStatics(bmi.students);
			}
			if(n==3)//ͳ��
			{
				bmi.Average(bmi.students);
				bmi.Median(bmi.students);
				bmi.Mode(bmi.students);
				bmi.Variance(bmi.students);
			}
			if(n==4)
			{
				bmi.sortStudents(bmi.new IdComparator());
				bmi.printStatics(bmi.students);
				bmi.sortStudents(bmi.new NameComparator());
				bmi.printStatics(bmi.students);
				bmi.sortStudents(bmi.new HeightComparator());
				bmi.printStatics(bmi.students);
				bmi.sortStudents(bmi.new WeightComparator());
				bmi.printStatics(bmi.students);
				bmi.sortStudents(bmi.new BmiComparator());
				bmi.printStatics(bmi.students);
			}
			if(n==5)
			{
				bmi.saveFile(bmi.students, "D://java_workspace//bmi.txt");
				
			}
			if(n==6)
			{
				bmi.students = bmi.readFile("D://java_workspace//bmi.txt");
				bmi.printStatics(bmi.students);
			}
			if(n==7)
			{
				bmi.findStudent(bmi.students);
			}
		}
		//bmi.inputStudents();
		//
		//bmi.saveFile(bmi.students, "D://java_workspace//bmi.txt");
		//bmi.students = bmi.readFile("D://java_workspace//bmi.txt");
		//bmi.printStatics(bmi.students);
		//bmi.sortStudents(bmi.new HeightComparator());
		//bmi.printStatics(bmi.students);
		
		
	}
	
	
	
	/**
	 * �Ӽ�������ѧ����Ϣ
	 * @return Student
	 */
	public Student inputStudent(){
		Scanner sc = new Scanner(System.in);
		Student s = new Student(null, null, 0, 0);
		System.out.println("id:");
		String id = sc.nextLine();
		if(this.isExists(id))
		{
			System.out.println("the student already exists!");
			return null;
		}
		System.out.println("name:");
		String name = sc.nextLine();
		System.out.println("height(m):");
		float height = sc.nextFloat();
		System.out.println("weight(kg):");
		float weight = sc.nextFloat();
		
		s.setId(id);
		s.setName(name);
		s.setHeight(height);
		s.setWeight(weight);
		s.setBmi(height, weight);
		
		return s;
	}
	
	/**
	 * ͨ��ѯ���û��Ƿ���������������Ƿ��������ѧ��,
	 * �������ѧ�����󱣴浽students��
	 */
	public void inputStudents()
	{
		String choice;
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("continue to input student? yes/no");
			choice = in.nextLine();
			if(choice.equals("yes"))
			{
				Student s = inputStudent();
				if(s!=null)
					students.add(s);
			}
			else
			{
				break;
			}
		}
	}
	
	/**
	 * �������ָ����������ѧ������
	 * �����浽students��
	 * @param n
	 */
	public void genStudents(int n)
	{
		Random r = new Random();
		double x=0.0,y=0.0;
		for(int i=0;i<n;i++)
		{
			x = r.nextGaussian();
			y = r.nextGaussian();
			Student s = new Student(null, null, 0, 0);
			if(isExists(String.format("%04d", i)))
				continue;//����ظ�������
			
			s.setId(String.format("%04d", i));
			s.setName(genRandomString(6));
			s.setHeight(1.75+x*0.1);
			s.setWeight(60.0+y*5.0);
			s.setBmi( (1.75+x*0.1),(60.0+y*5.0));
			
			students.add(s);
		}
	}
	
	/**
	 * �����������
	 * @param length
	 * @return
	 */
	public String genRandomString(int length)
	{
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r= new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++)
		{
			int number = r.nextInt(26);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * �жϸ�ѧ���Ƿ��Ѿ����루�Ƿ���students�У�
	 * @param id
	 * @return
	 */
	public boolean isExists(String id)
	{
		if (students == null) return false;
		for(Student s:students)
		{
			if(id.equals(s.getId()))
				return true;
		}
		return false;
	}
	
	/**
	 * ͳ��BMI�ľ�ֵ
	 */
	public void Average(ArrayList<Student> students)
	{
		double sum=0;
		double n=0;
		for(int i=0;i<students.size();i++)
		{
			sum += students.get(i).bmi;
			n += 1;
		}
		if(n!=0)
		{
			System.out.printf("BMI�ľ�ֵΪ:%.2f",sum/n);
		}
		System.out.println();
	}
	
	/**
	 * ͳ��BMI����ֵ
	 */
	public void Median(ArrayList<Student> students)
	{
		int i,j,k;
		double med;
		for(i=0;i<students.size()-1;i++)//��������
		{
			k=i;
			for(j=i+1;j<students.size();j++)
			{
				if(students.get(k).bmi>students.get(j).bmi)
				{
					k=j;
				}
			}
			if(k!=i)
			{
				Student tmp = students.get(k);
				students.set(k, students.get(i));
				students.set(i,tmp);	
			}
		}
		if(students.size()%2 != 0)//students����Ϊ����
		{
			int q = (students.size()-1)/2;
			System.out.printf("BMI����ֵΪ:%.2f", students.get(q).bmi);
		}
		
		if(students.size()%2 == 0)//students����Ϊż��
		{
			int q = students.size()/2;
			int p = q-1;
			System.out.printf("BMI����ֵΪ:%.2f", (students.get(p).bmi+students.get(q).bmi)/2);
		}
		System.out.println();
	}
	
	/**
	 * ͳ��BMI������
	 * @param students
	 */
	public void Mode(ArrayList<Student> students)
	{
		int i,j,k;
		int nCount=0,maxCount=0,position=-1;
		double[] zhongshu = new double[students.size()];
		double seed=students.get(0).bmi;
		for(i=0;i<students.size()-1;i++)//��������
		{
			k=i;
			for(j=i+1;j<students.size();j++)
			{
				if(students.get(k).bmi>students.get(j).bmi)
				{
					k=j;
				}
			}
			if(k!=i)
			{
				Student tmp = students.get(k);
				students.set(k, students.get(i));
				students.set(i,tmp);	
			}
		}
		
		for(i=0;i<=students.size();i++)
		{
			if(i<students.size() && students.get(i).bmi == seed)
			{
				nCount++;
			}
			else
			{
				if(nCount > maxCount)
				{
					maxCount = nCount;
					position = 0;
					zhongshu[0] = students.get(i-1).bmi;
				}
				else if(nCount == maxCount)
				{
					zhongshu[++position] = students.get(i-1).bmi;
				}
				if(i<students.size())
				{
					seed = students.get(i).bmi;
					nCount = 1;
				}
			}
		}
		if(maxCount <= 1)
			System.out.println("BMIû������");
		else
		{
			System.out.print("BMI������:");
			for(i=0;i<=position;i++)
			{
				System.out.print(zhongshu[i]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * ͳ��BMI�ķ���
	 * @param students
	 */
	public void Variance(ArrayList<Student> students)
	{
		double sum=0;
		double n=0;
		double ave,var=0;
		for(int i=0;i<students.size();i++)
		{
			sum += students.get(i).bmi;
			n += 1;
		}
		ave = sum/n;
		for(int i=0;i<students.size();i++)
		{
			var += (students.get(i).bmi-ave)*(students.get(i).bmi-ave);
			
		}
		System.out.printf("BMI�ķ���Ϊ:%.2f", var/n);
		System.out.println();
	}
	
	/**
	 * ��ӡ����ѧ���Ļ�����Ϣ
	 * @param students
	 */
	public void printStatics(ArrayList<Student> students)
	{
		for(Student s:students)
		{
			System.out.printf("id:%s"+"\t"+"name:%s"+"\t"
					+"height:%.2f"+"\t"+"weight:%.2f"+"\t"
					+"bmi:%.2f"+"%n",s.id,s.name,s.height,s.weight,s.bmi);
		}
		Average(students);
		Median(students);
		Mode(students);
		Variance(students);
	}
	
	/**
	 * id comparator����
	 * @author kkkkkkkkkkk
	 *
	 */
	private class IdComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student st1,Student st2)
		{
			return st1.id.compareTo(st2.id);
		}
	}
	
	/**
	 * name comparator����
	 * @author kkkkkkkkkkk
	 *
	 */
	private class NameComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student st1,Student st2)
		{
			return st1.name.compareTo(st2.name);
		}
	}
	
	/**
	 * height comparator����
	 * @author kkkkkkkkkkk
	 *
	 */
	private class HeightComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student st1,Student st2)
		{
			if(st1.height>st2.height)
				return 1;
			else if(st1.height<st2.height)
				return -1;
			else
				return 0;
		}
	}
	
	/**
	 * weight comparator����
	 * @author kkkkkkkkkkk
	 *
	 */
	private class WeightComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student st1,Student st2)
		{
			if(st1.weight>st2.weight)
				return 1;
			else if(st1.weight<st2.weight)
				return -1;
			else
				return 0;
		}
	}
	
	/**
	 * bmi comparator����
	 * @author kkkkkkkkkkk
	 *
	 */
	private class BmiComparator implements Comparator<Student>
	{
		@Override
		public int compare(Student st1,Student st2)
		{
			if(st1.bmi>st2.bmi)
				return 1;
			else if(st1.bmi<st2.bmi)
				return -1;
			else
				return 0;
		}
	}
	/**
	 * ������
	 * @param c
	 */
	public void sortStudents(Comparator<Student> c)
	{
		Collections.sort(students,c);
	}
	
	/**
	 * ��ѧ����Ϣstudentsд�뵽ָ�����ı��ļ��У�ÿһ��д��һ��ѧ����
	 * @param students
	 * @param fileName
	 */
	public static void saveFile(ArrayList<Student> students,String fileName)
	{
		try{
			FileWriter writer = new FileWriter(fileName,false);
			for(Student s:students)
			{
				writer.write(String.format("%s,%s,%.2f,%.2f\r\n", 
						s.id,s.name,s.height,s.weight));
			}
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ļ��е����ݵ�ѧ��ArrayList�У������ظ�ArrayList��
	 * @param fileName
	 * @return
	 */
	public  static ArrayList<Student> readFile(String fileName)
	{
		File file = new File(fileName);
		BufferedReader reader = null;
		ArrayList<Student> v = new ArrayList<Student>();
		try{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while((tempString = reader.readLine()) != null)
			{
				String[] a = tempString.split(",");
				Student s = new OOBMI().new Student(a[0],a[1],Double.parseDouble(a[2]),Double.parseDouble(a[3]));
				v.add(s);
			}
			reader.close();
			return v;
		}catch(IOException e){
			e.printStackTrace();
		}
		return v;
	}
	
	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ����ʾ
	 * ��ʾ�û��Ƿ��޸Ļ�ɾ��ѧ��
	 * @param students
	 */
	public void findStudent(ArrayList<Student> students)
	{	
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ������(0)���޸�(1)��ɾ��ѧ����Ϣ(2):");
		int n = in.nextInt();
		if(n==0)
		{
			Student s = inputStudent();
			students.add(s);
			saveFile(students, "D://java_workspace//bmi.txt");
		}
		
		else{
			if(n==1)
			{
				System.out.println("������Ҫ�޸�ѧ����ѧ��:");
				Scanner sc = new Scanner(System.in);
				String id = sc.nextLine();
				for(int i=0;i<students.size();i++)
				{
					if(id.equals(students.get(i).id))
					{
						System.out.printf("id:%s"+"\t"+"name:%s"+"\t"
								+"height:%.2f"+"\t"+"weight:%.2f"+"\t"
								+"bmi:%.2f"+"%n",
								students.get(i).id,students.get(i).name,students.get(i).height,students.get(i).weight,students.get(i).bmi);
					modifyStudent(students.get(i));
					saveFile(students, "D://java_workspace//bmi.txt");
					}
			}
		}
					
			else if(n==2)
				{
					System.out.println("������Ҫɾ��ѧ����ѧ��:");
					Scanner sc = new Scanner(System.in);
					String id = sc.nextLine();
					deleteStudent(id);
					saveFile(students, "D://java_workspace//bmi.txt");
				}
					
			}
		}

	
	public void modifyStudent(Student s)
	{
		int n;
		
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.println("��ѡ��Ҫ�޸�����(0),���(1),����(2),����(����):");
			n = in.nextInt();
			if(n==0)
			{
				System.out.println("������Ҫ�޸ĵ�����:");
				Scanner en = new Scanner(System.in);
				String str = en.nextLine();
				s.setName(str);
			}
			else if(n==1)
			{
				System.out.println("������Ҫ�޸ĵ����(m):");
				double a = in.nextDouble();
				s.setHeight(a);
			}
			else if(n==2)
			{
				System.out.println("������Ҫ�޸ĵ�����(kg)");
				double b = in.nextDouble();
				s.setWeight(b);
			}
			else 
				break;
			
		}
	}
	
	public void deleteStudent(String id)
	{
		Iterator <Student> it = students.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(id.equals(s.id))
			{
				it.remove();
			}
		}
	}
}
