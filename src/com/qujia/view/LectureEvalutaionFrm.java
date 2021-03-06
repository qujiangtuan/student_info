package com.qujia.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.qujia.dao.OpenCourseDao;
import com.qujia.dao.PerCourseDao;
import com.qujia.dao.QueAnsDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.PerCourse;
import com.qujia.model.QueAns;
import com.qujia.model.Student;
import com.qujia.util.DateUtil;
import com.qujia.util.MyRadioCellEditor;
import com.qujia.util.MyRadioCellRenderer;
import com.qujia.util.ViewUtil;

public class LectureEvalutaionFrm extends JDialog {

          private JPanel contentPane;
          private JTable table;
          private static boolean flag;
          private JLabel label_subName;
          private JLabel label_proName;
          private static String[] ansArray={};
          private static double avg=0;
          private JLabel label_zgx;
          private Student student,stuTemp;
          private JTextArea textArea;
          
          public static double getAvg() {
                    return avg;
          }

          public static void setAvg(double avg) {
                    LectureEvalutaionFrm.avg = avg;
          }

          public static boolean isFlag() {
                    return flag;
          }

          public static void setFlag(boolean flag) {
                    LectureEvalutaionFrm.flag = flag;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LectureEvalutaionFrm frame = new LectureEvalutaionFrm(null);
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
          public LectureEvalutaionFrm(JFrame fr) {
                    super(fr, "", true);
                    this.setResizable(false);
                    setTitle("\uAC15\uC758\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 770, 450);
                    
                    student =(Student) MainFrm.userObject;
                    StudentDao stuDao=new StudentDao();
                    stuTemp=stuDao.login(student);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 65, 720, 148);
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    lblNewLabel.setBounds(24, 15, 54, 15);
                    
                    table = new JTable();
                    table.setRowHeight(20);
                    table.setModel(new DefaultTableModel(
                    	new Object[][] {
                    		{null, null, null},
                    	},
                    	new String[] {
                    		"\uBC88\uD638", "\uD3C9\uAC00\uC9C8\uBB38", "\uD3C9\uAC00 \uB2F5\uC548"
                    	}
                    ) {
                    	boolean[] columnEditables = new boolean[] {
                    		false, false, true
                    	};
                    	public boolean isCellEditable(int row, int column) {
                    		return columnEditables[column];
                    	}
                    } );
                    table.getColumnModel().getColumn(1).setPreferredWidth(399);
                    table.getColumnModel().getColumn(2).setPreferredWidth(169);
                    scrollPane.setViewportView(table);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    lblNewLabel_1.setBounds(291, 15, 66, 15);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAC1D\uAD00\uC2DD:");
                    lblNewLabel_2.setBounds(17, 44, 61, 15);
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC8FC\uAD00\uC2DD:");
                    lblNewLabel_3.setBounds(17, 223, 61, 15);
                    
                    label_zgx = new JLabel("\uC810\uACF5\uC774\uB098 \uAD50\uC591\uAD50\uC721\uACFC\uC815\uC5D0 \uB300\uD55C \uAC74\uC758\uC0AC\uD56D\uC774\uB098 \uAC1C\uC120\uD560 \uC810\uC774 \uC788\uB2E4\uBA74 \uC790\uC720\uB86D\uAC8C \uC81C\uC2DC\uD574 \uC8FC\uC2ED\uC2DC\uC624.");
                    label_zgx.setBounds(92, 223, 637, 15);
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(17, 256, 720, 69);
                    scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
                    
                    JLabel lblNewLabel_4 = new JLabel("");
                    lblNewLabel_4.setBounds(69, 44, 0, 0);
//                    [매우그렇다]:(5) [대체로 그렇다]:(4) [그저 그렇다]:(3) [대체로 아니다]:(2) [전혀 아니다]:(1)
                    JButton btnNewButton = new JButton("확 인");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submitAction(e);
                              }
                    });
                    btnNewButton.setBounds(536, 343, 76, 23);
