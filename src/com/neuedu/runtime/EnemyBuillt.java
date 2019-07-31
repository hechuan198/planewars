package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.List;

public class EnemyBuillt extends BaseSprite implements Moveable, Drawable {

    private Image image;

    private int speed = FrameConstant.GAME_SPEED * 3;

    public EnemyBuillt() {
        this(0,0, ImageMap.get("epb1"));
    }

    public EnemyBuillt(int x, int y, Image image) {
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
        setY(getY() + speed);

        borderTesting();

    }

    public void borderTesting(){
        if (getY() > FrameConstant.FRANE_HEIGHT ){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyBuilltList.remove(this);




        }
    }

    public void collisionTesting(Plane plane){
        GameFrame gameFrame = DataStore.get("gameframe");

            if (plane.getRectangle().intersects(this.getRectangle())) {
                gameFrame.gameOver = true;
                gameFrame.bullitList.remove(this);
            }


    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }
}
