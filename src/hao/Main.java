package hao;

import javax.swing.*;


class Windows extends JFrame {
    public Mianban m=new Mianban();
    Windows(){
        this.add(m);
    }
    public void show0(){
        this.setSize(1200,800);
        this.setTitle("打大鸟");
        m.Pao();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
public class Main {
    public static void main(String[] args) {
        Windows w=new Windows();
        w.show0();
    }

    }

