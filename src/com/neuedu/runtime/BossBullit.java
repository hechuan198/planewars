package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class BossBullit extends BaseSprite implements Moveable, Drawable {

    private List<Image> imageList = new ArrayList<>();

    public BossBullit() {
        this(0,0);
    }

    public BossBullit(int x, int y) {
        super(x, y);
        imageList.add(ImageMap.get("bossb_1"));
        imageList.add(ImageMap.get("bossb_2"));
        imageList.add(ImageMap.get("bossb_3"));
        imageList.add(ImageMap.get("bossb_4"));
        imageList.add(ImageMap.get("bossb_5"));
        imageList.add(ImageMap.get("bossb_6"));
    }

    int index = 0;

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imageList.get(index++/10),getX(),getY(), imageList.get(0).getWidth(null), imageList.get(0).getHeight(null),null);
        if (index >= 50){
            index = 0;
        }
        borderTesting();
    }

    @Override
    public void move() {
        setY(getY() + FrameConstant.GAME_SPEED * 2);
    }

    public void borderTesting(){
        if (getY() > FrameConstant.FRANE_HEIGHT ){
            GameFrame gameFrame = DataStore.get("gameframe");
            gameFrame.enemyBuilltList.remove(this);




        }
    }



    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),
                imageList.get(0).getWidth(null), imageList.get(0).getHeight(null));
    }



}
