package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Plane extends BaseSprite implements Moveable, Drawable {

    private boolean up,right,down,left;

    private boolean fire;

    private boolean bigFire;

    private Image image;

    private int speed = FrameConstant.GAME_SPEED*5;

    public Plane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    public Plane() {
        this((FrameConstant.FRANE_WIDTH-ImageMap.get("plane1").getWidth(null)/2)/2,FrameConstant.FRANE_HEIGHT-ImageMap.get("plane1").getHeight(null), ImageMap.get("plane1"));
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null)/2,image.getHeight(null)/2,null);
        move();
        fire();
        if (fire || bigFire){
            index++;
            if (index >= 10){
                index = 0;
            }
        }
    }

    private int index = 0;
    /**
     * 开火
     */
    public void fire(){
        if (fire && index == 0){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.bullitList.add(new Bullit(getX() + image.getWidth(null)/3-ImageMap.get("myb1").getWidth(null),
                    getY() - ImageMap.get("myb1").getHeight(null),ImageMap.get("myb1")));
        } else if (bigFire && index == 0){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.bullitList.add(new Bullit(getX() + image.getWidth(null)/4*3+20-ImageMap.get("myb2").getWidth(null),
                    getY() - ImageMap.get("myb2").getHeight(null)/2 -  25,ImageMap.get("myb2")));
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
        GameFrame gameFrame = DataStore.get("gameframe");
        if (gameFrame.gameOver){
            setY(FrameConstant.FRANE_HEIGHT-ImageMap.get("plane1").getHeight(null));
            setX((FrameConstant.FRANE_WIDTH-ImageMap.get("plane1").getWidth(null)/2)/2);
            gameFrame.gameOver = false;
        }

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
        if (e.getKeyCode() == KeyEvent.VK_J){
            bigFire = true;

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

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY() ,
                image.getWidth(null)/2,
                image.getHeight(null)/2);
    }

    //敌方飞机与我方飞机碰撞
    public void collisionTesting(List<EnemyPlane> enemyPlaneList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                enemyPlaneList.remove(enemyPlane);
                gameFrame.gameOver = true;
            }
        }

    }


}
