package com.qujia.util;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import com.qujia.view.SearchAddressFrm;
import com.qujia.view.SearchDeptFrm;
import com.qujia.view.SearchOrgFrm;
import com.qujia.view.SearchSuperiorFrm;

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
          public void showCenter(SearchDeptFrm searchDeptFrm) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    searchDeptFrm.setLocation( (int) (width - searchDeptFrm.getWidth()) / 2,(int) (height - searchDeptFrm.getHeight()) / 2);
//                    show();
          }
          public void showCenter(SearchAddressFrm searchAddressFrm) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    searchAddressFrm.setLocation( (int) (width - searchAddressFrm.getWidth()) / 2,(int) (height - searchAddressFrm.getHeight()) / 2);
//                    show();
          }
          public void showCenter(SearchSuperiorFrm searchSuperiorFrm) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    searchSuperiorFrm.setLocation( (int) (width - searchSuperiorFrm.getWidth()) / 2,(int) (height - searchSuperiorFrm.getHeight()) / 2);
//                    show();
          }
          public void showCenter(SearchOrgFrm searchOrgFrm) {
                    // TODO Auto-generated method stub
                    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                    searchOrgFrm.setLocation( (int) (width - searchOrgFrm.getWidth()) / 2,(int) (height - searchOrgFrm.getHeight()) / 2);
//                    show();
          }
}
