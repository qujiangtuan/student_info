package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddAppendMajorStudentFrm extends JFrame {

	private JPanel contentPane;
	private JLabel label_name;
	private JComboBox comboBox_major,comboBox_major_type;
	private DatePicker datePicker;

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
		setBounds(100, 100, 525, 369);
		
		 ViewUtil vu=new ViewUtil();
         vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC774    \uB984:");
		
		label_name = new JLabel();
		label_name.setText("123");
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uACF5\uAD6C\uBD84:");
		
		comboBox_major_type = new JComboBox();
		comboBox_major_type.setModel(new DefaultComboBoxModel(new String[] {"\uBCF5\uC218\uC804\uACF5", "\uBD80\uC804\uACF5"}));
		
		JLabel lblNewLabel_2 = new JLabel("\uCD94\uAC00\uC804\uACF5:");
		
		comboBox_major = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\uC2E0\uCCAD\uC77C\uC790:");
		
		datePicker = new DatePicker();
		
		JButton submitButton = new JButton("\uB4F1 \uB85D");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addAppendMajorAction(ae);
			}
		});
		
		JButton cancelButton = new JButton("\uCDE8 \uC18C");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(submitButton)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(datePicker, 0, 0, Short.MAX_VALUE)
							.addComponent(comboBox_major, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox_major_type, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_name, 0, 143, Short.MAX_VALUE))
						.addComponent(cancelButton))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label_name))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox_major_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBox_major, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(cancelButton))
					.addGap(51))
		);
		contentPane.setLayout(gl_contentPane);
		getStudentName();//填充姓名
		setDeptStandName();//填充学科
		
	}
	//추가전공 등록 event
	protected void addAppendMajorAction(ActionEvent ae) {
		String name = label_name.getText().toString();
		String majorType=comboBox_major_type.getSelectedItem().toString();
		Org org=(Org) comboBox_major.getSelectedItem();
		String major = org.getName();
		String applyDate = null;
		try {
			applyDate = getStringDate(datePicker);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "신청일자 입력해주세요!");
			return;
		}
		Student student=new Student();
		student.setName(name);
		student.setMajorType(majorType);
		student.setMajor(major);
		student.setApplyDate(applyDate);
		StudentDao sDao=new StudentDao();
		
		if(sDao.UpdateAppendMajor(student)) {
			JOptionPane.showMessageDialog(this, "추가전공 등록 성공!");
			this.dispose();
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(this, "추가전공 등록 실패!");
		}
		StudentManagerFrm smf=new StudentManagerFrm();
		this.show(false);
		smf.revalidate();
	}
	//학생이름 받기
	public void getStudentName() {
		StudentManagerFrm amf=new StudentManagerFrm();
		String name=amf.getStudentName();
		label_name.setText(name);
	}
	 //学科 从数据库中把数据填充选择框
    protected void setDeptStandName() {
              // TODO Auto-generated method stub
              OrgDao orgDao=new OrgDao();
              List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
//              System.out.println(orgList);
              for (Org org: orgList) {
            	  comboBox_major.addItem(org);
              }
              orgDao.closeDao();
    }
    public String getStringDate(DatePicker datepick) {
        String stringDate;
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) datepick.getValue();
        //System.out.println(date);
        stringDate = form.format(date);
        return stringDate;
}
}
