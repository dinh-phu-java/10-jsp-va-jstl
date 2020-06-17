import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SQLServlet",urlPatterns={"/get_sql"})
public class SQLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sqlStatement=request.getParameter("sqlStatement");
        String sqlResult=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl="jdbc:mysql://localhost:3306/classicmodels";
            String username="root";
            String password="qazWSX1@";
            Connection connection= DriverManager.getConnection(dbUrl,username,password);
            Statement statement=connection.createStatement();

            if (sqlStatement.length()>6){
                String sqlType=sqlStatement.substring(0,6);
                if (sqlType.equalsIgnoreCase("select")){
                    ResultSet resultSet=statement.executeQuery(sqlStatement);
                    sqlResult=SQLUtil.getHTMLTable(resultSet);
                    System.out.println(sqlResult);
                }else{
                    int id= statement.executeUpdate(sqlStatement);
                    if (id==0){

                    }else{

                    }
                }
            }else{

            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute("sqlStatement",sqlStatement);
        session.setAttribute("sqlResult",sqlResult);
        String url="/index.jsp";
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
