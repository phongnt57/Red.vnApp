package com.example.red;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.adapter.NewsAdapter;

public class NewListActivity extends ListActivity {
	private List<RssItem> items;

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this,NewsActivity.class);
		intent.putExtra(Var.LINK,items.get(position).getLink());
		startActivity(intent);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		int category = bundle.getInt(Var.CATEGORY);
		int paper = bundle.getInt(Var.PAPER);
		setTitle("List"+paper + category);
		int key = paper *1000+ category;
	    items = Var.newsMap.get(key);
		//if(items==null ) items.add(new RssItem());
		NewsAdapter adapter = new NewsAdapter(this,Var.ICONS[paper],items);
		setListAdapter(adapter);
		//CategoryAdapter adapter = new CategoryAdapter(this,Var.ICONS[0],Var.LINKS[0]);
		//setListAdapter(adapter);
	}

}
