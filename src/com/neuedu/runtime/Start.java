package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Start  extends BaseSprite implements Drawable {

    public boolean star = true;

    List<Image> imageList = new ArrayList<>();

    public Start() {
        imageList.add(ImageMap.get("start1"));
        imageList.add(ImageMap.get("start2"));
        imageList.add(ImageMap.get("start3"));
        imageList.add(ImageMap.get("start4"));
        imageList.add(ImageMap.get("start5"));
        imageList.add(ImageMap.get("start6"));
        imageList.add(ImageMap.get("start7"));
        imageList.add(ImageMap.get("start7"));
        imageList.add(ImageMap.get("start7"));
        imageList.add(ImageMap.get("start7"));
        imageList.add(ImageMap.get("start7"));
        imageList.add(ImageMap.get("start7"));

    }

    int index = 0;

    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index++/15), (FrameConstant.FRANE_WIDTH - imageList.get(0).getWidth(null))/2,
                (FrameConstant.FRANE_HEIGHT - imageList.get(0).getHeight(null))/2,
                imageList.get(0).getWidth(null),
                imageList.get(0).getHeight(null),null);

        if (index >= 180){
            star = false;
        }
    }
}
