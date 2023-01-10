

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		System.out.println("Google搜尋的結果：");
		GoogleQuery g = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> query = g.query();
	
		KeywordList keys = new KeywordList();
		try {
			for(WebPage w : g.webs) {
				w.setScore(keys.getList());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("打分數後的排列結果：");
		WebSort sort = new WebSort(g.webs);
		sort.sort();
		sort.output();
//		System.out.println("you did it :)");
		
		String[][] s = new String[sort.webs.size()][2];
		request.setAttribute("query", s);
		int num = 0;
//		HashMap<String, String> result = g.query();
		for(WebPage w : sort.webs) {
		    String key = w.name;
		    String value = w.url;
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
//		    System.out.println(key + "" + value);
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
