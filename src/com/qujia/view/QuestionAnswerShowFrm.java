package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.QueAnsDao;
import com.qujia.model.QueAns;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class QuestionAnswerShowFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchQue;
	private JTable table;
	private JPanel panel_manager,panel_add;
	private JTextField textField_addQue;
	private JTextField textField_addAns;
	private JTextField textField_upQue;
	private JTextField textField_upAns;
	private QueAnsDao qaDao;
	private static int row=-1;
	private  DefaultTableModel dft ;
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
	          this.setResizable(false);
		setTitle("\uB2F5\uC548\uBCF4\uAE30\uAD6C\uC131");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 823, 572);
		
		ViewUtil vu = new ViewUtil();
        vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_add = new JPanel();
		panel_add.setBounds(5, 22, 785, 100);
		panel_add.setBorder(BorderFactory.createTitledBorder("평가문답항목 추가"));
		panel_manager = new JPanel();
		panel_manager.setBounds(5, 132, 785, 396);
		panel_manager.setBorder(BorderFactory.createTitledBorder("답안보기관리"));
		panel_manager.setBackground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_2.setBounds(30, 28, 111, 15);
		
		textField_searchQue = new JTextField();
		textField_searchQue.setBounds(153, 25, 253, 21);
		textField_searchQue.setColumns(10);
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    String searQue = textField_searchQue.getText().toString();
		                    QueAns qa=new QueAns();
		                    qa.setQueName(searQue);
		                    setTable(qa);
		          }
		});
		searchButton.setBounds(600, 24, 83, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 71, 746, 200);
		
		JLabel label_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		label_2.setBounds(18, 285, 94, 15);
		
		JLabel label_3 = new JLabel("  \uB2F5\uC548\uC720\uD615\uBA85:");
		label_3.setBounds(18, 318, 94, 15);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateQueAnsAction(e);
		          }
		});
		updateButton.setBounds(190, 363, 83, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    deleteQueAnsAction(e);
		          }
		});
		deleteButton.setBounds(323, 363, 83, 23);
		
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
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    addQueAnsAction(e);
		          }
		});
		btnNewButton.setBounds(686, 33, 69, 44);
		btnNewButton.setBackground(new Color(176, 224, 230));
		
		textField_addQue = new JTextField();
		textField_addQue.setEditable(false);
		textField_addQue.setBounds(126, 30, 474, 21);
		textField_addQue.setColumns(10);
		contentPane.add(panel_add);
		panel_add.setLayout(null);
		panel_add.add(lblNewLabel);
		panel_add.add(label);
		panel_add.add(textField_addQue);
		panel_add.add(btnNewButton);
		
		textField_addAns = new JTextField();
		textField_addAns.setEditable(false);
		textField_addAns.setBounds(126, 58, 474, 21);
		panel_add.add(textField_addAns);
		textField_addAns.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchQuestion sdf=new searchQuestion(new JFrame());
                            sdf.setVisible(true);
                            textField_addQue.setText(addSearchQue());
		          }
		});
		btnNewButton_1.setBounds(601, 29, 61, 23);
		panel_add.add(btnNewButton_1);
		
		JButton button = new JButton("조회");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    SearchAnswer sdf=new SearchAnswer(new JFrame());
                            sdf.setVisible(true);
                            textField_addAns.setText(addSearchAns());
		          }
		});
		button.setBounds(601, 56, 61, 23);
		panel_add.add(button);
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
		
		textField_upQue = new JTextField();
		textField_upQue.setEditable(false);
		textField_upQue.setColumns(10);
		textField_upQue.setBounds(116, 284, 567, 21);
		panel_manager.add(textField_upQue);
		
		JButton button_1 = new JButton("조회");
		button_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchQuestion sdf=new searchQuestion(new JFrame());
                            sdf.setVisible(true);
                            textField_upQue.setText(addSearchQue());
		          }
		});
		button_1.setBounds(703, 281, 61, 23);
		panel_manager.add(button_1);
		
		textField_upAns = new JTextField();
		textField_upAns.setEditable(false);
		textField_upAns.setColumns(10);
		textField_upAns.setBounds(116, 312, 567, 21);
		panel_manager.add(textField_upAns);
		
		JButton button_2 = new JButton("조회");
		button_2.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    SearchAnswer sdf=new SearchAnswer(new JFrame());
                            sdf.setVisible(true);
                            textField_upAns.setText(addSearchAns());
		          }
		});
		button_2.setBounds(703, 314, 61, 23);
		panel_manager.add(button_2);
		
		JButton button_3 = new JButton("닫기");
		button_3.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button_3.setBounds(459, 363, 83, 23);
		panel_manager.add(button_3);
		dft = (DefaultTableModel) table.getModel();
	    setTable(new QueAns());
	}

          protected void deleteQueAnsAction(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    QueAnsDao qaDao =new QueAnsDao();
                    String id = table.getValueAt(row, 0).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(qaDao.deleteQueAns(id)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }  
                    }
                    qaDao.closeDao();
                    setTable(new QueAns());
                    resetValue();
          }

          protected void updateQueAnsAction(ActionEvent e) {
                    String id = dft.getValueAt(row, 0).toString();
                    String editQue = textField_upQue.getText().toString();
                    String editAns = textField_upAns.getText().toString();
                    String editQueId = this.getQueIdByName(editQue);
                    String editAnsId=this.getAnsIdByName(editAns);
                    if(StringUtil.isEmpty(editQue)){
                              JOptionPane.showMessageDialog(this, "평가질문내용을 선택해주세요!");
                              return;
                    }
                    if(StringUtil.isEmpty(editAns)){
                              JOptionPane.showMessageDialog(this, "답안유형명을 선택해주세요!");
                              return;
                    }
                    QueAns qa=new QueAns();
                    qa.setId(id);
                    qa.setQueId(editQueId);
                    qa.setQueName(editQue);
                    qa.setAnsId(editAnsId);
                    qa.setAnsName(editAns);
                    QueAnsDao qaDao=new QueAnsDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(qaDao.updateQueAns(qa)){
                                        JOptionPane.showMessageDialog(this, "답안보기를 수정했습니다!");
                                        setTable(new QueAns());
                                        resetValue();
                                        return;
                              }else{
                                        JOptionPane.showMessageDialog(this, "답안보기 수정이 실패되었습니다!");
                                        return;
                              }
                    }
                    
                    
          }

          protected void selectRowAction(MouseEvent e) {
                    row=table.getSelectedRow();
                    String id = dft.getValueAt(row,0).toString();
                    String upQue = dft.getValueAt(row, 1).toString();
                    String upAns = dft.getValueAt(row, 2).toString();
                    textField_upQue.setText(upQue);
                    textField_upAns.setText(upAns);
                    
          }

          private void setTable(QueAns queAns) {
                    dft.setRowCount(0);
                    QueAnsDao qaDao=new QueAnsDao();
                    List<QueAns> qaList = qaDao.getQueAns(queAns);
                    for(QueAns q:qaList){
                              Vector v=new Vector();
                              v.add(q.getId());
                              v.add(q.getQueName());
                              v.add(q.getAnsName());
                              dft.addRow(v);
                    }
                    qaDao.closeDao();
                    
          }

          protected void addQueAnsAction(ActionEvent e) {
                    String queName = textField_addQue.getText().toString();
                    String ansName = textField_addAns.getText().toString();
                    String queId = this.getQueIdByName(queName);
                    String ansId=this.getAnsIdByName(ansName);
                    if(StringUtil.isEmpty(queName)){
                              JOptionPane.showMessageDialog(this, "평가질문을 선택해주세요!");
                              return;
                    }
                    if(StringUtil.isEmpty(ansName)){
                              JOptionPane.showMessageDialog(this, "답안유형을 선택해주세요!");
                              return;
                    }
                    QueAns qa=new QueAns();
                    qa.setQueId(queId);                    
                    qa.setQueName(queName);
                    qa.setAnsId(ansId);
                    qa.setAnsName(ansName);
                    QueAnsDao qaDao=new QueAnsDao();
                    if(qaDao.AddQueAns(qa)){
                              JOptionPane.showMessageDialog(this, "질문답안을 추가했습니다!");
                              resetValue();
                              setTable(new QueAns());
                              return;
                    }else{
                              JOptionPane.showMessageDialog(this, "질문답안 추가는 실패했습니다!");
                              return;
                    }
          }

          private void resetValue() {
                    textField_addQue.setText("");
                    textField_addAns.setText("");
                    textField_upQue.setText("");
                    textField_upAns.setText("");
          }

          private String getAnsIdByName(String ansName) {
                    qaDao=new QueAnsDao();
                    String id=qaDao.getAnsIdByName(ansName);
                    return id;
          }

          private String getQueIdByName(String queName) {
                    qaDao=new QueAnsDao();
                     String id=qaDao.getQueIdByName(queName);
                     return id;
          }

          protected String addSearchAns() {
                    return SearchAnswer.getAnsName();
          }

          protected String addSearchQue() {
                    return searchQuestion.getQueName();
          }
}
