package com.qujia.test;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.eltima.components.ui.DatePicker;
import com.qujia.model.ClassRoom;
import com.qujia.model.TableTime;
import com.qujia.util.DateUtil;

public class CourseArrangeFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTable table_1;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseArrangeFrm frame = new CourseArrangeFrm();
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
          public CourseArrangeFrm() {
                    setTitle("\uC218\uAC15\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 635, 526);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC218\uAC15\uC774\uB984:");
                    
                    JComboBox comboBox = new JComboBox();
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC218\uAC15\uBC88\uD638:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel label = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    
                    JComboBox comboBox_1 = new JComboBox();
                    
                    JLabel lblNewLabel_2 = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC77C\uC9DC:");
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uD559    \uB144:");
                    
                    JComboBox comboBox_2 = new JComboBox();
                    
                    JLabel lblNewLabel_4 = new JLabel("\uB204\uC801\uD559\uAE30:");
                    
                    JComboBox comboBox_3 = new JComboBox();
                    
                    
                    
                     
                    DateUtil du=new DateUtil();
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JButton btnNewButton = new JButton("등  록");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void getdate(){
                                        Date cellEditorValue = (Date) new JSpinnerColRender().getCellEditorValue();
                              }
                              public void actionPerformed(ActionEvent arg0) {
                                        
                                        ClassRoom cr =new ClassRoom();
                                        Boolean bool = (Boolean) table_1.getModel().getValueAt(1,0);
                                        String dateStart =(String) new JSpinnerColRender().getCellEditorValue();
                                        String dateEnd =(String) new JSpinnerColRender().getCellEditorValue();
                                        
//                                        Date dateStart =(Date) new JSpinnerColRender().getCellEditorValue();
//                                        Date dateEnd =(Date) new JSpinnerColRender().getCellEditorValue();
                                      //  Date dateStart = (Date) table_1.getModel().getValueAt(1, 1);
                                        //Date dateEnd = (Date) table_1.getModel().getValueAt(1, 2);
                                       String crname=(String) table_1.getModel().getValueAt(1,3);
                                       cr.setCrName(crname);
                                       
                                        TableTime tt=new TableTime();
                                        tt.setBool(bool);
                                        tt.setDateStart(dateStart);
                                        tt.setDateEnd(dateEnd);
                                        tt.setCr(cr);
                                        Map<Integer, Object> map =new HashMap<Integer, Object>();
                                        map.put(1, tt.getBool());
                                        map.put(2,tt.getDateStart());
                                        map.put(3, tt.getDateEnd());
                                        map.put(4, tt.getCr());
                                        System.out.println(map);
                                        //System.out.println(bool);
                              }
                    });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(42)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
                                                                      .addContainerGap())
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel)
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addComponent(label)
                                                                                                    .addComponent(lblNewLabel_3))
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addComponent(comboBox_2, 0, 158, Short.MAX_VALUE)
                                                                                                    .addComponent(comboBox_1, 0, 158, Short.MAX_VALUE))))
                                                                      .addGap(34)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(23)
                                                                                          .addComponent(lblNewLabel_1)
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addComponent(textField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                                    .addComponent(lblNewLabel_4)
                                                                                                    .addComponent(lblNewLabel_2))
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                    .addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                    .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                      .addContainerGap(63, Short.MAX_VALUE))))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                  .addContainerGap(368, Short.MAX_VALUE)
                                                  .addComponent(btnNewButton)
                                                  .addGap(148))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label)
                                                                      .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(lblNewLabel_2))
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(20)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(44)
                                                  .addComponent(btnNewButton)
                                                  .addContainerGap(61, Short.MAX_VALUE))
                    );
                    
                    table_1 = new JTable();
                    table_1.setRowHeight(25);
                    table_1.setModel(new DefaultTableModel(
                              new Object[][] {
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                                  {null, null, null, null},
                                        },
                              new String[] {
                                        "\uC218\uAC15\uC694\uC77C", "\uC2DC\uC791\uC2DC\uAC04", "\uB05D\uB098\uC2DC\uAC04", "\uAC15\uC758\uC2E4"
                              }
                    
                    ));
                    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                    int rowCount = table_1.getModel().getRowCount();
                    for (int i = 0; i < rowCount; i++) {
                              model.setValueAt(new Boolean(false), i, 0);
                    }
                    table_1.getColumnModel().getColumn(0).setPreferredWidth(62);
                    table_1.getColumnModel().getColumn(1).setPreferredWidth(102);
                    table_1.getColumnModel().getColumn(2).setPreferredWidth(93);
                    table_1.getColumnModel().getColumn(3).setPreferredWidth(157);
                    
                    
                    table_1.getColumnModel().getColumn(0).setCellEditor(new CheckBoxCellEditor());
                    table_1.getColumnModel().getColumn(0).setCellRenderer(new CWCheckBoxRenderer());
                    
                     
                    
                    table_1.getColumnModel().getColumn(1).setCellEditor(new JSpinnerColRender());
                    table_1.getColumnModel().getColumn(1).setCellRenderer(new JSpinnerColRender());
                    
                    table_1.getColumnModel().getColumn(2).setCellEditor(new JSpinnerColRender());
                    table_1.getColumnModel().getColumn(2).setCellRenderer(new JSpinnerColRender());
                    
                    table_1.getColumnModel().getColumn(3).setCellEditor(new JComboBoxColRender());
                    table_1.getColumnModel().getColumn(3).setCellRenderer(new JComboBoxColRender());
                     
                    
                    scrollPane.setViewportView(table_1);
                    
                    contentPane.setLayout(gl_contentPane);
          }
         //第一列编辑1
          class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {
                    //~ Static fields/initializers -------------------------------------------------------------------------------------

                    private static final long serialVersionUID = 1L;

                    //~ Instance fields ------------------------------------------------------------------------------------------------

                    protected JCheckBox checkBox;

                    //~ Constructors ---------------------------------------------------------------------------------------------------

                    public CheckBoxCellEditor() {
                      checkBox = new JCheckBox();
                      checkBox.setHorizontalAlignment(SwingConstants.CENTER);
                      // checkBox.setBackground( Color.white);
                    }

                    //~ Methods --------------------------------------------------------------------------------------------------------

                    @Override public Object getCellEditorValue() {
                      return Boolean.valueOf(checkBox.isSelected());
                    }

                    //~ ----------------------------------------------------------------------------------------------------------------

                    @Override public Component getTableCellEditorComponent(
                      JTable  table,
                      Object  value,
                      boolean isSelected,
                      int     row,
                      int     column) {
                      checkBox.setSelected(((Boolean) value).booleanValue());

                      return checkBox;

                    }
                  } // end class CheckBoxCellEditor
        //第一列编辑2
                  class CWCheckBoxRenderer extends JCheckBox implements TableCellRenderer {
                    //~ Static fields/initializers -------------------------------------------------------------------------------------

                    private static final long serialVersionUID = 1L;

                    //~ Instance fields ------------------------------------------------------------------------------------------------

                    Border border = new EmptyBorder(1, 2, 1, 2);

                    //~ Constructors ---------------------------------------------------------------------------------------------------

                    public CWCheckBoxRenderer() {
                      super();
                      setOpaque(true);
                      setHorizontalAlignment(SwingConstants.CENTER);
                    }

                    //~ Methods --------------------------------------------------------------------------------------------------------

                    @Override public Component getTableCellRendererComponent(
                      JTable  table,
                      Object  value,
                      boolean isSelected,
                      boolean hasFocus,
                      int     row,
                      int     column) {
                      if (value instanceof Boolean) {
                        setSelected(((Boolean) value).booleanValue());

                        // setEnabled(table.isCellEditable(row, column));
                        setForeground(table.getForeground());
                        setBackground(table.getBackground());

                      }

                      return this;
                    }
                  } // end class CWCheckBoxRenderer

                //第二列编辑（时间选择）
          public class JSpinnerColRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor{
                    private JTable table;
                    private DefaultTableModel model;
                    private int row;
                    
                    private JSpinner spinner;
                    
                    public JSpinnerColRender() {
                              super();
                              this.spinner = new JSpinner();
                              spinner.setModel(new SpinnerDateModel(new Date(1536505200000L), new Date(1536505200000L), new Date(1536505200000L), Calendar.HOUR));
                              DateUtil du=new DateUtil();
                              
                              spinner=du.spinnerHour();
                    }
                    
                    @Override
                    public Object getCellEditorValue() {
                              // TODO Auto-generated method stub
                              Date date = (Date)spinner.getValue();
                              SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                              String StringDate = df.format(date);
                              return StringDate;
                    }

                    @Override
                    public Component getTableCellEditorComponent(JTable table,
                                        Object value, boolean isSelected, int row,
                                        int cloumn) {
                              this.table=table;
                              this.row=row;
                              this.model=(DefaultTableModel) table.getModel();
                              return spinner;         
                               
                    }

                    @Override
                    public Component getTableCellRendererComponent(JTable arg0,
                                        Object arg1, boolean arg2,
                                        boolean arg3, int arg4, int arg5) {
                              // TODO Auto-generated method stub
                              return spinner;
                    }

          } 
        //第三列编辑（下拉框）
          public class JComboBoxColRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor{
                    private JTable table;
                    private DefaultTableModel model;
                    private int row;
                    
                    private JComboBox comboBox;
                    
                    public JComboBoxColRender() {
                              super();
                              this.comboBox = new JComboBox();
                              
                    }
                    
                    @Override
                    public Object getCellEditorValue() {
                              // TODO Auto-generated method stub
                              return null;
                    }

                    @Override
                    public Component getTableCellEditorComponent(JTable table,
                                        Object value, boolean isSelected, int row,
                                        int cloumn) {
                              this.table=table;
                              this.row=row;
                              this.model=(DefaultTableModel) table.getModel();
                              return comboBox;         
                               
                    }

                    @Override
                    public Component getTableCellRendererComponent(JTable arg0,
                                        Object arg1, boolean arg2,
                                        boolean arg3, int arg4, int arg5) {
                              // TODO Auto-generated method stub
                              return comboBox;
                    }

          }
}
