package com.qujia.util;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
public class MyRadioCellRenderer extends MyRadioPanel implements
		TableCellRenderer {
 
	private static final long serialVersionUID = 1L;

 
	public MyRadioCellRenderer(String[] strButtonTexts) {
		super(strButtonTexts);
	}
 
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof Integer) {
			setSelectedIndex(((Integer) value).intValue());
		}
		return this;
	}
}
