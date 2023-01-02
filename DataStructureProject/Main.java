import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //讀使用者的input在google的搜尋結果 再把每個結果tree sort
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("搜尋：");
		String input = sc.next();
		File file = new File("keywordList.txt");
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine()){
//			int numOfKeywords = scanner.nextInt();
			
			String name = scanner.next();
			double weight = scanner.nextDouble();
			Keyword k = new Keyword(name, weight);
			keywords.add(k);
			
			// for(int i = 0; i < 22; i++)
			// {
			// 	String name = scanner.next();
			// 	double weight = scanner.nextDouble();
			// 	Keyword k = new Keyword(name, weight);
			// 	keywords.add(k);
			// }
//			tree.setPostOrderScore(keywords);
//			tree.eularPrintTree();
		}
		scanner.close();
		
		try {
			FileWriter writer = new FileWriter("url.txt");
			GoogleQuery g = new GoogleQuery(input);
			writer.write(g.query().toString());
			writer.close();
			System.out.println("done");
			System.out.println(g.titles);
			System.out.println(g.urls);
			sc.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try 
//		{
//			System.out.println(new GoogleQuery(input).query());
//			GoogleQuery g = new GoogleQuery("NCCU");
//			g.query();
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//		}
	}
    
}