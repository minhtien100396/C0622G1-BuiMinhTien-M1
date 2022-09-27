package servlet;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("first"));
        double secondOperand = Double.parseDouble(request.getParameter("second"));
        char operator = request.getParameter("select").charAt(0);
        switch (operator){
            case '+':
                request.setAttribute("result", Calculator.calculate(firstOperand,secondOperand,'+'));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            case '-':
                request.setAttribute("result",  Calculator.calculate(firstOperand,secondOperand,'-'));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            case 'x':
                request.setAttribute("result", Calculator.calculate(firstOperand,secondOperand,'x'));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            case '/':
                if (secondOperand != 0){
                    request.setAttribute("result", Calculator.calculate(firstOperand,secondOperand,'/'));
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } else {
                    request.setAttribute("result", "Mẫu số không thể bằng 0");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
        }
    }
}
