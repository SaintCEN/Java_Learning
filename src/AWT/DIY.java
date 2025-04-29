package AWT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class DIY {
    public static class ImageView extends Component {
        /*
        public abstract class Graphics {
   	//移动画笔原点到指定坐标，默认是(0,0)
    public abstract void translate(int x, int y);
    //设定画笔颜色
    public abstract void setColor(Color c);
    //设置为普通绘画模式
    public abstract void setPaintMode();
    //交替颜色模式，比较高级，小伙伴自行了解
    public abstract void setXORMode(Color c1);
    //设置字体，绘制文本内容时就按照这个字体来绘制
    public abstract void setFont(Font font);

    //设置裁剪区域，一旦设置裁剪区域，那么裁剪区域以外的地方即使绘制，也不会生效，绘制
  	//只会在裁剪区域内生效（有点像图层蒙版？）
    public abstract void setClip(int x, int y, int width, int height);
    //设定自定义形状的裁剪区域
    public abstract void setClip(Shape clip);

    //拷贝指定区域的内容到另一个位置
    public abstract void copyArea(int x, int y, int width, int height,
                                  int dx, int dy);
    //绘制直线
    public abstract void drawLine(int x1, int y1, int x2, int y2);
    //填充矩形区域
    public abstract void fillRect(int x, int y, int width, int height);
    //绘制矩形边框
    public void drawRect(int x, int y, int width, int height);
		//绘制圆角矩形边框
    public abstract void drawRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight);
    //填充圆角矩形区域
    public abstract void fillRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight);
    //绘制3D矩形边框（其实就是加了个深色和浅色边框，有一个视觉效果罢了）
    public void draw3DRect(int x, int y, int width, int height,
                           boolean raised);
    //填充3D矩形区域（同上）
    public void fill3DRect(int x, int y, int width, int height,
                           boolean raised);
    //绘制椭圆形边框
    public abstract void drawOval(int x, int y, int width, int height);
    //填充椭圆形区域
    public abstract void fillOval(int x, int y, int width, int height);
    //绘制弧线边框
    public abstract void drawArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle);
		//填充扇形区域
    public abstract void fillArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle);
    //绘制折线（需要提供多个坐标）
    public abstract void drawPolyline(int xPoints[], int yPoints[],
                                      int nPoints);
		//绘制多边形边框
    public abstract void drawPolygon(int xPoints[], int yPoints[],
                                     int nPoints);
    //填充多边形区域
    public abstract void fillPolygon(int xPoints[], int yPoints[],
                                     int nPoints);
    //绘制文本
    public abstract void drawString(String str, int x, int y);
   	//绘制图片（绘制大小为图片原本大小）
    public abstract boolean drawImage(Image img, int x, int y,
                                      ImageObserver observer);
   	//绘制按自定义大小缩放后的图片
    public abstract boolean drawImage(Image img, int x, int y,
                                      int width, int height,
                                      ImageObserver observer);
    //绘制图片时如果是透明部分则采用背景颜色填充
    public abstract boolean drawImage(Image img, int x, int y,
                                      Color bgcolor,
                                      ImageObserver observer);
    //绘制按自定义大小缩放后带背景颜色的图片
    public abstract boolean drawImage(Image img, int x, int y,
                                      int width, int height,
                                      Color bgcolor,
                                      ImageObserver observer);
    //对原本的图片按照起始坐标和尺寸进行裁剪后，再以给定大小绘制到给定位置
    public abstract boolean drawImage(Image img,
                                      int dx1, int dy1, int dx2, int dy2,
                                      int sx1, int sy1, int sx2, int sy2,
                                      ImageObserver observer);
    //累了
    public abstract boolean drawImage(Image img,
                                      int dx1, int dy1, int dx2, int dy2,
                                      int sx1, int sy1, int sx2, int sy2,
                                      Color bgcolor,
                                      ImageObserver observer);
        */
        public ImageView(){

        }
        @Override
        public void paint(Graphics g){ // 重写绘制
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.RED);    //画笔改成红色
            //在中间画个圆角矩形边框
            g.drawRoundRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2, 30, 30);
        }
        }
        public static void main(String[] args) throws IOException {
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

            frame.add(new ImageView());
            Image image = ImageIO.read(new File("src/AWT/test.png"));
            frame.setIconImage(image);
            frame.setShape(new RoundRectangle2D.Double(0, 0, 200, 200, 20, 20));
            frame.setVisible(true);
        }
    }
