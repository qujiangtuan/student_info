package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class AnswerTypeManagerFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_serchName;
	private JTable table;
	private JTextField textField_editName;
	private JTextField textField_editInfo;
	private JTextField textField_addName;
	private JTextField textField_addInfo;
	private JPanel panel_manager,panel_addType,panel_card;
	private CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerTypeManagerFrm frame = new AnswerTypeManagerFrm();
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
	public AnswerTypeManagerFrm() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("\uB2F5\uC548\uC720\uD615\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 780, 455);
		
		ViewUtil vu = new ViewUtil();
        vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(27, 5, 707, 53);
		
		panel_card = new JPanel();
		panel_card.setBounds(27, 68, 708, 333);
		card=new CardLayout(0, 0);
		panel_card.setLayout(card);
		
		panel_manager = new JPanel();
		panel_manager.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_manager, "panel_manager");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 684, 167);
		
		JLabel lblNewLabel = new JLabel("\uB2F5\uC548\uC720\uD615\uC774\uB984:");
		lblNewLabel.setBounds(12, 20, 95, 15);
		
		textField_serchName = new JTextField();
		textField_serchName.setBounds(112, 17, 176, 21);
		textField_serchName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC720\uD615\uAD6C\uBD84:");
		lblNewLabel_1.setBounds(316, 20, 77, 15);
		
		JComboBox comboBox_searchType = new JComboBox();
		comboBox_searchType.setBounds(391, 17, 109, 21);
		comboBox_searchType.setModel(new DefaultComboBoxModel(new String[] {"", "\uC8FC\uAD00\uC2DD", "\uAC1C\uAD00\uC2DD"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.setBounds(526, 16, 61, 23);
		
		JLabel lblNewLabel_2 = new JLabel("\uB2F5\uC548\uC720\uD615\uBA85:");
		lblNewLabel_2.setBounds(35, 245, 64, 15);
		
		textField_editName = new JTextField();
		textField_editName.setBounds(111, 242, 200, 21);
		textField_editName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC720\uD615\uAD6C\uBD84:");
		lblNewLabel_3.setBounds(348, 245, 52, 15);
		
		JComboBox comboBox_editType = new JComboBox();
		comboBox_editType.setBounds(405, 242, 139, 21);
		comboBox_editType.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uAD00\uC2DD", "\uC8FC\uAD00\uC2DD"}));
		
		JLabel lblNewLabel_4 = new JLabel("\uCD94\uAC00\uC815\uBCF4:");
		lblNewLabel_4.setBounds(35, 277, 52, 15);
		
		textField_editInfo = new JTextField();
		textField_editInfo.setBounds(111, 274, 200, 21);
		textField_editInfo.setColumns(10);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.setBounds(348, 273, 61, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.setBounds(481, 273, 63, 23);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uB2F5\uC548\uC720\uD615\uBA85", "\uB2F5\uC548\uC720\uD615\uAD6C\uBD84", "\uCD94\uAC00\uC815\uBCF4"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(284);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(119);
		scrollPane.setViewportView(table);
		panel_manager.setLayout(null);
		panel_manager.add(lblNewLabel);
		panel_manager.add(textField_serchName);
		panel_manager.add(lblNewLabel_1);
		panel_manager.add(comboBox_searchType);
		panel_manager.add(searchButton);
		panel_manager.add(scrollPane);
		panel_manager.add(lblNewLabel_2);
		panel_manager.add(lblNewLabel_4);
		panel_manager.add(textField_editName);
		panel_manager.add(textField_editInfo);
		panel_manager.add(lblNewLabel_3);
		panel_manager.add(comboBox_editType);
		panel_manager.add(updateButton);
		panel_manager.add(deleteButton);
		
		panel_addType = new JPanel();
		panel_addType.setBackground(new Color(173, 216, 230));
		panel_card.add(panel_addType, "panel_addType");
		
		JLabel lblNewLabel_5 = new JLabel("\uB2F5\uC548\uC720\uD615\uC774\uB984:");
		
		textField_addName = new JTextField();
		textField_addName.setColumns(10);
		
		JLabel label = new JLabel("\uB2F5\uC548\uC720\uD615\uAD6C\uBD84:");
		
		JComboBox comboBox_addType = new JComboBox();
		comboBox_addType.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uAD00\uC2DD", "\uC8FC\uAD00\uC2DD"}));
		
		JLabel label_1 = new JLabel(" \uCD94 \uAC00 \uC815 \uBCF4:");
		
		textField_addInfo = new JTextField();
		textField_addInfo.setColumns(10);
		
		JButton button_add = new JButton("\uCD94 \uAC00");
		GroupLayout gl_panel_addType = new GroupLayout(panel_addType);
		gl_panel_addType.setHorizontalGroup(
			gl_panel_addType.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_addType.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
						.addComponent(button_add)
						.addGroup(gl_panel_addType.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_addType.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_addName, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
								.addGroup(gl_panel_addType.createSequentialGroup()
									.addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_addInfo)
										.addComponent(comboBox_addType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addContainerGap(317, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_addType.setVerticalGroup(
			gl_panel_addType.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_addType.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_addName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(comboBox_addType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_addInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(button_add)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		panel_addType.setLayout(gl_panel_addType);
		
		JButton button_manager = new JButton("\uB2F5\uC548\uC720\uD615\uAD00\uB9AC");
		button_manager.setBounds(30, 10, 134, 23);
		button_manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_card, "panel_manager");
			}
		});
		
		JButton button_addType = new JButton("\uB2F5\uC548\uC720\uD615\uCD94\uAC00");
		button_addType.setBounds(168, 10, 126, 23);
		button_addType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_addType");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel_card);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		panel_menu.add(button_manager);
		panel_menu.add(button_addType);
	}
}
