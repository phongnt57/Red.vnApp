package com.example.red;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class NewsActivity extends Activity {
	private TextView text;
	private String link;
	private ProgressDialog dialog;
	public Document doc;
	public String art;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		Bundle bundle = getIntent().getExtras();
		setTitle(R.string.app_name);
	    link = bundle.getString(Var.LINK);
		text = (TextView) findViewById(R.id.textView1);
		final TextView tag = (TextView) findViewById(R.id.tag);
		tag.setText("Hien thi noi dung");
		
		dialog = ProgressDialog.show(this, "", "Loading..");
		
		new NewsTask().execute();
	}
	class NewsTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... arg0) {
			jsoup j = new jsoup();
		    art = j.getText(link);
			
				
			// TODO Auto-generated method stub
			return null;
		}
		

		

		@Override
		protected void onPostExecute(Void result) {
			
			super.onPostExecute(result);
			if(dialog!=null){
				dialog.dismiss();
			}
			text.setText(art);
			
		}

	
	
		
	}
	class RedWebViewClient extends WebViewClient{

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			if(dialog!=null){
				dialog.dismiss();
			}
			super.onPageFinished(view, url);
		}
		
		
	}

}
