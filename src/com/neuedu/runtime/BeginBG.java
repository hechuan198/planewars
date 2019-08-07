package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.util.ImageMap;

import java.awt.*;

public class BeginBG extends BaseSprite implements Drawable {

    public BeginBG() {
        this.image = ImageMap.get("beginbg");
    }

    private Image image;

    @Override
    public void draw(Graphics g) {
           g.drawImage(image,0,0, FrameConstant.FRANE_WIDTH,FrameConstant.FRANE_HEIGHT,null);
    }
}
