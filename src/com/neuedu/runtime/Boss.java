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
import java.util.Random;

public class Boss extends BaseSprite implements Moveable, Drawable {

    List<Image> imageList = new ArrayList<>();

    private boolean right;

    public int bossHp = 100;



    public Boss() {
        super(250,6000);
        imageList.add(ImageMap.get("boss_A_1"));
        imageList.add(ImageMap.get("boss_A_2"));
        imageList.add(ImageMap.get("boss_A_3"));
        imageList.add(ImageMap.get("boss_A_4"));
        imageList.add(ImageMap.get("boss_A_5"));
        imageList.add(ImageMap.get("boss_A_6"));
        imageList.add(ImageMap.get("boss_A_7"));
        imageList.add(ImageMap.get("boss_A_8"));
        imageList.add(ImageMap.get("boss_A_9"));
    }

    int index;

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imageList.get(index++/3),getX(),getY(),imageList.get(0).getWidth(null),imageList.get(0).getHeight(null),null);
        borderTesting();
        fire();
        if (index >= 24){
            index = 0;
        }

    }

    int fire = 0;
    int type = 1;

    public void fire(){
        if (getY() >= 100) {
            fire++;
            if (fire == 10) {
                GameFrame gameFrame = DataStore.get("gameframe");
                gameFrame.bossBullitList.add(new BossBullit(getX() + (imageList.get(0).getWidth(null) - ImageMap.get("bossb_1").getWidth(null)) / 2,
                        getY() + imageList.get(0).getHeight(null)/2 - 40,type++));
                if (type > 8){
                    type = 1;
                }
                fire = 0;
            }


        }

    }
    @Override
    public void move() {
        if (getY() <= 100){
            setY(getY() + FrameConstant.GAME_SPEED * 2);
        }else{
            setY(100);
            if (right){
                setX(getX() + FrameConstant.GAME_SPEED);
            }else{
                setX(getX() - FrameConstant.GAME_SPEED);
            }

        }
    }


    //边界检测
    public void borderTesting(){

        if (getX() + imageList.get(0).getWidth(null) >= FrameConstant.FRANE_WIDTH ){
            right = false;
        }else if (getX() < 10){
            right = true;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY() ,
                imageList.get(0).getWidth(null),
                imageList.get(0).getHeight(null));
    }

    // boss 与我方子弹碰撞检测
    public void collisionBullitTesting(List<Bullit> bullitList){
        GameFrame gameFrame = DataStore.get("gameframe");
        for (Bullit bullit : bullitList) {
            if (bullit.getRectangle().intersects(this.getRectangle())) {
                bossHp--;
                gameFrame.bullitList.remove(bullit);
            }
        }
    }

}
