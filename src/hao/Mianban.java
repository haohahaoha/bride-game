package hao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Constant{
    public static final int H = 1197;
}
public class Mianban extends JPanel implements MouseMotionListener, MouseListener {
        int y=663;
        private Ne niao;
        boolean begin = true;
        private static Image a=new ImageIcon("img/13.jpg").getImage();//背景
        private static Image b=new ImageIcon("img/11.jpg").getImage();//地1
        private static Image bb=new ImageIcon("img/1.jpg").getImage();//地2
        private static Image c=new ImageIcon("img/8.gif").getImage();//柱子
        private static Image cc=new ImageIcon("img/8.gif").getImage();//柱子
        private static Image d=new ImageIcon("img/2.png").getImage();//鸟
        private static Image e=new ImageIcon("img/3.gif").getImage();//死鸟
        private static Image f=new ImageIcon("img/5.png").getImage();//开始
        private static Image g=new ImageIcon("img/4.png").getImage();//结束
        public static int x=(b.getWidth(null)-Constant.H);
        public static int x1=x+b.getWidth(null);
        public int x2=600;
        public int x22=x2+c.getWidth(null);
        private List<Ne>nia;//鸟
        private List<Ne>zhuzi;//柱子
        private List<Ne> bombs;//死亡的鸟
        Mianban(){
            niao=new Ne(200,300,50,d);//鸟的初始位置
            nia=new ArrayList<Ne>();//鸟
            zhuzi=new ArrayList<Ne>();//柱子
            bombs=new ArrayList<Ne>();//死亡的鸟
            this.addMouseMotionListener(this);
            this.addMouseListener(this);
        }
        public void paint(Graphics g){
            super.paint(g);
            if(begin){
                g.drawImage(f, 0, 0, this);
                try {
                    Thread.sleep(3000);
                    begin = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            g.drawImage(a,0,0,this);
            g.drawImage(b,x,y,this);
            g.drawImage(bb,x1,y,this);
            g.drawImage(c,x2,0,this);//柱子1
            g.drawImage(c,x22,0,this);//柱子2
            niao.drawImg1(g);//画鸟
//            /*画死亡的鸟*/?
            for(int i=0;i<bombs.size();i++){
                Ne bomb=bombs.get(i);
                bomb.drawImg1(g);
            }
        }
        public void Pao(){
            new Thread() {
                public void run(){
                    while(true){
                        x--;
                        x1--;
                        if((x+b.getWidth(null))<=0)x=b.getWidth(null);
                        else if((x1+bb.getWidth(null))<=0)x1=b.getWidth(null);
                        x2--;
                        x22--;
                        if((x2+c.getWidth(null))<=0)x2=c.getWidth(null);
                        else if((x22+cc.getWidth(null))<=0)x22=c.getWidth(null);
                        for(int i=0;i<nia.size();i++){
                            for(int j=0;j<zhuzi.size();j++){
                                if(nia.get(i).isTouch(zhuzi.get(j))){
                                    Ne ne=zhuzi.get(j);
//                                    zhuzi.remove(j);
//                                    nia.remove(i);
                                    ne.setImg(e);
                                    ne.setDie(20);
                                    bombs.add(ne);
                                }
                            }
                        }
                        for(int i=0;i<bombs.size();i++) {
                            Ne bom = bombs.get(i);
                            bom.setDie(bom.getDie() - 1);
                            if (bom.getDie() <= 0) {
                                bombs.remove(i);
                                begin=false;
                                g.getGraphics();
                            }
                        }
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        repaint();
                    }
                }
            }.start();
        }

    @Override/*点击鼠标时调用*/
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    System.out.println("anxia");
    }

    @Override/*松开鼠标*/
    public void mouseReleased(MouseEvent e) {
    System.out.println("songkai");
    }

    @Override/* 鼠标出现在组件 中时调用*/
    public void mouseEntered(MouseEvent e) {

    }

    @Override/*鼠标移出组件时*/
    public void mouseExited(MouseEvent e) {

    }

    @Override/*鼠标按着拖动*/
    public void mouseDragged(MouseEvent e) {
    niao.setX(e.getX()-30);
    niao.setY(e.getY()-30);
    repaint();//刷新面板
    }

    @Override/*鼠标移动*/
    public void mouseMoved(MouseEvent e) {
    niao.setY(e.getY()-30);
    niao.setX(e.getX()-30);
    repaint();//刷新面板
    }
}


