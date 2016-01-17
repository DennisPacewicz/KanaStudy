package com.example.dennis.kanastudy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onGetQuizSetup(View view) {
        // get the Quiz Setup view
        Intent getQuizSetupIntent = new Intent(this, QuizSetupActivity.class);

        startActivity(getQuizSetupIntent);

    }

    public void onGetAbout(View view) {
        // get the About view
        Intent getAboutIntent = new Intent(this, AboutActivity.class);
        startActivity(getAboutIntent);
    }

    public void onGetGuide(View view) {
        // get the Guide view
        Intent getGuideIntent = new Intent(this, GuideActivity.class);
        startActivity(getGuideIntent);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String title = "Ka<font color='#CCCCCC'>ta</font>na";

            TextView appTitle = (TextView) rootView.findViewById(R.id.appTitle);

            appTitle.setText(Html.fromHtml(title), TextView.BufferType.SPANNABLE);
            return rootView;
        }
    }
}
