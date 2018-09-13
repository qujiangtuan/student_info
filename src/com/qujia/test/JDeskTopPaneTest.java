package com.qujia.test;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
public class JDeskTopPaneTest extends JFrame implements ActionListener  
{     
    private Container container = null ;  
    private JButton btn = null ;  
    private int xOffSet = 50 ;      //?ݻ??x�����  
    private int yOffSet = 50 ;      //?ݻ??y�����  
    private int frameCount = 0;     //?ݻ????  
    private JDesktopPane desktopPane ;  //?��?̫  
    private JInternalFrame internalFrame ;  //?ݻ??  
  
    public JDeskTopPaneTest(){  
        //?��main??  
        setTitle("?��?̫����");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(800,600);  
        container = getContentPane();  
        desktopPane = new JDesktopPane();  
        desktopPane.setBackground(new Color(224,224,224));  
        container.add(desktopPane);  
          
        //?������?���?���죬��ʥ��main??  
        btn = new JButton("add");  
        btn.setActionCommand("add");  
        btn.addActionListener(this);  
        container.add(btn,BorderLayout.SOUTH);  
  
        try {     
       //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//Windows?̫     
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel") ; //Mac?̫     
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel") ;//Java��??̫     
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
        internalFrame.getContentPane().add(new JLabel("����!"),BorderLayout.CENTER);  
        desktopPane.add(internalFrame);  
        try{  
            internalFrame.setSelected(true);  
        }catch(Exception e){  
            JOptionPane.showMessageDialog(null,"???��");  
        }  
        frameCount++;  
    }  
    public static void main(String[] args){  
        new JDeskTopPaneTest().setVisible(true);  
    }  
}  