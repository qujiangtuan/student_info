package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class PersonalInfo_pro extends JFrame {

	private JPanel contentPane;
	private JLabel label_email;
	private JLabel label_name,label_orgName,label_perType,label_proType,label_teaType;
	private JLabel label_tel,label_address,label_pno;
	private ProStaff ps,psTmp;
	private List<Org> orgList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo_pro frame = new PersonalInfo_pro();
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
	public PersonalInfo_pro() {
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 590, 362);
		
		ViewUtil vu=new ViewUtil();
        vu.showCenter(this);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC131    \uBA85:");
		lblNewLabel.setBounds(59, 45, 62, 15);
		
		
		
		label_name = new JLabel("123");
		label_name.setBounds(131, 45, 130, 15);
		
		JLabel lblNewLabel_2 = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
		lblNewLabel_2.setBounds(59, 81, 62, 15);
		
		label_orgName = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		label_orgName.setBounds(131, 81, 122, 15);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_4.setBounds(59, 126, 62, 15);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774 \uBA54 \uC77C:");
		lblNewLabel_5.setBounds(307, 126, 62, 15);
		
		JLabel lblNewLabel_6 = new JLabel("\uC8FC    \uC18C:");
		lblNewLabel_6.setBounds(59, 169, 54, 15);
		
		JLabel lblNewLabel_7 = new JLabel("\uB2F4\uB2F9\uC9C1\uC704:");
		lblNewLabel_7.setBounds(307, 81, 62, 15);
		
		label_perType = new JLabel("\uC804\uC784\uAD50\uC218");
		label_perType.setBounds(387, 81, 75, 15);
		
		JButton submitButton = new JButton("\uD655 \uC778");
		submitButton.setBounds(131, 238, 69, 23);
		
		JLabel lblNewLabel_9 = new JLabel("\uC544 \uC774 \uB514:");
		lblNewLabel_9.setBounds(307, 45, 62, 15);
		
		label_pno = new JLabel("1876114");
		label_pno.setBounds(387, 45, 162, 15);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(label_name);
		contentPane.add(label_orgName);
		contentPane.add(label_perType);
		contentPane.add(lblNewLabel_9);
		contentPane.add(label_pno);
		contentPane.add(submitButton);
		
		label_proType = new JLabel("\uC9C1    \uC6D0");
		label_proType.setFont(new Font("Dialog", Font.BOLD, 13));
		label_proType.setBounds(258, 10, 89, 15);
		contentPane.add(label_proType);
		
		label_teaType = new JLabel("\uAC15\uC0AC");
		label_teaType.setBounds(472, 81, 95, 15);
		contentPane.add(label_teaType);
		
		
		
		label_tel = new JLabel("01042421555");
		label_tel.setBounds(131, 126, 125, 15);
		contentPane.add(label_tel);
		
		label_email = new JLabel("qujiangtuan@qq.com");
		label_email.setBounds(387, 123, 162, 15);
		contentPane.add(label_email);
		
		label_address = new JLabel("New label");
		label_address.setBounds(131, 169, 436, 15);
		contentPane.add(label_address);
		
		ps=(ProStaff) MainFrm.userObject;
		ProStaffDao psDao=new ProStaffDao();
		psTmp=psDao.login(ps);
		setInfor();
	}
	          
          private void setInfor() {
                    label_proType.setText(psTmp.getProType());
                    label_name.setText(psTmp.getpName());
                    label_pno.setText(psTmp.getpNo());
                    label_orgName.setText(this.getOrgNameById(psTmp.getOrgId()));
                    label_perType.setText(psTmp.getPerType());
                    if("교원".equals(psTmp.getProType())){
                              if(!StringUtil.isEmpty(psTmp.getTeaType())) {
                                        label_teaType.setText(psTmp.getTeaType());
                              }else{
                                        label_teaType.setText("");
                              }
                    }else{
                              label_teaType.setText("");
                    }
                    label_tel.setText(psTmp.getTel());
                    label_email.setText(psTmp.getEmail());
                    label_address.setText(psTmp.getAddress());
                    
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
