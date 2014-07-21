package com.MegaDodo.simplenetworktest;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// This is a little app to try out the network connectivity test code found here:
// http://developer.android.com/training/basics/network-ops/connecting.html 

public class MainActivity extends Activity {

    private TextView mDisplayText = null;
    private Button mButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        mDisplayText = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);

        if (mButton == null)
            Log.d(getLocalClassName(), "mButton is null");
        if (mDisplayText == null)
            Log.d(getLocalClassName(), "mDisplayText is null");


        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View aView) {
            	ConnectivityManager connMgr = (ConnectivityManager)
            		getSystemService(Context.CONNECTIVITY_SERVICE);
            	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            	if (networkInfo != null && networkInfo.isConnected()) {
            		mDisplayText.setText("Network OK");
            	} else {
            		mDisplayText.setText("No network");
            	}
            }
    });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
