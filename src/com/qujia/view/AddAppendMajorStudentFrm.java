package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.SecondMajorRangeDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.SecondMajorRange;
import com.qujia.model.Student;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class AddAppendMajorStudentFrm extends JFrame {

	private JPanel contentPane;
	private JLabel label_name;
	private JComboBox comboBox_major_type;
	private JLabel Label_dept;
	private JTextField textField_major;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAppendMajorStudentFrm frame = new AddAppendMajorStudentFrm();
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
	public AddAppendMajorStudentFrm() {
		setTitle("\uCD94\uAC00\uC804\uACF5");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 350);
		
		 ViewUtil vu=new ViewUtil();
         vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC774    \uB984:");
		lblNewLabel.setBounds(80, 53, 63, 15);
		
		label_name = new JLabel();
		label_name.setBounds(161, 53, 271, 15);
		label_name.setText("123");
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uACF5\uAD6C\uBD84:");
		lblNewLabel_1.setBounds(80, 127, 63, 15);
		
		comboBox_major_type = new JComboBox();
		comboBox_major_type.setBounds(161, 124, 271, 21);
		comboBox_major_type.setModel(new DefaultComboBoxModel(new String[] {"\uBCF5\uC218\uC804\uACF5", "\uBD80\uC804\uACF5"}));
		
		JLabel lblNewLabel_2 = new JLabel("\uCD94\uAC00\uC804\uACF5:");
		lblNewLabel_2.setBounds(80, 166, 63, 15);
		
		JButton submitButton = new JButton("\uB4F1 \uB85D");
		submitButton.setBounds(173, 241, 63, 23);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addAppendMajorAction(ae);
			}
		});
		
		JButton cancelButton = new JButton("\uCDE8 \uC18C");
		cancelButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		cancelButton.setBounds(283, 241, 63, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(label_name);
		contentPane.add(comboBox_major_type);
		contentPane.add(submitButton);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel_3 = new JLabel("소속하과:");
		lblNewLabel_3.setBounds(80, 88, 63, 15);
		contentPane.add(lblNewLabel_3);
		
		  Label_dept = new JLabel("135465465");
		Label_dept.setBounds(161, 88, 271, 15);
		contentPane.add(Label_dept);
		
		textField_major = new JTextField();
		textField_major.setBounds(161, 163, 116, 21);
		contentPane.add(textField_major);
		textField_major.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                            sdf.setVisible(true);
                            textField_major.setText(addSearch());
		          }
		});
		btnNewButton.setBounds(289, 162, 97, 23);
		contentPane.add(btnNewButton);
		getStudentName();//填充姓名
		getStudentDept();
		
	}
	protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
          }

          //추가전공 등록 event
	protected void addAppendMajorAction(ActionEvent ae) {
		String name = label_name.getText().toString();
		String deptName=Label_dept.getText().toString();
		String majorType=comboBox_major_type.getSelectedItem().toString();
//		Org org=(Org) comboBox_major.getSelectedItem();
		
		String secondMajor = textField_major.getText().toString();
		String applyDate =DateUtil.getTodayDate();
		
		SecondMajorRange smr=new SecondMajorRange();
		smr.setOrgidBaseName(deptName);
		smr.setOrgidAllowName(secondMajor);
		
		SecondMajorRangeDao smrDao=new SecondMajorRangeDao();
		try {
		          SecondMajorRange smr2 = smrDao.isAllow(smr);
		          if("Yes".equals(smr2.getIsAllow())){
		                    if(majorType.equals(smr2.getAllowType())){
		                              Student student=new Student();
		                              student.setName(name);
		                              student.setMajorType(majorType);
		                              student.setMajor(secondMajor);
		                              student.setApplyDate(applyDate);
		                              
		                              StudentDao sDao=new StudentDao();
		                              if(sDao.UpdateAppendMajor(student)) {
		                                  JOptionPane.showMessageDialog(this, "["+majorType+"]->{ "+secondMajor+" } 등록 성공했습니다!");
		                                  this.dispose();
		                                  this.setVisible(false);
		                              }else {
		                                  JOptionPane.showMessageDialog(this, "추가전공 등록 실패했습니다!");
		                              }
		                              StudentManagerFrm smf=new StudentManagerFrm();
		                              this.show(false);
		                              smf.revalidate();
		                    }else{
		                              JOptionPane.showMessageDialog(this, "전공 허용하지 않습니다!");
		                              
		                    }
		          }else{
		                    JOptionPane.showMessageDialog(this, "전공 허용하지 않습니다!");
		          }
		} catch (Exception e) {
		          JOptionPane.showMessageDialog(this, "전공 허용하지 않습니다!");
		}
		
		          
		
//		Student student=new Student();
//		student.setName(name);
//		student.setMajorType(majorType);
//		student.setMajor(secondMajor);
//		student.setApplyDate(applyDate);
//		
//		StudentDao sDao=new StudentDao();
//		if(sDao.UpdateAppendMajor(student)) {
//			JOptionPane.showMessageDialog(this, "추가전공 등록 성공했습니다!");
//			this.dispose();
//			this.setVisible(false);
//		}else {
//			JOptionPane.showMessageDialog(this, "추가전공 등록 실패했습니다!");
//		}
//		StudentManagerFrm smf=new StudentManagerFrm();
//		this.show(false);
//		smf.revalidate();
	}
	//학생이름 받기
	public void getStudentName() {
		StudentManagerFrm amf=new StudentManagerFrm();
		String name=amf.getStudentName();
		label_name.setText(name);
	}
	//학생학과 받기
    public void getStudentDept() {
        StudentManagerFrm amf=new StudentManagerFrm();
        String deptName=amf.getStudentDept();
        Label_dept.setText(deptName);
    }
}
