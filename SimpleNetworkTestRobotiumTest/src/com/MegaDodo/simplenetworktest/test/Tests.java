package com.MegaDodo.simplenetworktest.test;

import junit.framework.Assert;

import com.MegaDodo.simplenetworktest.MainActivity;
import com.MegaDodo.simplenetworktest.R;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class Tests extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo = null;
	
	public Tests() {
		super("com.Megadodo.simplenetworktest", MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

    public void testBasic() {
        solo.assertCurrentActivity("Checking current Activity", MainActivity.class);

        
        // Button btn = (Button) solo.getView(R.id.button);
        // TextView txtView = (TextView) solo.getView(R.id.textView);
   
        // _solo.sleep(5000);
        solo.clickOnButton("Test!");
        Assert.assertTrue(solo.waitForText("Network OK",1,10));
        // solo.waitForText("Network OK", 1, 15);
         
}
	
}
