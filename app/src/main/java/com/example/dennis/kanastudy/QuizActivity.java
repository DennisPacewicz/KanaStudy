package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by dennis on 13/04/15.
 */
public class QuizActivity extends Activity {
    private static Map<String, String[]> kanaMap;
    protected int quizType;
    protected Button b1, b2, b3, b4;
    protected Object[] keys;

    static {
        kanaMap = new HashMap<String, String[]>();
        // english translated to char array HIRAGANA, KATAKANA
        kanaMap.put("a", new String[]{"あ", "ア"});
        kanaMap.put("i", new String[] { "い", "イ"});
        kanaMap.put("u", new String[] { "う", "ウ"});
        kanaMap.put("e", new String[] { "え", "エ"});
        kanaMap.put("o", new String[] { "お", "オ"});

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz_layout);

        Intent activityQuizType = getIntent();
        quizType = activityQuizType.getExtras().getInt("QuizType");

        //get buttons from the view
        b1 = (Button)findViewById(R.id.option1);
        b2 = (Button)findViewById(R.id.option2);
        b3 = (Button)findViewById(R.id.option3);
        b4 = (Button)findViewById(R.id.option4);

        //load keys
        keys = kanaMap.keySet().toArray();

        newQuestion();
    }

    public void newQuestion(){
        b1.setText(getSym(keys[0]));
        b2.setText(getSym(keys[1]));
        b3.setText(getSym(keys[2]));
        b4.setText(getSym(keys[3]));
    }

    public String getSym(Object obj){
        String[] sym = kanaMap.get(obj.toString());
        return sym[quizType];
    }
}
