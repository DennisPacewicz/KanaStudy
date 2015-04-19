package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;


/**
 * Created by dennis on 13/04/15.
 */
public class QuizActivity extends Activity {
    private Map<String, String[]> kanaMap;
    protected int quizType;
    private Button b1, b2, b3, b4;
    private TextView score;
    private TextView question;
    private int attempted = 0;
    private int correctAnswers = 0;
    private static Toast answerPrompt;
    private String ans;
    private String prevAns = "";
    protected Object[] keys;


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
        score = (TextView)findViewById(R.id.scoreLabel);

        //load map
        kanaMap = new kanaMap(this.getApplicationContext()).getMap();
        //load keys
        keys = kanaMap.keySet().toArray();

        newQuestion();
    }

    public void newQuestion(){
        // get random syllable for the question
        Random rand = new Random();
        // make sure the same question isn't generated twice in a row
        do {
            ans = keys[rand.nextInt(kanaMap.size())].toString();
        } while (prevAns.equals(ans));
        prevAns = ans;

        question.setText(ans);

        String[] labels = getButtonLabels(ans, 4); //get a set of answers containing the correct answer
        shuffleArray(labels); //randomize the position of the answer

        b1.setText(labels[0]);
        b2.setText(labels[1]);
        b3.setText(labels[2]);
        b4.setText(labels[3]);
        score.setText(correctAnswers + " / " + attempted);
    }
    public void onAnswer(View view) {
        if (answerPrompt != null) // if there is a response being shown from previous question...
            answerPrompt.cancel(); // cancel it

        String[] answer = kanaMap.get(ans);
        boolean correct = false;
        String promptText = "?";
        // check if button pressed has the correct symbol which matches the answer key
        switch(view.getId()) {
            case R.id.option1:
                if(Arrays.asList(answer).contains(b1.getText())){
                    correct = true;
                }
                break;
            case R.id.option2:
                if(Arrays.asList(answer).contains(b2.getText())){
                    correct = true;
                }
                break;
            case R.id.option3:
                if(Arrays.asList(answer).contains(b3.getText())){
                    correct = true;
                }
                break;
            case R.id.option4:
                if(Arrays.asList(answer).contains(b4.getText())){
                    correct = true;
                }
                break;
        }

        if(correct){
            promptText = "Correct! :3";
            correctAnswers = correctAnswers + 1;
        } else {
            promptText = "False. :(";
        }

        attempted = attempted + 1;
        answerPrompt = Toast.makeText(getBaseContext(), promptText, Toast.LENGTH_SHORT);
        answerPrompt.show();
        newQuestion();
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

    private String getSym(Object obj){
        String[] sym = kanaMap.get(obj.toString());
        return sym[quizType];
    }

    private int randKey() {
        Random rand = new Random();
        return rand.nextInt(kanaMap.size());
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
