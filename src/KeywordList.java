import java.util.ArrayList;

public class KeywordList  {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
		lst.add(new Keyword("美洲",10));
		lst.add(new Keyword("美國",10));
		lst.add(new Keyword("旅行社",10));
		lst.add(new Keyword("套裝行程",10));
		lst.add(new Keyword("當地參團",10));
		lst.add(new Keyword("熱門行程",10));
		lst.add(new Keyword("方案",10));
		lst.add(new Keyword("團體",8));
		lst.add(new Keyword("出團",8));
		lst.add(new Keyword("多日遊",8));
		lst.add(new Keyword("行程",8));
		lst.add(new Keyword("旅遊",6));
		lst.add(new Keyword("美加",6));
		lst.add(new Keyword("住宿",6));
		lst.add(new Keyword("機票",6));
		lst.add(new Keyword("景點",6));
		lst.add(new Keyword("度假",6));
		lst.add(new Keyword("旅遊險",6));
		lst.add(new Keyword("規劃",4));
		lst.add(new Keyword("報名",4));
		lst.add(new Keyword("餐食",4));
		lst.add(new Keyword("出發",4));
		lst.add(new Keyword("USA",10));
		lst.add(new Keyword("California",4));
		lst.add(new Keyword("America",10));
		lst.add(new Keyword("維基百科",-1000));
		
		lst.add(new Keyword("美洲",10));
		lst.add(new Keyword("美国",10));
		lst.add(new Keyword("旅行社",10));
		lst.add(new Keyword("套装行程",10));
		lst.add(new Keyword("当地参团",10));
		lst.add(new Keyword("热门行程",10));
		lst.add(new Keyword("方案",10));
		lst.add(new Keyword("团体",8));
		lst.add(new Keyword("出团",8));
		lst.add(new Keyword("多日游",8));
		lst.add(new Keyword("行程",8));
		lst.add(new Keyword("旅游",6));
		lst.add(new Keyword("美加",6));
		lst.add(new Keyword("住宿",6));
		lst.add(new Keyword("机票",6));
		lst.add(new Keyword("景点",6));
		lst.add(new Keyword("度假",6));
		lst.add(new Keyword("旅游险",6));
		lst.add(new Keyword("规划",4));
		lst.add(new Keyword("报名",4));
		lst.add(new Keyword("餐食",4));
		lst.add(new Keyword("出发",4));
		lst.add(new Keyword("加州",4));
		
//		USA 1 
//		Trip advice/ Trip Planner 1 
//		Vacation packages 1 
//		Bucket list 0.6
//		Road trip 0.4
//		California 0.4
//		New York 0.4
		
    }
	public ArrayList<Keyword> getList()
	{
		return lst;
	}
	public void add(Keyword keyword){
		lst.add(keyword);
//		System.out.println("Done");
    }
	
	public void find(String s){
		int maxValue = -1;
		int maxIndex = -1;
		for(int i=0; i<lst.size(); i++){
			int lcs = findLCS(lst.get(i).name, s);
			//System.out.println(lcs);
			if(lcs > maxValue){
				maxValue = lcs;
				maxIndex = i;
			}
		}
		System.out.println(lst.get(maxIndex).toString());
	}
	
	public int findLCS(String x, String y){
		//1. fill this method
		int[][] L=new int[x.length()+1][y.length()+1];
		for(int i=0;i<=x.length();i++)
		{
			L[i][0]=0;
		}
		for(int j=0;j<=y.length();j++)
		{
			L[0][j]=0;
		}
		for(int i=1;i<=x.length();i++)
		{
			for(int j=1;j<=y.length();j++)
			{
			    if(x.substring(i-1,i).equals(y.substring(j-1,j)))
				{
					L[i][j]=L[i-1][j-1]+1;
				}
				else
				{
					if(L[i-1][j]>L[i][j-1])
					{
						L[i][j]=L[i-1][j];
					}
					else
					{
						L[i][j]=L[i][j-1];
					}
				}
			}
		}	
		return L[x.length()][y.length()];
		
	}
	
	private void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
				if(j==matrix[0].length-1)System.out.print("\n");
			}
		}
	}
}