package com.kite.joco.toolbarp1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{


    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tbElso = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tbElso);
        tvHello = (TextView) findViewById(R.id.tvHelloMain);
        /*tbElso.setSubtitle("Subtitle of toolbar");
        tbElso.setSubtitleTextColor(getResources().getColor(R.color.blue));
        tbElso.setTitle("Title of toolbar");
        tbElso.setTitleTextColor(getResources().getColor(R.color.red));
        tbElso.setNavigationIcon(getResources().getDrawable(android.R.drawable.arrow_down_float));
        tbElso.setNavigationContentDescription("Navi item desc");*/
        tbElso.inflateMenu(R.menu.menu_main);
        if (getIntent() != null) {
            handleIntent(getIntent());
        } else {
            Log.d("TOOLBAR:MAINACTIVITY", ":Hogy a csába lehet null az intent???");
        }
    }


    public void onClick(View v) {
        Intent searchIntent = new Intent(this,SearchActivity.class);
        startActivity(searchIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.btnsearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);

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
            //    onSearchRequested();
            Log.d("TOOLBARSEARCH", "  search started just need under android 3.0");
        }

        return super.onOptionsItemSelected(item);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("TOOLBARSEARCH", " Search fired with : " + query);
            showsearchString(query);
        } else {
            Log.d("TOOLBARSEARCH", " Nem kereséssel lett az Activity meghívva");
        }
    }

    private void showsearchString(String text) {
        tvHello.setText(text);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this,query,Toast.LENGTH_SHORT).show();
        Log.d("TOOLBAR:MAINACTIVITY"," A keresett szöveg " + query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("TOOLBAR:MAINACTIVITY"," A keresés új szövege "+newText);
        return false;
    }
}
