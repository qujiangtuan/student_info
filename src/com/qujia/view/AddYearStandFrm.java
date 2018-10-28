package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
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
	private JTextField textField_deptName;
	private List<Org> orgList;

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
	          this.setResizable(false);
		setTitle("\uD559\uB144\uBCC4\uD559\uC0AC\uAE30\uC900\uB4F1\uB85D");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 589, 339);
		
		 ViewUtil vu = new ViewUtil();
         vu.showCenter(this);
         
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		lblNewLabel.setBounds(118, 33, 103, 15);
		
		JLabel lblNewLabel_1 = new JLabel("\uC878\uC5C5\uC774\uC218\uD559\uC810:");
		lblNewLabel_1.setBounds(40, 76, 91, 15);
		
		textField_creditAll = new JTextField();
		textField_creditAll.setBounds(144, 76, 115, 21);
		textField_creditAll.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
		lblNewLabel_2.setBounds(271, 76, 91, 15);
		
		textField_majorScore = new JTextField();
		textField_majorScore.setBounds(374, 76, 116, 21);
		textField_majorScore.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
		lblNewLabel_3.setBounds(40, 113, 91, 15);
		
		textField_majorMustScore = new JTextField();
		textField_majorMustScore.setBounds(144, 113, 115, 21);
		textField_majorMustScore.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
		lblNewLabel_4.setBounds(270, 113, 91, 15);
		
		textField_culMustScore = new JTextField();
		textField_culMustScore.setBounds(374, 113, 116, 21);
		textField_culMustScore.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728:");
		lblNewLabel_6.setBounds(40, 157, 91, 15);
		
		textField_recTatio = new JTextField();
		textField_recTatio.setBounds(143, 154, 116, 21);
		textField_recTatio.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		lblNewLabel_7.setBounds(270, 157, 91, 15);
		
		textField_recTemp = new JTextField();
		textField_recTemp.setBounds(375, 154, 115, 21);
		textField_recTemp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uC815\uC2DC\uBAA8\uC9D1\uC778\uC6D0:");
		lblNewLabel_8.setBounds(40, 195, 91, 15);
		
		textField_recForm = new JTextField();
		textField_recForm.setBounds(144, 195, 115, 21);
		textField_recForm.setColumns(10);
		
		JButton submitButton = new JButton("\uB4F1  \uB85D");
		submitButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    submitAction(e);
		          }
		});
		submitButton.setBounds(190, 251, 69, 23);
		
		JButton cancleButton = new JButton("\uCD5C  \uC18C");
		cancleButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		cancleButton.setBounds(330, 251, 69, 23);
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
		contentPane.add(cancleButton);
		
		textField_deptName = new JTextField();
		textField_deptName.setBounds(233, 30, 116, 21);
		contentPane.add(textField_deptName);
		textField_deptName.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC870\uD68C");
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent arg0) {
		                    SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                            sdf.setVisible(true);
                            textField_deptName.setText(addSearch());
		          }
		});
		btnNewButton.setBounds(372, 29, 91, 23);
		contentPane.add(btnNewButton);
	}
	          protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
          }

                    //학년별 학과기준 등록
	          protected void submitAction(ActionEvent e) {
	                    String deptName = textField_deptName.getText().toString();
	                    String orgCode = this.getOrgidByOrgName(deptName);//조직코드
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
	                    String loginDate=DateUtil.getTodayDate();
	                    YearDeptStand yds=new YearDeptStand();
	                    yds.setYearNo(yearNo);
//	                    yds.setYearStart(yearStart);
//	                    yds.setYearEnd(yearEnd);
	                    yds.setCredit(creditAll);
	                    yds.setMajor(majorScore);
	                    yds.setMajorMust(majorMustScore);
	                    yds.setCul(culScore);
	                    yds.setCulMust(culMustScore);
	                    yds.setRecTatio(recTatio);
	                    yds.setRecTemp(recTemp);
	                    yds.setRecForm(recForm);
	                    yds.setOrgId(orgCode);
	                    yds.setLoginDate(loginDate);
	                    yds.setDeptName(deptName);
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

	    //orgName에 통해서 orgid를 받는다
          public String getOrgidByOrgName(String name){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getName().equals(name)) return org.getOrgCode();
                    }
                    return "";
          }
}
