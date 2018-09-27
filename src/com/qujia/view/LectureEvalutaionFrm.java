package com.qujia.view;
import com.qujia.test3.*;
import com.qujia.util.ViewUtil;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.qujia.test1.MyRadioCellEditor;
import com.qujia.test1.MyRadioCellRenderer;

public class LectureEvalutaionFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LectureEvalutaionFrm frame = new LectureEvalutaionFrm();
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
          public LectureEvalutaionFrm() {
                    setTitle("\uAC15\uC758\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 770, 450);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    
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
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAC1D\uAD00\uC2DD:");
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC8FC\uAD00\uC2DD:");
                    
                    JLabel label = new JLabel("\uC810\uACF5\uC774\uB098 \uAD50\uC591\uAD50\uC721\uACFC\uC815\uC5D0 \uB300\uD55C \uAC74\uC758\uC0AC\uD56D\uC774\uB098 \uAC1C\uC120\uD560 \uC810\uC774 \uC788\uB2E4\uBA74 \uC790\uC720\uB86D\uAC8C \uC81C\uC2DC\uD574 \uC8FC\uC2ED\uC2DC\uC624.");
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
                    
                    JLabel lblNewLabel_4 = new JLabel("");
//                    [매우그렇다]:(5) [대체로 그렇다]:(4) [그저 그렇다]:(3) [대체로 아니다]:(2) [전혀 아니다]:(1)
                    JButton btnNewButton = new JButton("\uD655\uC778");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                            	  Integer index;
                            	  try {
                            		  index=(Integer) table.getValueAt(0, 2);
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(null, "평가 선택해주세요!" );
									return;
								}
                            	  
                            	  int rowCount=table.getRowCount();
                            	  List<Integer> integerList=new ArrayList<Integer>();
                            	  
                            	  for (int i = 0; i <rowCount; i++) {
                            		  index=(Integer) table.getValueAt(i, 2);
                            		  integerList.add(index+1);
								}
//                            	  index=(Integer) table.getValueAt(rowCount-1, 2);
//                            	  integerList.add(index);
                            	  System.out.println(integerList);
                            	  setTable();
                              }
                    });
                    btnNewButton.setBackground(new Color(176, 224, 230));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAE40\uBBF8\uC601");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    					.addGroup(gl_contentPane.createSequentialGroup()
                    						.addGap(19)
                    						.addComponent(lblNewLabel)
                    						.addPreferredGap(ComponentPlacement.RELATED)
                    						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    						.addGap(18)
                    						.addComponent(lblNewLabel_1)
                    						.addPreferredGap(ComponentPlacement.UNRELATED)
                    						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                    					.addGroup(gl_contentPane.createSequentialGroup()
                    						.addContainerGap()
                    						.addComponent(lblNewLabel_2)
                    						.addPreferredGap(ComponentPlacement.UNRELATED)
                    						.addComponent(lblNewLabel_4))
                    					.addGroup(gl_contentPane.createSequentialGroup()
                    						.addContainerGap()
                    						.addComponent(lblNewLabel_3)
                    						.addPreferredGap(ComponentPlacement.RELATED)
                    						.addComponent(label)))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addContainerGap()
                    					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)))
                    			.addContainerGap())
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addContainerGap(587, Short.MAX_VALUE)
                    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                    			.addGap(29))
                    		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                    			.addContainerGap()
                    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    			.addContainerGap())
                    );
                    gl_contentPane.setVerticalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGap(10)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(lblNewLabel)
                    				.addComponent(lblNewLabel_1)
                    				.addComponent(lblNewLabel_5)
                    				.addComponent(lblNewLabel_6))
                    			.addGap(14)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(lblNewLabel_2)
                    				.addComponent(lblNewLabel_4))
                    			.addPreferredGap(ComponentPlacement.RELATED)
                    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                    			.addPreferredGap(ComponentPlacement.UNRELATED)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(lblNewLabel_3)
                    				.addComponent(label))
                    			.addGap(18)
                    			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                    			.addGap(18)
                    			.addComponent(btnNewButton)
                    			.addContainerGap(35, Short.MAX_VALUE))
                    );
                    
                    JTextArea textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane_1.setViewportView(textArea);
                    contentPane.setLayout(gl_contentPane);
                    setTable();
                    
          }
          public class setRadioButton{
        	  public setRadioButton() {
        		  String[] answer = { "1", "2", "3","4","5" };
                  TableColumn column = table.getColumnModel().getColumn(2);
                  column.setCellEditor(new MyRadioCellEditor(new MyRadioCellRenderer(answer)));
                  column.setCellRenderer(new MyRadioCellRenderer(answer));
        	  }
          }
          public class setRadioButton2{
        	  public setRadioButton2() {
        		  String[] answer = { "좋다", "싫다"};
                  TableColumn column = table.getColumnModel().getColumn(2);
                  column.setCellEditor(new MyRadioCellEditor(new MyRadioCellRenderer(answer)));
                  column.setCellRenderer(new MyRadioCellRenderer(answer));
        	  }
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
          public void setTable() {
              DefaultTableModel dft = (DefaultTableModel) table.getModel();
              // 清空列表(resetTable)
              dft.setRowCount(0);
              
//              // 得到列表内容，并且遍历(get table contents)
//              DeptStandDao dStandDao=new DeptStandDao();
//              List<DeptStand> dStandList = dStandDao.getDeptStandList(dStand);
//              for (DeptStand ds: dStandList) {
                        // Vector类 是在 java 中可以实现自动增长的对象数组
//                        Vector v = new Vector();
//                       v.add(null);
//                       v.add(null);
//                       
//                       v.add(new setRadioButton());
//                        dft.addRow(v);
                        Vector v2 = new Vector();
                        v2.add(null);
                        v2.add(null);
                        v2.add(new setRadioButton2());
                         dft.addRow(v2);
//              }
//              dStandDao.closeDao();
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
 
}
