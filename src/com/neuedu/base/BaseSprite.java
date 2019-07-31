package com.neuedu.base;

import java.awt.*;

public abstract class BaseSprite {
    private int x;
    private int y;

    public BaseSprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BaseSprite() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Rectangle getRectangle(){
        return null;
    }
}
