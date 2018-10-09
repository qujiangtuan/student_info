package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.YearDeptStandDao;
import com.qujia.model.Org;
import com.qujia.model.YearDeptStand;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddYearStandFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_creditAll;
	private JTextField textField_majorScore;
	private JTextField textField_majorMustScore;
	private JTextField textField_culMustScore;
	private JTextField textField_recTatio;
	private JTextField textField_recTemp;
	private JTextField textField_recForm;
	private JComboBox comboBox_deptName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddYearStandFrm frame = new AddYearStandFrm();
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
	public AddYearStandFrm() {
		setTitle("\uD559\uB144\uBCC4\uD559\uC0AC\uAE30\uC900\uB4F1\uB85D");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 589, 559);
		
		 ViewUtil vu = new ViewUtil();
         vu.showCenter(this);
         
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		lblNewLabel.setBounds(118, 48, 103, 15);
		
		  comboBox_deptName = new JComboBox();
		comboBox_deptName.setBounds(234, 48, 238, 21);
		
		JLabel lblNewLabel_1 = new JLabel("\uC878\uC5C5\uC774\uC218\uD559\uC810:");
		lblNewLabel_1.setBounds(130, 87, 91, 15);
		
		textField_creditAll = new JTextField();
		textField_creditAll.setBounds(234, 87, 238, 21);
		textField_creditAll.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
		lblNewLabel_2.setBounds(130, 126, 91, 15);
		
		textField_majorScore = new JTextField();
		textField_majorScore.setBounds(234, 126, 238, 21);
		textField_majorScore.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
		lblNewLabel_3.setBounds(130, 165, 91, 15);
		
		textField_majorMustScore = new JTextField();
		textField_majorMustScore.setBounds(234, 165, 238, 21);
		textField_majorMustScore.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
		lblNewLabel_4.setBounds(130, 204, 91, 15);
		
		textField_culMustScore = new JTextField();
		textField_culMustScore.setBounds(234, 204, 238, 21);
		textField_culMustScore.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728:");
		lblNewLabel_6.setBounds(130, 245, 91, 15);
		
		textField_recTatio = new JTextField();
		textField_recTatio.setBounds(234, 245, 238, 21);
		textField_recTatio.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		lblNewLabel_7.setBounds(130, 284, 91, 15);
		
		textField_recTemp = new JTextField();
		textField_recTemp.setBounds(234, 284, 238, 21);
		textField_recTemp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uC815\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		lblNewLabel_8.setBounds(130, 323, 91, 15);
		
		textField_recForm = new JTextField();
		textField_recForm.setBounds(234, 323, 238, 21);
		textField_recForm.setColumns(10);
		
		JButton submitButton = new JButton("\uB4F1  \uB85D");
		submitButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    submitAction(e);
		          }
		});
		submitButton.setBounds(180, 410, 69, 23);
		
		JButton cancleButton = new JButton("\uCD5C  \uC18C");
		cancleButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		cancleButton.setBounds(348, 410, 69, 23);
		contentPane.setLayout(null);
		contentPane.add(submitButton);
		contentPane.add(lblNewLabel_8);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_7);
		contentPane.add(textField_recForm);
		contentPane.add(textField_recTemp);
		contentPane.add(textField_recTatio);
		contentPane.add(textField_culMustScore);
		contentPane.add(textField_majorMustScore);
		contentPane.add(textField_majorScore);
		contentPane.add(textField_creditAll);
		contentPane.add(comboBox_deptName);
		contentPane.add(cancleButton);
		
		setDeptName();
	}
	          //학년별 학과기준 등록
	          protected void submitAction(ActionEvent e) {
	                    Org org = (Org) comboBox_deptName.getSelectedItem();
	                    String orgCode = org.getOrgCode();//조직코드
	                    String yearStart=DateUtil.getThisYear();//적용시작년한
	                    String yearEnd=(Integer.parseInt(DateUtil.getThisYear())+1)+"";//적용종료년한
	                    String yearNo=getYearNo(yearStart);//학년별기준번호
	                    int creditAll,majorScore,majorMustScore,culScore,culMustScore,recTatio,recTemp,recForm;
	                    try {
	                                creditAll = Integer.parseInt( textField_creditAll.getText().toString());//졸업이수학점
	                                majorScore = Integer.parseInt( textField_majorScore.getText().toString());//전공이수학점
	                                majorMustScore = Integer.parseInt( textField_majorMustScore.getText().toString());//전공필수학점
//	                            int culScore = Integer.parseInt( textField_culScore.getText().toString());//교양이수학점
	                                culScore=creditAll-majorScore;
	                                culMustScore = Integer.parseInt( textField_culMustScore.getText().toString());//교양필수학점
	                                recTatio = Integer.parseInt( textField_recTatio.getText().toString());//모집비율
	                                recTemp = Integer.parseInt( textField_recTemp.getText().toString());//수시모집인원
	                                recForm = Integer.parseInt( textField_recForm.getText().toString());//정시모집인원
                    } catch (Exception e2) {
                              JOptionPane.showMessageDialog(this,"숫자 데이터를 입력해주세요!");
                              return;
                    }
	                    
//	                    if (StringUtil.isEmpty(creditAll)) {
//	                              JOptionPane.showMessageDialog(this,"졸업이수학점을 입력해주세요!");
//	                              return;
//	                    }
//	                    if (StringUtil.isEmpty(majorScore)) {
//                                  JOptionPane.showMessageDialog(this,"전공이수학점을 입력해주세요!");
//                                  return;
//                        }
//	                    if (StringUtil.isEmpty(majorMustScore)) {
//                                  JOptionPane.showMessageDialog(this,"전공필수학점을 입력해주세요!");
//                                  return;
//                        }
//	                    if (StringUtil.isEmpty(culMustScore)) {
//                                  JOptionPane.showMessageDialog(this,"교양필수학점을 입력해주세요!");
//                                  return;
//                        }
//	                    if (StringUtil.isEmpty(recTatio)) {
//                                  JOptionPane.showMessageDialog(this,"모집비율을 입력해주세요!");
//                                  return;
//                        }
//	                    if (StringUtil.isEmpty(recTemp)) {
//                                  JOptionPane.showMessageDialog(this,"수시모집인원을 입력해주세요!");
//                                  return;
//                        }
//	                    if (StringUtil.isEmpty(recForm)) {
//                                  JOptionPane.showMessageDialog(this,"정시모집인원을 선택해주세요!");
//                                  return;
//                        }
	                    YearDeptStand yds=new YearDeptStand();
	                    yds.setYearNo(yearNo);
	                    yds.setYearStart(yearStart);
	                    yds.setYearEnd(yearEnd);
	                    yds.setCredit(creditAll);
	                    yds.setMajor(majorScore);
	                    yds.setMajorMust(majorMustScore);
	                    yds.setCul(culScore);
	                    yds.setCulMust(culMustScore);
	                    yds.setRecTatio(recTatio);
	                    yds.setRecTemp(recTemp);
	                    yds.setRecForm(recForm);
	                    yds.setOrgId(orgCode);
	                    YearDeptStandDao ydsDao=new YearDeptStandDao();
	                    if(ydsDao.addYearStand(yds)){
	                              JOptionPane.showMessageDialog(this, "학년벌학사기준 등록 성공했습니다!");
	                    }else{
	                              JOptionPane.showMessageDialog(this, "학년벌학사기준 등록 실패했습니다!");
	                    }
	          }
	          //학년벌 기준번호 pk
	          private String getYearNo(String yearStart) {
                    String yearNO1=yearStart+StringUtil.getRandom2();
                      return yearNO1;
              }

          //학과 받기
	      protected void setDeptName() {
              // TODO Auto-generated method stub
              OrgDao orgDao=new OrgDao();
              List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
              for (Org org: orgList) {
                        comboBox_deptName.addItem(org);
              }
              orgDao.closeDao();
    }
}
