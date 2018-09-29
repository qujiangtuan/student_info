package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

import oracle.net.aso.p;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddProFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_ename;
          private JTextField textField_address;
          private JTextField textField_email;
          private JTextField textField_cardid_1;
          private JTextField textField_cardid_2;
          private JTextField textField_tel;
          private  JRadioButton teacherRadioButton,empRadioButton;
          private  JRadioButton radioButton1,radioButton2,radioButton3;
          private  JRadioButton radioButton_male,radioButton_female;
          private ButtonGroup bgroup1,bgroup2,bgroup3;
          private JPanel panel,panel_1,panel_2;
          private CardLayout card;
          private JComboBox comboBox_teacher,comboBox_emptype,comboBox_org;
          private JLabel lblNewLabel_2;
          private JComboBox comboBox_superior1;
          private JLabel label_7;
          private JComboBox comboBox_superior2;
          private DatePicker datePicker;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddProFrm frame = new AddProFrm();
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
          public AddProFrm() {
                    setTitle("\uAD50\uC9C1\uC6D0\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 581, 440);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAD50\uC6D0\uC774\uB984:");
                    
                    textField_name = new JTextField();
                    textField_name.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("    \uC601\uC5B4\uC774\uB984:");
                    
                    textField_ename = new JTextField();
                    textField_ename.setColumns(10);
                    
                    JLabel label = new JLabel("       \uC131 \uBCC4:");
                    
                    JLabel label_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638:");
                    
                    JLabel label_2 = new JLabel("    \uC18C\uC18D\uC870\uC9C1:");
                    
                    JLabel label_3 = new JLabel("        \uC8FC\uC18C:");
                    
                    JLabel label_4 = new JLabel("      \uC774\uBA54\uC77C:");
                    
                    textField_address = new JTextField();
                    textField_address.setColumns(10);
                    
                    textField_email = new JTextField();
                    textField_email.setColumns(10);
                    
                    radioButton_male = new JRadioButton("\uB0A8");
                    radioButton_male.setSelected(true);
                    radioButton_female = new JRadioButton("\uC5EC");
                    bgroup3=new ButtonGroup();
                    bgroup3.add(radioButton_male);
                    bgroup3.add(radioButton_female);
                    comboBox_org = new JComboBox();
                    
                    textField_cardid_1 = new JTextField();
                    textField_cardid_1.addKeyListener(new KeyAdapter() {
                    	@Override
                    	public void keyTyped(KeyEvent ke) {
                    		int keyChar = ke.getKeyChar();
                            if (keyChar >= KeyEvent.VK_0
                                                && keyChar <= KeyEvent.VK_9
                                                || keyChar == KeyEvent.VK_BACK_SPACE
                                                || keyChar == KeyEvent.VK_DELETE) {

                            } else {
                                      ke.consume();
                                      JOptionPane.showMessageDialog(
                                                          null,
                                                          "숫자 입력해주세요!");
                                      return;
                            }
                            int len = textField_cardid_1.getText()
                                                .length();
                            if (len > 5) {
                                      ke.consume();
                                      // JOptionPane.showMessageDialog(null,
                                      // "6짜리 초과하면 안 됩니다!");
                                      KeyboardFocusManager.getCurrentKeyboardFocusManager()
                                                          .focusNextComponent();
                                      return;
                            }
                    	}
                    });
                    textField_cardid_1.setColumns(10);
                    
                    textField_cardid_2 = new JTextField();
                    textField_cardid_2.addKeyListener(new KeyAdapter() {
                    	@Override
                    	public void keyTyped(KeyEvent ke) {
                    		 int keyChar = ke.getKeyChar();
                             if (keyChar >= KeyEvent.VK_0
                                                 && keyChar <= KeyEvent.VK_9
                                                 || keyChar == KeyEvent.VK_BACK_SPACE
                                                 || keyChar == KeyEvent.VK_DELETE) {

                             } else {
                                       ke.consume();
                                       JOptionPane.showMessageDialog(
                                                           null,
                                                           "숫자 입력해주세요!");
                                       ke.consume();
                                       return;
                             }
                             int len = textField_cardid_2.getText()
                                                 .length();
                             if (len > 6) {
                                       ke.consume();
                                       JOptionPane.showMessageDialog(
                                                           null,
                                                           "7짜리 초과하면 안 됩니다!");
                                       ke.consume();
                                       return;
                             }
                    	}
                    });
                    textField_cardid_2.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uB4F1 \uB85D");
                    btnNewButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		addProSubmit(ae);
                    	}
                    });
                    btnNewButton.setBackground(new Color(224, 255, 255));
                    
                    JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
                    btnNewButton_1.setBackground(new Color(255, 182, 193));
                    
                    JLabel staff_typeLabel = new JLabel("\uAD50\uC9C1\uC6D0\uAD6C\uBD84:");
                   
                    teacherRadioButton = new JRadioButton("\uAD50\uC6D0");
                    teacherRadioButton.setSelected(true);
                    teacherRadioButton.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                    		card.show(panel, "panel_1");
                    		comboBox_emptype.setSelectedIndex(0);
                    		comboBox_superior2.setSelectedIndex(0);
                    		
                    	}
                    });
                    
                    empRadioButton = new JRadioButton("\uC9C1\uC6D0");
                    empRadioButton.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent e) {
                    		card.show(panel, "panel_2");
                    		bgroup2.clearSelection();
                    		radioButton1.setSelected(true);
                    		comboBox_superior1.setSelectedIndex(0);
                    	}
                    });
                    bgroup1=new ButtonGroup();
                    bgroup1.add(teacherRadioButton);
                    bgroup1.add(empRadioButton);
                    panel = new JPanel();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638:");
                    
                    textField_tel = new JTextField();
                    textField_tel.setColumns(10);
                    
                    JLabel lblNewLabel_4 = new JLabel("    등록일자:");
                    
                    datePicker = new DatePicker();
                    
                    JLabel label_6 = new JLabel("-");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGap(46)
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(staff_typeLabel)
                    								.addComponent(lblNewLabel))
                    							.addGap(18)
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    								.addGroup(gl_contentPane.createSequentialGroup()
                    									.addComponent(teacherRadioButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    									.addPreferredGap(ComponentPlacement.RELATED)
                    									.addComponent(empRadioButton, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                    								.addComponent(textField_name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    							.addGap(16))
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addContainerGap()
                    							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                    							.addGap(18)))
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    							.addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                    								.addComponent(label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    								.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    								.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                    						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addContainerGap()
                    							.addComponent(btnNewButton))
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGap(55)
                    							.addComponent(lblNewLabel_3)
                    							.addGap(18)
                    							.addComponent(textField_tel, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                    					.addGap(18)
                    					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    					.addComponent(textField_ename, 138, 138, Short.MAX_VALUE)
                    					.addGroup(gl_contentPane.createSequentialGroup()
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    							.addComponent(textField_cardid_1, 0, 0, Short.MAX_VALUE)
                    							.addComponent(radioButton_male, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    							.addGroup(gl_contentPane.createSequentialGroup()
                    								.addGap(17)
                    								.addComponent(radioButton_female, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    								.addGap(7))
                    							.addGroup(gl_contentPane.createSequentialGroup()
                    								.addGap(8)
                    								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                    								.addPreferredGap(ComponentPlacement.RELATED)
                    								.addComponent(textField_cardid_2, 0, 0, Short.MAX_VALUE))))
                    					.addComponent(comboBox_org, 0, 130, Short.MAX_VALUE)
                    					.addComponent(textField_address, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    					.addComponent(textField_email, Alignment.TRAILING)
                    					.addComponent(datePicker, 0, 0, Short.MAX_VALUE))
                    				.addComponent(btnNewButton_1))
                    			.addGap(176))
                    );
                    gl_contentPane.setVerticalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGap(37)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel_1)
                    				.addComponent(textField_ename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel))
                    			.addGap(22)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(label)
                    				.addComponent(radioButton_male)
                    				.addComponent(radioButton_female)
                    				.addComponent(staff_typeLabel)
                    				.addComponent(teacherRadioButton)
                    				.addComponent(empRadioButton))
                    			.addPreferredGap(ComponentPlacement.UNRELATED)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(label_1)
                    						.addComponent(textField_cardid_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(textField_cardid_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                    					.addGap(8)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(label_2)
                    						.addComponent(comboBox_org, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(label_3)
                    						.addComponent(textField_address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(label_4)
                    						.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    								.addComponent(lblNewLabel_3)
                    								.addComponent(textField_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    							.addGap(18)))
                    					.addGap(12)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(btnNewButton)
                    						.addComponent(btnNewButton_1))
                    					.addGap(419))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addComponent(lblNewLabel_4)
                    					.addContainerGap())))
                    );
                    
                    card=new CardLayout(0,0);
                    panel.setLayout(card);
                    
                    panel_1 = new JPanel();
                    panel_1.setBackground(new Color(224, 255, 255));
                    panel.add(panel_1, "panel_1");
                    
                    JLabel label_5 = new JLabel("\uAD50\uC6D0\uAD6C\uBD84:");
                    
                    
                    
                    comboBox_teacher = new JComboBox();
                    comboBox_teacher.setEnabled(true);
                    comboBox_teacher.setModel(new DefaultComboBoxModel(new String[] {"", "\uC815\uAD50\uC218", "\uBD80\uAD50\uC218", "\uC870\uAD50\uC218", "\uC804\uC784\uAC15\uC0AC"}));
                    radioButton1 = new JRadioButton("\uC804\uC784\uAD50\uC218");
                    radioButton1.setSelected(true);
                    radioButton1.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent e) {
                    		if(comboBox_teacher.isEditable()) {
                    			
                    		}else {
                				comboBox_teacher.setEnabled(true);

                    		}
                    	}
                    });
                    radioButton2 = new JRadioButton("\uACB8\uC784\uAD50\uC218");
                    radioButton2.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent e) {
                    		comboBox_teacher.setEnabled(false);
                    		comboBox_teacher.setSelectedIndex(0);
                    	}
                    });
                    
                    radioButton3 = new JRadioButton("\uC2DC\uAC04\uAC15\uC0AC");
                    radioButton3.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent e) {
                    		comboBox_teacher.setEnabled(false);
                    		comboBox_teacher.setSelectedIndex(0);
                    	}
                    });
                    bgroup2=new ButtonGroup();
                    bgroup2.add(radioButton1);
                    bgroup2.add(radioButton2);
                    bgroup2.add(radioButton3);
                    
                    lblNewLabel_2 = new JLabel("\uC9C1\uC18D\uC0C1\uC0AC:");
                    
                    comboBox_superior1 = new JComboBox();
                    comboBox_superior1.setModel(new DefaultComboBoxModel(new String[] {""}));
                    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                    gl_panel_1.setHorizontalGroup(
                    	gl_panel_1.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_panel_1.createSequentialGroup()
                    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    				.addComponent(label_5)
                    				.addComponent(lblNewLabel_2))
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_panel_1.createSequentialGroup()
                    					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    						.addComponent(radioButton3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    						.addComponent(radioButton2, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    						.addComponent(radioButton1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(comboBox_teacher, 0, 83, Short.MAX_VALUE)
                    					.addGap(14))
                    				.addGroup(gl_panel_1.createSequentialGroup()
                    					.addComponent(comboBox_superior1, 0, 83, Short.MAX_VALUE)
                    					.addContainerGap())))
                    );
                    gl_panel_1.setVerticalGroup(
                    	gl_panel_1.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_panel_1.createSequentialGroup()
                    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_panel_1.createSequentialGroup()
                    					.addGap(14)
                    					.addComponent(label_5))
                    				.addGroup(gl_panel_1.createSequentialGroup()
                    					.addGap(11)
                    					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(radioButton1)
                    						.addComponent(comboBox_teacher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addComponent(radioButton2)
                    			.addPreferredGap(ComponentPlacement.UNRELATED)
                    			.addComponent(radioButton3)
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    				.addComponent(lblNewLabel_2)
                    				.addComponent(comboBox_superior1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    			.addContainerGap(9, Short.MAX_VALUE))
                    );
                    panel_1.setLayout(gl_panel_1);
                    
                    panel_2 = new JPanel();
                    panel_2.setBackground(new Color(245, 245, 220));
                    panel.add(panel_2, "panel_2");
                    
                    comboBox_emptype = new JComboBox();
                    comboBox_emptype.setModel(new DefaultComboBoxModel(new String[] {"", "\uBD80\uC7A5", "\uCC28\uC7A5", "\uB300\uB9AC", "\uC0AC\uC6D0"}));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC9C1\uC6D0\uAD6C\uBD84:");
                    
                    label_7 = new JLabel("\uC9C1\uC18D\uC0C1\uC0AC:");
                    
                    comboBox_superior2 = new JComboBox();
                    comboBox_superior2.setModel(new DefaultComboBoxModel(new String[] {""}));
                    GroupLayout gl_panel_2 = new GroupLayout(panel_2);
                    gl_panel_2.setHorizontalGroup(
                    	gl_panel_2.createParallelGroup(Alignment.TRAILING)
                    		.addGroup(gl_panel_2.createSequentialGroup()
                    			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                    				.addComponent(lblNewLabel_5)
                    				.addComponent(label_7))
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                    				.addComponent(comboBox_superior2, 0, 166, Short.MAX_VALUE)
                    				.addComponent(comboBox_emptype, 0, 166, Short.MAX_VALUE))
                    			.addContainerGap())
                    );
                    gl_panel_2.setVerticalGroup(
                    	gl_panel_2.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_panel_2.createSequentialGroup()
                    			.addGap(30)
                    			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
                    				.addComponent(lblNewLabel_5)
                    				.addGroup(gl_panel_2.createSequentialGroup()
                    					.addComponent(comboBox_emptype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addGap(18)
                    					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(comboBox_superior2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(label_7))))
                    			.addContainerGap(38, Short.MAX_VALUE))
                    );
                    panel_2.setLayout(gl_panel_2);
                    contentPane.setLayout(gl_contentPane);
                    setDeptName();
                    setSuperior();
          }
          //submit add pro action
		protected void addProSubmit(ActionEvent ae) {
			String pno,name,ename,staffType,sex,personType,teacherType=null,supid;
			String cardid1,cardid2,cardid,orgId,address,email,tel,date;
			name=textField_name.getText().toString();
			ename=textField_ename.getText().toString();
			staffType=teacherRadioButton.isSelected() ? teacherRadioButton.getText():empRadioButton.getText();
			sex=radioButton_male.isSelected() ? radioButton_male.getText() : radioButton_female.getText();
			if(teacherRadioButton.isSelected()) {
				personType=radioButton1.isSelected()? radioButton1.getText(): 
					(radioButton2.isSelected()? radioButton2.getText():radioButton3.getText());
				if(radioButton1.isSelected()) {
					teacherType=comboBox_teacher.getSelectedItem().toString();
				}else {
					teacherType=null;
				}
				try {
					ProStaff ps=(ProStaff)comboBox_superior1.getSelectedItem();
					supid=ps.getpNo();
				} catch (Exception e) {
					supid=null;
				}
				
			}else {
				personType=comboBox_emptype.getSelectedItem().toString();
				try {
					ProStaff ps=(ProStaff)comboBox_superior2.getSelectedItem();
					supid=ps.getpNo();
				} catch (Exception e) {
					supid=null;
				}
				
			}
			cardid1=textField_cardid_1.getText().toString();
			cardid2=textField_cardid_2.getText().toString();
			cardid=cardid1+"-"+cardid2;
			
			Org org=(Org) comboBox_org.getSelectedItem();
			orgId=org.getOrgCode();
			address=textField_address.getText().toString();
			email=textField_email.getText().toString();
			tel=textField_tel.getText().toString();
			date=getStringDate(datePicker);
			 pno=getStudentNumber(date,orgId);
			 if(StringUtil.isEmpty(name)) {
				 JOptionPane.showMessageDialog(this, "교직원이름을 입력해주세요!");
				 return;
			 }
			 if(StringUtil.isEmpty(cardid1)) {
				 JOptionPane.showMessageDialog(this, "주민등록번호를 입력해주세요!");
				 return;
			 }
			 if(StringUtil.isEmpty(cardid2)) {
				 JOptionPane.showMessageDialog(this, "주민등록번호를 입력해주세요!");
				 return;
			 }
			 if(StringUtil.isEmpty(address)) {
				 JOptionPane.showMessageDialog(this, "주소를 입력해주세요!");
				 return;
			 }
			 if(StringUtil.isEmpty(email)) {
				 JOptionPane.showMessageDialog(this, "이메일을 입력해주세요!");
				 return;
			 }
			 if(StringUtil.isEmpty(tel)) {
				 JOptionPane.showMessageDialog(this, "전화번호를 입력해주세요!");
				 return;
			 }
			 ProStaff ps=new ProStaff();
			 ps.setpNo(pno);
			 ps.setpName(name);
			 ps.setPeName(ename);
			 ps.setProType(staffType);
			 ps.setPerType(personType);
			 ps.setTeaType(teacherType);
			 ps.setSex(sex);
			 ps.setIdCardNo(cardid);
			 ps.setOrgId(orgId);
			 ps.setAddress(address);
			 ps.setTel(tel);
			 ps.setEmail(email);
			 ps.setLoginDate(date);
			 ps.setPassword(cardid1);
			 ps.setSupId(supid);
			 ProStaffDao psDao=new ProStaffDao();
			 if(psDao.addProStaff(ps)) {
                     JOptionPane.showMessageDialog(this,
                                         "교직원이 등록 성공! ");
           } else {
                     JOptionPane.showMessageDialog(this,
                                         "교직원이 등록 실패！");
           }
			psDao.closeDao();	
			resetValue();
			setSuperior();
		}
		//직속상사 从数据库中把数据填充选择框
        protected void setSuperior() {
        	comboBox_superior1.removeAllItems();
                  // TODO Auto-generated method stub
                 ProStaffDao psDao=new ProStaffDao();
                 ProStaff ps1=new ProStaff();
                 ps1.setProType("교원");
                 ProStaff ps2=new ProStaff();
                 ps2.setProType("직원");
                  List<ProStaff> proStaffList1 = psDao.getProStaffList(ps1);
                  List<ProStaff> proStaffList2 = psDao.getProStaffList(ps2);
                  String str=null;
                  comboBox_superior1.addItem(str);
                  for (ProStaff psa : proStaffList1) {
                	  comboBox_superior1.addItem(psa);
				}
                  for (ProStaff psb : proStaffList2) {
                	  comboBox_superior2.addItem(psb);
				}
                  psDao.closeDao();
        }
		//学科 从数据库中把数据填充选择框
        protected void setDeptName() {
                  // TODO Auto-generated method stub
                  OrgDao orgDao=new OrgDao();
                  List<Org> orgList=orgDao.getOrgList(new Org());
                  for (Org org: orgList) {
                	  comboBox_org.addItem(org);
                  }
                  orgDao.closeDao();
        }
		//등록하고 초기화
		public void resetValue() {
			textField_name.setText("");
			textField_ename.setText("");
			textField_address.setText("");
			textField_cardid_1.setText("");
			textField_cardid_2.setText("");
			textField_email.setText("");
			textField_tel.setText("");
			bgroup1.clearSelection();
			bgroup2.clearSelection();
			bgroup3.clearSelection();
			radioButton_male.setSelected(true);
			radioButton1.setSelected(true);
			teacherRadioButton.setSelected(true);
			comboBox_org.setSelectedIndex(0);
			comboBox_emptype.setSelectedIndex(0);
			comboBox_superior1.setSelectedIndex(0);
			comboBox_superior2.setSelectedIndex(0);
			comboBox_teacher.setSelectedIndex(0);
		}
			//日期格式	
		 public String getStringDate(DatePicker datepick) {
             String stringDate;
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             Date date;
             if(datepick.getValue()==null){
                       date=new Date();
             }else{
                       date = (Date) datepick.getValue();
             }
             stringDate = form.format(date);
             return stringDate;
		 }
		 // 获取教授id
         public String getStudentNumber(String str1,String string) {
                   String str = str1.substring(2, 4);
                   String str2;
                   str2=string.substring(3, 5);
                   String sNo = str + str2 + getRandom();
                   return sNo;
         }
         // 获取一个随机产生的三位数（001,001）
         public String getRandom() {
                   String threeNumber;
                   Random random = new Random();
                   int i = random.nextInt(1000);
                   String str = i + "";
                   if (i >= 0 && i <= 9) {
                             threeNumber = "00" + str;
                   } else if (i >= 10 && i <= 99) {
                             threeNumber = "0" + str;
                   } else {
                             threeNumber = str;
                   }
                   return threeNumber;
         }
}
