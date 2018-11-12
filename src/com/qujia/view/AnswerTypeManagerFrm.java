package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.AnswerDao;
import com.qujia.model.Answer;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AnswerTypeManagerFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_serchName;
	private JTable table;
	private JPanel panel_manager,panel_addType,panel_card;
	private CardLayout card;
	private JComboBox comboBox_ansType;
	private Integer[] infoArray;
	private JComboBox comboBox_info;
	private JLabel label_type ;
	private JComboBox comboBox_anstype ;
	private JComboBox comboBox_searchType;
	private String[] ansNameArray;
	private static int row=-1;
	private JComboBox comboBox_upType,comboBox_upName,comboBox_upInfo;
	private DefaultTableModel dft;
	private String[] typeArray;
	private JLabel label_upInfo;
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
	          this.setResizable(false);
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
		panel_manager.setBackground(new Color(240, 255, 240));
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
		
		comboBox_searchType = new JComboBox();
		comboBox_searchType.setBounds(391, 17, 109, 21);
		comboBox_searchType.setModel(new DefaultComboBoxModel(new String[] {"", "주관식", "객관식"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchAnswer(e);
		          }
		});
		searchButton.setBounds(526, 16, 95, 23);
		
		JLabel lblNewLabel_2 = new JLabel("\uB2F5\uC548\uC720\uD615\uBA85:");
		lblNewLabel_2.setBounds(12, 245, 95, 15);
		
		JLabel lblNewLabel_3 = new JLabel("\uC720\uD615\uAD6C\uBD84:");
		lblNewLabel_3.setBounds(348, 245, 76, 15);
		
		comboBox_upType = new JComboBox();
		comboBox_upType.addItemListener(new ItemListener() {
		          public void itemStateChanged(ItemEvent e) {
		                    String selectType = e.getItem().toString();
                            if("객관식".equals(selectType)){
                                      infoArray=new Integer[] {2, 3, 4, 5};
                                      label_upInfo.setText("답안유형코드:");
                            }else{
                                      infoArray=new Integer[] {500,1000,2000};
                                      label_upInfo.setText("답안  글자수:"); 
                            }
                            comboBox_upInfo.setModel(new DefaultComboBoxModel(infoArray));
		          }
		});
		comboBox_upType.setBounds(424, 242, 139, 21);
		typeArray=new String[] {"객관식", "주관식"};
		comboBox_upType.setModel(new DefaultComboBoxModel(typeArray));
		
		label_upInfo = new JLabel("\uCD94\uAC00\uC815\uBCF4:");
		label_upInfo.setBounds(12, 277, 87, 15);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateAnsAction(e);
		          }
		});
		updateButton.setBounds(348, 273, 76, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    deleteAnsAction(e);
		          }
		});
		deleteButton.setBounds(488, 273, 75, 23);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		          @Override
		          public void mouseClicked(MouseEvent e) {
		                    selectRowAction(e);
		          }
		});
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
		panel_manager.add(label_upInfo);
		panel_manager.add(lblNewLabel_3);
		panel_manager.add(comboBox_upType);
		panel_manager.add(updateButton);
		panel_manager.add(deleteButton);
		
		JButton button = new JButton("닫기");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button.setBounds(620, 273, 76, 23);
		panel_manager.add(button);
		
		comboBox_upName = new JComboBox();
		ansNameArray=new String[] {"", "예/아니오", "좋다/싫다", "좋다/중간/싫다", "좋다/보통/나쁘다", 
		                    "만족/보통/불만족", "아주좋다/상타/평타/하타", "씹상타/상타/평타/하타/씹하타", "자소서연습이나해라", "대강써라"};
		comboBox_upName.setModel(new DefaultComboBoxModel(ansNameArray));
		comboBox_upName.setBounds(112, 242, 200, 21);
		panel_manager.add(comboBox_upName);
		
		comboBox_upInfo = new JComboBox();
		infoArray=new Integer[] {2, 3, 4, 5};
		comboBox_upInfo.setModel(new DefaultComboBoxModel(infoArray));
		comboBox_upInfo.setBounds(112, 274, 200, 21);
		panel_manager.add(comboBox_upInfo);
		
		panel_addType = new JPanel();
		panel_addType.setBackground(new Color(248, 248, 255));
		panel_card.add(panel_addType, "panel_addType");
		
		JLabel lblNewLabel_5 = new JLabel("\uB2F5\uC548\uC720\uD615\uC774\uB984:");
		
		JLabel label = new JLabel("\uB2F5\uC548\uC720\uD615\uAD6C\uBD84:");
		
		comboBox_ansType = new JComboBox();
		comboBox_ansType.addItemListener(new ItemListener() {
		          public void itemStateChanged(ItemEvent e) {
		                    String selectType = e.getItem().toString();
		                    if("객관식".equals(selectType)){
		                              infoArray=new Integer[] {2, 3, 4, 5};
		                              label_type.setText("답안유형코드:");
		                    }else{
		                              infoArray=new Integer[] {500,1000,2000};
		                              label_type.setText("답안  글자수:"); 
		                    }
		                    comboBox_info.setModel(new DefaultComboBoxModel(infoArray));
		          }
		});
		comboBox_ansType.setModel(new DefaultComboBoxModel(new String[] {"객관식", "주관식"}));
		
		label_type = new JLabel("답안유형코드:");
		
		JButton button_add = new JButton("\uCD94 \uAC00");
		button_add.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    AddAnswerAction(e);
		          }
		});
		
		JButton button_1 = new JButton("취 소");
		button_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    card.show(panel_card, "panel_manager");
		          }
		});
		
		comboBox_info = new JComboBox();
		infoArray=new Integer[] {2, 3, 4, 5};
		comboBox_info.setModel(new DefaultComboBoxModel(infoArray));
		
		comboBox_anstype = new JComboBox();
		comboBox_anstype.setEditable(true);
		comboBox_anstype.setModel(new DefaultComboBoxModel(new String[] {"", "예/아니오", "좋다/싫다", "좋다/중간/싫다", "그렇다/보통/그렇지 않다", "좋다/보통/나쁘다", "만족/보통/불만족", "아주좋다/상타/평타/하타", "씹상타/상타/평타/하타/씹하타", "자소서연습이나해라", "대강써라"}));
		GroupLayout gl_panel_addType = new GroupLayout(panel_addType);
		gl_panel_addType.setHorizontalGroup(
		          gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                    .addGroup(gl_panel_addType.createSequentialGroup()
		                              .addGap(64)
		                              .addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                                        .addGroup(gl_panel_addType.createSequentialGroup()
		                                                  .addGap(101)
		                                                  .addComponent(button_add, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
		                                                  .addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
		                                                  .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
		                                        .addGroup(gl_panel_addType.createSequentialGroup()
		                                                  .addPreferredGap(ComponentPlacement.RELATED)
		                                                  .addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                                                            .addGroup(gl_panel_addType.createSequentialGroup()
		                                                                      .addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                                                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
		                                                                                .addComponent(label_type, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
		                                                                      .addGap(18)
		                                                                      .addGroup(gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                                                                                .addComponent(comboBox_info, 0, 218, Short.MAX_VALUE)
		                                                                                .addComponent(comboBox_ansType, 0, 218, Short.MAX_VALUE)))
		                                                            .addGroup(gl_panel_addType.createSequentialGroup()
		                                                                      .addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
		                                                                      .addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
		                                                                      .addComponent(comboBox_anstype, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
		                                                                      .addPreferredGap(ComponentPlacement.RELATED)))))
		                              .addContainerGap(246, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_addType.setVerticalGroup(
		          gl_panel_addType.createParallelGroup(Alignment.LEADING)
		                    .addGroup(gl_panel_addType.createSequentialGroup()
		                              .addGap(31)
		                              .addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(lblNewLabel_5)
		                                        .addComponent(comboBox_anstype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                              .addGap(24)
		                              .addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(label)
		                                        .addComponent(comboBox_ansType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                              .addGap(28)
		                              .addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(label_type)
		                                        .addComponent(comboBox_info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                              .addGap(51)
		                              .addGroup(gl_panel_addType.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(button_add)
		                                        .addComponent(button_1))
		                              .addContainerGap(113, Short.MAX_VALUE))
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
		dft= (DefaultTableModel) table.getModel();
		setTable(new Answer());
	}

          protected void deleteAnsAction(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    AnswerDao anDao =new AnswerDao();
                    String id = table.getValueAt(row, 0).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(anDao.deleteAns(id)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }  
                    }
                    anDao.closeDao();
                    setTable(new Answer());
          }

          protected void updateAnsAction(ActionEvent e) {
                    String id = dft.getValueAt(row, 0).toString();
                    String upName = comboBox_upName.getSelectedItem().toString();
                    String upType = comboBox_upType.getSelectedItem().toString();
                    Integer upInfo =Integer.parseInt(comboBox_upInfo.getSelectedItem().toString());
                    if(StringUtil.isEmpty(upName)){
                              JOptionPane.showMessageDialog(this, "답안유형명을 선택해주세요!");
                              return;
                    }
                    Answer ans=new Answer();
                    ans.setAnsName(upName);
                    ans.setAnsType(upType);
                    ans.setInfo(upInfo);
                    ans.setId(id);
                    AnswerDao anDao=new AnswerDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(anDao.updateAns(ans)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }else{
                              return;
                    }
                    anDao.closeDao();
                    setTable(new Answer());
                    
          }

          protected void selectRowAction(MouseEvent e) {
                    row=table.getSelectedRow();
                    String id = dft.getValueAt(row, 0).toString();
                    String name = dft.getValueAt(row, 1).toString();
                    String type = dft.getValueAt(row, 2).toString();
                    int info = Integer.parseInt(dft.getValueAt(row, 3).toString());
                    //name
                    for(int i=0;i<comboBox_upName.getItemCount();i++){
                              if(name.equals(ansNameArray[i])){
                                        comboBox_upName.setSelectedIndex(i);
                              } 
                    }
                    //type
                    if("객관식".equals(type)){
                              label_upInfo.setText("답안유형코드:");
                              infoArray=new Integer[] {2, 3, 4, 5};
                              comboBox_upInfo.setModel(new DefaultComboBoxModel(infoArray));
                    }else{
                              label_upInfo.setText("답안  글자수:");
                              infoArray=new Integer[] {500,1000,2000};
                              comboBox_upInfo.setModel(new DefaultComboBoxModel(infoArray));
                    }
                    for(int i=0;i<comboBox_upType.getItemCount();i++){
                              if(type.equals(typeArray[i])){
                                        comboBox_upType.setSelectedIndex(i);
                              } 
                    }
                    //info
                    for(int i=0;i<comboBox_upInfo.getItemCount();i++){
                              if(info==infoArray[i]){
                                        comboBox_upInfo.setSelectedIndex(i);
                              } 
                    }
          }

          protected void searchAnswer(ActionEvent e) {
                    String serName = textField_serchName.getText().toString();
                    String serType = comboBox_searchType.getSelectedItem().toString();
                    Answer ans=new Answer();
                    ans.setAnsName(serName);
                    ans.setAnsType(serType);
                    setTable(ans);
          }

          private void setTable(Answer ans) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    AnswerDao anDao=new AnswerDao();
                    List<Answer> ansList = anDao.getAnsList(ans);
                    for(Answer a : ansList){
                              Vector v=new Vector();
                              v.add(a.getId());
                              v.add(a.getAnsName());
                              v.add(a.getAnsType());
                              v.add(a.getInfo());
                              dft.addRow(v);
                    }
                    anDao.closeDao();  
          }

          protected void AddAnswerAction(ActionEvent e) {
                    String ansName= comboBox_anstype.getSelectedItem().toString();
                    String ansType = comboBox_ansType.getSelectedItem().toString();
                    Integer info = Integer.parseInt(comboBox_info.getSelectedItem().toString());
                    if(StringUtil.isEmpty(ansName)){
                              JOptionPane.showMessageDialog(this, "답안이름을 선택해주세요!");
                              return;
                    }
                    Answer ans=new Answer();
                    ans.setAnsName(ansName);
                    ans.setAnsType(ansType);
                    ans.setInfo(info);
                    AnswerDao anDao=new AnswerDao();
                    if(anDao.AddAnswer(ans)){
                              JOptionPane.showMessageDialog(this, "답안유형을 추가했습니다!");
                              setTable(new Answer());
                    }else{
                              JOptionPane.showMessageDialog(this, "답안유형 추가 실패되었습니다!");
                    }
                    anDao.closeDao();
          }
}
