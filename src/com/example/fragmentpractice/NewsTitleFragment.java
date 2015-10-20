package com.example.fragmentpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnItemClickListener{
	private ListView newsTitleListView;
	private List<News> newsList;
	private NewsAdapter adapter;
	private boolean isTwoPane;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		newsList=getNews();
		adapter=new NewsAdapter(activity,R.layout.news_item,newsList);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.news_title_frag, container,false);
		newsTitleListView=(ListView) view.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_layout)!=null){
			isTwoPane=true;
		}else{
			isTwoPane=false;
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent,View view,int position,long id){
		News news=newsList.get(position);
		if(isTwoPane){
			NewsContentFragment newsContentFragment=(NewsContentFragment) 
					getFragmentManager().findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		}else{
			NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
		}
	}

	private List<News> getNews() {
		List<News> newsList=new ArrayList<News>();
		News news1=new News();
		news1.setTitle("宿建德江");
		news1.setContent("移舟泊烟渚，日暮客愁新。野旷天低树，江清月近人。");
		newsList.add(news1);
		News news2=new News();
		news2.setTitle("登乐游原");
		news2.setContent("向晚意不适，驱车登古原。夕阳无限好，只是近黄昏。");
		newsList.add(news2);
		News news3=new News();
		news3.setTitle("至德二载甫自京金光门出问道归凤翔乾元初从左拾遗移华州掾与亲故别因出此门有悲往事");
		news3.setContent("此道昔归顺，西郊胡正繁。至今残破胆，应有未招魂。近得归京邑，移官岂至尊。无才日衰老，驻马望千门。");
		newsList.add(news3);
		News news4=new News();
		news4.setTitle("自河南经乱关内阻饥兄弟离散各在一处因望月有感聊书所怀寄上浮梁大兄於潜七兄乌江十五兄兼示符离及下邽弟妹。");
		news4.setContent("时难年荒世业空，弟兄羁旅各西东。田园寥落干戈后，骨肉流离道路中。吊影分为千里雁，辞根散作九秋蓬。共看明月应垂泪，一夜乡心五处同。");
		newsList.add(news4);
		return newsList;
	}

}
