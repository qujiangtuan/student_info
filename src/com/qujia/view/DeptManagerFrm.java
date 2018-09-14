package com.qujia.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ClassDao;
import com.qujia.model.StudentClass;

public class DeptManagerFrm extends JInternalFrame {
          private JTextField searchClassNameTextField;
          private JTable classListTable;
          private JTextField textField;
          private JTextField textField_1;
          private JTextField textField_2;
          private JTextField textField_3;
          private JTextField textField_4;
          private JTextField textField_5;
          private JTextField textField_6;

          /**
           * Launch the application.
           */
          // public static void main(String[] args) {
          // EventQueue.invokeLater(new Runnable() {
          // public void run() {
          // try {
          // ClassManagerFrm frame = new ClassManagerFrm();
          // frame.setVisible(true);
          // } catch (Exception e) {
          // e.printStackTrace();
          // }
          // }
          // });
          // }

          /**
           * Create the frame.
           */
          public DeptManagerFrm() {
                    setTitle("학과과리");
                    setBounds(20, 20, 868, 508);
                    setClosable(true);
                    setIconifiable(true);

                    // ViewUtil vu=new ViewUtil();
                    // vu.showCenter(this);
                    JLabel classNameLabel = new JLabel("학과이름:");
                    classNameLabel.setIcon(new ImageIcon(DeptManagerFrm.class
                                        .getResource("/images/className.png")));
                    classNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    searchClassNameTextField = new JTextField();
                    searchClassNameTextField.setFont(new Font("나눔명조",
                                        Font.PLAIN, 12));
                    searchClassNameTextField.setColumns(10);

                    JButton searchButton = new JButton("검색");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        StudentClass sc = new StudentClass();
                                        String str = searchClassNameTextField
                                                            .getText()
                                                            .toString();
                                        sc.setName(str);
                                        setTable(sc);
                              }
                    });
                    searchButton.setIcon(new ImageIcon(DeptManagerFrm.class
                                        .getResource("/images/search.png")));
                    searchButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JScrollPane scrollPane = new JScrollPane();

                    JLabel lblNewLabel = new JLabel("학과코드:");
                    lblNewLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField = new JTextField();
                    textField.setColumns(10);

                    JLabel label = new JLabel("학과이름:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_1 = new JTextField();
                    textField_1.setColumns(10);

                    JLabel lblNewLabel_1 = new JLabel("모집인원:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_2 = new JTextField();
                    textField_2.setColumns(10);

                    JLabel label_1 = new JLabel("수학년학\r\n:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_3 = new JTextField();
                    textField_3.setColumns(10);

                    JLabel lblNewLabel_2 = new JLabel("재학년한:");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_4 = new JTextField();
                    textField_4.setColumns(10);

                    JLabel lblNewLabel_3 = new JLabel("학과설명:");
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JTextArea textArea = new JTextArea();

                    JButton btnNewButton = new JButton("수  정");
                    btnNewButton.setBackground(new Color(50, 205, 50));
                    btnNewButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JButton btnNewButton_1 = new JButton("삭  제\r\n");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                              }
                    });
                    btnNewButton_1.setBackground(new Color(255, 140, 0));
                    btnNewButton_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JLabel lblNewLabel_4 = new JLabel("소속대학:");
                    lblNewLabel_4.setFont(new Font("휴먼고딕", Font.BOLD, 13));

                    textField_5 = new JTextField();
                    textField_5.setColumns(10);

                    JLabel label_2 = new JLabel("졸업이수학점:");
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));

                    textField_6 = new JTextField();
                    textField_6.setColumns(10);
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(groupLayout
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout
                                                            .createSequentialGroup()
                                                            .addGroup(groupLayout
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(groupLayout
                                                                                                    .createSequentialGroup()
                                                                                                    .addGap(52)
                                                                                                    .addComponent(classNameLabel)
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addComponent(searchClassNameTextField,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        241,
                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                    .addGap(38)
                                                                                                    .addComponent(searchButton))
                                                                                .addGroup(groupLayout
                                                                                                    .createSequentialGroup()
                                                                                                    .addGap(35)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addComponent(lblNewLabel)
                                                                                                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                            .addComponent(textField,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.TRAILING)
                                                                                                                                                                .addComponent(lblNewLabel_4)
                                                                                                                                                                .addComponent(label_1))
                                                                                                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addComponent(textField_5,
                                                                                                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(textField_3,
                                                                                                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                    GroupLayout.PREFERRED_SIZE))))
                                                                                                    .addGap(43)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addComponent(label)
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addComponent(textField_1,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addComponent(lblNewLabel_2)
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addComponent(textField_4,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE)))
                                                                                                                                            .addGap(48)
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.TRAILING)
                                                                                                                                                                .addComponent(lblNewLabel_1)
                                                                                                                                                                .addComponent(lblNewLabel_3)))
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addComponent(label_2,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                94,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                            .addGap(4)
                                                                                                                                            .addComponent(textField_6,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(textField_2,
                                                                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                            GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addComponent(textArea,
                                                                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                                                                            166,
                                                                                                                                            GroupLayout.PREFERRED_SIZE))
                                                                                                    .addPreferredGap(ComponentPlacement.RELATED,
                                                                                                                        31,
                                                                                                                        Short.MAX_VALUE)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(btnNewButton_1)
                                                                                                                        .addComponent(btnNewButton))
                                                                                                    .addGap(96))
                                                                                .addGroup(groupLayout
                                                                                                    .createSequentialGroup()
                                                                                                    .addContainerGap()
                                                                                                    .addComponent(scrollPane,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        822,
                                                                                                                        GroupLayout.PREFERRED_SIZE)))
                                                            .addGap(36)));
                    groupLayout.setVerticalGroup(groupLayout
                                        .createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout
                                                            .createSequentialGroup()
                                                            .addGap(39)
                                                            .addGroup(groupLayout
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(classNameLabel)
                                                                                .addComponent(searchClassNameTextField,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    29,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(searchButton))
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addComponent(scrollPane,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                219,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(groupLayout
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(groupLayout
                                                                                                    .createSequentialGroup()
                                                                                                    .addGap(18)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(lblNewLabel)
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createParallelGroup(
                                                                                                                                                                Alignment.BASELINE)
                                                                                                                                            .addComponent(textField,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                            .addComponent(label)
                                                                                                                                            .addComponent(textField_1,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                            .addComponent(lblNewLabel_1)
                                                                                                                                            .addComponent(textField_2,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                    .addGroup(groupLayout
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGap(23)
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createParallelGroup(
                                                                                                                                                                                                        Alignment.BASELINE)
                                                                                                                                                                                    .addComponent(label_1)
                                                                                                                                                                                    .addComponent(textField_3,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createParallelGroup(
                                                                                                                                                                                                        Alignment.BASELINE)
                                                                                                                                                                                    .addComponent(lblNewLabel_2)
                                                                                                                                                                                    .addComponent(textField_4,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                    .addComponent(lblNewLabel_3)))
                                                                                                                                            .addGap(18)
                                                                                                                                            .addGroup(groupLayout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createParallelGroup(
                                                                                                                                                                                                        Alignment.BASELINE)
                                                                                                                                                                                    .addComponent(lblNewLabel_4)
                                                                                                                                                                                    .addComponent(textField_5,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGroup(groupLayout
                                                                                                                                                                                    .createParallelGroup(
                                                                                                                                                                                                        Alignment.BASELINE)
                                                                                                                                                                                    .addComponent(label_2,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        19,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                    .addComponent(textField_6,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))))
                                                                                                                        .addGroup(groupLayout
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGap(30)
                                                                                                                                            .addComponent(textArea,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                59,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                    .addContainerGap(47,
                                                                                                                        Short.MAX_VALUE))
                                                                                .addGroup(Alignment.TRAILING,
                                                                                                    groupLayout.createSequentialGroup()
                                                                                                                        .addGap(3)
                                                                                                                        .addComponent(btnNewButton)
                                                                                                                        .addGap(21)
                                                                                                                        .addComponent(btnNewButton_1)
                                                                                                                        .addGap(61)))));

                    classListTable = new JTable();
                    classListTable.setRowHeight(25);
                    classListTable.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectedTableRow(me);
                              }
                    });
                    classListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    classListTable.setModel(new DefaultTableModel(
                                        new Object[][] {
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null },
                                                            {
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null,
                                                                                null }, },
                                        new String[] {
                                                            "\uD559\uACFC\uCF54\uB4DC",
                                                            "\uD559\uACFC\uC774\uB984",
                                                            "\uC18C\uC18D\uB300\uD559",
                                                            "\uBAA8\uC9D1\uC778\uC6D0",
                                                            "\uC7AC\uD559\uC778\uC6D0",
                                                            "\uB4F1\uB85D\uC77C\uC9DC",
                                                            "\uC878\uC5C5\uC774\uC218\uD559\uC810",
                                                            "\uC218\uD559\uB144\uD559",
                                                            "\uC7AC\uD559\uB144\uD55C",
                                                            "\uD559\uACFC\uC124\uBA85" }) {
                              boolean[] columnEditables = new boolean[] { true,
                                                  false, true, true, true,
                                                  true, true, true, true, false };

                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    classListTable.getColumnModel().getColumn(0)
                                        .setPreferredWidth(80);
                    classListTable.getColumnModel().getColumn(1)
                                        .setPreferredWidth(112);
                    classListTable.getColumnModel().getColumn(2)
                                        .setPreferredWidth(81);
                    classListTable.getColumnModel().getColumn(3)
                                        .setPreferredWidth(95);
                    classListTable.getColumnModel().getColumn(4)
                                        .setPreferredWidth(79);
                    classListTable.getColumnModel().getColumn(5)
                                        .setPreferredWidth(108);
                    classListTable.getColumnModel().getColumn(6)
                                        .setPreferredWidth(133);
                    classListTable.getColumnModel().getColumn(7)
                                        .setPreferredWidth(93);
                    classListTable.getColumnModel().getColumn(8)
                                        .setPreferredWidth(88);
                    classListTable.getColumnModel().getColumn(9)
                                        .setPreferredWidth(129);
                    scrollPane.setViewportView(classListTable);
                    getContentPane().setLayout(groupLayout);
                    // set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    classListTable.setDefaultRenderer(Object.class, cr);

                    setTable(new StudentClass());
          }

          // 选中表格一行出发事件
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel dft = (DefaultTableModel) classListTable
                                        .getModel();
                    // 得到选中表格中的哪一行，那一列的值
                    // editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(),
                    // 1).toString());
                    // editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(),
                    // 2).toString());
          }

          private void setTable(StudentClass studentClsss) {
                    DefaultTableModel dft = (DefaultTableModel) classListTable
                                        .getModel();
                    // 清空列表
                    dft.setRowCount(0);
                    // 得到列表内容，并且遍历
                    ClassDao classDao = new ClassDao();
                    List<StudentClass> classList = classDao
                                        .getClassList(studentClsss);
                    for (StudentClass sc : classList) {
                              // Vector类 是在 java 中可以实现自动增长的对象数组
                              Vector v = new Vector();
                              v.add(sc.getId());
                              v.add(sc.getName());
                              v.add(sc.getInfo());
                              dft.addRow(v);
                    }
                    classDao.closeDao();
          }
}
