package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class QuestionAnswerShowFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchQue;
	private JTable table;
	private JPanel panel_manager,panel_add;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionAnswerShowFrm frame = new QuestionAnswerShowFrm();
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
	public QuestionAnswerShowFrm() {
		setTitle("\uB2F5\uC548\uBCF4\uAE30\uAD6C\uC131");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 823, 622);
		
		ViewUtil vu = new ViewUtil();
        vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_add = new JPanel();
		panel_add.setBounds(5, 62, 785, 100);
		panel_add.setBorder(BorderFactory.createTitledBorder("평가문답항목 추가"));
		panel_manager = new JPanel();
		panel_manager.setBounds(5, 172, 785, 396);
		panel_manager.setBorder(BorderFactory.createTitledBorder("답안보기관리"));
		panel_manager.setBackground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_1 = new JLabel("\uD3C9\uAC00\uBB38\uB2F5\uBA85:");
		lblNewLabel_1.setBounds(150, 15, 105, 22);
		lblNewLabel_1.setFont(new Font("휴먼명조", Font.BOLD, 15));
		
		JLabel label_1 = new JLabel("\uC804\uACF5\uACFC\uBAA9\uC6A9 \uD3C9\uAC00\uBB38\uB2F5");
		label_1.setBounds(278, 17, 242, 18);
		label_1.setFont(new Font("휴먼명조", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_2.setBounds(30, 28, 111, 15);
		
		textField_searchQue = new JTextField();
		textField_searchQue.setBounds(153, 25, 253, 21);
		textField_searchQue.setColumns(10);
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.setBounds(600, 24, 83, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 71, 746, 200);
		
		JLabel label_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		label_2.setBounds(18, 285, 94, 15);
		
		JLabel label_3 = new JLabel("  \uB2F5\uC548\uC720\uD615\uBA85:");
		label_3.setBounds(18, 318, 94, 15);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.setBounds(620, 281, 83, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.setBounds(620, 314, 83, 23);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uD3C9\uAC00\uBB38\uB2F5\uD56D\uBAA9\uBC88\uD638", "\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9", "\uB2F5\uC548\uC720\uD615"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(341);
		table.getColumnModel().getColumn(2).setPreferredWidth(175);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel.setBounds(29, 33, 92, 15);
		
		JLabel label = new JLabel("\uB2F5\uC548\uC720\uD615\uBA85:");
		label.setBounds(41, 60, 80, 15);
		
		JButton btnNewButton = new JButton("\uCD94 \uAC00");
		btnNewButton.setBounds(686, 33, 69, 44);
		btnNewButton.setBackground(new Color(176, 224, 230));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(126, 30, 474, 21);
		textField.setColumns(10);
		contentPane.add(panel_add);
		panel_add.setLayout(null);
		panel_add.add(lblNewLabel);
		panel_add.add(label);
		panel_add.add(textField);
		panel_add.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(126, 58, 474, 21);
		panel_add.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.setBounds(601, 29, 61, 23);
		panel_add.add(btnNewButton_1);
		
		JButton button = new JButton("조회");
		button.setBounds(601, 56, 61, 23);
		panel_add.add(button);
		contentPane.add(lblNewLabel_1);
		contentPane.add(label_1);
		contentPane.add(panel_manager);
		panel_manager.setLayout(null);
		panel_manager.add(lblNewLabel_2);
		panel_manager.add(textField_searchQue);
		panel_manager.add(searchButton);
		panel_manager.add(scrollPane);
		panel_manager.add(label_3);
		panel_manager.add(label_2);
		panel_manager.add(deleteButton);
		panel_manager.add(updateButton);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(116, 284, 390, 21);
		panel_manager.add(textField_2);
		
		JButton button_1 = new JButton("조회");
		button_1.setBounds(510, 283, 61, 23);
		panel_manager.add(button_1);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(116, 312, 390, 21);
		panel_manager.add(textField_3);
		
		JButton button_2 = new JButton("조회");
		button_2.setBounds(510, 311, 61, 23);
		panel_manager.add(button_2);
	}
}
