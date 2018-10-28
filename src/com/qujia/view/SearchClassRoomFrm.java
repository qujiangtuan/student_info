package com.qujia.view;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ClassRoomDao;
import com.qujia.model.ClassRoom;
import com.qujia.util.ViewUtil;

public class SearchClassRoomFrm extends JDialog {

	private JPanel contentPane;
	private JTextField textField_seaName;
	private JTable table;
	private List<ClassRoom> csList ;
	private JComboBox comboBox_editExp;
	private String[] explist;
	private JButton btnNewButton;
	private JButton button;
	private static int index;
	private static String crName;
	private static String crNo;
	

	public static String getCrName() {
                    return crName;
          }

          public static void setCrName(String crName) {
                    SearchClassRoomFrm.crName = crName;
          }

          public static String getCrNo() {
                    return crNo;
          }

          public static void setCrNo(String crNo) {
                    SearchClassRoomFrm.crNo = crNo;
          }

          /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClassRoomFrm frame = new SearchClassRoomFrm(null);
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
	public SearchClassRoomFrm(JFrame fr) {
	    super(fr, "", true);
	    this.setResizable(false);
		setTitle("\uAC15\uC758\uC2E4\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 729, 329);
		
		 ViewUtil vu = new ViewUtil();
         vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		explist=new String[] {"", "일반강의실", "실습강의실"};
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		lblNewLabel_4.setBounds(36, 26, 61, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_seaName = new JTextField();
		textField_seaName.setBounds(131, 23, 125, 21);
		contentPane.add(textField_seaName);
		textField_seaName.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uAC80 \uC0C9");
		btnNewButton_1.setBounds(552, 22, 92, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchClassRoomAction(e);
		          }
		});
		
		JLabel lblNewLabel_7 = new JLabel("\uAC15\uC758\uC2E4\uD2B9\uC131:");
		lblNewLabel_7.setBounds(291, 26, 79, 15);
		contentPane.add(lblNewLabel_7);
		
		comboBox_editExp = new JComboBox();
		comboBox_editExp.setBounds(382, 23, 125, 21);
		contentPane.add(comboBox_editExp);
		comboBox_editExp.setModel(new DefaultComboBoxModel(explist));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 64, 642, 172);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
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
		                    "\uBC88\uD638", "\uAC15\uC758\uC2E4\uBA85", "\uC815\uC6D0", "\uAC15\uC758\uC2E4\uD2B9\uC131"
		          }
		) {
		          boolean[] columnEditables = new boolean[] {
		                    false, false, false, false
		          };
		          public boolean isCellEditable(int row, int column) {
		                    return columnEditables[column];
		          }
		});
		
		btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    submitAction(e);
		          }
		});
		btnNewButton.setBounds(544, 246, 61, 23);
		contentPane.add(btnNewButton);
		
		button = new JButton("취소");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button.setBounds(617, 246, 61, 23);
		contentPane.add(button);
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(64);
		table.getColumnModel().getColumn(3).setPreferredWidth(272);
		
		setTable(new ClassRoom());
	}

          protected void searchClassRoomAction(ActionEvent e) {
                    String  name=null,crExp=null;
    	          ClassRoom cs=new ClassRoom();
                  name=textField_seaName.getText().toString();
                  cs.setCrName(name);
                  crExp = comboBox_editExp.getSelectedItem().toString();
                  cs.setExp(crExp);
                  setTable(cs);
    	}
          //select row
	          protected void selectRowAction(MouseEvent e) {
	                    index=table.getSelectedRow();
          }
          //set table
                    private void setTable(ClassRoom classRoom) {
                              DefaultTableModel dft = (DefaultTableModel) table.getModel();
                              dft.setRowCount(0);
                              ClassRoomDao crDao=new ClassRoomDao();
                              List<ClassRoom> csList = crDao.getCsList(classRoom);
                              for(ClassRoom c : csList){
                                        Vector v=new Vector();
                                        v.add(c.getCrNo());//0
                                        v.add(c.getCrName());
                                        v.add(c.getCounts());
                                        v.add(c.getExp());
                                        dft.addRow(v);
                              }
                              crDao.closeDao();  
                    }
                    private void submitAction(ActionEvent e) {
                              DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                              this.setVisible(false);
                              this.disable();
                              crName=dft.getValueAt(index, 1).toString();
                              crNo=dft.getValueAt(index, 0).toString();
                    }

                    
}
