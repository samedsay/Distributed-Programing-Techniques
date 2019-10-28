import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        printWriter.println("Method: " + request.getMethod() + "<br>");
        try {
            int operation = Integer.parseInt(request.getParameter("operation"));
            int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
            int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
            if(operation == 1)
                printWriter.println("Result : " + (firstNumber + secondNumber));
            else if(operation == 2)
                printWriter.println("Result : " + (firstNumber - secondNumber));
            else if(operation == 3)
                printWriter.println("Result : " + (firstNumber * secondNumber));
            else if(operation == 4)
                printWriter.println("Result : " + (firstNumber / secondNumber));
        } catch (Exception e) {
            printWriter.println("Please Try Again<br>");
            printWriter.println(e);
        }
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        printWriter.println("Method: " + request.getMethod() + "<br>");
        try {
            int operation = Integer.parseInt(request.getParameter("operation"));
            int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
            int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
            if(operation == 1)
                printWriter.println("Result : " + (firstNumber + secondNumber));
            else if(operation == 2)
                printWriter.println("Result : " + (firstNumber - secondNumber));
            else if(operation == 3)
                printWriter.println("Result : " + (firstNumber * secondNumber));
            else if(operation == 4)
                printWriter.println("Result : " + (firstNumber / secondNumber));
       
        } catch (Exception e) {
            printWriter.println("Please Try Again<br>");
            printWriter.println(e);
        }
        printWriter.close();
    }
}
