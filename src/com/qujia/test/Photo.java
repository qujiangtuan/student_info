package com.qujia.test;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *  主面板 ，有一个Jlabel和两个按钮，上传和下载；
 *  Jlbel用于点击下载时显示数据库的图片文件，
 * 
 */
public class Photo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lab = new JLabel();
	photoAction l = new photoAction(this);// 建立Action层，并把页面层的对象传过去

	public Photo() {
		init();
	}

	public static void main(String[] args) {
		new Photo();
	}

	private void init() {
		lab.setBounds(100, 200, 300, 233);
		lab.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(lab);

		// // 添加两个button(可以封装)
		JButton jb = new JButton("업로드");
		jb.setBounds(50, 600, 135, 30);
		getContentPane().add(jb);
		JButton jb1 = new JButton("다운로드");
		jb1.setBounds(240, 600, 146, 30);
		getContentPane().add(jb1);

		// 添加监听
		jb.addActionListener(l);
		jb1.addActionListener(l);

		// 初始化页面
		setSize(700, 700);
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);

	}

    /**
     * 设置JLabel图片
     * 
     * @param i  Icon图片类型
     */

	public void setLabel(Icon i) {
		lab.setIcon(i);

	}

}
