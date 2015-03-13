package com.example.runmanga;

/*
 * This is a working application that only has one button
 * 
 * It connects to my server, by Wireless LAN
 * The server has a static IP and the socket connection
 * is made via this path.
 * 
 * Pressing the button Run Downloader will have the server
 * run the shell command to download all of the lastest
 * released manga from baka-updates.com
 */


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	    	Log.e("MainActivity","before");
	        setContentView(R.layout.activity_main);



	//This is the start of the VLC 
	            final VLCInterface VLC = new VLCInterface();
	            VLC.execute();
	            

	    OnClickListener handler = new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				System.out.println("Button Clicked");
				
				//Show user that they have clicked the button
				Toast.makeText(getApplicationContext(), v.getContentDescription(), Toast.LENGTH_SHORT).show();
				VLC.out.write(v.getContentDescription()+"\r\n");
				VLC.out.flush(); 
				
			}

			 
		 };
		 
		 //Find the buttons and add their handler
		 Button btn0 = (Button)findViewById(R.id.mangarun);		 
		 btn0.setOnClickListener(handler);
		 
		 Button btn1 = (Button)findViewById(R.id.bakarun);		 
		 btn1.setOnClickListener(handler);

	    } 
	    
	}