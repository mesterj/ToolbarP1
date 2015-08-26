package com.kite.joco.toolbarp1;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tbElso = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tbElso);
        /*tbElso.setSubtitle("Subtitle of toolbar");
        tbElso.setSubtitleTextColor(getResources().getColor(R.color.blue));
        tbElso.setTitle("Title of toolbar");
        tbElso.setTitleTextColor(getResources().getColor(R.color.red));
        tbElso.setNavigationIcon(getResources().getDrawable(android.R.drawable.arrow_down_float));
        tbElso.setNavigationContentDescription("Navi item desc");*/
        tbElso.inflateMenu(R.menu.menu_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.btnsearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

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
        if (id == R.id.btnsearch) {
            onSearchRequested();
            Log.d("TOOLBARSEARCH"," search started");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("TOOLBAR"," A query: " +query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
