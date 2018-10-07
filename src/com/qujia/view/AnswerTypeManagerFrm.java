package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		
		panel_card = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_card, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_menu, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_menu, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_card, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		card=new CardLayout(0, 0);
		panel_card.setLayout(card);
		
		panel_manager = new JPanel();
		panel_manager.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_manager, "panel_manager");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\uB2F5\uC548\uC720\uD615\uC774\uB984:");
		
		textField_serchName = new JTextField();
		textField_serchName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC720\uD615\uAD6C\uBD84:");
		
		JComboBox comboBox_searchType = new JComboBox();
		comboBox_searchType.setModel(new DefaultComboBoxModel(new String[] {"", "\uC8FC\uAD00\uC2DD", "\uAC1C\uAD00\uC2DD"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		
		JLabel lblNewLabel_2 = new JLabel("\uB2F5\uC548\uC720\uD615\uBA85:");
		
		textField_editName = new JTextField();
		textField_editName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC720\uD615\uAD6C\uBD84:");
		
		JComboBox comboBox_editType = new JComboBox();
		comboBox_editType.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uAD00\uC2DD", "\uC8FC\uAD00\uC2DD"}));
		
		JLabel lblNewLabel_4 = new JLabel("\uCD94\uAC00\uC815\uBCF4:");
		
		textField_editInfo = new JTextField();
		textField_editInfo.setColumns(10);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		GroupLayout gl_panel_manager = new GroupLayout(panel_manager);
		gl_panel_manager.setHorizontalGroup(
			gl_panel_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager.createSequentialGroup()
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_manager.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_serchName, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_searchType, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(searchButton))
						.addGroup(gl_panel_manager.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
						.addGroup(gl_panel_manager.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_editName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_editInfo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_manager.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_editType, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_manager.createSequentialGroup()
									.addComponent(updateButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel_manager.setVerticalGroup(
			gl_panel_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_serchName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox_searchType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_editName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBox_editType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_editInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateButton)
						.addComponent(deleteButton))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
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
		panel_manager.setLayout(gl_panel_manager);
		
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
		button_manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_card, "panel_manager");
			}
		});
		
		JButton button_addType = new JButton("\uB2F5\uC548\uC720\uD615\uCD94\uAC00");
		button_addType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_card, "panel_addType");
			}
		});
		GroupLayout gl_panel_menu = new GroupLayout(panel_menu);
		gl_panel_menu.setHorizontalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addGap(30)
					.addComponent(button_manager)
					.addGap(33)
					.addComponent(button_addType, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(413, Short.MAX_VALUE))
		);
		gl_panel_menu.setVerticalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_menu.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_manager)
						.addComponent(button_addType))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_menu.setLayout(gl_panel_menu);
		contentPane.setLayout(gl_contentPane);
	}
}
