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
		setTitle("ѧ����Ϣ��ѯ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 504);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(100, 100, 601, 50);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ѧ����Ϣ����");
		mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ѧ����Ϣ�޸�");
		mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ѧ����Ϣɾ��");
		mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenu menu = new JMenu("����");
		menu.setFont(new Font("����", Font.BOLD, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("ѧ������");
		menuItem.setFont(new Font("����", Font.BOLD, 16));
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("��������");
		mntmNewMenuItem_3.setFont(new Font("����", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("�������");
		mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("��������");
		mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("BMI����");
		mntmNewMenuItem_6.setFont(new Font("����", Font.BOLD, 16));
		menu.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(" ѧ����Ϣ��ѯ");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 28));
		
		JLabel label = new JLabel("ѧ �ţ�");
		label.setFont(new Font("����", Font.BOLD, 16));
		
		idtext = new JTextField();
		idtext.setColumns(10);
		
		JLabel label_1 = new JLabel("�� ����");
		label_1.setFont(new Font("����", Font.BOLD, 16));
		
		nametext = new JTextField();
		nametext.setColumns(10);
		
		JButton button = new JButton("��ѧ�Ų�ѯ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OOBMI().genStudents(10);
				idsearchActionPerformed(e);
			}
		});
		button.setFont(new Font("����", Font.BOLD, 16));
		
		JButton button_1 = new JButton("��������ѯ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OOBMI().genStudents(10);
				namesearchActionPerformed(e);
			}
		});
		button_1.setFont(new Font("����", Font.BOLD, 16));
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
	 * ������ѯ�¼�����
	 * @param e
	 */
	private void namesearchActionPerformed(ActionEvent e) {
		String name = this.nametext.getText();
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
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
	 * ѧ�Ų�ѯ�¼�����
	 * @param e
	 */
	private void idsearchActionPerformed(ActionEvent e) {
		String id = this.idtext.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null,"ѧ�Ų���Ϊ��");
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
