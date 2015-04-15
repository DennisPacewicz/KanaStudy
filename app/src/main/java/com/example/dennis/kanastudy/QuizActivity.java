package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by dennis on 13/04/15.
 */
public class QuizActivity extends Activity {
    private static Map<String, String[]> kanaMap;
    protected int quizType;
    protected Button b1, b2, b3, b4;
    protected TextView question;
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

        //get buttons and question label from the view
        b1 = (Button)findViewById(R.id.option1);
        b2 = (Button)findViewById(R.id.option2);
        b3 = (Button)findViewById(R.id.option3);
        b4 = (Button)findViewById(R.id.option4);
        question = (TextView)findViewById(R.id.questionLabel);

        //load keys
        keys = kanaMap.keySet().toArray();

        newQuestion();
    }

    public void newQuestion(){
        // get random syllable for the question
        Random rand = new Random();
        String ans = keys[rand.nextInt(kanaMap.size())].toString();
        question.setText(ans);

        String[] labels = getButtonLabels(ans, 4);

        b1.setText(labels[0]);
        b2.setText(labels[1]);
        b3.setText(labels[2]);
        b4.setText(labels[3]);
    }

    private String[] getButtonLabels(String ans, int num) {
        String[] labels = new String[num];
        labels[0] = getSym(ans);
        for(int i=1; i<(num); i++){
            String sym = getSym(keys[randKey()]);
            if(Arrays.asList(labels).contains(sym)){
                i = i-1; // if symbol already exists, re-roll random key generation
            } else {
                labels[i] = sym;
            }
        }

        return labels;
    }

    public String getSym(Object obj){
        String[] sym = kanaMap.get(obj.toString());
        return sym[quizType];
    }
    public static int randKey() {
        Random rand = new Random();
        int randomNum = rand.nextInt(kanaMap.size());

        return randomNum;
    }
    static void shuffleArray(String[] ar)
    {
        Random rand = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rand.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
