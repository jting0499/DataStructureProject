import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery 
{
	public String searchKeyword;
	public String url;
	public String content;
	public ArrayList<WebPage> webs = new ArrayList<WebPage>();
//	public ArrayList<String> titles = new ArrayList<String>();
//	public ArrayList<String> urls = new ArrayList<String>();
	
	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+ "美國旅遊" + searchKeyword+"&oe=utf8&num=20";
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		//set HTTP header
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();
		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		
		/* 
		 * some Jsoup source
		 * https://jsoup.org/apidocs/org/jsoup/nodes/package-summary.html
		 * https://www.1ju.org/jsoup/jsoup-quick-start
 		 */
		
		//using Jsoup analyze html string
		Document doc = Jsoup.parse(content);
		
		//select particular element(tag) which you want 
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				
				if(title.equals("")) 
				{
					continue;
				}
				if(citeUrl.indexOf("wikipedia") > 0 ) {
					continue;
				}
				if(citeUrl.indexOf("baidu") > 0 ) {
					continue;
				}
				if(citeUrl.indexOf("cambridge") > 0 ) {
					continue;
				}
//				if(citeUrl.indexOf("html") > 0) {
//					continue;
//				}

				String nCiteUrl = citeUrl.substring(citeUrl.indexOf("http"), citeUrl.indexOf("&sa"));
//				citeUrl = URLDecoder.decode(citeUrl, "UTF-8");
				nCiteUrl = java.net.URLDecoder.decode(nCiteUrl, StandardCharsets.UTF_8.name());
				webs.add(new WebPage(nCiteUrl, title));
//				titles.add(title);
//				urls.add(citeUrl);
				
				System.out.println("Title: " + title + " , 縮短後的url: " + nCiteUrl);
				System.out.println("原本的url: " + citeUrl);
				
				//put title and pair into HashMap
				retVal.put(title, citeUrl);

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		return retVal;
	}
}