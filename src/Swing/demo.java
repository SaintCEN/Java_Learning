package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class demo {
    public static class SwingDemo extends JFrame {
        private JTextArea logArea;
        private JLabel statusBar;
        private JPopupMenu popupMenu;

        public SwingDemo() {
            // 窗口基本设置
            setTitle("Swing 综合示例");
            setSize(800, 600);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            setLocationRelativeTo(null);

            // 初始化组件
            createMenuBar();
            createToolBar();
            createMainPanel();
            createStatusBar();
            createPopupMenu();

            // 窗口关闭事件处理
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    confirmExit();
                }
            });
        }

        private void createMenuBar() {
            JMenuBar menuBar = new JMenuBar();

            // 文件菜单
            JMenu fileMenu = new JMenu("文件");
            JMenuItem exitItem = new JMenuItem("退出");
            exitItem.addActionListener(e -> confirmExit());
            fileMenu.add(exitItem);

            // 编辑菜单
            JMenu editMenu = new JMenu("编辑");
            JMenuItem clearItem = new JMenuItem("清空日志");
            clearItem.addActionListener(e -> logArea.setText(""));
            editMenu.add(clearItem);

            // 帮助菜单
            JMenu helpMenu = new JMenu("帮助");
            JMenuItem aboutItem = new JMenuItem("关于");
            aboutItem.addActionListener(e -> showAboutDialog());
            helpMenu.add(aboutItem);

            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(helpMenu);
            setJMenuBar(menuBar);
        }

        private void createToolBar() {
            JToolBar toolBar = new JToolBar();

            // 使用资源文件中的图标（需要准备图片文件）
            ImageIcon icon = new ImageIcon(String.valueOf(UIManager.getIcon("FileView.computerIcon")));
            JButton toolButton = new JButton(icon);
            toolButton.setToolTipText("工具栏按钮");
            toolButton.addActionListener(e -> appendLog("工具栏按钮被点击"));
            toolBar.add(toolButton);

            toolBar.addSeparator();

            JButton colorButton = new JButton("颜色");
            colorButton.addActionListener(e -> chooseColor());
            toolBar.add(colorButton);

            add(toolBar, BorderLayout.NORTH);
        }

        private void createMainPanel() {
            JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

            // 输入面板
            JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

            // 文本输入
            JTextField textField = new JTextField();
            JButton submitButton = new JButton("提交");
            submitButton.addActionListener(e -> {
                appendLog("提交内容: " + textField.getText());
                textField.setText("");
            });

            inputPanel.add(new JLabel("输入内容:"));
            inputPanel.add(textField);
            inputPanel.add(new JLabel());
            inputPanel.add(submitButton);

            // 选择组件
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"选项1", "选项2", "选项3"});
            comboBox.addActionListener(e -> appendLog("选择: " + comboBox.getSelectedItem()));

            JCheckBox checkBox = new JCheckBox("复选框");
            checkBox.addItemListener(e -> appendLog("复选框状态: " + checkBox.isSelected()));

            ButtonGroup radioGroup = new ButtonGroup();
            JRadioButton radio1 = new JRadioButton("单选1");
            JRadioButton radio2 = new JRadioButton("单选2");
            radioGroup.add(radio1);
            radioGroup.add(radio2);

            ItemListener radioListener = e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    appendLog("选择单选按钮: " + ((JRadioButton) e.getSource()).getText());
                }
            };
            radio1.addItemListener(radioListener);
            radio2.addItemListener(radioListener);

            JPanel selectionPanel = new JPanel(new GridLayout(0, 1));
            selectionPanel.add(new JLabel("下拉框:"));
            selectionPanel.add(comboBox);
            selectionPanel.add(checkBox);
            selectionPanel.add(radio1);
            selectionPanel.add(radio2);

            // 日志区域
            logArea = new JTextArea();
            logArea.setEditable(false);
            logArea.setComponentPopupMenu(popupMenu); // 绑定右键菜单

            // 布局组装
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.add(inputPanel, BorderLayout.NORTH);
            leftPanel.add(selectionPanel, BorderLayout.CENTER);

            mainPanel.add(leftPanel, BorderLayout.WEST);
            mainPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

            add(mainPanel);
        }

        private void createStatusBar() {
            statusBar = new JLabel("就绪");
            add(statusBar, BorderLayout.SOUTH);
        }

        private void createPopupMenu() {
            popupMenu = new JPopupMenu();
            JMenuItem copyItem = new JMenuItem("复制");
            JMenuItem pasteItem = new JMenuItem("粘贴");
            popupMenu.add(copyItem);
            popupMenu.add(pasteItem);
        }

        private void appendLog(String message) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
            logArea.append("[" + timestamp + "] " + message + "\n");
            statusBar.setText("最后操作: " + message);
        }

        private void chooseColor() {
            Color color = JColorChooser.showDialog(this, "选择颜色", Color.WHITE);
            if (color != null) {
                logArea.setBackground(color);
                appendLog("背景颜色更改为: " + color.toString());
            }
        }

        private void showAboutDialog() {
            JOptionPane.showMessageDialog(this,
                    "Swing 演示程序\n版本 1.0",
                    "关于",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        private void confirmExit() {
            int result = JOptionPane.showConfirmDialog(this,
                    "确定要退出程序吗？",
                    "确认退出",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new SwingDemo().setVisible(true);
            });
        }
    }
}