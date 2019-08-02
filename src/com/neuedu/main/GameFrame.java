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

    // 通关
    public Win win = new Win();

    //创建敌方飞机
    public final List<EnemyPlane> enemyPlaneList = new CopyOnWriteArrayList<>();

    //创建敌方子弹
    public final List<EnemyBuillt> enemyBuilltList = new CopyOnWriteArrayList<>();

    // 创建道具
    public List<Prop> propList = new CopyOnWriteArrayList<>();

    // 创建boss
    public Boss boss = new Boss();

    // 创建boss子弹集合
    public List<BossBullit> bossBullitList = new CopyOnWriteArrayList<>();

//    创建游戏结束绘画
    public GameOver gameOver = new GameOver();


    //绘画
    @Override
    public void paint(Graphics g) {
            background.draw(g);
            if (Plane.hp > 0 ) {
                plane.draw(g);
                if (boss.bossHp > 0) {
                    plane.collisionTesting(enemyPlaneList);
                    plane.collisionBullitTesting(enemyBuilltList);
                    plane.collisionPropTesting(propList);
                    plane.collisionBossBullitTesting(bossBullitList);
                    plane.collisionBossTesting(boss);
                }
            }

            for (Bullit bullit : bullitList) {
                bullit.draw(g);
//                bullit.collisionBullitTesting(enemyBuilltList);
                bullit.collisionTesting(enemyPlaneList);
            }
//            bigBullit.draw(g);

            for (EnemyPlane enemyPlane : enemyPlaneList) {
                enemyPlane.draw(g);

            }
            for (EnemyBuillt enemyBuillt : enemyBuilltList) {
                enemyBuillt.draw(g);
            }
            if (boss.bossHp != 0) {
                boss.draw(g);
                boss.collisionBullitTesting(bullitList);
            }
        for (BossBullit bossBullit : bossBullitList) {
            bossBullit.draw(g);
        }
        for (Prop prop : propList) {
            prop.draw(g);
        }
        if (Plane.hp <= 0) {
            gameOver.draw(g);
        }
        if (boss.bossHp == 0){
            win.draw(g);
        }







            g.setFont(new Font("楷体",Font.BOLD,25 ));
            g.setColor(Color.GREEN);
            g.drawString("得分：" + Count.getCount(),100,100);
            g.drawString("血量："+ plane.hp,100,130);
            g.drawString("BOSS血量："+ boss.bossHp,100,160);

            //随机添加飞机
            addPlane();
        //添加道具
        addHpProp();

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

        // 键盘监听器
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
        //飞机编号
        int enemyPlaneId = random.nextInt(2) + 1;
        GameFrame gameFrame = DataStore.get("gameframe");
        if ( random.nextInt(1000) > 985){
            gameFrame.enemyPlaneList.add(new EnemyPlane(random.nextInt(800 - ImageMap.get("ep"+enemyPlaneId).getWidth(null)),
                    -ImageMap.get("ep"+enemyPlaneId).getHeight(null), ImageMap.get("ep"+enemyPlaneId),enemyPlaneId));
        }




    }

    //添加道具
    public void addHpProp(){
        if (Bullit.addHp == true){

            propList.add(new Prop(Bullit.enemyX,Bullit.enemyY,1));
            Bullit.addHp = false;

        }
    }

}
