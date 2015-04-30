package com.example.dennis.kanastudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.Map;

/**
 * Created by dennis on 15/04/15.
 */
public class GuideActivity extends Activity {
    private String[] katakana;
    private String[] hiragana;
    GridView listView1;
    GridView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);

        // set up tabs
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Hiragana");
        host.addTab(spec);

        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Katakana");
        host.addTab(spec);

        kanaMap k = new kanaMap(this.getApplicationContext());
        hiragana = k.getHiraganaGuide();
        katakana = k.getKatakanaGuide();


        listView1 = (GridView)findViewById(R.id.tab1list);
        listView2 = (GridView)findViewById(R.id.tab2list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_text, hiragana);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.list_text, katakana);

        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);


    }
}
