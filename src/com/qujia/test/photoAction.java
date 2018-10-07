package com.qujia.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class photoAction extends JFrame implements ActionListener {
	private Photo photo;

	public photoAction(Photo photo) {
		this.photo = photo;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		photoDao dao = new photoDao();
		if ("업로드".equals(e.getActionCommand())) {
			dao.setPhoto("C:/Users/qujia/Pictures/java.png");// 上传时，可以选择获取路径，这边就直接指定了
		}else{
		          JOptionPane.showMessageDialog(this, "없어");
		}
		if ("다운로드".equals(e.getActionCommand())) {
			photo.setLabel(dao.getIcon());// 从dao层中获取Icon对象，并传到页面层进行展示；
		}
	}

}
