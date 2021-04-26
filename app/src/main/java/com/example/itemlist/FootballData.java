package com.example.itemlist;

import java.util.ArrayList;

public class FootballData {
    private static String[] title = new String[]{
            "Soto", "Sate", "Bakso", "Gudeg", "Siomay",
            "Nasi Goreng", "Pempek", "Seblak", "Rendang", "Opor Ayam"
    };

    private static int[] thumbnail = new int[]{
            R.drawable.soto, R.drawable.sate, R.drawable.bakso,
            R.drawable.gudeg, R.drawable.siomay, R.drawable.nasigoreng,
            R.drawable.pempek, R.drawable.seblak, R.drawable.rendang,
            R.drawable.oporayam
    };

    private static String[] preview = new String[]{
            "Ini Soto",
            "Ini Sate",
            "Ini Bakso",
            "Ini Gudeg",
            "Ini Siomay",
            "Ini Nasi Goreng",
            "Ini Pempek",
            "Ini Seblak",
            "Ini Rendang",
            "Ini Opor Ayam"
    };

    public static ArrayList<FootballModel> getListData(){
        FootballModel footballModel = null;
        ArrayList<FootballModel> list = new ArrayList<>();
        for (int i=0; i<title.length; i++){
            footballModel = new FootballModel();
            footballModel.setPhoto(thumbnail[i]);
            footballModel.setPlayer_name(title[i]);
            footballModel.setPreview(preview[i]);

            list.add(footballModel);
        }return list;
    }
}
