package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class ProManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_3;
          private JTextField textField_5;
          private JTextField textField_6;
          private JTextField textField_7;
          private JTextField textField_2;
          private JTextField textField_1;
          private JTextField textField_4;
          private JTextField textField_8;
          private JTable table;
          private JScrollPane scrollPane;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ProManagerFrm frame = new ProManagerFrm();
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
          public ProManagerFrm() {
                    setTitle("\uAD50\uC9C1\uC6D0\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 874, 694);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uAD50\uC6D0\uC774\uB984:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    
                    JLabel lblNewLabel = new JLabel("\uAD50\uC9C1\uC6D0\uAD6C\uBD84:");
                    
                    JComboBox comboBox = new JComboBox();
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uC784\uAD50\uC218", "\uACB8\uC784\uAD50\uC218", "\uC2DC\uAC04\uAC15\uC0AC"}));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC6D0\uAD6C\uBD84:");
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uC815\uAD50\uC218", "\uBD80\uAD50\uC218", "\uC870\uAD50\uC218", "\uC804\uC784\uAC15\uC0AC"}));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC124\uBCC4:");
                    
                    JLabel lblNewLabel_4 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638:");
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uC8FC\uC18C:");
                    
                    textField_5 = new JTextField();
                    textField_5.setColumns(10);
                    
                    JLabel lblNewLabel_7 = new JLabel("\uC804\uD654\uBC88\uD638:");
                    
                    textField_6 = new JTextField();
                    textField_6.setColumns(10);
                    
                    JLabel lblNewLabel_8 = new JLabel("\uC774\uBA54\uC77C:");
                    
                    textField_7 = new JTextField();
                    textField_7.setColumns(10);
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\uB0A8", "\uC5EC"}));
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JComboBox comboBox_3 = new JComboBox();
                    
                    JLabel lblNewLabel_10 = new JLabel("\uAD50\uC218\uC774\uB984:");
                    
                    textField_4 = new JTextField();
                    textField_4.setColumns(10);
                    
                    JLabel lblNewLabel_11 = new JLabel("\uAD50\uC218\uBC88\uD638:");
                    
                    textField_8 = new JTextField();
                    textField_8.setColumns(10);
                    
                    scrollPane = new JScrollPane();
                    
                    JButton btnNewButton = new JButton("\uCEF4  \uC0C9");
                    
                    JButton btnNewButton_1 = new JButton("\uC218  \uC815");
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    
                    JButton btnNewButton_2 = new JButton("\uC0AD  \uC81C");
                    btnNewButton_2.setBackground(new Color(255, 182, 193));
                    
                    JRadioButton rdbtnNewRadioButton = new JRadioButton("");
                    
                    JRadioButton radioButton = new JRadioButton("");
                    
                    JLabel lblNewLabel_9 = new JLabel("직원구분:");
                    
                    JComboBox comboBox_4 = new JComboBox();
                    
                    JLabel lblNewLabel_12 = new JLabel("직속상사:");
                    
                    JComboBox comboBox_5 = new JComboBox();
                    
                    JComboBox comboBox_6 = new JComboBox();
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addContainerGap()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addComponent(lblNewLabel)
                    						.addComponent(label)
                    						.addComponent(lblNewLabel_5)
                    						.addComponent(lblNewLabel_3)
                    						.addComponent(lblNewLabel_7)
                    						.addComponent(lblNewLabel_9))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addComponent(comboBox_4, 0, 209, Short.MAX_VALUE)
                    						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    						.addComponent(comboBox, 0, 209, Short.MAX_VALUE)
                    						.addComponent(comboBox_2, Alignment.TRAILING, 0, 209, Short.MAX_VALUE)
                    						.addComponent(comboBox_3, Alignment.TRAILING, 0, 209, Short.MAX_VALUE)
                    						.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGap(74)
                    							.addComponent(lblNewLabel_12))
                    						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    							.addGap(49)
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(lblNewLabel_4)
                    								.addComponent(lblNewLabel_6)
                    								.addComponent(lblNewLabel_2)
                    								.addComponent(lblNewLabel_1)
                    								.addComponent(lblNewLabel_8))
                    							.addGap(27)))
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                    							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    							.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                    						.addComponent(textField_5)
                    						.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                    						.addComponent(textField_7)
                    						.addComponent(textField_1))
                    					.addGap(46)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addComponent(btnNewButton_1)
                    						.addComponent(btnNewButton_2))
                    					.addGap(29))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGap(9)
                    							.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    							.addPreferredGap(ComponentPlacement.RELATED)
                    							.addComponent(lblNewLabel_10)
                    							.addPreferredGap(ComponentPlacement.RELATED)
                    							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                    							.addGap(24)
                    							.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    							.addPreferredGap(ComponentPlacement.RELATED)
                    							.addComponent(lblNewLabel_11)
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                    							.addGap(41)
                    							.addComponent(btnNewButton))
                    						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE))
                    					.addContainerGap())))
                    );
                    gl_contentPane.setVerticalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addContainerGap()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    				.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    				.addComponent(radioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(lblNewLabel_10)
                    					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    					.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(lblNewLabel_11)))
                    			.addGap(28)
                    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                    			.addGap(30)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(label)
                    				.addComponent(lblNewLabel_1)
                    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel)
                    				.addComponent(lblNewLabel_2)
                    				.addComponent(btnNewButton_1))
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(lblNewLabel_3)
                    						.addComponent(lblNewLabel_4)
                    						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    							.addComponent(lblNewLabel_6))
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    							.addComponent(lblNewLabel_5)
                    							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(lblNewLabel_7)
                    						.addComponent(lblNewLabel_8)))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGap(34)
                    					.addComponent(btnNewButton_2)))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(lblNewLabel_9)
                    					.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(lblNewLabel_12)
                    					.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    			.addGap(20))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                    	new Object[][] {
                    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                    	},
                    	new String[] {
                    		"\uAD50\uC6D0\uBC88\uD638", "\uC774\uB984", "\uC601\uC5B4\uC774\uB984", "\uAD50\uC9C1\uC6D0\uAD6C\uBD84", "\uAD50\uC6D0\uAD6C\uBD84", "\uC804\uC784\uAD50\uC218\uAD6C\uBD84", "\uC131\uBCC4", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC18D\uC18D\uD559\uACFC", "\uC8FC\uC18C", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C", "\uB4F1\uB85D\uC77C\uC9DC", "\uBE44\uBC00\uBC88\uD638", "\uC9C1\uC18D\uC0AC\uC0C1"
                    	}
                    ) {
                    	boolean[] columnEditables = new boolean[] {
                    		false, false, false, false, false, true, false, false, false, false, false, false, false, false, true
                    	};
                    	public boolean isCellEditable(int row, int column) {
                    		return columnEditables[column];
                    	}
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    table.getColumnModel().getColumn(2).setPreferredWidth(88);
                    table.getColumnModel().getColumn(3).setPreferredWidth(84);
                    table.getColumnModel().getColumn(4).setPreferredWidth(88);
                    table.getColumnModel().getColumn(5).setPreferredWidth(83);
                    table.getColumnModel().getColumn(6).setPreferredWidth(48);
                    table.getColumnModel().getColumn(7).setPreferredWidth(89);
                    table.getColumnModel().getColumn(9).setPreferredWidth(101);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setViewportView(table);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(gl_contentPane);
                    //这两条是显示横滚动条
//                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          }
}
