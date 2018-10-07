package com.qujia.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *  数据操作（这边我就不封装之类的了，还有一些变量七七八八的，自己弄弄吧）
 *  注释我感觉写的差不多了，不懂的查API或者问度娘吧
 * 
 */
public class photoDao {
	/**
	 * 上传图片到数据库
     * @param filename 文件路径
	 */
	public void setPhoto(String filename) {

	       // 加载驱动程序类
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 建立数据库联机，其中denglu为数据库名，sa为连接数据库的帐号及密码。
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");

			FileInputStream str = new FileInputStream(filename); //filename 图片文件路径
			String sql = "insert into picture(id,image) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "1"); // ID号
			pstmt.setBinaryStream(2, str, str.available()); // 图片数据
			// 将数据存入数据库
			pstmt.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
     *  从数据库中获取图片的io流并转为图片Icon
     * @return Icon对象
     */

	public Icon getIcon() {
		Icon IC = new ImageIcon();
		ByteArrayOutputStream baos = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.110.136.106:1522:XE", "student", "6317800");
			Statement stmt = con.createStatement();
			String sql = "select image from picture WHERE id='1'";

			PreparedStatement ps = con
					.prepareStatement("select Image from picture where id='1'");// 从数据库中读取的图片是事先已经存入的二进制数据
			ResultSet rs = ps.executeQuery();

			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				InputStream is = rs.getBinaryStream("image");
				baos = new ByteArrayOutputStream();
				int b = 0;
				while ((b = is.read()) != -1) {
					baos.write(b);
				}
			}
			// 将数据流转为Icon数据
			IC = new ImageIcon(baos.toByteArray());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return IC;

	}

}
