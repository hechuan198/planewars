package com.neuedu.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageMap {

    private static final Map<String, Image> map = new HashMap<>();

    static {
        map.put("bg1", ImageUtil.getImage("com\\neuedu\\imgs\\bg\\bg1.png"));

        map.put("plane1",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\my_1.png"));

        map.put("myb1",ImageUtil.getImage("com\\neuedu\\imgs\\bullit\\myb_1.png"));

        map.put("ep1",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\ep_1.png"));

        map.put("epb1",ImageUtil.getImage("com\\neuedu\\imgs\\bullit\\epb_1.png"));

        map.put("myb2",ImageUtil.getImage("com\\neuedu\\imgs\\bullit\\myb_2.gif"));


    }

    public static Image get(String key){
        return map.get(key);
    }

}
