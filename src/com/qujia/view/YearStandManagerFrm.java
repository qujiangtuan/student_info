package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;

public class YearStandManagerFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YearStandManagerFrm frame = new YearStandManagerFrm();
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
	public YearStandManagerFrm() {
		setTitle("\uD559\uB144\uBCC4\uAD50\uC721\uBD80\uC11C\uD559\uC0AC\uAE30\uC900\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD559\uB144:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnNewButton = new JButton("\uAC80  \uC0C9");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		
		JLabel lblNewLabel_3 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		
		JLabel lblNewLabel_4 = new JLabel("\uC801\uC6A9\uC885\uB8CC\uB144\uB3C4:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("\uAD50\uC591\uC774\uC218\uD559\uC810:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_2 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel label_3 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC815\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uBD80\uAC00\uC804\uACF5\uD5C8\uC6A9\uC5EC\uBD80:");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("yes");
		
		JRadioButton rdbtnNo = new JRadioButton("no");
		
		JButton button = new JButton("\uC218 \uC815");
		button.setBackground(new Color(224, 255, 255));
		
		JButton button_1 = new JButton("\uC0AD \uC81C");
		button_1.setBackground(new Color(255, 99, 71));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(chckbxNewCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(42)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_8)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
									.addGap(75)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
									.addGap(155))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addGap(18)
									.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(button))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(button_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNo))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uB144\uB3C4", "\uC870\uC9C1\uC774\uB984", "\uC801\uC6A9\uC2DC\uC791\uB144\uB3C4", "\uC801\uC6A9\uC885\uB8CC\uB144\uB3C4", "\uC804\uACF5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uD544\uC218\uD559\uC810", "\uC804\uACF5\uC120\uD0DD\uD559\uC810", "\uAD50\uC591\uC774\uC218\uD559\uC810", "\uAD50\uC591\uD544\uC218\uD559\uC810", "\uAD50\uC591\uC120\uD0DD\uD559\uC810", "\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728", "\uC218\uC2DC\uBAA8\uC9D1\uC778\uC6D0", "\uC815\uC2DC\uBAA8\uC9D1\uC778\uC6D0", "\uBD80\uAC00\uC804\uACF5\uD5C8\uC6A9\uC5EC\uBD80", "\uBD80\uAC00\uC804\uACF5\uD544\uC218\uD559\uC810", "\uBD80\uAC00\uC804\uACF5\uD544\uC218\uAD50\uC591"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(88);
		table.getColumnModel().getColumn(8).setPreferredWidth(92);
		table.getColumnModel().getColumn(9).setPreferredWidth(91);
		table.getColumnModel().getColumn(10).setPreferredWidth(86);
		table.getColumnModel().getColumn(11).setPreferredWidth(89);
		table.getColumnModel().getColumn(12).setPreferredWidth(89);
		table.getColumnModel().getColumn(13).setPreferredWidth(107);
		table.getColumnModel().getColumn(14).setPreferredWidth(111);
		table.getColumnModel().getColumn(15).setPreferredWidth(113);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.setLayout(gl_contentPane);
	}
}
