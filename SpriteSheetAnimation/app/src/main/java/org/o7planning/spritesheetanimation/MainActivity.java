package org.o7planning.spritesheetanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //image button
    private ImageButton buttonPlay;
    //declaring gameview
    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //phát hiện kích thước của màn hình
        //Getting display object
        Display display = getWindowManager().getDefaultDisplay();

        //Getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);

        //Initializing game view object
        //this time we are also passing the screen size to the GameView constructor
        gameView = new GameView(this, size.x, size.y);
        //adding it to contentview
        setContentView(gameView);
        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Initializing game view object
        gameView = new GameView(this, size.x, size.y);
        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        //adding it to contentview
        setContentView(gameView);
        //adding a click listener
        buttonPlay.setOnClickListener(this);
    }

    //pausing the game when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }
    //running the game when activity is resumed
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
    @Override
    public void onClick(View v) {

        //starting game activity
        startActivity(new Intent(this, MainActivity.class));
    }
    /**
     * Created by Belal on 6/24/2016.
     */
    public static class Player {
        //Bitmap to get character from image
        private Bitmap bitmap;

        //coordinates
        private int x;
        private int y;

        //motion speed of the character
        private int speed = 0;

        //constructor
        public Player(Context context) {
            x = 75;
            y = 50;
            speed = 1;

            //Getting bitmap from drawable resource
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        }

        //Method to update coordinate of character
        public void update() {
            //updating x coordinate
            x++;
        }

        /*
         * These are getters you can generate it autmaticallyl
         * right click on editor -> generate -> getters
         * */
        public Bitmap getBitmap() {
            return bitmap;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getSpeed() {
            return speed;
        }
    }
}