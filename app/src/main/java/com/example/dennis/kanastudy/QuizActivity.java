package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button b1, b2, b3, b4;
    private TextView question;
    private static Toast answerPrompt;
    private String ans;
    protected Object[] keys;

    static {
        kanaMap = new HashMap<String, String[]>();
        // english translated to char array HIRAGANA, KATAKANA
        kanaMap.put("a", new String[]{"あ", "ア"});
        kanaMap.put("i", new String[] { "い", "イ"});
        kanaMap.put("u", new String[] { "う", "ウ"});
        kanaMap.put("e", new String[] { "え", "エ"});
        kanaMap.put("o", new String[] { "お", "オ"});
        kanaMap.put("ka", new String[]{"か", "カ"});
        kanaMap.put("ki", new String[]{"き", "キ"});
        kanaMap.put("ku", new String[]{"く", "ク"});
        kanaMap.put("ke", new String[]{"け", "ケ"});
        kanaMap.put("ko", new String[]{"こ", "コ"});
        kanaMap.put("sa", new String[]{"さ", "サ"});
        kanaMap.put("si", new String[]{"し", "シ"});
        kanaMap.put("su", new String[]{"す", "ス"});
        kanaMap.put("se", new String[]{"せ", "セ"});
        kanaMap.put("so", new String[]{"そ", "ソ"});
        kanaMap.put("ta", new String[]{"た", "タ"});
        kanaMap.put("ti", new String[]{"ち", "チ"});
        kanaMap.put("tu", new String[]{"つ", "ツ"});
        kanaMap.put("te", new String[]{"て", "テ"});
        kanaMap.put("to", new String[]{"と", "ト"});
        kanaMap.put("na", new String[]{"な", "ナ"});
        kanaMap.put("ni", new String[]{"に", "ニ"});
        kanaMap.put("nu", new String[]{"ぬ", "ヌ"});
        kanaMap.put("ne", new String[]{"ね", "ネ"});
        kanaMap.put("no", new String[]{"の", "ノ"});
        kanaMap.put("ha", new String[]{"は", "ハ"});
        kanaMap.put("hi", new String[]{"ひ", "ヒ"});
        kanaMap.put("fu", new String[]{"ふ", "フ"});
        kanaMap.put("he", new String[]{"へ", "ヘ"});
        kanaMap.put("ho", new String[]{"ほ", "ホ"});
        kanaMap.put("ma", new String[]{"ま", "マ"});
        kanaMap.put("mi", new String[]{"み", "ミ"});
        kanaMap.put("mu", new String[]{"む", "ム"});
        kanaMap.put("me", new String[]{"め", "メ"});
        kanaMap.put("mo", new String[]{"も", "モ"});
        kanaMap.put("ya", new String[]{"や", "ヤ"});
        kanaMap.put("yu", new String[]{"ゆ", "ユ"});
        kanaMap.put("yo", new String[]{"よ", "ヨ"});
        kanaMap.put("ra", new String[]{"ら", "ラ"});
        kanaMap.put("ri", new String[]{"り", "リ"});
        kanaMap.put("ru", new String[]{"る", "ル"});
        kanaMap.put("re", new String[]{"れ", "レ"});
        kanaMap.put("ro", new String[]{"ろ", "ロ"});
        kanaMap.put("wa", new String[]{"わ", "ワ"});
        kanaMap.put("wi", new String[]{"ゐ", "ヰ"});
        kanaMap.put("we", new String[]{"ゑ", "ヱ"});
        kanaMap.put("wo", new String[]{"を", "ヲ"});
        kanaMap.put("n", new String[]{"ん", "ン"});

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
        ans = keys[rand.nextInt(kanaMap.size())].toString();
        question.setText(ans);

        String[] labels = getButtonLabels(ans, 4); //get a set of answers containing the correct answer
        shuffleArray(labels); //randomize the position of the answer

        b1.setText(labels[0]);
        b2.setText(labels[1]);
        b3.setText(labels[2]);
        b4.setText(labels[3]);
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
        } else {
            promptText = "False. :(";
        }
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

    private static int randKey() {
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
