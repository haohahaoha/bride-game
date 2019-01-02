package hao;

import java.awt.*;

public class Ne {
    private int x,y;
    private int h;
    private int r;
    private int f;//鸟的运动方向，0是上，1是下
    private Image img;
    private int die;
    private static final int UP=0;
    private static final int DOWN=1;
    public Ne(int x, int y, int h, int f, Image img){//判断鸟
        this.x=x;
        this.y=y;
        this.f=f;
        this.h=h;
        this.img=img;
    }
    public Ne(int x,int y,int h,Image img){//柱子,鸟
        this.x=x;
        this.y=y;
        this.h=h;
        this.img=img;
    }
    public void drawImg(Graphics g){//画柱子
        g.drawImage(img,x,y,40,h,null);
    }
    public void drawImg1(Graphics g){//画鸟
        g.drawImage(img,x,y,h,h,null);
    }
    public boolean isTouch(Ne ball){
        int x1=x+r;
        int y1=y+r;
        int x2=ball.getX()+ball.getR();
        int y2=ball.getY()+ball.getR();
        double s=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        double sr=r+ball.getR();
        return s<=sr;

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    public int getDie() {
        return die;
    }
    public void setDie(int die) { this.die = die; }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
