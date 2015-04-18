package com.example.dennis.kanastudy;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dennis on 14/04/15.
 */
public class kanaMap {
    private HashMap<String, String[]> kana;

    public kanaMap(Context context){
        // constructor
        kana = new HashMap<String, String[]>();
        Pattern inputp = Pattern.compile("(\\w+) ([^\\u0000-\\u007F]+) ([^\\u0000-\\u007F]+)"); //unicode matching regex

        try {
            InputStream instream = context.getAssets().open("kana.txt");

            if (instream != null) {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader br = new BufferedReader(inputreader);

                String line;
                do {
                    line = br.readLine();
                    // do something with the line
                    Matcher m1 = inputp.matcher(line);
                    while(m1.find()){
                        String key = m1.group(1).trim().toLowerCase();
                        String hiragana = m1.group(2).trim();
                        String katakana = m1.group(3).trim();
                        kana.put(key, new String[] {hiragana, katakana});
                    }
                } while (line != null);

                instream.close();
            }
        } catch (Exception ex) {
            // file reading error
            System.out.println("kana map not loaded");
        }

    }
    public HashMap<String, String[]> getMap(){
        //gets the map
        return kana;
    }
}
