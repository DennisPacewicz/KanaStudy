package com.example.dennis.kanastudy;

import java.util.HashMap;

/**
 * Created by dennis on 14/04/15.
 */
public class kanaMap {
    private static HashMap<String, String[]> kana;
    public static HashMap<String, String[]> getMap(){
        //gets the map
        kana = new HashMap<String, String[]>();
        kana.put("a", new String[]{"あ", "ア"});
        kana.put("i", new String[] { "い", "イ"});
        kana.put("u", new String[] { "う", "ウ"});
        kana.put("e", new String[] { "え", "エ"});
        kana.put("o", new String[] { "お", "オ"});
        kana.put("ka", new String[]{"か", "カ"});
        kana.put("ki", new String[]{"き", "キ"});
        kana.put("ku", new String[]{"く", "ク"});
        kana.put("ke", new String[]{"け", "ケ"});
        kana.put("ko", new String[]{"こ", "コ"});
        kana.put("sa", new String[]{"さ", "サ"});
        kana.put("si", new String[]{"し", "シ"});
        kana.put("su", new String[]{"す", "ス"});
        kana.put("se", new String[]{"せ", "セ"});
        kana.put("so", new String[]{"そ", "ソ"});
        kana.put("ta", new String[]{"た", "タ"});
        kana.put("ti", new String[]{"ち", "チ"});
        kana.put("tu", new String[]{"つ", "ツ"});
        kana.put("te", new String[]{"て", "テ"});
        kana.put("to", new String[]{"と", "ト"});
        kana.put("na", new String[]{"な", "ナ"});
        kana.put("ni", new String[]{"に", "ニ"});
        kana.put("nu", new String[]{"ぬ", "ヌ"});
        kana.put("ne", new String[]{"ね", "ネ"});
        kana.put("no", new String[]{"の", "ノ"});
        kana.put("ha", new String[]{"は", "ハ"});
        kana.put("hi", new String[]{"ひ", "ヒ"});
        kana.put("fu", new String[]{"ふ", "フ"});
        kana.put("he", new String[]{"へ", "ヘ"});
        kana.put("ho", new String[]{"ほ", "ホ"});
        kana.put("ma", new String[]{"ま", "マ"});
        kana.put("mi", new String[]{"み", "ミ"});
        kana.put("mu", new String[]{"む", "ム"});
        kana.put("me", new String[]{"め", "メ"});
        kana.put("mo", new String[]{"も", "モ"});
        kana.put("ya", new String[]{"や", "ヤ"});
        kana.put("yu", new String[]{"ゆ", "ユ"});
        kana.put("yo", new String[]{"よ", "ヨ"});
        kana.put("ra", new String[]{"ら", "ラ"});
        kana.put("ri", new String[]{"り", "リ"});
        kana.put("ru", new String[]{"る", "ル"});
        kana.put("re", new String[]{"れ", "レ"});
        kana.put("ro", new String[]{"ろ", "ロ"});
        kana.put("wa", new String[]{"わ", "ワ"});
        kana.put("wi", new String[]{"ゐ", "ヰ"});
        kana.put("we", new String[]{"ゑ", "ヱ"});
        kana.put("wo", new String[]{"を", "ヲ"});
        kana.put("n", new String[]{"ん", "ン"});
        return kana;
    }
}
