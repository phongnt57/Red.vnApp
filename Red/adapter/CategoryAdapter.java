package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redvn.R;
import com.example.redvn.Var;

public class CategoryAdapter extends ArrayAdapter {
	private Context context;
	private String[] categories;
	private int ivIcon;
	public CategoryAdapter(Context context,int ivIcon,
			String[] categories){
		
		super(context,ivIcon,categories);
		this.context = context;
		this.categories = categories;
		this.ivIcon = ivIcon;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.category, parent, false) ;
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIcon);
		TextView tv  = (TextView) rowView.findViewById(R.id.tvCategory);
		iv.setImageResource(ivIcon);
		tv.setText(categories[position]);
		return rowView;
		
		
		
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
	}
	

}
