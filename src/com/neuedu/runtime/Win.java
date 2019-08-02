package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;

import com.neuedu.constant.FrameConstant;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Win extends BaseSprite implements  Drawable {


    List<Image> imageList = new ArrayList<>();

    public Win() {
        imageList.add(ImageMap.get("win1"));
        imageList.add(ImageMap.get("win2"));
        imageList.add(ImageMap.get("win3"));
        imageList.add(ImageMap.get("win4"));
        imageList.add(ImageMap.get("win5"));
        imageList.add(ImageMap.get("win6"));
        imageList.add(ImageMap.get("win7"));
        imageList.add(ImageMap.get("win8"));
        imageList.add(ImageMap.get("win9"));
        imageList.add(ImageMap.get("win10"));
        imageList.add(ImageMap.get("win11"));
        imageList.add(ImageMap.get("win12"));
        imageList.add(ImageMap.get("win13"));
        imageList.add(ImageMap.get("win14"));

    }

    int index = 0;

    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index++/10), (FrameConstant.FRANE_WIDTH - imageList.get(0).getWidth(null))/2,
                (FrameConstant.FRANE_HEIGHT - imageList.get(0).getHeight(null))/2,null);

        if (index >= 130){
            index = 130;
        }
    }

}
