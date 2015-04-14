package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by dennis on 13/04/15.
 */
public class QuizSetupActivity extends Activity {
    public void onGetQuiz(View view) {
        // get the Quiz view
        Intent getQuizIntent = new Intent(this, QuizActivity.class);

        final int result = 1;

        startActivity(getQuizIntent);

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

                    break;
            case R.id.radio_katakana:
                if (checked)
                    // radio button katakana selected
                    break;
        }
    }
}

