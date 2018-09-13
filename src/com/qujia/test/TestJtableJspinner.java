package com.qujia.test;


import java.awt.Component;  
import java.awt.event.MouseEvent;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.EventObject;  
import javax.swing.AbstractCellEditor;  
import javax.swing.JFrame;  
import javax.swing.JSpinner;  
import javax.swing.JTable;  
import javax.swing.SpinnerDateModel;  
import javax.swing.SpinnerListModel;  
import javax.swing.SpinnerModel;  
import javax.swing.table.DefaultTableModel;  
import javax.swing.table.TableCellEditor;  
import javax.swing.table.TableColumn;  
  
/** 
 * 
 * @author Administrator 
 */  
public class TestJtableJspinner {  
      
    public static void main(String[] args){  
        JTable table = new JTable();  
        DefaultTableModel model = (DefaultTableModel)table.getModel();  
  
        // Add some columns  
        model.addColumn("A", new Object[]{"item1"});  
        model.addColumn("B", new Object[]{"08:09:11"});  
  
        // These are the spinner values  
        String[] values = new String[]{"item1", "item2", "item3"};  
  
        // Set the spinner editor on the 1st visible column  
        int vColIndex = 0;  
        TableColumn col = table.getColumnModel().getColumn(vColIndex);  
        col.setCellEditor(new SpinnerEditor(values));  
  
        // 2st  
        Calendar calendar = Calendar.getInstance();  
        Date initDate = calendar.getTime();  
        calendar.add(Calendar.YEAR, -100);  
        Date start = calendar.getTime();  
        calendar.add(Calendar.YEAR, 200);  
        Date end = calendar.getTime();  
        TableColumn col2 = table.getColumnModel().getColumn(1);  
        SpinnerDateEditor se = new SpinnerDateEditor(new SpinnerDateModel(initDate, start, end, Calendar.YEAR));  
        col2.setCellEditor(se);  
  
        JFrame frame = new JFrame("swing-test1");  
        frame.add(table);  
        frame.pack();  
        frame.setVisible(true);  
  
        // If you want to make the cell appear like a spinner in its  
        // non-editing state, also set the spinner renderer  
        //col.setCellRenderer(new SpinnerRenderer(values));  
    }  
  
    public static class SpinnerEditor extends AbstractCellEditor  
        implements TableCellEditor {  
        final JSpinner spinner = new JSpinner();  
  
        // Initializes the spinner.  
        public SpinnerEditor(String[] items) {  
            spinner.setModel(new SpinnerListModel(java.util.Arrays.asList(items)));  
        }  
  
        // Prepares the spinner component and returns it.  
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {  
            spinner.setValue(value);  
            return spinner;  
        }  
  
        // Enables the editor only for double-clicks.  
        public boolean isCellEditable(EventObject evt) {  
            if (evt instanceof MouseEvent) {  
                return ((MouseEvent)evt).getClickCount() >= 2;  
            }  
            return true;  
        }  
  
        // Returns the spinners current value.  
        public Object getCellEditorValue() {  
            return spinner.getValue();  
        }  
    }  
  
     public static class SpinnerDateEditor extends AbstractCellEditor  
        implements TableCellEditor {  
        final JSpinner spinner = new JSpinner();  
  
        // Initializes the spinner.  
        public SpinnerDateEditor(SpinnerModel model){  
            spinner.setModel(model);  
            spinner.setEditor(new JSpinner.DateEditor(spinner, "hh:mm:ss"));  
        }  
  
        // Prepares the spinner component and returns it.  
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {  
            Date date = null;  
            try {  
                date = new SimpleDateFormat("hh:mm:ss").parse(value.toString());  
                // myDate = new MyDate(date.getTime());  
            } catch (ParseException ex) {  
                ex.printStackTrace();  
            }  
            spinner.setValue(date);  
            return spinner;  
        }  
  
        // Enables the editor only for double-clicks.  
        public boolean isCellEditable(EventObject evt) {  
            if (evt instanceof MouseEvent) {  
                return ((MouseEvent)evt).getClickCount() >= 2;  
            }  
            return true;  
        }  
  
        // Returns the spinners current value.  
        public Object getCellEditorValue() {  
            Date date = (Date)spinner.getValue();  
            return new SimpleDateFormat("hh:mm:ss").format(date);  
        }  
    }  
}  
