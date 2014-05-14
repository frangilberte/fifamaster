package com.fifamaster;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fifamaster.fragment.FifaListFragment;


public class MainActivity extends ActionBarActivity implements FifaListFragment.OnPlayerSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FifaListFragment fragment = (FifaListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_list);
        fragment.setOnPlayerSelectedListener(this);
    }

    @Override
    public void OnPlayerSelected(String resourceId) {
        Toast.makeText(this,"Selected"+ resourceId,Toast.LENGTH_SHORT ).show();
    }
}
