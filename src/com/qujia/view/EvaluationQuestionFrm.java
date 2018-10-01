package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("\uD3C9\uAC00\uC9C8\uBB38\uAD6C\uC131\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 797, 460);
		
		ViewUtil vu = new ViewUtil();
        vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_card = new JPanel();
		
		JButton questionManButton = new JButton("\uD3C9\uAC00\uC9C8\uBB38\uAD00\uB9AC");
		questionManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_Manager");
			}
		});
		
		JButton questionAddButton = new JButton("\uD3C9\uAC00\uC9C8\uBB38\uCD94\uAC00");
		questionAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_add");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(questionManButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(questionAddButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(panel_card, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(questionManButton)
						.addComponent(questionAddButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_card, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		card=new CardLayout(0, 0);
		panel_card.setLayout(card);
		
		panel_Manager = new JPanel();
		panel_Manager.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_Manager, "panel_Manager");
		
		JLabel lblNewLabel = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		textField_searchQue = new JTextField();
		textField_searchQue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD3C9\uAC00\uB300\uC0C1");
		
		JComboBox comboBox_searchObj = new JComboBox();
		comboBox_searchObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC1C\uC124\uAD50\uC218"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		textField_editQue = new JTextField();
		textField_editQue.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		
		JComboBox comboBox_editObj = new JComboBox();
		comboBox_editObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC1C\uC124\uAD50\uC218"}));
		
		JButton updateButton = new JButton("\uC218 \uC815");
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		GroupLayout gl_panel_Manager = new GroupLayout(panel_Manager);
		gl_panel_Manager.setHorizontalGroup(
			gl_panel_Manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Manager.createSequentialGroup()
					.addGroup(gl_panel_Manager.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Manager.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_searchQue, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(comboBox_searchObj, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchButton))
						.addGroup(gl_panel_Manager.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_Manager.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_Manager.createSequentialGroup()
									.addGroup(gl_panel_Manager.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_Manager.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_Manager.createSequentialGroup()
											.addComponent(comboBox_editObj, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
											.addGap(52)
											.addComponent(updateButton)
											.addGap(59)
											.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_editQue))))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_Manager.setVerticalGroup(
			gl_panel_Manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Manager.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_Manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_searchQue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox_searchObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_Manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_editQue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_Manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBox_editObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateButton)
						.addComponent(deleteButton))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		
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
		panel_Manager.setLayout(gl_panel_Manager);
		
		panel_add = new JPanel();
		panel_add.setBackground(new Color(253, 245, 230));
		panel_card.add(panel_add, "panel_add");
		
		JLabel lblNewLabel_4 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_5 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		
		JComboBox comboBox_addObj = new JComboBox();
		comboBox_addObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC15\uC758\uAD50\uC218"}));
		
		JButton addButton = new JButton("\uCD94  \uAC00");
		GroupLayout gl_panel_add = new GroupLayout(panel_add);
		gl_panel_add.setHorizontalGroup(
			gl_panel_add.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_add.createSequentialGroup()
					.addGroup(gl_panel_add.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_add.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_panel_add.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_add.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox_addObj, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
						.addGroup(gl_panel_add.createSequentialGroup()
							.addGap(265)
							.addComponent(addButton)))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		gl_panel_add.setVerticalGroup(
			gl_panel_add.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_add.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel_add.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(52)
					.addGroup(gl_panel_add.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(comboBox_addObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(addButton)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		JTextArea textArea_addQue = new JTextArea();
		textArea_addQue.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_addQue);
		panel_add.setLayout(gl_panel_add);
		contentPane.setLayout(gl_contentPane);
	}
}
