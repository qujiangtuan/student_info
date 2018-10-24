package com.qujia.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.eltima.components.ui.DatePicker;


public class DateUtil extends DatePicker{
   // public static void main(String[] args) {

//        JFrame f = new JFrame("LoL");
//        f.setSize(400, 300);
//        f.setLocation(200, 200);
//        f.setLayout(null);
//
//        final DatePicker datepick;
//        datepick = getDatePicker();
//        f.add(datepick);
//
//        JButton b = new JButton("获取时间");
//        b.setBounds(137, 183, 100, 30);
//        f.add(b);
//
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(f, "获取控件中的日期：" + datepick.getValue());
//                System.out.println(datepick.getValue());//这是一个java.util.Date对象
//            }
//        });
//
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        f.setVisible(true);
//    }

   
    public static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyyMMdd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };
    //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        datepick.setLocation(137, 83);//设置起始位置
        /*
        //也可用setBounds()直接设置大小与位置
        datepick.setBounds(137, 83, 177, 24);
        */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CANADA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
    public static  JSpinner spinnerHour( ){
              
//              SpinnerDateModel hourModel=new SpinnerDateModel();
//              JSpinner spinner = new JSpinner(hourModel);
              JSpinner spinner = new JSpinner( );
              spinner.setModel(new SpinnerDateModel(new Date(1536505200000L), new Date(1536505200000L), new Date(1536505200000L), Calendar.HOUR));
              spinner.setValue(new Date());
              JSpinner.DateEditor editor=new JSpinner.DateEditor(spinner,"HH:MM");
              spinner.setEditor(editor);
              return spinner;
    }
    public void spinnerHour2( JSpinner spinner){
              
//            SpinnerDateModel hourModel=new SpinnerDateModel();
//            spinner = new JSpinner(hourModel);
            //spinner.setModel(new SpinnerDateModel(new Date(1536505200000L), new Date(1536505200000L), new Date(1536505200000L), Calendar.HOUR));
           // spinner.setValue(new Date());
            JSpinner.DateEditor editor=new JSpinner.DateEditor(spinner,"HH:MM");
            spinner.setEditor(editor);
  }
    public String Date2String(Date date){
//              Date date = (Date) spinner.getValue();
              SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
              String dateString = formatter.format(date);
              return dateString;
    }
    //금년 년도
    public static String getThisYear(){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            String dateString = formatter.format(date);
            return dateString;
  }
  //get 학기 
    public static int getTerm(){
              List<Integer> nextTermList = Arrays.asList(3,4,5,6,7);
              Date nowDate = new Date();
              int month = nowDate.getMonth();
              int day = nowDate.getDay();
              return (nextTermList.contains(month) || (month == 2 && day > 15) || (month == 8 && day < 15)) ? 1 : 2;
          }
    /*调用方法
     *  DateUtil du=new DateUtil();
                    //JSpinner spinner = new JSpinner();
                    JSpinner spinner=du.spinnerHour();
     */
    /*
     * private JSpinner spinner_1_1,spinner_2_1,spinner_3_1,spinner_4_1,spinner_5_1,spinner_6_1,spinner_7_1,
          spinner_1_2,spinner_2_2,spinner_3_2,spinner_4_2,spinner_5_2,spinner_6_2,spinner_7_2;
          private JCheckBox checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6,checkBox_7;
          private JLabel lebel_name, leabel_no,leabel_pro,leabel_date,leabel_schYear,leabel_term;
          private JComboBox comboBox_name,comboBox_pro,comboBox_schYear,comboBox_term;
          private  JComboBox comboBox_one,comboBox_two,comboBox_three,comboBox_four,comboBox_five,comboBox_six,comboBox_seven;
     */
    /*
     * spinner_1.setModel(new SpinnerDateModel(new Date(1536505200000L), new Date(1536505200000L), new Date(1536505200000L), Calendar.HOUR));
    spinner_1_1=dux.spinnerHour();
    spinner_1_2=dux.spinnerHour();
    spinner_2_1=dux.spinnerHour();
    spinner_2_2=dux.spinnerHour();
    spinner_3_1=dux.spinnerHour();
    spinner_3_2=dux.spinnerHour();
    spinner_4_1=dux.spinnerHour();
    spinner_4_2=dux.spinnerHour();
    spinner_5_1=dux.spinnerHour();
    spinner_5_2=dux.spinnerHour();
    spinner_6_1=dux.spinnerHour();
    spinner_6_2=dux.spinnerHour();
    spinner_7_1=dux.spinnerHour();
    spinner_7_2=dux.spinnerHour();
    
    */
    
    
    /*
     * 表格多选设置值
     * DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                    int rowCount = table_1.getModel().getRowCount();
                    for (int i = 0; i < rowCount; i++) {
                              model.setValueAt(new Boolean(false), i, 0);
                    }
     */
//    table_1.addMouseListener(new MouseListener() {
//              
//              @Override
//              public void mouseReleased(MouseEvent e) {
//                        // TODO Auto-generated method stub
//                        
//              }
//              
//              @Override
//              public void mousePressed(MouseEvent e) {
//                        // TODO Auto-generated method stub
//                        
//              }
//              
//              @Override
//              public void mouseExited(MouseEvent e) {
//                        // TODO Auto-generated method stub
//                        
//              }
//              
//              @Override
//              public void mouseEntered(MouseEvent e) {
//                        // TODO Auto-generated method stub
//                        
//              }
//              
//              @Override
//              public void mouseClicked(MouseEvent e) {
//                        // TODO Auto-generated method stub
//                        if(e.getClickCount()==1){
//                                  int columnIndex=table_1.columnAtPoint(e.getPoint());
//                                  int rowIndex=table_1.rowAtPoint(e.getPoint());
//                                  if(columnIndex==0){
//                                            if(table_1.getValueAt(rowIndex, columnIndex)==null){
//                                                      table_1.setValueAt(false, rowIndex, columnIndex);
//                                            }
//                                            if(((Boolean)table_1.getValueAt(rowCount, columnIndex)).booleanValue()){
//                                                      table_1.setValueAt(false, rowIndex, columnIndex);
//                                            }else{
//                                                      table_1.setValueAt(true, rowIndex, columnIndex);
//                                            }
//                                  }
//                        }
//              }
//    });
 // 数据库中获取日期
    public static String getTodayDate( ) {
              String stringDate;
              SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
              Date date;
              date=new Date();
              stringDate = form.format(date);
              return stringDate;
    }
}