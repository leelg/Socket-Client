package com.example.runmanga;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import android.os.AsyncTask;
import android.util.Log;

public class VLCInterface extends AsyncTask<String, String, String> {

	 
	static BufferedReader in;
	PrintWriter out;
	Socket socket;
	
public String doInBackground(String... arg0) {

		 
        try {
        	socket = new Socket("192.168.1.35", 10123);

   
            socket.setTcpNoDelay(true);
            if(socket.isConnected() && socket.isBound()){
            	Log.e("INTERFACE","Connected");
            	
            }
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            out = new PrintWriter(socket.getOutputStream(), true);

    		


	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         
         
        
        
        return null;
	}

}