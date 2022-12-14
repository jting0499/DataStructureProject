import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String url, String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
//		1. calculate score
		for(Keyword keyword : keywords){
			this.score += keyword.weight*counter.countKeyword(keyword.name);
		}

	}	
	
//	public void setURL(String newURL) {
//		this.url = newURL;
//	}
}