package AWT;

import java.awt.*;
import java.awt.event.*;

public class Layout {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        frame.setSize(500,300);
        frame.setTitle("原神");
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
        /*
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(50);
        borderLayout.setVgap(50);
        frame.setLayout(new BorderLayout());
        frame.add(new Button("1"), BorderLayout.WEST);
        frame.add(new Button("2"), BorderLayout.EAST);
        frame.add(new Button("3"), BorderLayout.SOUTH);
        frame.add(new Button("4"), BorderLayout.NORTH);
        frame.add(new Button("5"), BorderLayout.CENTER);
        */
        /*
        frame.setLayout(new FlowLayout());   //采用流式布局
        frame.add(new Button("1"));
        frame.add(new Button("2"));
        frame.add(new Button("3"));
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
        */
        /*
        CardLayout layout = new CardLayout();
        frame.setLayout(layout);
        frame.add(new Label("1"));
        frame.add(new Label("2"));
        frame.setVisible(true);
        while (true) {
            Thread.sleep(3000);
            layout.next(frame);    //我们需要使用CardLayout对象来进行切换
        }
        */
        /*
        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(2);
        frame.setLayout(gridLayout);
        for (int i = 0; i < 10; i++)
            frame.add(new Button(i+""));
        */
        Panel top = new Panel();
        top.setBackground(Color.PINK);
        top.setLayout(new FlowLayout());    //面板默认会采用FlowLayout，所以说这里指不指定都一样
        for (int i = 0; i < 5; i++)    //面板就像窗口一样，可以设定布局和添加组件
            top.add(new Button("流式"+i));
        frame.add(top);

        Panel bottom = new Panel();
        bottom.setBackground(Color.ORANGE);
        bottom.setLayout(new GridLayout());   //下半部分我们采用网格布局
        for (int i = 0; i < 5; i++)
            bottom.add(new Button("网格"+i));
        frame.add(bottom);
        frame.setVisible(true);
    }
}
