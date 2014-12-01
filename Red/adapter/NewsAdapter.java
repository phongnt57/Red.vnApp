package com.example.adapter;

import com.example.redvn.*;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redvn.R;

public class NewsAdapter extends ArrayAdapter<RssItem> {
	private Context context;
	private List<RssItem> items;
	private int ivIcon;
	public NewsAdapter(Context context,int ivIcon,List<RssItem> items)
	{
		super(context, ivIcon,items);
		this.context = context;
		this.ivIcon = ivIcon;
		this.items = items;
		
		
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.news, parent, false) ;
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIcon);
		TextView tv  = (TextView) rowView.findViewById(R.id.tvNews);
		iv.setImageResource(ivIcon);
		//tv.setText("hello");
		tv.setText(items.get(position).getTitle());
		return rowView;
		
		
		
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
	}
	
	
	
	

}
