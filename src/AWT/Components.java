package AWT;

import java.awt.*;
import java.awt.event.*;

public class Components {

    public static void main(String[] args){
        Frame frame = new Frame();
        frame.setSize(500,300);
        frame.setTitle("原神");
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("窗口已关闭！");
                System.exit(0);
            }
        });
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标点击："+e.getX()+","+e.getY());
            }
        });
        frame.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getScrollAmount());
            }
        });
        frame.setVisible(true);

        frame.setLayout(null);
        Label label = new Label("Genshin");
        label.setLocation(215,30);
        label.setSize(100,20);
        label.setFont(new Font("SimSong", Font.BOLD, 15));
        label.setForeground(Color.BLUE);
        frame.add(label);

        TextField field = new TextField();
        field.setBounds(20, 50, 100, 25);
        field.setEchoChar('*');
        frame.add(field);

        Button button = new Button("Login");
        button.setBounds(20, 90, 100, 30);
        button.addActionListener(e -> System.out.println("输入的用户名是："+field.getText()));
        frame.add(button);

        Checkbox checkbox = new Checkbox("Remember");
        checkbox.setBounds(20, 70, 100, 30);
        frame.add(checkbox);

        CheckboxGroup group = new CheckboxGroup();

        Checkbox c1 = new Checkbox("AAA");
        c1.setBounds(20, 120, 100, 30);
        frame.add(c1);

        Checkbox c2 = new Checkbox("BBB");
        c2.setBounds(20, 140, 100, 30);
        frame.add(c2);

        c1.setCheckboxGroup(group);
        c2.setCheckboxGroup(group);


    }
}
