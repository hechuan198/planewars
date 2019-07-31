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
import java.util.List;


public class Bullit extends BaseSprite implements Moveable, Drawable {

    private Image image;



    private int speed = FrameConstant.GAME_SPEED * 5;

    public Bullit() {
        this(0,0, ImageMap.get("myb1"));
    }

    public Bullit(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();

    }

    @Override
    public void move() {
        setY(getY() - speed);
        borderTesting();
    }

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
    // 我方子弹与敌方飞机碰撞
    public void collisionTesting(List<EnemyPlane> enemyPlaneList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                enemyPlaneList.remove(enemyPlane);
                gameFrame.bullitList.remove(this);
                Count.setCount();
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
