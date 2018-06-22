package com.example.user.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "MainActivity";
     int myactive =0;
    int [] gamestate={2,2,2,2,2,2,2,2,2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ImageTapped(View view){
        ImageView myimage=(ImageView) view;
        Log.d(TAG, "ImageTapped: "+myimage.getTag().toString());
       int tappedplayer=Integer.parseInt(myimage.getTag().toString());

        if(gamestate[tappedplayer] == 2)
        {
            gamestate[tappedplayer]=myactive;
            if (myactive == 0) {
                myimage.setImageResource(R.drawable.cross);
                myimage.animate().rotation(360).setDuration(1000);
                myactive = 1;
            } else {
                myimage.setImageResource(R.drawable.circle);
                myactive = 0;
            }
        }
    }
    public void playagain(View view){
         myactive =0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.line1);
        for(int i=0;i<linearLayout1.getChildCount();i++){
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.line2);
        for(int i=0;i<linearLayout2.getChildCount();i++){
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout3=(LinearLayout)findViewById(R.id.line3);
        for(int i=0;i<linearLayout3.getChildCount();i++){
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }
}
