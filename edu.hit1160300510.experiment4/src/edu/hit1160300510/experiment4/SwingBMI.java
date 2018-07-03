 package edu.hit1160300510.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import edu.hit1160300510.experiment4.SwingBMI.Student;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class SwingBMI extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField nametext;
	JScrollPane sp = new JScrollPane();
	JTextArea ta = new JTextArea();
	private ArrayList<Student> students= new ArrayList<Student>();
	
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
		
		public Student(String id,String name) {
			super();
			this.id = id;
			this.name = name;
		}
		

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void setId(String id)//id构造函数
		{
			this.id = id;
		}
		public String getId()//得到id的值
		{
			return this.id;
		}
		public void setName(String name)//name构造函数
		{
			this.name = name;
		}
		public void setHeight(double height)//height构造函数
		{
			this.height = height;
		}
		public void setWeight(double weight)//weight构造函数
		{
			this.weight = weight;
		}
		public void setBmi(double height,double weight)//bmi构造函数
		{
			double a = weight/(height*height);
			BigDecimal b = new BigDecimal(a);
			this.bmi = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		public String toString()
		{
			return this.id+"\t"+this.name+"\t"+this.height+"m\t"+this.weight+"kg\t"+this.bmi;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBMI frame = new SwingBMI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public SwingBMI() {
		setTitle("学生信息查询界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 504);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(100, 100, 601, 50);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("学生信息输入");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputActionPerformed(e);
				
			}
		});
		mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 16));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("学生信息修改");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modActionPerformed(e);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 16));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("学生信息删除");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.BOLD, 16));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("BMI\u7EDF\u8BA1\u754C\u9762");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chartActionPerformed(e);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("宋体", Font.BOLD, 16));
		menuBar.add(mntmNewMenuItem_7);
		
		JMenu menu = new JMenu("排序");
		menu.setFont(new Font("宋体", Font.BOLD, 16));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("学号排序");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				StringBuffer sb = new StringBuffer();
				ta.setText("");
				students = readFile("D://java_workspace//bmi.txt");
				sortStudents(new IdComparator());
				for(Student stu:students)
				{
					sb.append(stu.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);
			}
		});
		menuItem.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("姓名排序");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				StringBuffer sb = new StringBuffer();
				ta.setText("");
				students = readFile("D://java_workspace//bmi.txt");
				sortStudents(new NameComparator());
				for(Student stu:students)
				{
					sb.append(stu.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("身高排序");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				StringBuffer sb = new StringBuffer();
				ta.setText("");
				students = readFile("D://java_workspace//bmi.txt");
				sortStudents(new HeightComparator());
				for(Student stu:students)
				{
					sb.append(stu.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("体重排序");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				StringBuffer sb = new StringBuffer();
				ta.setText("");
				students = readFile("D://java_workspace//bmi.txt");
				sortStudents(new WeightComparator());
				for(Student stu:students)
				{
					sb.append(stu.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("BMI排序");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				StringBuffer sb = new StringBuffer();
				ta.setText("");
				students = readFile("D://java_workspace//bmi.txt");
				sortStudents(new BmiComparator());
				for(Student stu:students)
				{
					sb.append(stu.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(" 学生信息查询");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 28));
		
		JLabel label = new JLabel("学 号：");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		
		idtext = new JTextField();
		idtext.setColumns(10);
		
		JLabel label_1 = new JLabel("姓 名：");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		nametext = new JTextField();
		nametext.setColumns(10);
		
		JButton button = new JButton("按学号查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students = readFile("D://java_workspace//bmi.txt");
				idsearchActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton button_1 = new JButton("按姓名查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students = readFile("D://java_workspace//bmi.txt");
				namesearchActionPerformed(e);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(39)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(nametext)
										.addComponent(idtext, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addGap(67)
									.addComponent(button_1))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(sp, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(18)
					.addComponent(sp, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
		);
		
		sp.setViewportView(ta);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void chartActionPerformed(ActionEvent e) {
		new BMIChart();
	}

	private void modActionPerformed(ActionEvent e) {
		this.setContentPane(new modifyPanel());
		setVisible(true);
	}

	private void deleteActionPerformed(ActionEvent e) {
		this.setContentPane(new deletePanel());
		setVisible(true);
	}

	private void inputActionPerformed(ActionEvent e) {
		this.setContentPane(new inputPanel());
		setVisible(true);
	}

	/**
	 * 随机生成指定数量的名学生对象，
	 * 并保存到students中
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
				continue;//如果重复则跳过
			
			s.setId(String.format("%04d", i));
			s.setName(genRandomString(6));
			s.setHeight(1.75+x*0.1);
			s.setWeight(60.0+y*5.0);
			s.setBmi( (1.75+x*0.1),(60.0+y*5.0));
			
			students.add(s);
		}
	}
	
	/**
	 * 随机生成名字
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
	 * 判断该学生是否已经输入（是否在students中）
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
	 * 打印所有学生的基本信息
	 * @param students
	 */
	public void printStatics(Student s)
	{
			System.out.printf("id:%s"+"\t"+"name:%s"+"\t"
					+"height:%.2f"+"\t"+"weight:%.2f"+"\t"
					+"bmi:%.2f"+"%n",s.id,s.name,s.height,s.weight,s.bmi);
	}
	
	/**
	 * 姓名查询事件处理
	 * @param e
	 */
	private void namesearchActionPerformed(ActionEvent e) {
		int flag = 1;
		StringBuffer sb = new StringBuffer();
		String name = this.nametext.getText();
		if(isEmpty(name)){
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		Student stu = new Student(null, name);
		for(int i=0;i<students.size();i++)
		{
			if(stu.name.equals(students.get(i).name)){
				flag = 0;
				sb.append(students.get(i).toString()).append("\n");
			}
		}
		ta.setText(sb.toString());
		ta.setEditable(false);
		if(flag == 1)
		{
			JOptionPane.showMessageDialog(null, "未找到这名学生");
			return;
		}
		
		
	}

	

	/**
	 * 学号查询事件处理
	 * @param e
	 */
	private void idsearchActionPerformed(ActionEvent e) {
		int flag = 1;
		StringBuffer sb = new StringBuffer();
		String id = this.idtext.getText();
		if(isEmpty(id)){
			JOptionPane.showMessageDialog(null,"学号不能为空");
			return;
		}
		Student stu = new Student(id,null);
		for(int i=0;i<students.size();i++)
		{
			if(stu.id.equals(students.get(i).id)){
				flag = 0;
				sb.append(students.get(i).toString()).append("\n");
			}
		}
		ta.setText(sb.toString());
		ta.setEditable(false);
		
		if(flag == 1)
		{
			JOptionPane.showMessageDialog(null, "未找到这名学生");
			return;
		}
	}
	
	/**
	 * 将学生信息students写入到指定的文本文件中，每一行写入一个学生。
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
	 * 读文件中的数据到学生ArrayList中，并返回该ArrayList。
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
				Student s = new SwingBMI().new Student(a[0],a[1],Double.parseDouble(a[2]),Double.parseDouble(a[3]));
				s.setBmi(s.height, s.weight);
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
	 * id comparator子类
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
	 * name comparator子类
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
	 * height comparator子类
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
	 * weight comparator子类
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
	 * bmi comparator子类
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
	 * 排序函数
	 * @param c
	 */
	public void sortStudents(Comparator<Student> c)
	{
		Collections.sort(students,c);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public class inputPanel extends JPanel {
		private JTextField idtext;
		private JTextField nametext;
		private JTextField heighttext;
		private JTextField weighttext;

		/**
		 * Create the panel.
		 */
		public inputPanel() {
			
			JLabel id = new JLabel("\u5B66 \u53F7\uFF1A");
			id.setFont(new Font("宋体", Font.BOLD, 16));
			
			idtext = new JTextField();
			idtext.setColumns(10);
			
			JLabel name = new JLabel("\u59D3 \u540D\uFF1A");
			name.setFont(new Font("宋体", Font.BOLD, 16));
			
			nametext = new JTextField();
			nametext.setColumns(10);
			
			JLabel height = new JLabel("\u8EAB \u9AD8\uFF1A");
			height.setFont(new Font("宋体", Font.BOLD, 16));
			
			heighttext = new JTextField();
			heighttext.setColumns(10);
			
			JLabel weight = new JLabel("\u4F53 \u91CD\uFF1A");
			weight.setFont(new Font("宋体", Font.BOLD, 16));
			
			weighttext = new JTextField();
			weighttext.setColumns(10);
			
			JButton save = new JButton("\u4FDD\u5B58");
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveActionPerformed(e);
				}
			});
			save.setFont(new Font("宋体", Font.BOLD, 16));
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(99)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(weight)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(weighttext, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(height)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(heighttext))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(name)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nametext))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(id, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(idtext, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(188)
								.addComponent(save)))
						.addContainerGap(124, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(62)
								.addComponent(id))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(57)
								.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(name)
							.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(height)
							.addComponent(heighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(18)
								.addComponent(weight))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(14)
								.addComponent(weighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(32)
						.addComponent(save)
						.addContainerGap(38, Short.MAX_VALUE))
			);
			setLayout(groupLayout);

		}

		private void saveActionPerformed(ActionEvent e) {
			int flag = 1;
			String id = this.idtext.getText();
			String name = this.nametext.getText();
			String height = this.heighttext.getText();
			String weight = this.weighttext.getText();
			
			if(isEmpty(id)){
				JOptionPane.showMessageDialog(null, "学号不能为空");
				return;
			}
			if(isEmpty(name)){
				JOptionPane.showMessageDialog(null, "姓名不能为空");
				return;
			}
			if(isEmpty(height)){
				JOptionPane.showMessageDialog(null, "身高不能为空");
				return;
			}
			if(isEmpty(weight)){
				JOptionPane.showMessageDialog(null, "体重不能为空");
				return;
			}
			
			Student stu = new SwingBMI().new Student(id,name,Double.parseDouble(height),Double.parseDouble(weight));
			for(Student s:students)
			{
				if(s.id.equals(stu.id) && s.name.equals(stu.name) && s.height == stu.height && s.weight == stu.weight)
				{
					flag= 0;
					JOptionPane.showMessageDialog(null, "该学生已存在，请重新输入");
					this.idtext.setText("");
					this.nametext.setText("");
					this.heighttext.setText("");
					this.weighttext.setText("");
				}
			}
			
			if(flag == 1)
			{
				students.add(stu);
				saveFile(students,"D://java_workspace//bmi.txt");
				JOptionPane.showMessageDialog(null, "成功保存");
			}
			
		}
	}
	
	public class deletePanel extends JPanel {
		private JTextField idtext;

		/**
		 * Create the panel.
		 */
		public deletePanel() {
			
			JLabel id = new JLabel("\u5220\u9664\u7684\u5B66\u53F7\uFF1A");
			id.setFont(new Font("宋体", Font.BOLD, 16));
			
			idtext = new JTextField();
			idtext.setColumns(10);
			
			JButton button = new JButton("\u63D0\u4EA4");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deActionPerformed(e);
				}
			});
			button.setFont(new Font("宋体", Font.BOLD, 16));
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(88)
						.addComponent(id)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(button)
							.addComponent(idtext, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(76, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(121)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(id))
						.addGap(40)
						.addComponent(button)
						.addContainerGap(88, Short.MAX_VALUE))
			);
			setLayout(groupLayout);

		}

		private void deActionPerformed(ActionEvent e) {
			int flag = 1;
			String id = idtext.getText();
			if(isEmpty(id))
			{
				JOptionPane.showMessageDialog(null, "请输入要删除的学号");
				return;
			}
			students = readFile("D://java_workspace//bmi.txt");
			for(Student s:students)
			{
				if(s.id.equals(id))
				{
					students.remove(s);
					flag = 0;
					saveFile(students,"D://java_workspace//bmi.txt");
					JOptionPane.showMessageDialog(null, "删除成功");
				}
			}
			if(flag == 1)
			{
				JOptionPane.showMessageDialog(null, "该学生不存在");
				idtext.setText("");
				return;
			}
			
		}

	}
	
	public class modifyPanel extends JPanel {
		private JTextField idtext;
		private JTextField nametext;
		private JTextField heighttext;
		private JTextField weighttext;
		String id;

		/**
		 * Create the panel.
		 */
		public modifyPanel() {
			
			JLabel id = new JLabel("\u8981\u4FEE\u6539\u5B66\u751F\u7684\u5B66\u53F7\uFF1A");
			id.setFont(new Font("宋体", Font.BOLD, 16));
			
			idtext = new JTextField();
			idtext.setColumns(10);
			
			JButton search = new JButton("\u67E5\u8BE2");
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seActionPerformed(e);
				}
			});
			search.setFont(new Font("宋体", Font.BOLD, 16));
			
			nametext = new JTextField();
			nametext.setColumns(10);
			
			JLabel name = new JLabel("\u59D3\u540D\uFF1A");
			name.setFont(new Font("宋体", Font.BOLD, 16));
			
			JLabel height = new JLabel("\u8EAB\u9AD8\uFF1A");
			height.setFont(new Font("宋体", Font.BOLD, 16));
			
			heighttext = new JTextField();
			heighttext.setColumns(10);
			
			JLabel weight = new JLabel("\u4F53\u91CD\uFF1A");
			weight.setFont(new Font("宋体", Font.BOLD, 16));
			
			weighttext = new JTextField();
			weighttext.setColumns(10);
			
			JButton save = new JButton("\u4FDD\u5B58");
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edActionPerformed(e);
				}
			});
			save.setFont(new Font("宋体", Font.BOLD, 16));
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(62)
						.addComponent(id)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(idtext, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(105, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(weight)
								.addGap(42)
								.addComponent(weighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(name)
									.addComponent(height))
								.addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(heighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(145))
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(327, Short.MAX_VALUE)
						.addComponent(search)
						.addGap(56))
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(330, Short.MAX_VALUE)
						.addComponent(save)
						.addGap(53))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(77)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(idtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(id))
						.addGap(16)
						.addComponent(search)
						.addGap(17)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(name)
							.addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(height)
							.addComponent(heighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(weight))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(weighttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(4)
						.addComponent(save)
						.addContainerGap(15, Short.MAX_VALUE))
			);
			setLayout(groupLayout);

		}

		private void edActionPerformed(ActionEvent e) {
			String name = nametext.getText();
			String height = heighttext.getText();
			String weight = weighttext.getText();
			if(isNotEmpty(name) && isNotEmpty(height) && isNotEmpty(weight))
			{
				students = readFile("D://java_workspace//bmi.txt");
				for(Student s:students)
				{
					if(s.id.equals(id)){
						s.setName(name);
						s.setHeight(Double.parseDouble(height));
						s.setWeight(Double.parseDouble(weight));
						s.setBmi(Double.parseDouble(height), Double.parseDouble(weight));
						JOptionPane.showMessageDialog(null, "修改成功");
						saveFile(students,"D://java_workspace//bmi.txt");
					}
			}
			
		}
		}

		private void seActionPerformed(ActionEvent e) {
			int flag = 1;
			id = idtext.getText();
			students = readFile("D://java_workspace//bmi.txt");
			for(Student s:students)
			{
				if(s.id.equals(id)){
					flag = 0;
					nametext.setText(s.name);
					heighttext.setText(Double.toString(s.height));
					weighttext.setText(Double.toString(s.weight));
					nametext.setEditable(true);
					heighttext.setEditable(true);
					weighttext.setEditable(true);
				}
				
			}
			if(flag==1)
			{
				JOptionPane.showMessageDialog(null, "该学生不存在");
				idtext.setText("");
				return;
			}
		}

	}
	
	
	public class BMIChart extends JPanel {
		/**
		 * Create the panel.
		 */
		public BMIChart() {
			double[] a = {0,0,0,0,0,0,0,0,0,0};
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			students = readFile("D://java_workspace//bmi.txt");
			for(Student s:students)
			{
				if(s.bmi>=10 && s.bmi<12)
					a[0]++;
				else if(s.bmi>=12 && s.bmi<14)
					a[1]++;
				else if(s.bmi>=14 && s.bmi<16)
					a[2]++;
				else if(s.bmi>=16 && s.bmi<18)
					a[3]++;
				else if(s.bmi>=18 && s.bmi<20)
					a[4]++;
				else if(s.bmi>=20 && s.bmi<22)
					a[5]++;
				else if(s.bmi>=22 && s.bmi<24)
					a[6]++;
				else if(s.bmi>=24 && s.bmi<26)
					a[7]++;
				else if(s.bmi>=26 && s.bmi<28)
					a[8]++;
				else if(s.bmi>=28 && s.bmi<=30)
					a[9]++;
			}
			
			JFreeChart chart = ChartFactory.createBarChart("BMI Statistics",
					"Intervals","Number of Students",dataset,PlotOrientation.VERTICAL,
					true,false,false);
			
			
			dataset.addValue(a[0], "BMI", "10-12");
			dataset.addValue(a[1], "BMI", "12-14");
			dataset.addValue(a[2], "BMI", "14-16");
			dataset.addValue(a[3], "BMI", "16-18");
			dataset.addValue(a[4], "BMI", "18-20");
			dataset.addValue(a[5], "BMI", "20-22");
			dataset.addValue(a[6], "BMI", "22-24");
			dataset.addValue(a[7], "BMI", "24-26");
			dataset.addValue(a[8], "BMI", "26-28");
			dataset.addValue(a[9], "BMI", "28-30");
			
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE);
			cp.setRangeMinorGridlinePaint(ChartColor.GRAY);
			
			ChartFrame frame = new ChartFrame("BMI Statistics",chart);
			frame.pack();
			frame.getChartPanel().setLayout(null);
			
			JButton height = new JButton("\u8EAB\u9AD8\u7EDF\u8BA1");
			height.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					heightStatistics(e);
				}
			});
			height.setFont(new Font("宋体", Font.BOLD, 16));
			height.setBounds(83, 0, 108, 27);
			frame.getChartPanel().add(height);
			
			JButton weight = new JButton("\u4F53\u91CD\u7EDF\u8BA1");
			weight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					weightStatistics(e);
				}
			});
			weight.setFont(new Font("宋体", Font.BOLD, 16));
			weight.setBounds(494, 1, 113, 27);
			frame.getChartPanel().add(weight);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);

		}
		private void weightStatistics(ActionEvent e) {
			double[] a = {0,0,0,0,0,0,0,0,0,0};
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for(Student s:students)
			{
				if(s.weight>=50.0 && s.weight<53.0)
					a[0]++;
				else if(s.weight>=53.0 && s.weight<56.0)
					a[1]++;
				else if(s.weight>=56.0 && s.weight<59.0)
					a[2]++;
				else if(s.weight>=59.0 && s.weight<62.0)
					a[3]++;
				else if(s.weight>=62.0 && s.weight<65.0)
					a[4]++;
				else if(s.weight>=68.0 && s.weight<71.0)
					a[5]++;
				else if(s.weight>=71.0 && s.weight<74.0)
					a[6]++;
				else if(s.weight>=77.0 && s.weight<80.0)
					a[7]++;
				else if(s.weight>=80.0 && s.weight<83.0)
					a[8]++;
				else if(s.height>=1.95 && s.height<2.0)
					a[9]++;
			}
			
			JFreeChart chart = ChartFactory.createBarChart("Weight Statistics",
					"Intervals","Number of Students",dataset,PlotOrientation.VERTICAL,
					true,false,false);
			
			
			dataset.addValue(a[0], "Weight", "50-53");
			dataset.addValue(a[1], "Weight", "53-56");
			dataset.addValue(a[2], "Weight", "56-59");
			dataset.addValue(a[3], "Weight", "59-62");
			dataset.addValue(a[4], "Weight", "62-65");
			dataset.addValue(a[5], "Weight", "65-68");
			dataset.addValue(a[6], "Weight", "68-71");
			dataset.addValue(a[7], "Weight", "71-74");
			dataset.addValue(a[8], "Weight", "74-77");
			dataset.addValue(a[9], "Weight", "77-80");
			
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE);
			cp.setRangeMinorGridlinePaint(ChartColor.GRAY);
			
			ChartFrame frame = new ChartFrame("BMI Statistics",chart);
			frame.pack();
			frame.setVisible(true);
			
		}
		private void heightStatistics(ActionEvent e) {
			double[] a = {0,0,0,0,0,0,0,0,0,0};
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for(Student s:students)
			{
				if(s.height>=1.50 && s.height<1.55)
					a[0]++;
				else if(s.height>=1.55 && s.height<1.60)
					a[1]++;
				else if(s.height>=1.60 && s.height<1.65)
					a[2]++;
				else if(s.height>=1.65 && s.height<1.70)
					a[3]++;
				else if(s.height>=1.70 && s.height<1.75)
					a[4]++;
				else if(s.height>=1.75 && s.height<1.80)
					a[5]++;
				else if(s.height>=1.80 && s.height<1.85)
					a[6]++;
				else if(s.height>=1.85 && s.height<1.90)
					a[7]++;
				else if(s.height>=1.90 && s.height<1.95)
					a[8]++;
				else if(s.height>=1.95 && s.height<2.0)
					a[9]++;
			}
			
			JFreeChart chart = ChartFactory.createBarChart("Height Statistics",
					"Intervals","Number of Students",dataset,PlotOrientation.VERTICAL,
					true,false,false);
			
			
			//dataset.addValue(a[0], "身高", "1.50-1.55");
			dataset.addValue(a[1], "Height", "1.55-1.60");
			dataset.addValue(a[2], "Height", "1.60-1.65");
			dataset.addValue(a[3], "Height", "1.65-1.70");
			dataset.addValue(a[4], "Height", "1.70-1.75");
			dataset.addValue(a[5], "Height", "1.75-1.80");
			dataset.addValue(a[6], "Height", "1.80-1.85");
			dataset.addValue(a[7], "Height", "1.85-1.90");
			dataset.addValue(a[8], "Height", "1.90-1.95");
			//dataset.addValue(a[9], "身高", "1.95-2.0");
			
			CategoryPlot cp = chart.getCategoryPlot();
			cp.setBackgroundPaint(ChartColor.WHITE);
			cp.setRangeMinorGridlinePaint(ChartColor.GRAY);
			
			ChartFrame frame = new ChartFrame("BMI Statistics",chart);
			frame.pack();
			frame.setVisible(true);
			
		}
	}
	
		public  boolean isEmpty(String str)
		{
			if(str==null || "".equals(str.trim()))
			{
				return true;
			}
			else
				return false;
		}
		
		/**
		 * 判断是否不是空
		 * @param str
		 * @return
		 */
		public boolean isNotEmpty(String str)
		{
			if(str!=null && !"".equals(str.trim()))
			{
				return true;
			}
			else
				return false;
		}
	
}
