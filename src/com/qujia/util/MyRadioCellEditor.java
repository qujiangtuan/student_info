package com.qujia.util;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

 
public class MyRadioCellEditor extends DefaultCellEditor implements
		ItemListener {
 
	private static final long serialVersionUID = 1L;
	/** radio pane. */
	private MyRadioPanel panel = null;
	private JRadioButton[] buttons;

 
	public MyRadioCellEditor(MyRadioPanel panel) {
		super(new JCheckBox());
		this.panel = panel;
		ButtonGroup buttonGroup = new ButtonGroup();
		buttons = panel.getButtons();
		for (int i = 0; i < buttons.length; i++) {
			buttonGroup.add(buttons[i]);
			buttons[i].addItemListener(this);
		}
	}

 
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (value instanceof Integer) {
			panel.setSelectedIndex(((Integer) value).intValue());
		}
		return panel;
	}
 
	public Object getCellEditorValue() {
		return new Integer(panel.getSelectedIndex());
////		  return 
//		                      JButton button = (JButton) panel.getComponent(panel.getSelectedIndex());
//		                      String butStr = button.getText().toString();
//	         for (int i = 0; i < buttons.length; i++) {
//                    if(buttons[i].isSelected()){
//                           return buttons[i];   
//                    }
//          }
	}
 
	public String getCellEditorValue2() {
	  //      return new Integer(panel.getSelectedIndex());
	  //        return 
	                                JButton button = (JButton) panel.getComponent(panel.getSelectedIndex());
	                                String butStr = button.getText().toString();
//	             for (int i = 0; i < buttons.length; i++) {
//	                      if(buttons[i].isSelected()){
//	                             return buttons[i];   
//	                      }
//	            }
//	              return buttons[panel.getSelectedIndex()];
	            return butStr;
	      }
	   
	public void itemStateChanged(ItemEvent e) {
		super.fireEditingStopped();
	}
}
