package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.io.FileReader;
import java.util.Random;


public class EnemyPlane extends BaseSprite implements Moveable, Drawable {

    private Image image;

    private Random random = new Random();

    public EnemyPlane() {
        this(0,0, ImageMap.get("ep1"));
    }

    public EnemyPlane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();
        fire();

    }


    public void fire(){
        if (random.nextInt(1000) > 995){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyBuilltList.add(new EnemyBuillt(getX() + image.getWidth(null)/2 - ImageMap.get("epb1").getWidth(null)/2,getY() + image.getHeight(null),ImageMap.get("epb1")));
        }
    }



    @Override
    public void move() {
        setY(getY() + FrameConstant.GAME_SPEED * 2);
        borderTesting();
    }


    public void borderTesting(){
        if (getY() > FrameConstant.FRANE_HEIGHT ) {
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyPlaneList.remove(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }
}
