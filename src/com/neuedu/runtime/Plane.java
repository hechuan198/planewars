package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Plane extends BaseSprite implements Moveable, Drawable {

    private boolean up,right,down,left;

    private boolean fire;

    public static int hp = 3;

    private boolean bigFire;

    private Image image;

    private int bigBegin = 2;

    private List<Image> imageList = new ArrayList<>();

    private int speed = FrameConstant.GAME_SPEED*5;

    public Plane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
        imageList.add(ImageMap.get("myb_2_1"));
        imageList.add(ImageMap.get("myb_2_2"));
        imageList.add(ImageMap.get("myb_2_3"));
        imageList.add(ImageMap.get("myb_2_4"));
        imageList.add(ImageMap.get("myb_2_5"));
    }

    public Plane() {
        this((FrameConstant.FRANE_WIDTH-ImageMap.get("plane1").getWidth(null)/2)/2,FrameConstant.FRANE_HEIGHT-ImageMap.get("plane1").getHeight(null), ImageMap.get("plane1"));
    }

    //开火延迟
    int index = 0;
    //大招循环
    int index1 = 0;

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(image,getX(),getY(),image.getWidth(null)/2,image.getHeight(null)/2,null);

        fire(g);
        if (fire){
            index++;
            if (index >= 10){
                index = 0;
            }
        }

    }


    /**
     * 开火
     */
    public void fire(Graphics g){
        if (fire && index == 0){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.bullitList.add(new Bullit(getX() + image.getWidth(null)/3-ImageMap.get("myb1").getWidth(null),
                    getY() - ImageMap.get("myb1").getHeight(null),1));
        } else if (bigFire){
            // 绘画闪电
            if (bigFire){
                g.drawImage(imageList.get(index1++/15),getX() - 5,getY() - imageList.get(0).getHeight(null)*2,imageList.get(0).getWidth(null),imageList.get(0).getHeight(null)*2,null);
            }
            if (index1 >= 60){
                index1 = 0;
            }
        }
    }

    @Override
    public void move() {
        if (up) {
            setY(getY()-speed);
        }if (right) {
            setX(getX()+speed);
        }if (down) {
            setY(getY()+speed);
        }if (left) {
            setX(getX()-speed);
        }
        borderTesting();
//        if (hp == 0){
//            setY(FrameConstant.FRANE_HEIGHT-ImageMap.get("plane1").getHeight(null));
//            setX((FrameConstant.FRANE_WIDTH-ImageMap.get("plane1").getWidth(null)/2)/2);
//            hp = 10;
//        }

    }
    //边界检测
    public void borderTesting(){
        if (getX() <8){
            setX(8);
        }
        if (getX() > FrameConstant.FRANE_WIDTH-image.getWidth(null)/2-8){
            setX(FrameConstant.FRANE_WIDTH-image.getWidth(null)/2-8);
        }
        if (getY() < 30){
            setY(30);
        }
        if (getY() > FrameConstant.FRANE_HEIGHT - image.getHeight(null)/2){
            setY(FrameConstant.FRANE_HEIGHT - image.getHeight(null)/2);
        }
    }

    //按下
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_UP){
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            fire = true;
//            fire();
        }
        if (e.getKeyCode() == KeyEvent.VK_J && bigBegin > 0){
            bigFire = true;
            bigBegin--;

        }
    }
    //抬起
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            fire = false;
            index = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_J){
            bigFire = false;
            index = 0;
        }
    }

    //飞机复位
    public void restoration(){
        setY(FrameConstant.FRANE_HEIGHT-ImageMap.get("plane1").getHeight(null));
        setX((FrameConstant.FRANE_WIDTH-ImageMap.get("plane1").getWidth(null)/2)/2);
    }

    //设置矩形
    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY() ,
                image.getWidth(null)/2 ,
                image.getHeight(null)/2);
    }
    // 闪电矩形
    public Rectangle getBigBullitRectangle() {
        return new Rectangle(getX() ,getY() - imageList.get(0).getHeight(null)*2 ,
                imageList.get(0).getWidth(null) ,
                imageList.get(0).getHeight(null)*2);
    }



    //敌方飞机与我方飞机碰撞
    public void collisionTesting(List<EnemyPlane> enemyPlaneList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                enemyPlaneList.remove(enemyPlane);
                hp--;
                restoration();
            }
            if (enemyPlane.getRectangle().intersects(this.getBigBullitRectangle()) && bigFire) {
                enemyPlaneList.remove(enemyPlane);
                Bullit.addHp = true;
                Bullit.enemyX = enemyPlane.getX();
                Bullit.enemyY = enemyPlane.getY();
            }
        }

    }
    //敌方子弹与我方飞机碰撞
    public void collisionBullitTesting(List<EnemyBuillt> enemyBuilltList){
        GameFrame gameFrame = DataStore.get("gameframe");

        for (EnemyBuillt enemyBuillt : enemyBuilltList) {
            if (enemyBuillt.getRectangle().intersects(this.getRectangle())) {

                gameFrame.enemyBuilltList.remove(enemyBuillt);
                hp--;
                restoration();
            }
            if (enemyBuillt.getRectangle().intersects(this.getBigBullitRectangle()) && bigFire) {
                enemyBuilltList.remove(enemyBuillt);
            }

        }



    }

    //道具与我方飞机
    public void collisionPropTesting(List<Prop> propList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (Prop prop : propList) {
            if (prop.getRectangle().intersects(this.getRectangle())) {
                gameFrame.propList.remove(prop);
                hp++;

            }

        }
    }
    // boss子弹与我方飞机
    public void collisionBossBullitTesting(List<BossBullit> bossBullitList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (BossBullit bossBullit : bossBullitList) {
            if (bossBullit.getRectangle().intersects(this.getRectangle())) {
                gameFrame.bossBullitList.remove(bossBullit);
                hp--;
                restoration();
            }
            if (bossBullit.getRectangle().intersects(this.getBigBullitRectangle()) && bigFire) {
                bossBullitList.remove(bossBullit);
            }

        }
    }

    // boss 与我方飞机
    public void collisionBossTesting(Boss boss){


            if (boss.getRectangle().intersects(this.getRectangle())) {
                hp--;
                restoration();
            }
        if (boss.getRectangle().intersects(this.getBigBullitRectangle()) && bigFire) {
            boss.bossHp--;
        }


    }




}
