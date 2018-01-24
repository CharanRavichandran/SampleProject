import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String myid= request.getParameter("id");
        
        try{
          
        Class.forName("com.mysql.jdbc.Driver");
         
                  Connection  con=DriverManager.getConnection
                             ("jdbc:mysql://localhost:3306/JspDb","root","");
                             PreparedStatement statement;        
                             String query = "DELETE FROM `product` WHERE id=?";
                             statement = con.prepareStatement(query);
                             statement.setString(1, myid);
                             int i=statement.executeUpdate();
                             out.println(i);
                          if(i>0)
                          {
                            out.println("You are successfully deleted");
                                                        
                          }
                          

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }

}