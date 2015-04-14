package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by dennis on 13/04/15.
 */
public class QuizActivity extends Activity {
    private static Map<String, char[]> kanaMap;
    static {
        kanaMap = new HashMap<String, char[]>();
        // english translated to char array HIRAGANA, KATAKANA
        kanaMap.put("a", new char[]{'あ', 'ア'});
        kanaMap.put("i", new char[] { 'い', 'イ'});
        kanaMap.put("u", new char[] { 'う', 'ウ'});
        kanaMap.put("e", new char[] { 'え', 'エ'});
        kanaMap.put("o", new char[] { 'お', 'オ'});

    }
    public void onGetQuiz(View view) {
        // get the Quiz view
        Intent getQuizIntent = new Intent(this, QuizActivity.class);

        final int result = 1;

        startActivity(getQuizIntent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz_layout);


    }
}
