package edu.hit1160300510.experiment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.hit1160300510.experiment3.OOBMI.Student;
import edu.hit1160300510.experiment4.Namesearchshow;
import edu.hit1160300510.experiment4.StringUtil;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;

public class SwingBMI extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField nametext;

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
		setResizable(false);
		setTitle("学生信息查询界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 504);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(100, 100, 601, 50);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("学生信息输入");
		mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("学生信息修改");
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("学生信息删除");
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenu menu = new JMenu("排序");
		menu.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("学号排序");
		menuItem.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("姓名排序");
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("身高排序");
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("体重排序");
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("BMI排序");
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
				new OOBMI().genStudents(10);
				idsearchActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton button_1 = new JButton("按姓名查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OOBMI().genStudents(10);
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
									.addComponent(button_1)))))
					.addContainerGap(143, Short.MAX_VALUE))
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
					.addContainerGap(179, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 姓名查询事件处理
	 * @param e
	 */
	private void namesearchActionPerformed(ActionEvent e) {
		String name = this.nametext.getText();
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		Student stu = new Student(null, name);
		for(int i=0;i<students.size();i++)
		{
			if(stu.name.equals(students.get(i).name))
				showStudent(students.get(i));
		}
		
	}
	
	private void showStudent(Student stu) {
		// TODO Auto-generated method stub
		this.setContentPane(new NameSearchShow(stu));
		setVisible(true);
	}

	/**
	 * 学号查询事件处理
	 * @param e
	 */
	private void idsearchActionPerformed(ActionEvent e) {
		String id = this.idtext.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null,"学号不能为空");
			return;
		}
		Student stu = new Student(id,null);
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
	
	
}
