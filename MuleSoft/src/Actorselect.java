

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Actorselect
 */
@WebServlet("/Actorselect")
public class Actorselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
	      String name=request.getParameter("actor");     
		out.println("<html><body>");
	    Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
	           String url= "jdbc:sqlite:F:/MuleSoft/sqlite/sqlite-tools-win32-x86-3360000/Movie.db";
	           conn = DriverManager.getConnection(url);
		       System.out.println("Connection Has Been Established");
		       PreparedStatement ps=conn.prepareStatement("select * from Movies where ACTOR=?");
		       ps.setString(1, name);
		       out.print("<table border=1 width=25% border=1>");
		       out.print("<center><h1>Result<h1></center>");
		       out.print("<center><h1>"+name+"<h1></center>");
		       ResultSet rs=ps.executeQuery();
		       out.println("<tr><th>Movie</th><th>Actor</th><th>Actress</th><th>Director</th><th>Year</th>");
		       while(rs.next())
		       {
		
               out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");	
                     
   
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
