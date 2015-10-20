package com.example.fragmentpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {
	private int resourceid;
	public NewsAdapter(Context context,int textViewResourceId,List<News> objects){
		super(context,textViewResourceId,objects);
		resourceid=textViewResourceId;
	}
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		News news=getItem(position);
		View view;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourceid,null);
		}else{
			view=convertView;
		}
		TextView newsTitleText=(TextView) view.findViewById(R.id.news_title);
		newsTitleText.setText(news.getTitle());
		return view;
	}

}
