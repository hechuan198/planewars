package com.neuedu.runtime;

import com.neuedu.base.BaesSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.util.ImageMap;

import java.awt.*;

public class Background extends BaesSprite implements Moveable, Drawable {



    private  Image image;

    public Background() {
        this(0,-9540, ImageMap.get("bg1"));
    }

    public Background(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void move() {
        setY(getY()+1);
    }

    @Override
    public void draw(Graphics g) {


        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();


    }
}
