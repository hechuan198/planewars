package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.Count;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bullit extends BaseSprite implements Moveable, Drawable {

    private Image image;




    private int type;


    public static boolean addHp;

    public static int enemyX;
    public static int enemyY;



    private int speed = FrameConstant.GAME_SPEED * 10;

    public Bullit() {
        this(0,0,1);
    }

    public Bullit(int x, int y,int type) {
        super(x, y);
        this.type = type;
        init();
    }

    public void init(){
        if (type == 1){
            image = ImageMap.get("myb1");
        }else if (type == 2){

        }
    }



    @Override
    public void draw(Graphics g) {
        move();
        if (type == 1) {
            g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        }else if (type == 2){}
    }



    @Override
    public void move() {
        setY(getY() - speed);
        borderTesting();
    }


    //边缘检测
    public void borderTesting(){
        if (getY() < 30 - image.getHeight(null) ){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.bullitList.remove(this);
//            System.out.println(gameFrame.bullitList.size());



        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),
                getY(),
                image.getWidth(null),
                image.getHeight(null));
    }

    private Random random = new Random();

    // 我方子弹与敌方飞机碰撞
    public void collisionTesting(List<EnemyPlane> enemyPlaneList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                enemyPlane.hp--;
                if (enemyPlane.hp == 0) {
                    enemyPlaneList.remove(enemyPlane);
                    //道具

                        addHp = true;
                        enemyX = enemyPlane.getX();
                        enemyY = enemyPlane.getY();


                    Count.setCount(enemyPlane.type);
                }
                gameFrame.bullitList.remove(this);
                //计数


            }
        }

    }

    //我方子弹与敌方子弹碰撞
    public void collisionBullitTesting(List<EnemyBuillt> enemyBuilltList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (EnemyBuillt enemyBuillt : enemyBuilltList) {
            if (enemyBuillt.getRectangle().intersects(this.getRectangle())) {
                enemyBuilltList.remove(enemyBuillt);
                gameFrame.bullitList.remove(this);

            }
        }

    }



}
