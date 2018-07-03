package edu.hit1160300510.experiment3;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.hit1160300510.experiment3.OOBMI.Student;

import javax.swing.GroupLayout.Alignment;

public class NameSearchShow extends JPanel {

	/**
	 * Create the panel.
	 */
	public NameSearchShow(Student stu) {
		
		JButton back = new JButton("\u8FD4\u56DE");
		
		JTextArea textArea = new JTextArea();
		StringBuffer sb = new StringBuffer();
		sb.append(stu.toString()).append("\n");
		textArea.setText(sb.toString());
		textArea.setEditable(false);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(5,5,500,300);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(sp);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(back)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(back)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
