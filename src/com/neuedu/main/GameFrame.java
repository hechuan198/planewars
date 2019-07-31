package com.neuedu.main;

import com.neuedu.constant.FrameConstant;
import com.neuedu.runtime.*;
import com.neuedu.util.Count;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameFrame extends Frame {
    //创建背景
    private Background background = new Background();

    //创建我方飞机
    private Plane plane = new Plane();

    //创建我方子弹
    public final List<Bullit> bullitList = new CopyOnWriteArrayList<>();

    //创建敌方飞机
    public final List<EnemyPlane> enemyPlaneList = new CopyOnWriteArrayList<>();

    //创建敌方子弹
    public final List<EnemyBuillt> enemyBuilltList = new CopyOnWriteArrayList<>();

    // 我方死亡
    public boolean gameOver = false;

    //绘画
    @Override
    public void paint(Graphics g) {
            background.draw(g);

            plane.draw(g);
            plane.collisionTesting(enemyPlaneList);


            for (Bullit bullit : bullitList) {
                bullit.draw(g);
            }

            for (EnemyPlane enemyPlane : enemyPlaneList) {
                enemyPlane.draw(g);
            }
            for (EnemyBuillt enemyBuillt : enemyBuilltList) {
                enemyBuillt.draw(g);
            }

            for (Bullit bullit : bullitList) {
                bullit.collisionTesting(enemyPlaneList);
                bullit.collisionBullitTesting(enemyBuilltList);
            }

            for (EnemyBuillt enemyBuillt : enemyBuilltList) {
                enemyBuillt.collisionTesting(plane);
            }



            g.setColor(Color.GREEN);
            g.drawString("击毁敌军数：" + Count.getCount(),200,200);
        addPlane();

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

        //设置点击关闭进程 窗口监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                plane.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {

                plane.keyReleased(e);

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

    public Random random = new Random();

    // 添加敌方飞机
    public void addPlane(){
        GameFrame gameFrame = DataStore.get("gameframe");
        while ( random.nextInt(1000) > 985){
            gameFrame.enemyPlaneList.add(new EnemyPlane(random.nextInt(800 - ImageMap.get("ep1").getWidth(null)),-ImageMap.get("ep1").getHeight(null), ImageMap.get("ep1")));
        }




    }



}