//                    btnNewButton.addActionListener(new ActionListener() {
//                              
//
//                              public void actionPerformed(ActionEvent e) {
//                            	  Integer index;
//                            	  try {
//                            		  index=(Integer) table.getValueAt(0, 2);
//								} catch (Exception e2) {
//									// TODO: handle exception
//									JOptionPane.showMessageDialog(null, "평가 선택해주세요!" );
//									return;
//								}
//                            	  
//                            	  int rowCount=table.getRowCount();
//                            	  List<Integer> integerList=new ArrayList<Integer>();
//                            	  
//                            	  for (int i = 0; i <rowCount; i++) {
//                            		  index=(Integer) table.getValueAt(i, 2);
//                            		  integerList.add(index+1);
//								}
////                            	  index=(Integer) table.getValueAt(rowCount-1, 2);
////                            	  integerList.add(index);
////                            	  System.out.println(integerList);
//                            	  setTable(new QueAns());
//                            	  flag=true;
//                            	  dispose();
//                              }
//                    });
                    
                    label_subName = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    label_subName.setText(ScoreShowToStudentFrm.getSubName());
                    label_subName.setBounds(90, 15, 189, 15);
                    
                    label_proName = new JLabel("\uAE40\uBBF8\uC601");
                    label_proName.setText(ScoreShowToStudentFrm.getProName());
                    label_proName.setBounds(305, 15, 71, 15);
                    
                    JButton button = new JButton("취 소");
                    button.setBounds(661, 343, 76, 23);
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                                        flag=false;
                              }
                    });
                    
                    textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane_1.setViewportView(textArea);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(label_subName);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(label_proName);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(label_zgx);
                    contentPane.add(scrollPane_1);
                    contentPane.add(scrollPane);
                    contentPane.add(btnNewButton);
                    contentPane.add(button);
                    setTable(new QueAns());
                    
          }
          protected void submitAction(ActionEvent e) {
//                    int index2=-1;
//                            try {
//                                index2=(Integer) table.getValueAt(0, 2);
//                          } catch (Exception e2) {
//                              // TODO: handle exception
//                              JOptionPane.showMessageDialog(null, "평가 선택해주세요!" );
//                              return;
//                          }
                            
                            int rowCount=table.getRowCount();
                            Integer[] index = new Integer[rowCount];
                            double score[]=new double[rowCount];
                            double sum=0;
                            double avg1=0;
                            List<Integer> integerList=new ArrayList<Integer>();
                  
                            for (int i = 0; i <rowCount; i++) {
                                      try {
                                                index[i]=(Integer) table.getValueAt(i, 2);
                                      } catch (Exception e2) {
                                                index[i]=3;
                                              JOptionPane.showMessageDialog(null, "평가 선택해주세요!" );
                                              return;
                                      }
                                      score[i]=getScore(index[i]);
                                      avg1=(sum+=score[i])/rowCount;
                                      avg=getAvg(avg1);
                          }
                            String eva = textArea.getText().toString();
                            PerCourse pc=new PerCourse();
                            pc.setEva(eva);
                            pc.setSno(stuTemp.getsNo());
                            pc.setYear(DateUtil.getThisYear());
                            pc.setTerm(DateUtil.getTerm());
                            pc.setCouNo(this.getCouNO(ScoreShowToStudentFrm.getSubName()));
                              System.out.println("avg="+avg);
                              PerCourseDao perDao=new PerCourseDao();
                            if(perDao.updateProScore(pc,avg)){
                                      JOptionPane.showMessageDialog(this, "강의 평가 완료되었습니다!");
                            }else{
                                      JOptionPane.showMessageDialog(this, "강의 평가 완료되지 않습니다!");
                            }
                            setTable(new QueAns());
                            flag=true;
                            dispose();
                    
          }
         
        
          private String getCouNO(String subName) {
                    OpenCourseDao ocDao=new OpenCourseDao();
                    String couNo = ocDao.getCouNo(subName);
                    return couNo;
          }

          private double getAvg(double avg1) {
                    BigDecimal bg = new BigDecimal(avg1);
                    double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    return f1;
          }

          private double getScore(Integer integer) {
                    double score=0;
                    switch (integer) {
                    case 0:
                              score=4.2;
                              break;
                   
                    case 1:
                              score=4.0;
                              break;
                    case 2:
                              score=3.5;
                              break;
                    case 3:
                              score=3.0;
                              break;         
                    case 4:
                              score=2.5;
                              break;   
                    case 5:
                              score=2.0;
                              break;           
                    default:
                              score=1.5;
                              break;
                    
                    }
                    return score;
          }

          public void setRadioButton3(String[] answer) {
//                    String[] answer = { "좋다", "싫다"};
                    TableColumn column = table.getColumnModel().getColumn(2);
                    column.setCellEditor(new MyRadioCellEditor(new MyRadioCellRenderer(answer)));
                    column.setCellRenderer(new MyRadioCellRenderer(answer));
                }
          //设置序列号
          public class setNumber{
        	  public setNumber() {
        		  //居中显示
//        		  DefaultTableCellRenderer  renderer  =  new  DefaultTableCellRenderer();   //set column align center		
//        		  renderer.setHorizontalAlignment(JTextField.CENTER);		
//        		  table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        	  }
          }
          public void setTable(QueAns qa) {
              DefaultTableModel dft = (DefaultTableModel) table.getModel();
              dft.setRowCount(0);
            
              QueAnsDao qaDao=new QueAnsDao();
              List<QueAns> qaList = qaDao.getQueAns(qa);
              for (QueAns q: qaList) {
//                        String answer="그렇다/보통/그렇지 않다";
//                        String[] ansArray={"그렇다","보통","그렇지 않다"};
                        Vector v2 = new Vector();
                        v2.add(q.getId());
                        v2.add(q.getQueName());
//                        v2.add(new setRadioButton2());
//                        v2.add(this.setRadioButton3(this.getAnsArray(q.getAnsName())));
                        ansArray=this.getAnsArray(q.getAnsName());
//                        for (int i = 0; i < ansArray.length; i++) {
//                                  System.out.println(i+ansArray[i]);
//                        }
                        v2.add(new setRadioButton2(ansArray));
//                        v2.add(new MyRadioPanel(ansArray));
//                        v2.add(defaultCloseOperation, this.setRadioButton3(ansArray));
                         dft.addRow(v2);
              }
              
              label_zgx.setText(qaDao.getQueKai(new QueAns()).getQueName());
              qaDao.closeDao();
    }
          private String[] getAnsArray(String answer) {
                    String[] result1 = answer.split("/");
                    return result1;
          }
          
          
          
          
          
          
          
//          public class OperationColRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor{
//                    private JTable table;
//                    private int row;
//                    private DefaultTableModel model;
//                    private JPanel jPanel=new JPanel();
//                    private JRadioButton  radioButton_1,radioButton_2,radioButton_3,radioButton_4,radioButton_5;
//                    private ButtonGroup btGroup;
//                    public OperationColRender() {
//                             jPanel.setLayout(null);
//                             radioButton_1=new JRadioButton("5");
//                             radioButton_2=new JRadioButton("4");
//                             radioButton_3=new JRadioButton("3");
//                             radioButton_4=new JRadioButton("2");
//                             radioButton_5=new JRadioButton("1");
//                             radioButton_1.setBounds(5, 5, 40, 15);
//                             radioButton_2.setBounds(45,5,40,15);
//                             radioButton_3.setBounds(85, 5, 40, 15);
//                             radioButton_4.setBounds(125,5,40,15);
//                             radioButton_5.setBounds(165, 5, 40, 15);
//                             btGroup=new ButtonGroup();
//                             btGroup.add(radioButton_1);
//                             btGroup.add(radioButton_2);
//                             btGroup.add(radioButton_3);
//                             btGroup.add(radioButton_4);
//                             btGroup.add(radioButton_5);
////                             radioButton_1.setSelected(true);
//                             jPanel.add(radioButton_1);
//                             jPanel.add(radioButton_2);
//                             jPanel.add(radioButton_3);
//                             jPanel.add(radioButton_4);
//                             jPanel.add(radioButton_5);
//                             radioButton_1.addActionListener(new ActionListener() {
//                              
//                              @Override
//                              public void actionPerformed(ActionEvent e) {
//                                         radioButton_1 = (JRadioButton) e.getSource();
//                                         if(radioButton_1.isSelected()){
//                                                   JRadioButton button=(JRadioButton) e.getSource();
//                                                   button.setBackground(new Color(176, 224, 230));
//                                                   System.out.println("hello");
//                                         }
//                              }
//                           });
//                    }
//                    @Override
//                    public Object getCellEditorValue() {
//                              // TODO Auto-generated method stub
//                             return null;
//                             // return Boolean.valueOf(radioButton_1.isSelected());
//                    }
//
//                    @Override
//                    public Component getTableCellEditorComponent(JTable table,
//                                        Object value, boolean isSelected,
//                                        int row, int column) {
//                              this.table=table;
//                              this.row=row;
//                              this.model=(DefaultTableModel) table.getModel();
//                              //radioButton_1.setSelected(((Boolean) value).booleanValue());
//                              return jPanel;
//                    }
//
//                    @Override
//                    public Component getTableCellRendererComponent(JTable  table,
//                                        Object  value,
//                                        boolean isSelected,
//                                        boolean hasFocus,
//                                        int     row,
//                                        int     column) {
////                              if (value instanceof Boolean) {
////                                        radioButton_1.setSelected(((Boolean) value).booleanValue());
////                              }
//                              return jPanel;
//                    }
//                    
//          }
          public class setRadioButton2{
                    public setRadioButton2(String[] answer) {
//                      String[] answer = { "좋다", "싫다"};
                        TableColumn column = table.getColumnModel().getColumn(2);
                        column.setCellEditor(new MyRadioCellEditor(new MyRadioCellRenderer(answer)));
                        column.setCellRenderer(new MyRadioCellRenderer(answer));
                    }
                }
          public class setRadioButton{
                    public setRadioButton() {
                        String[] answer = { "1", "2", "3","4","5" };
                        TableColumn column = table.getColumnModel().getColumn(2);
                        column.setCellEditor(new MyRadioCellEditor(new MyRadioCellRenderer(answer)));
                        column.setCellRenderer(new MyRadioCellRenderer(answer));
                    }
                }
}
