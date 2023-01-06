import java.util.ArrayList;

public class WebSort {
	public ArrayList<WebPage> webs;
	
	public WebSort(ArrayList<WebPage> webs){
		this.webs = webs;
    }
	
//	public void add(Keyword keyword){
//		lst.add(keyword);
//    }
	
	//Quick sort
	public void sort(){
		if(webs.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, webs.size()-1);
		}
	}
	
	private void quickSort(int leftbound, int rightbound){
		//1. Implement QuickSort algorithm
		if(leftbound<rightbound)
		{
			int i=leftbound-1;
			for(int j=leftbound;j<rightbound;j++)
			{
				if(webs.get(j).score>=webs.get(rightbound).score)
				{
					i++;
					swap(i,j);
				}
			}
			swap(i+1,rightbound);
			quickSort(leftbound,i);
			quickSort(i+2,rightbound);
		}
	}
	
	private void swap(int aIndex, int bIndex){
		WebPage temp = webs.get(aIndex);
		webs.set(aIndex, webs.get(bIndex));
		webs.set(bIndex, temp);
	}
	
	public void output(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < webs.size(); i++){
			String s = webs.get(i).name + " " + webs.get(i).score + "\n";
			if(i > 0)sb.append(" ");
			sb.append(s);
		}
		
		System.out.println(sb.toString());	
	}
}