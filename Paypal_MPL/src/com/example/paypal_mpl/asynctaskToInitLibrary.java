package com.example.paypal_mpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.paypal.android.MEP.PayPal;
import android.os.AsyncTask;
import android.util.Log;

public class asynctaskToInitLibrary extends AsyncTask<String, Integer, String >
{
	Paypal_MPL object ;
	
	asynctaskToInitLibrary ( Paypal_MPL object )
	{
		this.object = object ;
		
		Log.e("Hello world", "Hello world") ;
	}
	
	@Override
	protected String doInBackground(String... params) 
	{
		
		URL actualUrl = null;
		try 
		{
			actualUrl = new URL("http://www.google.com") ;
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			HttpURLConnection cn = (HttpURLConnection)actualUrl.openConnection();
			Log.i(cn.getResponseMessage(),"tushar:connectionResponse") ;
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PayPal pp = PayPal.getInstance();
		
		// If the library is already initialized, then we don't need to initialize it again.
		if(pp == null) 
		{
			// This is the main initialization call that takes in your Context, the Application ID, and the server you would like to connect to.
			pp = PayPal.initWithAppID(object, "APP-80W284485P519543T", PayPal.ENV_SANDBOX );

			// -- These are required settings.
			pp.setLanguage("en_US"); // Sets the language for the library.
			// --

			// -- These are a few of the optional settings.
			// Sets the fees payer. If there are fees for the transaction, this person will pay for them. Possible values are FEEPAYER_SENDER,
			// FEEPAYER_PRIMARYRECEIVER, FEEPAYER_EACHRECEIVER, and FEEPAYER_SECONDARYONLY.
			pp.setFeesPayer(PayPal.FEEPAYER_EACHRECEIVER); 
			// Set to true if the transaction will require shipping.
			pp.setShippingEnabled(true);
			// Dynamic Amount Calculation allows you to set tax and shipping amounts based on the user's shipping address. Shipping must be
			// enabled for Dynamic Amount Calculation. This also requires you to create a class that implements PaymentAdjuster and Serializable.
			pp.setDynamicAmountCalculationEnabled(false);
			// --
		}
		
		if (pp.isLibraryInitialized()) 
		{
			return "initialized" ;
		}
		else 
		{
			return "not-initialized" ;
		}
	}
	protected void onPostExecute(String result)
	{
		object.initializationStatus ( result ) ;
	}

}
