package com.example.dennis.kanastudy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

/**
 * Created by dennis on 13/04/15.
 */
public class AboutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about_layout);
        String title = "Ka<font color='#CCCCCC'>ta</font>na";

        TextView appTitle = (TextView) findViewById(R.id.appTitle);

        appTitle.setText(Html.fromHtml(title), TextView.BufferType.SPANNABLE);

    }
    public void goToGit (View view) {
        goToUrl("https://github.com/lyninx/KanaStudy");
    }
    public void goToTwitter (View view) {
        goToUrl ( "http://twitter.com/DennisPacewicz");
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
