package com.example.red;

import java.util.HashMap;
import java.util.List;


public class Var {
	public static final String[] PAPERS = {"Red"};
	public static final int[] ICONS = {R.drawable.arow};
	
	
	public static final String[] VNEXPRESS_CATEGORIES = {"TRANG CHỦ","VẤN ĐỀ NÓNG",
		" GÓC NHÌN","TRI THỨC","LỊCH SỬ"};
	
	public static final String[] VNEXPRESS_LINKS =  {
		"http://www.dantri.com.vn/trangchu.rss",
		"http://feeds.feedburner.com/TEDTalks_audio",
		"http://reds.vn/index.php/chinh-tri?format=feed&type=rss",
		"http://reds.vn/index.php/tri-thuc?format=feed&type=rss",
		"http://reds.vn/index.php/lich-su?format=feed&type=rss"};
	
	public static final String[][] CATEGORIES = {VNEXPRESS_CATEGORIES};
	public static final String[][] LINKS = {VNEXPRESS_LINKS};
	public static final String PAPER = "paper";
	public static final String CATEGORY = "category";
	public static final String LINK = "link";
	public static  HashMap<Integer,List<RssItem>> newsMap = 
			new HashMap<Integer,List<RssItem>>();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	

}
