package com.qujia.test3;

import javax.swing.table.AbstractTableModel;

public class RowHeaderTableModel extends AbstractTableModel {
	private int rowCount;// 当前JTable的行数，与需要加RowHeader的TableModel同步

	public RowHeaderTableModel(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return 1;
	}

	public Object getValueAt(int row, int column) {
		return row;
	}

}
