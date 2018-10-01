package com.qujia.test3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableRowHeaderFrame extends JFrame   {
	public TableRowHeaderFrame(){
		DefaultTableModel model = new DefaultTableModel(50,10);
		JTable table = new JTable(model); 
		/*将table加入JScrollPane*/
		JScrollPane scrollPane = new JScrollPane(table);
		 /*将rowHeaderTable作为row header加入JScrollPane的RowHeaderView区域*/ 

		scrollPane.setRowHeaderView(new RowHeaderTable(table,40));
		this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 }
}
