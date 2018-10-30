package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class EvaluationQuestionFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchQue;
	private JTable table;
	private JTextField textField_editQue;
	private JPanel panel_Manager,panel_add,panel_card;
	private CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluationQuestionFrm frame = new EvaluationQuestionFrm();
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
	public EvaluationQuestionFrm() {
	          this.setResizable(false);
		setTitle("\uD3C9\uAC00\uC9C8\uBB38\uAD6C\uC131\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 797, 460);
		
		ViewUtil vu = new ViewUtil();
        vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_card = new JPanel();
		panel_card.setBounds(31, 48, 722, 358);
		
		JButton questionManButton = new JButton("\uD3C9\uAC00\uC9C8\uBB38\uAD00\uB9AC");
		questionManButton.setBounds(43, 15, 130, 23);
		questionManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_Manager");
			}
		});
		
		JButton questionAddButton = new JButton("\uD3C9\uAC00\uC9C8\uBB38\uCD94\uAC00");
		questionAddButton.setBounds(204, 15, 122, 23);
		questionAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_add");
			}
		});
		
		card=new CardLayout(0, 0);
		panel_card.setLayout(card);
		
		panel_Manager = new JPanel();
		panel_Manager.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_Manager, "panel_Manager");
		
		JLabel lblNewLabel = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel.setBounds(35, 31, 92, 15);
		
		textField_searchQue = new JTextField();
		textField_searchQue.setBounds(139, 28, 205, 21);
		textField_searchQue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("평가대상：");
		lblNewLabel_1.setBounds(356, 31, 75, 15);
		
		JComboBox comboBox_searchObj = new JComboBox();
		comboBox_searchObj.setBounds(436, 28, 163, 21);
		comboBox_searchObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC1C\uC124\uAD50\uC218"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.setBounds(632, 27, 61, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 56, 686, 170);
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_2.setBounds(18, 247, 91, 15);
		
		textField_editQue = new JTextField();
		textField_editQue.setBounds(121, 244, 583, 21);
		textField_editQue.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		lblNewLabel_3.setBounds(18, 287, 91, 15);
		
		JComboBox comboBox_editObj = new JComboBox();
		comboBox_editObj.setBounds(121, 284, 160, 21);
		comboBox_editObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC1C\uC124\uAD50\uC218"}));
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.setBounds(333, 283, 80, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.setBounds(453, 283, 80, 23);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9", "\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(428);
		table.getColumnModel().getColumn(2).setPreferredWidth(144);
		scrollPane.setViewportView(table);
		panel_Manager.setLayout(null);
		panel_Manager.add(lblNewLabel);
		panel_Manager.add(textField_searchQue);
		panel_Manager.add(lblNewLabel_1);
		panel_Manager.add(comboBox_searchObj);
		panel_Manager.add(searchButton);
		panel_Manager.add(scrollPane);
		panel_Manager.add(lblNewLabel_3);
		panel_Manager.add(lblNewLabel_2);
		panel_Manager.add(comboBox_editObj);
		panel_Manager.add(updateButton);
		panel_Manager.add(deleteButton);
		panel_Manager.add(textField_editQue);
		
		JButton button = new JButton("닫기");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button.setBounds(573, 283, 80, 23);
		panel_Manager.add(button);
		
		panel_add = new JPanel();
		panel_add.setBackground(new Color(253, 245, 230));
		panel_card.add(panel_add, "panel_add");
		
		JLabel lblNewLabel_4 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_4.setBounds(62, 52, 95, 15);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(169, 52, 323, 80);
		
		JLabel lblNewLabel_5 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		lblNewLabel_5.setBounds(62, 187, 95, 15);
		
		JComboBox comboBox_addObj = new JComboBox();
		comboBox_addObj.setBounds(169, 184, 323, 21);
		comboBox_addObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC15\uC758\uAD50\uC218"}));
		
		JButton addButton = new JButton("\uCD94  \uAC00");
		addButton.setBounds(228, 260, 65, 23);
		
		JTextArea textArea_addQue = new JTextArea();
		textArea_addQue.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_addQue);
		panel_add.setLayout(null);
		panel_add.add(lblNewLabel_5);
		panel_add.add(lblNewLabel_4);
		panel_add.add(comboBox_addObj);
		panel_add.add(scrollPane_1);
		panel_add.add(addButton);
		
		JButton button_1 = new JButton("취 소");
		button_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    card.show(panel_card, "panel_Manager");
		          }
		});
		button_1.setBounds(317, 260, 65, 23);
		panel_add.add(button_1);
		contentPane.setLayout(null);
		contentPane.add(questionManButton);
		contentPane.add(questionAddButton);
		contentPane.add(panel_card);
	}
}
