import java.util.ArrayList;

public class KeywordList  {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
		lst.add(new Keyword("美洲",20));
		lst.add(new Keyword("美國",20));
		lst.add(new Keyword("旅行社",20));
		lst.add(new Keyword("套裝行程",20));
		lst.add(new Keyword("當地參團",20));
		lst.add(new Keyword("熱門行程",20));
		lst.add(new Keyword("美國餐廳",30));
		lst.add(new Keyword("美國景點",30));
		lst.add(new Keyword("美國飯店",30));
		lst.add(new Keyword("美國住宿",30));
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
		lst.add(new Keyword("維基百科",-10000));
		lst.add(new Keyword("百度百科",-10000));
		lst.add(new Keyword("英雄聯盟",-10000));
		
		lst.add(new Keyword("美洲",20));
		lst.add(new Keyword("美国",20));
		lst.add(new Keyword("旅行社",20));
		lst.add(new Keyword("套装行程",20));
		lst.add(new Keyword("当地参团",20));
		lst.add(new Keyword("热门行程",20));
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
		
		lst.add(new Keyword("USA",20));
		lst.add(new Keyword("America",20));
		lst.add(new Keyword("California",4));
		lst.add(new Keyword("America hotel",30));
		lst.add(new Keyword("America restaurant",30));
		lst.add(new Keyword("Trip planner",20));
		lst.add(new Keyword("trip planner",20));
		lst.add(new Keyword("Trip advice",20));
		lst.add(new Keyword("trip advice",20));
		lst.add(new Keyword("vacation packages",20));
		lst.add(new Keyword("Bucket list",6));
		lst.add(new Keyword("Road trip",4));
		lst.add(new Keyword("New York",4));
		
		lst.add(new Keyword("アメリカ",20));
		lst.add(new Keyword("旅行代理店",20));
		lst.add(new Keyword("パッケージ旅行日程",20));
		lst.add(new Keyword("現地参加",20));
		lst.add(new Keyword("人気の旅程",20));
		lst.add(new Keyword("プログラム",20));
		lst.add(new Keyword("团体",8));
		lst.add(new Keyword("団体出発",8));
		lst.add(new Keyword("日帰りツアー",8));
		lst.add(new Keyword("旅程表",8));
		lst.add(new Keyword("旅行",6));
		lst.add(new Keyword("アメリカとカナダ",6));
		lst.add(new Keyword("宿泊施設",6));
		lst.add(new Keyword("航空券",6));
		lst.add(new Keyword("アトラクション",6));
		lst.add(new Keyword("バケーション",6));
		lst.add(new Keyword("旅行保険",6));
		lst.add(new Keyword("計画",4));
		lst.add(new Keyword("登録",4));
		lst.add(new Keyword("食事",4));
		lst.add(new Keyword("出発",4));
		lst.add(new Keyword("カリフォルニア",4));
		lst.add(new Keyword("ウィキペディア",-1000));
		
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