package com.example.paypal_mpl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Paypal_MPL extends Activity implements interface_ForLibraryInit
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_paypal__mpl) ;
	}

	public void PayPalButtonClick_ ( View v )
	{
		asynctaskToInitLibrary object = new asynctaskToInitLibrary(this) ;
		object.execute("") ;
	}

	@Override
	public void initializationStatus(String status) 
	{
		Toast.makeText(this,"status", Toast.LENGTH_SHORT).show() ;
		
		Intent i = new Intent ( this , Payments_Style.class) ;
		startActivity(i) ;
	}
	
}