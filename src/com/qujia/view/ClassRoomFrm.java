package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassRoomFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	CardLayout card;
	private JPanel panel,panel_crManager,panel_crAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassRoomFrm frame = new ClassRoomFrm();
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
	public ClassRoomFrm() {
		setTitle("\uAC15\uC758\uC2E4\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 729, 480);
		
		 ViewUtil vu = new ViewUtil();
         vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		JButton managerButton = new JButton("\uAC15\uC758\uC2E4\uAD00\uB9AC");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "panel_crManager");
			}
		});
		
		JButton addButton = new JButton("\uAC15\uC758\uC2E4\uB4F1\uB85D");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "panel_crAdd");
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(managerButton)
							.addGap(46)
							.addComponent(addButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(managerButton)
						.addComponent(addButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		card=new CardLayout(0, 0);
		panel.setLayout(card);
		
		panel_crManager = new JPanel();
		panel_crManager.setBackground(new Color(224, 255, 255));
		panel.add(panel_crManager, "panel_crManager");
		
		JLabel lblNewLabel_3 = new JLabel("\uAC15\uC758\uC2E4\uBC88\uD638:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uAC80 \uC0C9");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_5 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC815\uC6D0:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uAC15\uC758\uC2E4\uD2B9\uC131:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JButton btnNewButton_2 = new JButton("\uC218 \uC815");
		btnNewButton_2.setBackground(new Color(60, 179, 113));
		
		JButton button = new JButton("\uC0AD \uC81C");
		button.setBackground(new Color(255, 99, 71));
		GroupLayout gl_panel_crManager = new GroupLayout(panel_crManager);
		gl_panel_crManager.setHorizontalGroup(
			gl_panel_crManager.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_crManager.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(btnNewButton_1)
					.addContainerGap(145, Short.MAX_VALUE))
				.addGroup(gl_panel_crManager.createSequentialGroup()
					.addGroup(gl_panel_crManager.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_crManager.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_crManager.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_crManager.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_5)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
							.addGap(27)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addGroup(gl_panel_crManager.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_2)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_crManager.createSequentialGroup()
							.addContainerGap(22, Short.MAX_VALUE)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_panel_crManager.setVerticalGroup(
			gl_panel_crManager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_crManager.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_crManager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_crManager.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_crManager.createSequentialGroup()
							.addGroup(gl_panel_crManager.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7))
							.addGap(18)
							.addGroup(gl_panel_crManager.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_crManager.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_crManager.createSequentialGroup()
								.addComponent(btnNewButton_2)
								.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
								.addComponent(button)
								.addGap(3))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_2.setViewportView(textArea_1);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\uAC15\uC758\uC2E4\uBC88\uD638", "\uAC15\uC758\uC2E4\uBA85", "\uC815\uC6D0", "\uAC15\uC758\uC2E4\uD2B9\uC131"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(64);
		table.getColumnModel().getColumn(3).setPreferredWidth(272);
		scrollPane_1.setViewportView(table);
		panel_crManager.setLayout(gl_panel_crManager);
		
		panel_crAdd = new JPanel();
		panel_crAdd.setBackground(new Color(176, 224, 230));
		panel.add(panel_crAdd, "panel_crAdd");
		
		JLabel lblNewLabel_1 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC815\uC6D0:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC15\uC758\uC2E4\uD2B9\uC131:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\uB4F1  \uB85D");
		GroupLayout gl_panel_crAdd = new GroupLayout(panel_crAdd);
		gl_panel_crAdd.setHorizontalGroup(
			gl_panel_crAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_crAdd.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_1)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(290, Short.MAX_VALUE))
		);
		gl_panel_crAdd.setVerticalGroup(
			gl_panel_crAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_crAdd.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panel_crAdd.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(67))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		panel_crAdd.setLayout(gl_panel_crAdd);
		contentPane.setLayout(gl_contentPane);
	}
}
