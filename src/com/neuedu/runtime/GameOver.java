package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameOver extends BaseSprite implements Drawable {

    List<Image> imageList = new ArrayList<>();

    public GameOver() {
        imageList.add(ImageMap.get("gameover1"));
        imageList.add(ImageMap.get("gameover2"));
        imageList.add(ImageMap.get("gameover3"));
        imageList.add(ImageMap.get("gameover4"));
        imageList.add(ImageMap.get("gameover5"));
        imageList.add(ImageMap.get("gameover6"));
        imageList.add(ImageMap.get("gameover7"));
        imageList.add(ImageMap.get("gameover8"));
        imageList.add(ImageMap.get("gameover9"));
    }

    int index = 0;

    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index++/5), (FrameConstant.FRANE_WIDTH - imageList.get(0).getWidth(null))/2,
                (FrameConstant.FRANE_HEIGHT - imageList.get(0).getHeight(null))/2,null);

        if (index >= 40){
            index = 40;
        }
    }
}
