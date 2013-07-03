package com.example.paypal_mpl;

import java.math.BigDecimal;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalAdvancedPayment;
import com.paypal.android.MEP.PayPalInvoiceData;
import com.paypal.android.MEP.PayPalInvoiceItem;
import com.paypal.android.MEP.PayPalPayment;
import com.paypal.android.MEP.PayPalReceiverDetails;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Payments_Style extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payments_style) ;
	}

	public void simplePayment ( View v )
	{
		Toast.makeText(this,"simplePayment",Toast.LENGTH_SHORT).show() ;

		PayPalPayment payment = new PayPalPayment();
		payment.setCurrencyType("USD");
		payment.setRecipient("tushar.pandey1991@gmail.com ");
		payment.setSubtotal(new BigDecimal("8.25"));
		payment.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);
		
		Log.i("complete : 1 ","tushar:simplepayment") ;

		PayPalInvoiceData invoice = new PayPalInvoiceData(); 
		invoice.setTax(new BigDecimal("1.25"));
		invoice.setShipping(new BigDecimal("4.50"));

		Log.i("complete : 2 ","tushar:simplepayment") ;
		
		PayPalInvoiceItem item1 = new PayPalInvoiceItem();
		item1.setName("Pink Stuffed Bunny");
		item1.setID("87239");
		item1.setTotalPrice(new BigDecimal("6.00"));
		item1.setUnitPrice(new BigDecimal("2.00"));
		item1.setQuantity(3);
		invoice.getInvoiceItems().add(item1);

		Log.i("complete : 3 ","tushar:simplepayment") ;
		
		PayPalInvoiceItem item2 = new PayPalInvoiceItem();
		item2.setName("Well Wishes");
		item2.setID("56691");
		item2.setTotalPrice(new BigDecimal("2.25"));
		item2.setUnitPrice(new BigDecimal("0.25"));
		item2.setQuantity(9);
		invoice.getInvoiceItems().add(item2);
		
		Log.i("complete : 4 ","tushar:simplepayment__") ;

		payment.setInvoiceData(invoice);
		payment.setMerchantName("The Gift Store");
		payment.setDescription("Quite a simple payment");
		payment.setCustomID("8873482296");
		payment.setIpnUrl("http://www.exampleapp.com/ipn");
		payment.setMemo("Hi! I'm making a memo for a simple payment.");

		Log.i("complete : 5 ","tushar:simplepayment") ;
		
		Intent checkoutIntent = PayPal.getInstance().checkout(payment, this, new ResultDelegate());
		startActivityForResult(checkoutIntent, request);		
	}

	public void parallelpayment ( View v )
	{
		Toast.makeText(this,"parallelpayment",Toast.LENGTH_SHORT).show() ;

		PayPalAdvancedPayment payment = new PayPalAdvancedPayment();
		payment.setCurrencyType("USD");
		payment.setIpnUrl("http://www.exampleapp.com/ipn");
		payment.setMemo("This sure is a swell memo for a parallel payment.");

		PayPalReceiverDetails receiver1 = new PayPalReceiverDetails();
		receiver1.setRecipient("tushar.pandey1991@gmail.com");
		receiver1.setSubtotal(new BigDecimal("13.50"));
		receiver1.setIsPrimary(false);
		receiver1.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);

		PayPalInvoiceData invoice1 = new PayPalInvoiceData();
		invoice1.setTax(new BigDecimal("2.20"));
		invoice1.setShipping(BigDecimal.ZERO);
		PayPalInvoiceItem item1 = new PayPalInvoiceItem();
		item1.setName("Laser Show");
		item1.setID("4211");
		item1.setTotalPrice(new BigDecimal("7.30"));
		item1.setUnitPrice(new BigDecimal("7.30"));
		item1.setQuantity(1);
		invoice1.getInvoiceItems().add(item1);

		PayPalInvoiceItem item2 = new PayPalInvoiceItem();
		item2.setName("Fog Machine");
		item2.setID("6325");
		item2.setTotalPrice(new BigDecimal("4.80"));
		item2.setUnitPrice(new BigDecimal("1.20"));
		item2.setQuantity(4);
		invoice1.getInvoiceItems().add(item2);

		PayPalInvoiceItem item3 = new PayPalInvoiceItem();
		item3.setName("Fog Liquid");
		item3.setID("2196");
		item3.setTotalPrice(new BigDecimal("1.40"));
		item3.setUnitPrice(new BigDecimal("0.20"));
		item3.setQuantity(7);
		invoice1.getInvoiceItems().add(item3);

		receiver1.setInvoiceData(invoice1);
		receiver1.setMerchantName("Laser Shop");
		receiver1.setDescription("The first of two party guys");
		receiver1.setCustomID("001813");

		payment.getReceivers().add(receiver1);
		PayPalReceiverDetails receiver2 = new PayPalReceiverDetails();
		receiver2.setRecipient("notes2791@gmail.com ");
		receiver2.setSubtotal(new BigDecimal("16.00"));
		receiver2.setIsPrimary(false);
		receiver2.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);

		PayPalInvoiceData invoice2 = new PayPalInvoiceData();
		invoice2.setTax(new BigDecimal("3.40"));
		invoice2.setShipping(new BigDecimal("5.15"));

		PayPalInvoiceItem item4 = new PayPalInvoiceItem();
		item4.setName("Beverages");
		item4.setID("7254");
		item4.setTotalPrice(new BigDecimal("11.00"));
		item4.setUnitPrice(new BigDecimal("1.00"));
		item4.setQuantity(11);
		invoice2.getInvoiceItems().add(item4);

		PayPalInvoiceItem item5 = new PayPalInvoiceItem();
		item5.setName("Refreshments");
		item5.setID("1288");
		item5.setTotalPrice(new BigDecimal("5.00"));
		item5.setUnitPrice(new BigDecimal("1.25"));
		item5.setQuantity(4);
		invoice2.getInvoiceItems().add(item5);

		receiver2.setInvoiceData(invoice2);
		receiver2.setMerchantName("Drinks & Refreshments");
		receiver2.setDescription("The second of two party guys");
		receiver2.setCustomID("001768");
		payment.getReceivers().add(receiver2);

		Intent checkoutIntent = PayPal.getInstance().checkout(payment, this, new ResultDelegate());
		startActivityForResult(checkoutIntent, request);	
	}

	public void chainedpayment ( View v )
	{
		Toast.makeText(this,"ChainedPayment",Toast.LENGTH_SHORT).show() ;

		PayPalAdvancedPayment payment = new PayPalAdvancedPayment();
		payment.setCurrencyType("USD");
		payment.setIpnUrl("http://www.exampleapp.com/ipn");
		payment.setMemo("Yarr, a memo for chained payments, this be.");

		PayPalReceiverDetails receiver1 = new PayPalReceiverDetails();
		receiver1.setRecipient("tharrahunmein@gmail.com");
		receiver1.setSubtotal(new BigDecimal("15.00"));
		receiver1.setIsPrimary(true);
		receiver1.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);

		PayPalInvoiceData invoice1 = new PayPalInvoiceData();
		invoice1.setTax(new BigDecimal("1.50"));
		invoice1.setShipping(new BigDecimal("3.50"));

		PayPalInvoiceItem item1 = new PayPalInvoiceItem();
		item1.setName("Boat Tickets");
		item1.setID("29463");
		item1.setTotalPrice(new BigDecimal("15.00"));
		item1.setUnitPrice(new BigDecimal("3.00"));
		item1.setQuantity(5);
		invoice1.getInvoiceItems().add(item1);
		receiver1.setInvoiceData(invoice1);
		receiver1.setMerchantName("Boating Inc.");
		receiver1.setDescription("A chain payment primary");
		receiver1.setCustomID("55342");
		payment.getReceivers().add(receiver1);

		PayPalReceiverDetails receiver2 = new PayPalReceiverDetails();
		receiver2.setRecipient("tushar.pandey1991@gmail.com");
		receiver2.setSubtotal(new BigDecimal("6.00"));
		receiver2.setIsPrimary(false);
		receiver2.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);
		receiver2.setMerchantName("Ticket Source Junior");
		receiver2.setDescription("One of the chain payment secondaries");
		receiver2.setCustomID("93675");
		payment.getReceivers().add(receiver2);

		PayPalReceiverDetails receiver3 = new PayPalReceiverDetails();
		receiver3.setRecipient("notes2791@gmail.com");
		receiver3.setSubtotal(new BigDecimal("7.00"));
		receiver3.setIsPrimary(false);
		receiver3.setPaymentType(PayPal.PAYMENT_TYPE_GOODS);
		receiver3.setMerchantName("Ticket Source Senior");
		receiver3.setDescription("One of the chain payment secondaries");
		receiver3.setCustomID("78853");
		payment.getReceivers().add(receiver3);

		Intent checkoutIntent = PayPal.getInstance().checkout(payment, this, new ResultDelegate());
		startActivityForResult(checkoutIntent, request);
	}

	public void preapproval ( View v )
	{
		Toast.makeText(this,"preapproval",Toast.LENGTH_SHORT).show() ;
	}

	private static final int request = 1;

	public void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		Log.i("complete : 6 : onActivityResult ","tushar:simplepayment") ;

		
		if(requestCode != request)
			return;

		/**
		 * If you choose not to implement the PayPalResultDelegate, then you will receive the transaction results here.
		 * Below is a section of code that is commented out. This is an example of how to get result information for
		 * the transaction. The resultCode will tell you how the transaction ended and other information can be pulled
		 * from the Intent using getStringExtra.
		 */
	
		switch(resultCode) 
		{
			case Activity.RESULT_OK:
			{
				Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show() ;
				break ;
			}
			case Activity.RESULT_CANCELED:
			{
				Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show() ;
				break ;
			}
			case PayPalActivity.RESULT_FAILURE:
			{
				Toast.makeText(this,"Failure",Toast.LENGTH_SHORT).show() ;
				break ;
			}
		}
	}
}
