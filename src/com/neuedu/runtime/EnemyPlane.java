package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;

import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;

import java.util.Random;


public class EnemyPlane extends BaseSprite implements Moveable, Drawable {

    private Image image;

    int type;

    private Random random = new Random();

    private boolean right;

//    private boolean addHp;

    int hp;


    public EnemyPlane() {
        this(0,0, ImageMap.get("ep1"),1);
        init();

    }

    public EnemyPlane(int x, int y, Image image,int type) {
        super(x, y);
        this.image = image;
        this.type = type;
        init();
    }

    public void init(){
        if (type == 1){
            hp = 1;
        }else if(type == 2){
            hp = 4;
        }
    }



    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();
        fire();

    }


    public void fire(){
        if (random.nextInt(1000) > 985){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyBuilltList.add(new EnemyBuillt(getX() + image.getWidth(null)/2 - ImageMap.get("epb1").getWidth(null)/2,getY() + image.getHeight(null),ImageMap.get("epb1")));
        }
    }



    @Override
    public void move() {
        if (type == 1) {
            setY(getY() + FrameConstant.GAME_SPEED * 10);
        }else if (type == 2){
            if (right){
                setY(getY() + FrameConstant.GAME_SPEED );
                setX(getX() + FrameConstant.GAME_SPEED * 2);
            }else{
                setY(getY() + FrameConstant.GAME_SPEED );
                setX(getX() - FrameConstant.GAME_SPEED * 2);
            }
        }
        borderTesting();
    }

//  边缘检测
    public void borderTesting(){

        if (getX() + image.getWidth(null) >= FrameConstant.FRANE_WIDTH ){
            right = false;
        }else if (getX() < 10){
            right = true;
        }

        if (getY() > FrameConstant.FRANE_HEIGHT ) {
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyPlaneList.remove(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }


    // 我方子弹与敌方飞机碰撞
//    public void collisionTesting(List<Bullit> bullitList){
//        GameFrame gameFrame = DataStore.get("gameframe");
//        for (Bullit bullit : bullitList) {
//            if (bullit.getRectangle().intersects(this.getRectangle())) {
//                bullitList.remove(bullit);
//                gameFrame.enemyPlaneList.remove(this);
//                //计数
//                Count.setCount();
//                //道具
//                if (random.nextInt(100) > 0){
//                    addHp = true;
//                }
//
//
//            }
//        }
//
//    }
}
