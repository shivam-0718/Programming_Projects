package servlet;

import model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

    public void service (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Control in servlet");
        final String sqlInsert = "INSERT INTO personalinfo (uname, email, password, ucity) VALUES (?, ?, ?, ?);";

        //Getting the data from the form into my controller/servlet.
        String uname = request.getParameter("uname");
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");
        String ucity = request.getParameter("ucity");

        //sending the data from Servlet class to Model class
        User user = new User();
        user.setUname(uname);
        user.setEmail(emailId);
        user.setPassword(password);
        user.setUcity(ucity);

        int rows = user.register();
        HttpSession session = request.getSession();
        session.setAttribute("name", uname);

        if(rows == 0) {
            try {
                response.sendRedirect("/RegistrationWebApp/failure.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                response.sendRedirect("/RegistrationWebApp/success.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }

}