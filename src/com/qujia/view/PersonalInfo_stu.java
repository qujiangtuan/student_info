package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class PersonalInfo_stu extends JFrame {

	private JPanel contentPane;
	private JLabel label_name,label_sno,label_dept,label_appendMajor,label_email;
	private JLabel label_degree,label_schYear,label_address,label_app,label_tel;
	private List<Org> orgList;
	private Student student,stuTemp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo_stu frame = new PersonalInfo_stu();
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
	public PersonalInfo_stu() {
	          this.setResizable(false);
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 570, 371);
		
		ViewUtil vu=new ViewUtil();
        vu.showCenter(this);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC131    \uBA85:");
		lblNewLabel.setBounds(48, 45, 65, 15);
		
		label_name = new JLabel("123");
		label_name.setBounds(131, 45, 130, 15);
		
		JLabel lblNewLabel_2 = new JLabel("\uD559\uBD80(\uACFC):");
		lblNewLabel_2.setBounds(48, 78, 65, 15);
		
		label_dept = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		label_dept.setBounds(131, 78, 130, 15);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_4.setBounds(48, 147, 65, 15);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774 \uBA54 \uC77C:");
		lblNewLabel_5.setBounds(271, 147, 65, 15);
		
		JLabel lblNewLabel_6 = new JLabel("\uC8FC    \uC18C:");
		lblNewLabel_6.setBounds(48, 190, 65, 15);
		
		label_app = new JLabel("\uCD94\uAC00\uC804\uACF5:");
		label_app.setBounds(48, 111, 65, 15);
		
		label_appendMajor = new JLabel("\uC5C6\uC74C");
		label_appendMajor.setBounds(131, 111, 130, 15);
		
		JButton submitButton = new JButton("\uD655 \uC778");
		submitButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		submitButton.setBounds(119, 258, 84, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(label_app);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(label_appendMajor);
		contentPane.add(label_name);
		contentPane.add(label_dept);
		contentPane.add(submitButton);
		
		JLabel lblNewLabel_9 = new JLabel("\uD559    \uBC88:");
		lblNewLabel_9.setBounds(271, 45, 65, 15);
		contentPane.add(lblNewLabel_9);
		
		label_sno = new JLabel("201518047");
		label_sno.setBounds(346, 45, 84, 15);
		contentPane.add(label_sno);
		
		JLabel lblNewLabel_11 = new JLabel("\uD559\uC704\uACFC\uC815:");
		lblNewLabel_11.setBounds(271, 78, 65, 15);
		contentPane.add(lblNewLabel_11);
		
		
		label_degree = new JLabel("\uD559\uC0AC\uACFC\uC815");
		label_degree.setBounds(346, 78, 84, 15);
		contentPane.add(label_degree);
		
		JLabel lblNewLabel_13 = new JLabel("\uD559    \uB144:");
		lblNewLabel_13.setBounds(271, 111, 65, 15);
		contentPane.add(lblNewLabel_13);
		
		label_schYear = new JLabel("1");
		label_schYear.setBounds(346, 111, 54, 15);
		contentPane.add(label_schYear);
		
		label_tel = new JLabel("01040421777");
		label_tel.setBounds(131, 147, 130, 15);
		contentPane.add(label_tel);
		
		label_email = new JLabel("qujiangtuan@qq.com");
		label_email.setBounds(346, 147, 143, 15);
		contentPane.add(label_email);
		
		label_address = new JLabel("\uBD80\uACBD");
		label_address.setBounds(131, 190, 347, 15);
		contentPane.add(label_address);
		
		student =(Student) MainFrm.userObject;
		StudentDao stuDao=new StudentDao();
		stuTemp=stuDao.login(student);
		setInfor();
	}
	
          private void setInfor() {
                    label_name.setText(stuTemp.getName());
                    label_sno.setText(stuTemp.getsNo());
                    label_dept.setText(this.getOrgNameById(stuTemp.getOrgId()));
                    label_degree.setText(stuTemp.getDegreeProcess());
                    label_app.setText(this.getApptype());
                    label_appendMajor.setText(this.getAppendMajor());
                    label_schYear.setText(stuTemp.getInSchYear());
                    label_tel.setText(stuTemp.getTel());
                    label_email.setText(stuTemp.getEmail());
                    label_address.setText(stuTemp.getAdress());
                    
          }
          private String getApptype() {
                    if(StringUtil.isEmpty(stuTemp.getMajorType())){
                              return "추가전공:";
                    }else{
                              if("부전공".equals(stuTemp.getMajorType())){
                                        return "부 전  공:";
                              }else{
                                        return "복수전공:";
                              }
                    }
          }

        private String getAppendMajor() {
                   if(StringUtil.isEmpty(stuTemp.getMajor())){
                             return "없음";
                   }else{
                             return stuTemp.getMajor();
                   }
          }

        //orgid에 통해서 orgName를 받는다
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
}
