package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;

public class AddSubjectFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddSubjectFrm frame = new AddSubjectFrm();
                                                  frame.setVisible(true);
                                        } catch (Exception e) {
                                                  e.printStackTrace();
                                        }
                              }
                    });
          }

          /**
           * Create the frame.
           */
          public AddSubjectFrm() {
                    setTitle("\uAD50\uACFC\uBAA9\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 544, 372);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    JLabel label = new JLabel("\uACFC\uBAA9\uC774\uB984:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField = new JTextField();
                    textField.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField.setColumns(10);

                    JLabel lblNewLabel = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    lblNewLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_1 = new JTextField();
                    textField_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_1.setColumns(10);

                    JLabel lblNewLabel_1 = new JLabel(
                                        "\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JComboBox comboBox = new JComboBox();
                    comboBox.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uC804\uD544", "\uC804\uC120",
                                        "\uAD50\uD544", "\uAD50\uC120" }));

                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_2 = new JLabel(" \uB300     \uC0C1 :");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uB300\uD559", "\uB300\uD559\uC6D0" }));

                    JLabel lblNewLabel_3 = new JLabel(
                                        "\uB300\uC0C1\uD559\uB144:");
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JLabel lblNewLabel_5 = new JLabel(
                                        "\uB300\uC0C1\uD559\uAE30:");
                    lblNewLabel_5.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JLabel label_2 = new JLabel("\uAC1C\uC124\uC77C\uC9DC:");
                    label_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    DatePicker datePicker = new DatePicker();

                    JButton btnNewButton = new JButton(" \uD559   \uC778");
                    btnNewButton.setBackground(new Color(64, 224, 208));
                    btnNewButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JButton btnNewButton_1 = new JButton("\uCDE8  \uC18C");
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    btnNewButton_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {
                                        "3", "2", "1" }));

                    JComboBox comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {
                                        "1", "2", "3", "4",
                                        "\uB300\uD559\uAD001",
                                        "\uB300\uD559\uAD002",
                                        "\uB300\uD559\uAD003" }));
                    comboBox_3.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_4 = new JLabel(
                                        "\uC18C\uC18D\uD559\uACFC:");
                    lblNewLabel_4.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JComboBox comboBox_4 = new JComboBox();
                    comboBox_4.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_4.setModel(new DefaultComboBoxModel(
                                        new String[] { "\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC" }));

                    JComboBox comboBox_5 = new JComboBox();
                    comboBox_5.setFont(new Font("Dialog", Font.BOLD, 13));
                    comboBox_5.setModel(new DefaultComboBoxModel(new String[] {
                                        "1", "2" }));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGap(21)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addComponent(label)
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addComponent(textField,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        136,
                                                                                                                        Short.MAX_VALUE))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addComponent(lblNewLabel)
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addComponent(textField_1,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        136,
                                                                                                                        Short.MAX_VALUE))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.TRAILING)
                                                                                                                        .addComponent(lblNewLabel_4)
                                                                                                                        .addComponent(label_1))
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(comboBox_4,
                                                                                                                                            0,
                                                                                                                                            136,
                                                                                                                                            Short.MAX_VALUE)
                                                                                                                        .addComponent(comboBox_2,
                                                                                                                                            0,
                                                                                                                                            136,
                                                                                                                                            Short.MAX_VALUE)
                                                                                                                        .addComponent(btnNewButton)))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addComponent(lblNewLabel_1)
                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                    .addComponent(comboBox,
                                                                                                                        0,
                                                                                                                        136,
                                                                                                                        Short.MAX_VALUE)))
                                                            .addGap(69)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addComponent(lblNewLabel_5)
                                                                                                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                            .addComponent(comboBox_5,
                                                                                                                                                                0,
                                                                                                                                                                122,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addComponent(label_2)
                                                                                                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                            .addComponent(datePicker,
                                                                                                                                                                0,
                                                                                                                                                                0,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addComponent(lblNewLabel_3)
                                                                                                                                                                .addComponent(lblNewLabel_2))
                                                                                                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addComponent(comboBox_1,
                                                                                                                                                                                    0,
                                                                                                                                                                                    122,
                                                                                                                                                                                    Short.MAX_VALUE)
                                                                                                                                                                .addComponent(comboBox_3,
                                                                                                                                                                                    0,
                                                                                                                                                                                    122,
                                                                                                                                                                                    Short.MAX_VALUE))))
                                                                                                    .addGap(30))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addComponent(btnNewButton_1)
                                                                                                    .addContainerGap()))));
                    gl_contentPane.setVerticalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGap(23)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(comboBox_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label)
                                                                                .addComponent(textField,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(comboBox_3,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(textField_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createParallelGroup(
                                                                                                                        Alignment.BASELINE)
                                                                                                    .addComponent(lblNewLabel_5)
                                                                                                    .addComponent(comboBox_5,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.BASELINE)
                                                                                                                        .addComponent(lblNewLabel_1)
                                                                                                                        .addComponent(comboBox,
                                                                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                            GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGap(18)
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(datePicker,
                                                                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                            GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createParallelGroup(
                                                                                                                                                                Alignment.BASELINE)
                                                                                                                                            .addComponent(label_1)
                                                                                                                                            .addComponent(label_2)
                                                                                                                                            .addComponent(comboBox_2,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addComponent(comboBox_4,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.RELATED,
                                                                                37,
                                                                                Short.MAX_VALUE)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(btnNewButton_1)
                                                                                .addComponent(btnNewButton))
                                                            .addGap(37)));
                    contentPane.setLayout(gl_contentPane);
          }
}
