package com.qujia.test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FileChooser extends JFrame implements ActionListener{  
    JButton open=null;  
    public static void main(String[] args) {  
        new FileChooser();  
    }  
    public FileChooser(){  
        getContentPane().setLayout(null);
        open=new JButton("업로드");  
        open.setBounds(94, 27, 84, 35);
        getContentPane().add(open);  
        
        JButton btnNewButton = new JButton("다운로드");
        btnNewButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                            TestOracle to= new TestOracle();
                            to.testQuery("katE74.hwp");
                  }
        });
        btnNewButton.setBounds(190, 33, 97, 23);
        getContentPane().add(btnNewButton);
        this.setBounds(400, 200, 370, 300);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        open.addActionListener(this);  
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        JFileChooser jfc=new JFileChooser();  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
        jfc.showDialog(new JLabel(), "选择");  
        File file=jfc.getSelectedFile();  
        if(file.isDirectory()){  
                 
            System.out.println("文件夹:"+file.getAbsolutePath());  
            
        }else if(file.isFile()){ 
                  
            System.out.println("文件:"+file.getAbsolutePath());  
            TestOracle to= new TestOracle();
            to.testInsert(file);
        }  
        System.out.println("file->"+file);
        System.out.println("fileName->"+jfc.getSelectedFile().getName());  
          
    }  
    

  
}