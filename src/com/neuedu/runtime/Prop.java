package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;


public class Prop extends BaseSprite implements Moveable, Drawable {


    private boolean right;

    private int type = 1;

    public Prop() {
        this(0, 0,1);
    }

    public Prop(int x, int y, int type) {
        super(x, y);

        this.type = type;
    }

    private int index = 10;



    @Override
    public void draw(Graphics g) {
        move();
        if (type == 1) {
            g.drawImage(ImageMap.get("addHp"+index/10), getX(), getY(),ImageMap.get("addHp"+index/10).getWidth(null), ImageMap.get("addHp"+index/10).getHeight(null), null);

            index++;

            if (index > 40){
                index = 10;
            }
        }

        borderTesting();
    }

    @Override
    public void move() {

        if (right){
            setY(getY() + FrameConstant.GAME_SPEED);
            setX(getX() + FrameConstant.GAME_SPEED );
        }else{
            setY(getY() + FrameConstant.GAME_SPEED );
            setX(getX() - FrameConstant.GAME_SPEED );
        }

    }


    public void borderTesting() {

        if (getX() + ImageMap.get("addHp"+index/10).getWidth(null) >= FrameConstant.FRANE_WIDTH) {
            right = false;
        } else if (getX() < 10) {
            right = true;
        }
        if (getX() > FrameConstant.FRANE_HEIGHT){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyPlaneList.remove(this);
        }

    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY() ,
                ImageMap.get("addHp"+index/10).getWidth(null),
                ImageMap.get("addHp"+index/10).getHeight(null));
    }

}