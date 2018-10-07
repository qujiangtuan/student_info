package com.qujia.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 1、画界面
 * 2、加按钮的监听事件
 * 3、添加拷贝的方法
 * author : xiyan
 */
public class CopyFileDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    JFileChooser fileChooser;//选择器
    JTextField jtfSourceField;//文件原路径
    JTextField jtfTargeTextField;//目标路径
    JButton SelectFile1;
    JButton SelectFile2;
    JButton copyButton;

    public CopyFileDemo(){
        super("复制文件");
        //初始化选择器
        fileChooser = new JFileChooser();
        //得到容器
        Container container = getContentPane();
        //实例化组件
        jtfSourceField=new JTextField(16);
        jtfTargeTextField=new JTextField(16);
        SelectFile1 = new  JButton("选择");
        SelectFile2 = new  JButton("选择");
        copyButton = new  JButton("拷贝");

        Box box = Box.createVerticalBox();//实例化box,用于组件
        JPanel panl = new JPanel();
        panl.add(new JLabel("源文件"));
        panl.add(jtfSourceField);
        panl.add(SelectFile1);
        box.add(panl);

        panl = new JPanel();
        panl.add(new JLabel("目标文件"));
        panl.add(jtfTargeTextField);
        panl.add(SelectFile2);
        panl.add(copyButton);
        //将panl放入box中
        box.add(panl);
        //将组件放入容器中
        container.add(box);
        //设置按钮的监听
        SelectFile1.addActionListener(new SelectFileListern());
        SelectFile2.addActionListener(new SelectFileListern());
        copyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceFile = jtfSourceField.getText();//得到源文件路径
                String targetFile = jtfTargeTextField.getText();//得到目标文件路径
                //执行拷贝操作
                try {
                    if (copy(sourceFile, targetFile)) {
                        JOptionPane.showMessageDialog(CopyFileDemo.this, "拷贝成功！");
                    }else {
                        JOptionPane.showMessageDialog(CopyFileDemo.this, "拷贝失败！");

                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        setSize(340,160); // 设置窗口的大小
        setVisible(true); //设置窗口可见
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口时退出程序
    }

    /**
     * 打开选择器
     * 
     * */
    class SelectFileListern implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //判断选择器是否打开，不可重复打开
            if (fileChooser.showOpenDialog(CopyFileDemo.this)==JFileChooser.APPROVE_OPTION) {
                //得到文件绝对路径
                String  filename = fileChooser.getSelectedFile().getAbsolutePath();
                //判断触发哪个按钮时的事件
                if (event.getSource().equals(SelectFile1)) {
                    jtfSourceField.setText(filename);
                }else {
                    jtfTargeTextField.setText(filename);
                }
            }
        }
}
    /**
     *  组成文件的字节序列称为字节流，组成文件的字符序列称为字符流
     *  字节流： InputStream  OutputStream
     *  字符流：Reader Writer
     *  
     *  根据流的方向分为输入流或输出流
     *  输入流：InputStream  Reader
     *  输出流：OutputStream Writer
     *  
     *  File类
     *  
     *  File类提供了大量的文件操作：删除文件，修改文件，建立目录、列表文件等等
     *  
     * @param file1  源文件路径
     * @param file2 目标文件路径
     * 
     */
    public boolean copy(String file1,String file2) {
        File filein = new File(file1);// 用路径名生成源文件
        File fileout = new File(file2);// 用路径名生成目标文件
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
             fin = new FileInputStream(filein);// 得到文件输入流
             fout = new FileOutputStream(fileout);
            byte[] buffer = new byte[1024];// // 创建容量为1024的缓冲区(存储已经读取到的数据)
            int len = -1 ;//返回-1 表示读取完毕
            while ((len = fin.read(buffer))!= -1) {
                // 将数据从buffer中写出去
                fout.write(buffer,0,len);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {

            // 关闭管道
            try {
                if (fin == null) {
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fin == null) {
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CopyFileDemo();
    }
}
