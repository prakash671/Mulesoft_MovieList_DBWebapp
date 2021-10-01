

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Newmovies
 */
@WebServlet("/Newmovies")
public class Newmovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String M=request.getParameter("movie");  
		String aC=request.getParameter("actor");  
		String aCS=request.getParameter("actress");  
		String D=request.getParameter("director");  
		String DT=request.getParameter("date");
		 Connection conn=null; 
		try{  
			Class.forName("org.sqlite.JDBC");
	           String url= "jdbc:sqlite:F:/MuleSoft/sqlite/sqlite-tools-win32-x86-3360000/Movie.db";
	           conn = DriverManager.getConnection(url);
		       System.out.println("Connection Has Been Established");      
		PreparedStatement ps=conn.prepareStatement(  
		"insert into MOVIES values(?,?,?,?,?)");  
		  
		ps.setString(1,M);  
		ps.setString(2,aC);  
		ps.setString(3,aCS);  
		ps.setString(4,D); 
		ps.setString(5,DT); 
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close(); 
		
		
		
	}

}
