package com.example.red;



import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.adapter.CategoryAdapter;

public class CategoryActivity extends ListActivity {
	private int paper;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method st
		//setContentView(R.layout.category);
		Bundle bundle = getIntent().getExtras();
	    paper = bundle.getInt(Var.PAPER);
		setTitle(Var.PAPERS[paper]);
		CategoryAdapter adapter = new CategoryAdapter(this,Var.ICONS[paper],Var.CATEGORIES[paper]);
		setListAdapter(adapter);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		
		
		dialog = ProgressDialog.show(CategoryActivity.this, "", "Loading");
		new CategoryTask().execute(position);
		
		/*
		;*/
	}
	 class CategoryTask extends AsyncTask<Integer,Void,Void>{
		 private int position;

			@Override
			protected Void doInBackground(Integer... params) {
				 position = params[0];
				//RssReader reader = new RssReader(Var.LINKS[paper][position]);
				RssReader reader = new RssReader(Var.LINKS[paper][position]);
				
				int key = paper * 1000 +position;
				List<RssItem> items;
				try {
					items = reader.getItems();
					//Log.e("TAG", items.toString());
					Var.newsMap.put(key, items);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				if(dialog!=null){
					dialog.dismiss();
					
				}

				Intent intent = new Intent(CategoryActivity.this,NewListActivity.class);
				intent.putExtra(Var.PAPER, paper);
				intent.putExtra(Var.CATEGORY, position);
				startActivity(intent);
				// TODO Auto-generated method stub
				super.onPostExecute(result);
			}
			 
			 
			 
		 }
	
	
	

}
