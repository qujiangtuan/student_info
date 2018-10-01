package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class QuestionAnswerShowFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchQue;
	private JTable table;
	private JPanel panel_manager,panel_add;
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
		panel_add.setBorder(BorderFactory.createTitledBorder("평가문답항목 추가"));
		panel_manager = new JPanel();
		panel_manager.setBorder(BorderFactory.createTitledBorder("답안보기관리"));
		panel_manager.setBackground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_1 = new JLabel("\uD3C9\uAC00\uBB38\uB2F5\uBA85:");
		lblNewLabel_1.setFont(new Font("휴먼명조", Font.BOLD, 15));
		
		JLabel label_1 = new JLabel("\uC804\uACF5\uACFC\uBAA9\uC6A9 \uD3C9\uAC00\uBB38\uB2F5");
		label_1.setFont(new Font("휴먼명조", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_add, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(lblNewLabel_1)
							.addGap(49)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_manager, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(panel_add, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_manager, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		textField_searchQue = new JTextField();
		textField_searchQue.setColumns(10);
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		JComboBox comboBox_editQue = new JComboBox();
		
		JLabel label_3 = new JLabel("  \uB2F5\uC548\uC720\uD615\uBA85:");
		
		JComboBox comboBox_editAns = new JComboBox();
		
		JButton updateButton = new JButton("\uC218 \uC815");
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		GroupLayout gl_panel_manager = new GroupLayout(panel_manager);
		gl_panel_manager.setHorizontalGroup(
			gl_panel_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_searchQue, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
					.addComponent(searchButton)
					.addGap(68))
				.addGroup(gl_panel_manager.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_manager.createSequentialGroup()
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_editQue, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_editAns, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_panel_manager.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(updateButton))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_manager.setVerticalGroup(
			gl_panel_manager.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_manager.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_searchQue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_editQue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateButton)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_manager.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_editAns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton)
						.addComponent(label_3))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
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
		panel_manager.setLayout(gl_panel_manager);
		
		JLabel lblNewLabel = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		
		JComboBox comboBox_addQue = new JComboBox();
		
		JLabel label = new JLabel("\uB2F5\uC548\uC720\uD615\uBA85:");
		
		JComboBox comboBox_addAns = new JComboBox();
		
		JButton btnNewButton = new JButton("\uCD94 \uAC00");
		btnNewButton.setBackground(new Color(176, 224, 230));
		GroupLayout gl_panel_add = new GroupLayout(panel_add);
		gl_panel_add.setHorizontalGroup(
			gl_panel_add.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_add.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(gl_panel_add.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_add.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_addAns, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_addQue, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(11))
		);
		gl_panel_add.setVerticalGroup(
			gl_panel_add.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_add.createSequentialGroup()
					.addGroup(gl_panel_add.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox_addQue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_add.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_addAns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(28))
				.addGroup(gl_panel_add.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(27))
		);
		panel_add.setLayout(gl_panel_add);
		contentPane.setLayout(gl_contentPane);
	}

}
