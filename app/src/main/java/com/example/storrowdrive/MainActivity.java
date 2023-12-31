package com.example.storrowdrive;

import android.app.Activity; //Handles onCreate, onResume, onPause
import android.provider.SyncStateContract;
import android.os.Bundle; //Handles os operation
import android.media.MediaPlayer; //Handles audio
import android.util.DisplayMetrics; //Handles use of phone display variables from WindowManager
import android.view.Window; //Handles set(phone display variations)
import android.view.WindowManager; //Handles get(phone display specifications)

//TODO: create the Scene class similar to the GameView class of CGT and GamePanel from GH
//TODO: add Swipe events

/*
    MainActivity is the starting point for the application
 */
public class MainActivity extends Activity {
    private Panel startView;
    MediaPlayer ambientMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //ON START DO THIS
        super.onCreate(savedInstanceState);

        //Set the window to fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Set the screen size constants
        DisplayMetrics screenConstants = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(screenConstants);
        ConstantVar.WIDTH = screenConstants.widthPixels;
        ConstantVar.HEIGHT = screenConstants.heightPixels;

        //Start the ambient noise
        ambientMusic = MediaPlayer.create(MainActivity.this, R.raw.clubmusic);
        ambientMusic.setLooping(true);

        //Create the Start Page
        startView = new Panel(this);
        setContentView(startView);

    }

    @Override
    protected void onResume() { //ON RESUME DO THIS
        super.onResume();
        ambientMusic.start();
    }

    @Override
    protected void onPause() { //ON PAUSE DO THIS
        super.onPause();
        ambientMusic.pause();
    }


}