package com.qujia.util;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class ViewUtil extends JFrame{
          public void showCenter(JFrame frame) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    frame.setLocation( (int) (width - frame.getWidth()) / 2,(int) (height - frame.getHeight()) / 2);
//                    show();
          }
          public void showCenter(JInternalFrame frame) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    frame.setLocation( (int) (width - frame.getWidth()) / 2,(int) (height - frame.getHeight()) / 2);
//                    show();
          }
}
