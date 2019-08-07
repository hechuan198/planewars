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
    private int type;

    public BossBullit() {
        this(0,0,1);
    }

    public BossBullit(int x, int y,int type) {
        super(x, y);
        this.type = type;
        imageList.add(ImageMap.get("bossb_1"));
        imageList.add(ImageMap.get("bossb_2"));
        imageList.add(ImageMap.get("bossb_3"));
        imageList.add(ImageMap.get("bossb_4"));
        imageList.add(ImageMap.get("bossb_5"));
        imageList.add(ImageMap.get("bossb_6"));
//        borderBullitTest();
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

//    public static double direction = 1;
//    public static boolean directionRight;
//    private final double dir = direction;

    @Override
    public void move() {

        if (type == 1) {
            setY(getY() + FrameConstant.GAME_SPEED * 2);
            setX((getX() + FrameConstant.GAME_SPEED * 2));
        }
        if (type == 2){
            setY(getY() + FrameConstant.GAME_SPEED * 2);

        }
        if (type == 3) {
            setY(getY() + FrameConstant.GAME_SPEED * 2);
            setX((getX() - FrameConstant.GAME_SPEED *2));
        }
        if (type == 4) {
            setX((getX() - FrameConstant.GAME_SPEED *2));
        }
        if (type == 5) {
            setY(getY() - FrameConstant.GAME_SPEED * 2);
            setX((getX() - FrameConstant.GAME_SPEED *2));
        }
        if (type == 6) {
            setY(getY() - FrameConstant.GAME_SPEED * 2);

        }
        if (type == 7) {
            setY(getY() - FrameConstant.GAME_SPEED * 2);
            setX((getX() + FrameConstant.GAME_SPEED *2));
        }
        if (type == 8) {

            setX((getX() + FrameConstant.GAME_SPEED *2));
        }


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

//    public void borderBullitTest(){
//        if (direction >= 1){
//             directionRight = false;
//        }
//        if (direction <= 1){
//            directionRight = true;
//        }
//        if (directionRight == false){
//            direction = direction - 0.5;
//        }
//        if (directionRight == true){
//            direction = direction + 0.5;
//        }
//    }


}
