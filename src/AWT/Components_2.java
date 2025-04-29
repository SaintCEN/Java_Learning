package AWT;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Components_2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(200, 300);
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
                System.out.println("鼠标点击：" + e.getX() + "," + e.getY());
            }
        });

        MenuBar bar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem item = new MenuItem("1");
        menu.add(new CheckboxMenuItem("2"));
        item.addActionListener(e -> System.out.println("一号选项被点击了！"));
        menu.add(item);
        item.setShortcut(new MenuShortcut('A'));
        bar.add(menu);
        frame.setMenuBar(bar);

        PopupMenu menu2 = new PopupMenu();    //创建弹出菜单
        menu2.add(new MenuItem("1"));
        menu2.add(new MenuItem("2"));
        frame.add(menu2);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    menu2.show(frame, e.getX(), e.getY());   //要展示弹出菜单，我们只需要调用show方法即可
                }
            }
        });

        Panel mainPanel = new Panel(new BorderLayout());
        ScrollPane scrollPane = new ScrollPane();
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(10, 2)); // 10行2列

        for (int i = 0; i < 20; i++) {
            buttonPanel.add(new Button(""+i));
        }
        scrollPane.add(buttonPanel);

        // 将滚动面板添加到主面板的北部
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 创建列表并添加到主面板的南部
        List list = new List(4, true); // 显示4行，允许多选
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        mainPanel.add(list, BorderLayout.SOUTH);
        frame.add(mainPanel);

        Dialog dialog = new Dialog(frame, "Dialog", true);
        dialog.setSize(200, 80);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}