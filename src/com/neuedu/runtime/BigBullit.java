package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BigBullit extends BaseSprite implements Moveable, Drawable {

    private List<Image> imageList = new ArrayList<>();

    int index;



    public BigBullit(int x, int y) {
        super(x, y);
        imageList.add(ImageMap.get("myb_2_1"));
        imageList.add(ImageMap.get("myb_2_2"));
        imageList.add(ImageMap.get("myb_2_3"));
        imageList.add(ImageMap.get("myb_2_4"));
        imageList.add(ImageMap.get("myb_2_5"));

    }

    public BigBullit() {
        this(0,0);
    }


    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index++ / 10), getX(), getY(), imageList.get(0).getWidth(null),
                imageList.get(0).getHeight(null), null);
        if (index == 40) {
            index = 0;
        }
    }
    @Override
    public void move() {

    }

//    //按下
//    public void keyPressed(KeyEvent e){
//        if (e.getKeyCode() == KeyEvent.VK_UP){
//            up = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT){
//            left = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN){
//            down = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
//            right = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE){
//            fire = true;
////            fire();
//        }
//        if (e.getKeyCode() == KeyEvent.VK_J){
//            bigFire = true;
//
//        }
//    }
//    //抬起
//    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_UP){
//            up = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT){
//            left = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN){
//            down = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
//            right = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE){
//            fire = false;
//            index = 0;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_J){
//            bigFire = false;
//            index = 0;
//        }
//    }
//

}
