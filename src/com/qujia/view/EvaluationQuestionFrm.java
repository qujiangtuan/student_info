package com.qujia.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.QuestionDao;
import com.qujia.model.Question;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class EvaluationQuestionFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchQue;
	private JTable table;
	private JPanel panel_Manager,panel_add,panel_card;
	private CardLayout card;
	private JComboBox comboBox_addObj;
	private JTextArea textArea_addQue;
	private JComboBox comboBox_searchObj;
	private static int row=-1;
	private DefaultTableModel   dft;
	private JTextArea textArea_editQue;
	private JComboBox comboBox_editObj;
	private String[] objArray;

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
				setTable(new Question());
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
//		panel_Manager.setBackground(new Color(224, 255, 255));
		panel_card.add(panel_Manager, "panel_Manager");
		
		JLabel lblNewLabel = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel.setBounds(35, 31, 92, 15);
		
		textField_searchQue = new JTextField();
		textField_searchQue.setBounds(139, 28, 205, 21);
		textField_searchQue.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("평가대상：");
		lblNewLabel_1.setBounds(356, 31, 75, 15);
		
		comboBox_searchObj = new JComboBox();
		comboBox_searchObj.setBounds(436, 28, 163, 21);
		comboBox_searchObj.setModel(new DefaultComboBoxModel(new String[] {"", "개설과정", "강의교수"}));
		
		JButton searchButton = new JButton("\uAC80 \uC0C9");
		searchButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchQuestion(e);
		          }
		});
		searchButton.setBounds(611, 27, 82, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 56, 686, 170);
		
		JLabel lblNewLabel_2 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_2.setBounds(18, 247, 91, 15);
		
		JLabel lblNewLabel_3 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		lblNewLabel_3.setBounds(18, 306, 91, 15);
		
		comboBox_editObj = new JComboBox();
		comboBox_editObj.setBounds(121, 303, 160, 21);
		objArray=new String[] {"개설과정", "강의교수"};
		comboBox_editObj.setModel(new DefaultComboBoxModel(objArray));
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateQuestion(e);
		          }
		});
		updateButton.setBounds(332, 302, 80, 23);
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    deleteQuestion(e);
		          }
		});
		deleteButton.setBounds(454, 302, 80, 23);
		
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
		
		JButton button = new JButton("닫기");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button.setBounds(574, 302, 80, 23);
		panel_Manager.add(button);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(121, 247, 533, 49);
		panel_Manager.add(scrollPane_2);
		
		textArea_editQue = new JTextArea();
		scrollPane_2.setViewportView(textArea_editQue);
		
		panel_add = new JPanel();
//		panel_add.setBackground(new Color(253, 245, 230));
		panel_card.add(panel_add, "panel_add");
		
		JLabel lblNewLabel_4 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9:");
		lblNewLabel_4.setBounds(62, 52, 95, 15);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(169, 52, 323, 80);
		
		JLabel lblNewLabel_5 = new JLabel("\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1:");
		lblNewLabel_5.setBounds(62, 187, 95, 15);
		
		comboBox_addObj = new JComboBox();
		comboBox_addObj.setBounds(169, 184, 323, 21);
		comboBox_addObj.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC124\uACFC\uC815", "\uAC15\uC758\uAD50\uC218"}));
		
		JButton addButton = new JButton("추가");
		addButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    AddQuestion(e);
		          }
		});
		addButton.setBounds(217, 260, 76, 23);
		
		textArea_addQue = new JTextArea();
		textArea_addQue.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_addQue);
		panel_add.setLayout(null);
		panel_add.add(lblNewLabel_5);
		panel_add.add(lblNewLabel_4);
		panel_add.add(comboBox_addObj);
		panel_add.add(scrollPane_1);
		panel_add.add(addButton);
		
		JButton button_1 = new JButton("취소");
		button_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    card.show(panel_card, "panel_Manager");
		          }
		});
		button_1.setBounds(317, 260, 82, 23);
		panel_add.add(button_1);
		contentPane.setLayout(null);
		contentPane.add(questionManButton);
		contentPane.add(questionAddButton);
		contentPane.add(panel_card);
		 dft= (DefaultTableModel) table.getModel();
		setTable(new Question());
	}

          protected void deleteQuestion(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    QuestionDao quDao =new QuestionDao();
                    String id = table.getValueAt(row, 0).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(quDao.deleteQue(id)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }  
                    }
                    quDao.closeDao();
                    setTable(new Question());
                    resetValue();
                    
          }

          protected void updateQuestion(ActionEvent e) {
                    row=table.getSelectedRow();
                    String id = dft.getValueAt(row, 0).toString();
                    String upQue = textArea_editQue.getText().toString();
                    String upObj = comboBox_editObj.getSelectedItem().toString();
                    if(StringUtil.isEmpty(upQue)){
                              JOptionPane.showMessageDialog(this, "질문내용을 입력해주세요!");
                              return;
                    }
                    Question qu=new Question();
                    qu.setQue(upQue);
                    qu.setObj(upObj);
                    qu.setId(id);
                    QuestionDao quDao=new QuestionDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(quDao.updateQuestion(qu)){
                                        JOptionPane.showMessageDialog(this, "질문내용을 수정했습니다!");
                                        setTable(new Question());
                                        resetValue();
                                        return;
                              }else{
                                        JOptionPane.showMessageDialog(this, "질문내용 수정이 실패되었습니다!");
                                        return;
                              }
                    }
                    
          }

          private void resetValue() {
                    textArea_editQue.setText("");
                    comboBox_editObj.setSelectedIndex(0);
          }

          protected void selectRowAction(MouseEvent e) {
                    row=table.getSelectedRow();
                    String id = dft.getValueAt(row, 0).toString();
                    String que = dft.getValueAt(row, 1).toString();
                    String obj = dft.getValueAt(row,2).toString();
                    textArea_editQue.setText(que);
                    for(int i=0;i<comboBox_editObj.getItemCount();i++){
                              if(obj.equals(objArray[i])){
                                        comboBox_editObj.setSelectedIndex(i);
                              } 
                    }
                    
          }

          protected void searchQuestion(ActionEvent e) {
                    String sQue = textField_searchQue.getText().toString();
                    String sObj;
                    try {
                              sObj = comboBox_searchObj.getSelectedItem().toString();
                    } catch (Exception e2) {
                              sObj=null;
                    }
                    Question qu=new Question();
                    qu.setQue(sQue);
                    qu.setObj(sObj);
                    setTable(qu);
          }

          private void setTable(Question question) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    QuestionDao quDao=new QuestionDao();
                    List<Question> quList = quDao.getQueList(question);
                    for(Question q : quList){
                              Vector v=new Vector();
                              v.add(q.getId());//0
                              v.add(q.getQue());
                              v.add(q.getObj());
                              dft.addRow(v);
                    }
                    quDao.closeDao();  
                    
          }

          protected void AddQuestion(ActionEvent e) {
                    String que = textArea_addQue.getText().toString();
                    String obj = comboBox_addObj.getSelectedItem().toString();
                    if(StringUtil.isEmpty(que)){
                              JOptionPane.showMessageDialog(this, "질문 내용을 입력해주세요!");
                              return;
                    }
                    Question qu=new Question();
                    qu.setQue(que);
                    qu.setObj(obj);
                    QuestionDao quDao=new QuestionDao();
                    if(quDao.AddQue(qu)){
                              JOptionPane.showMessageDialog(this, "질문을 추가했습니다!");
                              textArea_addQue.setText("");
                              return;
                    }else{
                              JOptionPane.showMessageDialog(this, "질문 추가는 실패했습니다!");
                              return;
                    }
          }
}
