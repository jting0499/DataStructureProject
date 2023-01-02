import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;

public class WordCounter {
	private String urlStr;
    private String content;
//    private ArrayList<Keyword> kList = new ArrayList<Keyword>(Arrays.asList(
//        new Keyword("美洲", 1), new Keyword("美國", 1),new Keyword("旅行社", 1),
//        new Keyword("套裝行程", 1),new Keyword("當地參團", 1),new Keyword("熱門行程", 1),
//        new Keyword("方案", 1),new Keyword("團體", 0.8),new Keyword("出團", 0.8),
//        new Keyword("多日遊", 0.8),new Keyword("行程", 0.8),new Keyword("旅遊", 0.6),
//        new Keyword("美加", 0.6),new Keyword("住宿", 0.6),new Keyword("機票", 0.6),
//        new Keyword("景點", 0.6),new Keyword("度假", 0.6),new Keyword("旅遊險", 0.6),
//        new Keyword("規劃", 0.4),new Keyword("報名", 0.4),new Keyword("餐食", 0.4),
//        new Keyword("出發", 0.4)));
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0;
		int fromIdx = 0;
		int found = -1;
	
		while ((found = content.indexOf(keyword, fromIdx)) != -1){
		    retVal++;
		    fromIdx = found + keyword.length();
		}
	
		return retVal;
    }
}