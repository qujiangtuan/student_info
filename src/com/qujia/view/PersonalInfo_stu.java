package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qujia.util.ViewUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PersonalInfo_stu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo_stu frame = new PersonalInfo_stu();
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
	public PersonalInfo_stu() {
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 353, 422);
		
		ViewUtil vu=new ViewUtil();
        vu.showCenter(this);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC774    \uB984:");
		
		JLabel lblNewLabel_1 = new JLabel("123");
		
		JLabel lblNewLabel_2 = new JLabel("\uC18C\uC18D\uD559\uACFC:");
		
		JLabel lblNewLabel_3 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774 \uBA54 \uC77C:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC8FC    \uC18C:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uCD94\uAC00\uC804\uACF5:");
		
		JLabel lblNewLabel_8 = new JLabel("\uC5C6\uC74C");
		
		JButton button = new JButton("\uC218  \uC815");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_2, Alignment.LEADING)
									.addComponent(textField_1, Alignment.LEADING)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(button)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(button)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
