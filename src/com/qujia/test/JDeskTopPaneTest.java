package com.qujia.test;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
public class JDeskTopPaneTest extends JFrame implements ActionListener  
{     
    private Container container = null ;  
    private JButton btn = null ;  
    private int xOffSet = 50 ;      //?Ý»??xø¶ì¹Õá  
    private int yOffSet = 50 ;      //?Ý»??yø¶ì¹Õá  
    private int frameCount = 0;     //?Ý»????  
    private JDesktopPane desktopPane ;  //?Øü?Ì«  
    private JInternalFrame internalFrame ;  //?Ý»??  
  
    public JDeskTopPaneTest(){  
        //?öÇmain??  
        setTitle("?Øü?Ì«ãÆÖÇ");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(800,600);  
        container = getContentPane();  
        desktopPane = new JDesktopPane();  
        desktopPane.setBackground(new Color(224,224,224));  
        container.add(desktopPane);  
          
        //?ÖÇûùäÎ?£¬ñ¼?ÞÀËì£¬ôÕÊ¥Óðmain??  
        btn = new JButton("add");  
        btn.setActionCommand("add");  
        btn.addActionListener(this);  
        container.add(btn,BorderLayout.SOUTH);  
  
        try {     
       //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//Windows?Ì«     
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel") ; //Mac?Ì«     
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel") ;//JavaÙù??Ì«     
    } catch (ClassNotFoundException ex) {     
        ex.printStackTrace();     
    } catch (InstantiationException ex) {     
        ex.printStackTrace();     
    } catch (IllegalAccessException ex) {     
        ex.printStackTrace();     
    } catch (UnsupportedLookAndFeelException ex) {     
        ex.printStackTrace();     
    }   
  
    }  
  
    public void actionPerformed(ActionEvent e){  
        if("add".equals(e.getActionCommand())){  
            addInternalFrame();  
        }  
          
    }  
  
    public void addInternalFrame(){  
        internalFrame = new JInternalFrame("frame" + frameCount,true,true,true,true);  
        internalFrame.setSize(200,150);  
        internalFrame.setVisible(true);  
        internalFrame.setLocation(xOffSet * frameCount,yOffSet * frameCount);  
        internalFrame.getContentPane().add(new JLabel("ùëùë!"),BorderLayout.CENTER);  
        desktopPane.add(internalFrame);  
        try{  
            internalFrame.setSelected(true);  
        }catch(Exception e){  
            JOptionPane.showMessageDialog(null,"???Öõ");  
        }  
        frameCount++;  
    }  
    public static void main(String[] args){  
        new JDeskTopPaneTest().setVisible(true);  
    }  
}  