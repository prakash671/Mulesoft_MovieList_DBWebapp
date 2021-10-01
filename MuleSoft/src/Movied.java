

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Movied
 */
@WebServlet("/Movied")
public class Movied extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
	    Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
	           String url= "jdbc:sqlite:F:/MuleSoft/sqlite/sqlite-tools-win32-x86-3360000/Movie.db";
	           conn = DriverManager.getConnection(url);
		       System.out.println("Connection Has Been Established");
		       Statement st= conn.createStatement();
		       ResultSet rs=st.executeQuery("select *from MOVIES");
		       out.println("<table border=1 width=25% height=25%>");
		       out.println("<tr><th> Movie</th><th>Actor</th><th>Actress</th><th>Director</th><th>Year</th>");
		       while(rs.next())
		       {
		    	   String M = rs.getString("NAME");
		    	   String aC = rs.getString("ACTOR");
		    	   String aCS = rs.getString("ACTRESS"); 
		    	   String D = rs.getString("DIRECTOR");
		    	   String DT = rs.getString("DATE"); 
	out.println("<tr><td>"+M+"</td><td>"+aC+"</td><td>"+aCS+"</td><td>"+D+"</td><td>"+DT+"</td></tr>");	           
		       }
		       out.println("</table>");
		       out.println("</body></html>");
		       conn.close();
		      	}
		catch(SQLException | ClassNotFoundException E){
			System.out.println("message "+E.getMessage());
		}
	}

}
