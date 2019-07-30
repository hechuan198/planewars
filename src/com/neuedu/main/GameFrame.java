package com.neuedu.main;

import com.neuedu.constant.FrameConstant;
import com.neuedu.runtime.Background;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {

    private Background background = new Background();

    //绘画
    @Override
    public void paint(Graphics g) {
        background.draw(g);
    }

    /**
     * 使用这个方法初始化窗口
     */
    public void init(){
        //设置窗口大小
        setSize(FrameConstant.FRANE_WIDTH,FrameConstant.FRANE_HEIGHT);
        //设置窗口居中
        setLocationRelativeTo(null);
        //启动窗口时不让有图片
        enableInputMethods(false);

        //设置点击关闭进程
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        //开启窗口
        setVisible(true);


        //线程刷新
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //刷新
                    repaint();
                    try {
//                        睡眠
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }

    private Image offScreenImage = null;//创建缓冲区
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(FrameConstant.FRANE_WIDTH,FrameConstant.FRANE_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();//创建离线图片的实例，在图片缓冲区绘图

        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);//将缓冲图片绘制到窗口目标
    }



}
