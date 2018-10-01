package com.qujia.test3;

import java.awt.Dimension;

import javax.swing.JTable;

public class RowHeaderTable extends JTable{
	private JTable refTable; //需要添加rowHeader的JTable     
/**
* 为JTable添加RowHeade
* @param refTable 需要添加rowHeader的JTable
* @param columnWideth rowHeader的宽度
*/
public RowHeaderTable(JTable refTable,int columnWidth){
			 super(new RowHeaderTableModel(refTable.getRowCount()));
			 this.refTable=refTable;
			 this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//不可以调整列宽     
			 this.getColumnModel().getColumn(0).setPreferredWidth(columnWidth);
			 this.setDefaultRenderer(Object.class,new RowHeaderRenderer(refTable,this));//设置渲染器     
			 this.setPreferredScrollableViewportSize (new Dimension(columnWidth,0));
		}
}
