package com.qujia.test; 
import java.awt.Container;
import java.util.Vector;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class TableFrame extends JFrame {
    private JTable table;
 
    private Vector<Vector<String>> data = new Vector<Vector<String>>();
    private Vector<String> colNames = new Vector<String>();
 
    public TableFrame() {
        super();
 
        initColnames();
        initData();
        Container c = getContentPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(data, colNames));
        table.setModel(new DefaultTableModel() {
            /**
         *
         */
            private static final long serialVersionUID = 1L;
 
            @Override
            public int getRowCount() {
                return data.size();
            }
 
            @Override
            public int getColumnCount() {
                return colNames.size();
            }
 
            @Override
            public String getColumnName(int column) {
                return colNames.get(column);
            }
 
            @Override
            public Object getValueAt(int row, int column) {
                return data.get(row).get(column);
            }
        });
//        table.setAutoCreateRowSorter(true);
//        table.getTableHeader().setReorderingAllowed(false);
 
        c.add(new JScrollPane(table));
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    private void initColnames() {
        for (int i = 0; i < 5; i++) {
            colNames.add("Col" + i);
        }
    }
 
    private void initData() {
        for (int i = 0; i < 20; i++) {
            Vector<String> record = new Vector<String>();
            for (int j = 0; j < 5; j++) {
                record.add(i + " " + j);
            }
 
            data.add(record);
        }
    }
 
    public static void main(String[] args) {
        new TableFrame();
    }
}