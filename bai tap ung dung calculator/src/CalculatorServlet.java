import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand=Double.parseDouble(request.getParameter("first_operand"));
        double secondOperand= Double.parseDouble(request.getParameter("second_operand"));
        String operation=request.getParameter("operation");

        double result= calculate(firstOperand,secondOperand,operation);

        request.setAttribute("result",result);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public double calculate(double first_operand,double second_operand,String operation){
        double result=0;
        switch(operation){
            case "add":
                result=first_operand+second_operand;
                break;
            case "sub":
                result=first_operand-second_operand;
                break;
            case "multiple":
                result=first_operand * second_operand;
                break;
            case "divide":
                result= first_operand / second_operand;
                break;
        }
        return result;
    }
}
