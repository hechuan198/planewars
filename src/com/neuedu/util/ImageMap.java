package com.neuedu.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageMap {

    private static final Map<String, Image> map = new HashMap<>();

    static {
        map.put("bg1", ImageUtil.getImage("com\\neuedu\\imgs\\bg\\bg1.png"));

        map.put("plane1",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\my_1.png"));

        map.put("ep1",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\ep_1.png"));
        map.put("ep2",ImageUtil.getImage("com\\neuedu\\imgs\\plane\\ep_2.png"));

        map.put("epb1",ImageUtil.getImage("com\\neuedu\\imgs\\bullit\\epb_1.png"));

        map.put("myb1",ImageUtil.getImage("com\\neuedu\\imgs\\bullit\\myb_1.png"));

        map.put("myb_2_1",ImageUtil.getImage("com/neuedu/imgs/bullit/myb_2_1.png"));
        map.put("myb_2_2",ImageUtil.getImage("com/neuedu/imgs/bullit/myb_2_2.png"));
        map.put("myb_2_3",ImageUtil.getImage("com/neuedu/imgs/bullit/myb_2_3.png"));
        map.put("myb_2_4",ImageUtil.getImage("com/neuedu/imgs/bullit/myb_2_4.png"));
        map.put("myb_2_5",ImageUtil.getImage("com/neuedu/imgs/bullit/myb_2_5.png"));

        map.put("addHp1",ImageUtil.getImage("com\\neuedu\\imgs\\prop\\addHP1.png"));
        map.put("addHp2",ImageUtil.getImage("com\\neuedu\\imgs\\prop\\addHP2.png"));
        map.put("addHp3",ImageUtil.getImage("com\\neuedu\\imgs\\prop\\addHP3.png"));
        map.put("addHp4",ImageUtil.getImage("com\\neuedu\\imgs\\prop\\addHP4.png"));

        map.put("gameover1",ImageUtil.getImage("com/neuedu/imgs/gameover/1.png"));
        map.put("gameover2",ImageUtil.getImage("com/neuedu/imgs/gameover/2.png"));
        map.put("gameover3",ImageUtil.getImage("com/neuedu/imgs/gameover/3.png"));
        map.put("gameover4",ImageUtil.getImage("com/neuedu/imgs/gameover/4.png"));
        map.put("gameover5",ImageUtil.getImage("com/neuedu/imgs/gameover/5.png"));
        map.put("gameover6",ImageUtil.getImage("com/neuedu/imgs/gameover/6.png"));
        map.put("gameover7",ImageUtil.getImage("com/neuedu/imgs/gameover/7.png"));
        map.put("gameover8",ImageUtil.getImage("com/neuedu/imgs/gameover/8.png"));
        map.put("gameover9",ImageUtil.getImage("com/neuedu/imgs/gameover/9.png"));

        map.put("win1",ImageUtil.getImage("com/neuedu/imgs/win/win1.png"));
        map.put("win2",ImageUtil.getImage("com/neuedu/imgs/win/win2.png"));
        map.put("win3",ImageUtil.getImage("com/neuedu/imgs/win/win3.png"));
        map.put("win4",ImageUtil.getImage("com/neuedu/imgs/win/win4.png"));
        map.put("win5",ImageUtil.getImage("com/neuedu/imgs/win/win5.png"));
        map.put("win6",ImageUtil.getImage("com/neuedu/imgs/win/win6.png"));
        map.put("win7",ImageUtil.getImage("com/neuedu/imgs/win/win7.png"));
        map.put("win8",ImageUtil.getImage("com/neuedu/imgs/win/win8.png"));
        map.put("win9",ImageUtil.getImage("com/neuedu/imgs/win/win9.png"));
        map.put("win10",ImageUtil.getImage("com/neuedu/imgs/win/win10.png"));
        map.put("win11",ImageUtil.getImage("com/neuedu/imgs/win/win11.png"));
        map.put("win12",ImageUtil.getImage("com/neuedu/imgs/win/win12.png"));
        map.put("win13",ImageUtil.getImage("com/neuedu/imgs/win/win13.png"));
        map.put("win14",ImageUtil.getImage("com/neuedu/imgs/win/win14.png"));

        map.put("boss_A_1",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_01.png"));
        map.put("boss_A_2",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_02.png"));
        map.put("boss_A_3",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_03.png"));
        map.put("boss_A_4",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_04.png"));
        map.put("boss_A_5",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_05.png"));
        map.put("boss_A_6",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_06.png"));
        map.put("boss_A_7",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_07.png"));
        map.put("boss_A_8",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_08.png"));
        map.put("boss_A_9",ImageUtil.getImage("com/neuedu/imgs/boss/boss_A_09.png"));

        map.put("bossb_1",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_1.png"));
        map.put("bossb_2",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_2.png"));
        map.put("bossb_3",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_3.png"));
        map.put("bossb_4",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_4.png"));
        map.put("bossb_5",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_5.png"));
        map.put("bossb_6",ImageUtil.getImage("com/neuedu/imgs/bullit/bossb_6.png"));




    }

    public static Image get(String key){
        return map.get(key);
    }

}
