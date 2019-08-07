package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;

import com.neuedu.constant.FrameConstant;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Warning extends BaseSprite implements Drawable {



    List<Image> imageList = new ArrayList<>();

    public Warning() {
        imageList.add(ImageMap.get("wraning1"));
        imageList.add(ImageMap.get("wraning2"));
        imageList.add(ImageMap.get("wraning3"));
        imageList.add(ImageMap.get("wraning4"));
        imageList.add(ImageMap.get("wraning5"));
        imageList.add(ImageMap.get("wraning6"));
        imageList.add(ImageMap.get("wraning7"));
        imageList.add(ImageMap.get("wraning8"));
        imageList.add(ImageMap.get("wraning9"));
        imageList.add(ImageMap.get("wraning10"));
        imageList.add(ImageMap.get("wraning11"));
        imageList.add(ImageMap.get("wraning12"));
        imageList.add(ImageMap.get("wraning13"));
        imageList.add(ImageMap.get("wraning14"));
        imageList.add(ImageMap.get("wraning15"));
        imageList.add(ImageMap.get("wraning16"));
        imageList.add(ImageMap.get("wraning17"));
        imageList.add(ImageMap.get("wraning18"));
        imageList.add(ImageMap.get("wraning19"));
        imageList.add(ImageMap.get("wraning20"));

    }

    int index = 0;

    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index++/10), (FrameConstant.FRANE_WIDTH - imageList.get(0).getWidth(null)) +50,
                (FrameConstant.FRANE_HEIGHT - imageList.get(0).getHeight(null))/4,
                imageList.get(0).getWidth(null)/2,
                imageList.get(0).getHeight(null)/2,null);

        if (index >= 190){
            index = 0;
        }
    }
}
