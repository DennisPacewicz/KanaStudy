package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;

/**
 * Created by dennis on 13/04/15.
 */
public class QuizSetupActivity extends Activity {
    int quiz = 0;
    boolean easymode = false;
    boolean voiced = false;

    public void onSwitchEasy(View view){
        if(!easymode){
            easymode = true;
        } else {
            easymode = false;
        }
    }
    public void onSwitchVoiced(View view){
        if(!voiced){
            voiced = true;
        } else {
            voiced = false;
        }
    }
    public void onGetQuiz(View view) {
        // get the Quiz view
        Intent getQuizIntent = new Intent(this, QuizActivity.class);

        getQuizIntent.putExtra("QuizType", quiz);
        getQuizIntent.putExtra("EasyMode", easymode);
        getQuizIntent.putExtra("IncludeVoiced", voiced);

        startActivity(getQuizIntent);
        //startActivityForResult(getQuizIntent, result);

    }
    public void onGetQuiz2(View view) {
        Intent getQuiz2Intent = new Intent(this, QuizActivity2.class);

        getQuiz2Intent.putExtra("QuizType", quiz);
        getQuiz2Intent.putExtra("EasyMode", easymode);
        getQuiz2Intent.putExtra("IncludeVoiced", voiced);

        startActivity(getQuiz2Intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz_setup_layout);


    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_hiragana:
                if (checked)
                    // radio button hiragana selected
                    quiz = 0;
                    break;

            case R.id.radio_katakana:
                if (checked)
                    // radio button katakana selected
                    quiz = 1;
                    break;
        }
    }

}

