package ru.shishkin.maxim.updateFiles;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class App extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

    public static void main(String[] args) {
        NewThreadWithMusic t = new NewThreadWithMusic("MusicInBackground");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 525, 249);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u0423\u041A\u0410\u0416\u0418\u0422\u0415 \u041F\u0423\u0422\u042C \u041A \u0424\u0410\u0419\u041B\u0423:");
        label.setBounds(10, 11, 164, 14);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(184, 8, 315, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u0421\u041E\u0417\u0414\u0410\u0422\u042C \u0424\u0410\u0419\u041B");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String put = textField.getText().trim();
                if (put.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
                } else {
                    File newf = new File(put);

                    try {
                        newf.createNewFile();
                        JOptionPane.showMessageDialog(null, "Файл создан!", "Информация", 1);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Файл не создан!", "Ошибка", 0);
                    }

                }
            }
        });
        button.setBounds(10, 39, 147, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("\u0423\u0414\u0410\u041B\u0418\u0422\u042C \u0424\u0410\u0419\u041B");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String put = textField.getText().trim();
                if (put.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
                } else {
                    File newf = new File(put);
                    if (newf.exists()) {
                        newf.delete();
                        JOptionPane.showMessageDialog(null, "Файл удалён!", "Информация", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Файл не удалён!", "Ошибка", 0);
                    }
                }
            }
        });
        button_1.setBounds(10, 73, 147, 23);
        contentPane.add(button_1);

        JButton btnNewButton = new JButton("\u041F\u0415\u0420\u0418\u041C\u0415\u041D\u041E\u0412\u0410\u0422\u042C");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String put = textField.getText().trim();
                if (put.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
                } else {
                    File newf = new File(put);
                    if (newf.exists()) {
                        String newfilename = JOptionPane.showInputDialog("������� ����� ��� �����");
                        if (newfilename == null) {
                            newfilename = "";
                        }
                        if (!newfilename.trim().isEmpty()) {
                            File newfile = new File(newf.getParent() + "\\" + newfilename);
                            newf.renameTo(newfile);
                            JOptionPane.showMessageDialog(null, "���� ������������!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "���� �� ������!");
                    }
                }
            }
        });
        btnNewButton.setBounds(10, 108, 147, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u041F\u0420\u041E\u0427\u0418\u0422\u0410\u0422\u042C");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String stroka = textField.getText().trim();
                if (stroka.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
                } else {
                    File nf = new File(stroka);
                    if (nf.exists()) {
                        try {
                            InputStream in = new FileInputStream(stroka);
                            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
                            String st = "";
                            while (buf.ready()) {
                                st = st + (buf.readLine() + "\n");
                            }
                            textArea.setText(st);
                            buf.close();
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "���� �� ������!");
                    }
                }
            }
        });
        btnNewButton_1.setBounds(10, 147, 147, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u0417\u0410\u041F\u0418\u0421\u0410\u0422\u042C \u0412 \u0424\u0410\u0419\u041B");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String put = textField.getText().trim();
                if (put.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
                } else {
                    File nf = new File(put);
                    if (nf.exists()) {
                        try {
                            OutputStream st = new FileOutputStream(put);
                            BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(st));
                            buf.write(textArea.getText());
                            buf.close();
                            st.close();
                            JOptionPane.showMessageDialog(null, "���������� �������� � ����!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "���� �� ������!");
                    }
                }
            }
        });
        btnNewButton_2.setBounds(10, 184, 147, 23);
        contentPane.add(btnNewButton_2);
        textArea = new JTextArea();
        textArea.setBounds(167, 39, 332, 161);
        contentPane.add(textArea);
    }
}