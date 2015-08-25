package com.kite.joco.toolbarp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tbElso = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tbElso);
        tbElso.setSubtitle("Subtitle of toolbar");
        tbElso.setSubtitleTextColor(getResources().getColor(R.color.blue));
        tbElso.setTitle("Title of toolbar");
        tbElso.setTitleTextColor(getResources().getColor(R.color.red));
        tbElso.setNavigationIcon(getResources().getDrawable(android.R.drawable.arrow_down_float));
        tbElso.setNavigationContentDescription("Navi item desc");
      //  tbElso.inflateMenu(R.menu.menu_main);

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
}
