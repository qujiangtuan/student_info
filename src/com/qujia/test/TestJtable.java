package com.qujia.test;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class TestJtable extends JPanel {
  
 public TestJtable(){
  init();
 }

 private void init() {
  setLayout(new BorderLayout());
  JScrollPane scrollPane = new JScrollPane(createTable());  
  add(scrollPane);
 }
  
 private JTable createTable() {
  JTable table = new JTable();
  String[] tableHeads = new String[]{"端口1","端口2","端口3"};
  DefaultTableModel dtm = (DefaultTableModel)table.getModel();
  dtm.setColumnIdentifiers(tableHeads);

 if( table.getRowSelectionAllowed()==true){
  table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
 }
  /*******添加的一些数据，也可以从数据库中提取数据*************/
   
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
  dtm.addRow(new Object[]{new Boolean(false),new Boolean(false),new Boolean(false)});
   
   
   
  /*****设置table的列模型****/
  TableColumnModel tcm = table.getColumnModel();
  tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));   
  tcm.getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()));   
  tcm.getColumn(2).setCellEditor(new DefaultCellEditor(new JCheckBox()));
   
  tcm.getColumn(0).setCellRenderer(new TestTableCellRenderer());   
  tcm.getColumn(0).setPreferredWidth(80);   
  tcm.getColumn(0).setWidth(80);   
  tcm.getColumn(0).setMaxWidth(80);   
   
  tcm.getColumn(1).setCellRenderer(new TestTableCellRenderer());   
  tcm.getColumn(1).setPreferredWidth(80);   
  tcm.getColumn(1).setWidth(80);   
  tcm.getColumn(1).setMaxWidth(80);   
   
  tcm.getColumn(2).setCellRenderer(new TestTableCellRenderer());   
  tcm.getColumn(2).setPreferredWidth(80);   
  tcm.getColumn(2).setWidth(80);   
  tcm.getColumn(2).setMaxWidth(80);
  
//  JRadioButton button1=new JRadioButton();
//  JRadioButton button2=new JRadioButton();
//  JRadioButton button3=new JRadioButton();
//  button1 = (JRadioButton) table.getModel().getValueAt(2, 1);
//  button2 = (JRadioButton) table.getModel().getValueAt(2, 2);
//  button3 = (JRadioButton) table.getModel().getValueAt(2, 3);
//  ButtonGroup buttonGroup=new ButtonGroup();
//  buttonGroup.add(button1);
//  buttonGroup.add(button2);
//  buttonGroup.add(button3);
        MyCellEditor cellEditor=new MyCellEditor();
       
  return table;
 }

 public static void main(String[] args) {
  JFrame jframe = new JFrame();
  jframe.setBounds(300,100,300,200);
  jframe.setTitle("测试");
  jframe.add(new TestJtable());
  jframe.setVisible(true);
 }
  
 
 
 class TestTableCellRenderer extends JRadioButton implements TableCellRenderer{

  @Override
  public Component getTableCellRendererComponent(JTable table,
  Object value, boolean isSelected, boolean hasFocus, int row,
  int column) {
  Boolean b = (Boolean) value;   
  this.setSelected(b.booleanValue());   
  return this;   

  }
   
 }
public class MyCellEditor implements TableCellEditor{

          @Override
          public void addCellEditorListener(CellEditorListener arg0) {
                    // TODO Auto-generated method stub
                    
          }

          @Override
          public void cancelCellEditing() {
                    // TODO Auto-generated method stub
                    
          }

          @Override
          public Object getCellEditorValue() {
                    // TODO Auto-generated method stub
                    return null;
          }

          @Override
          public boolean isCellEditable(EventObject arg0) {
                    // TODO Auto-generated method stub
                    return false;
          }

          @Override
          public void removeCellEditorListener(CellEditorListener arg0) {
                    // TODO Auto-generated method stub
                    
          }

          @Override
          public boolean shouldSelectCell(EventObject arg0) {
                    // TODO Auto-generated method stub
                    return false;
          }

          @Override
          public boolean stopCellEditing() {
                    // TODO Auto-generated method stub
                    return false;
          }

          @Override
          public Component getTableCellEditorComponent(JTable arg0,
                              Object arg1, boolean arg2, int arg3, int arg4) {
                    // TODO Auto-generated method stub
                    return null;
          }
           
 }
}  
