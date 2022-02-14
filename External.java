import java.io.File;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.*;

public class External {
    int x;
    JFrame frame1 = new JFrame("Varify valid user");
    JLabel label1 = new JLabel("Enter password");
    JTextField text1 = new JTextField();
    JButton button1 = new JButton("Open");

    public void frame() {
        label1.setBounds(10, 10, 200, 50);
        text1.setBounds(10, 70, 200, 50);
        button1.setBounds(10, 130, 100, 40);

        button1.setBackground(Color.green);
        button1.setForeground(Color.MAGENTA);
        label1.setBackground(Color.BLACK);
        text1.setBackground(Color.DARK_GRAY);
        text1.setForeground(Color.WHITE);
        label1.setForeground(Color.RED);

        Font font1 = new Font("Constantia", Font.BOLD, 20);
        button1.setFont(font1);
        text1.setFont(font1);
        label1.setFont(font1);

        frame1.add(button1);
        frame1.add(label1);
        frame1.add(text1);

        frame1.setSize(300,250);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(A1);
    }

    public void run() {
        try {
            String path = "F:";
            File f1 = new File(path);

            if (f1.exists()) {
                frame();
                if (x > 0) {
                    if (x == 12345) {
                        Desktop.getDesktop().open(f1);
                    } else {
                        System.out.println("Sorry wrong password you can not use the External Device");
                    }
                } else {
                    try {
                        Thread.sleep(12000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    run();
                }

            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                run();

            }

        } catch (Exception ee) {
            System.out.println(ee);
        }

    }

    public static void main(String[] args) {
        External obj = new External();
        obj.run();

    }

    ActionListener A1 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            button1.setBackground(Color.RED);
            String s = text1.getText();
            x = Integer.valueOf(s);
            String w="Loading....";
             text1.setText(w);

        }
    };
}