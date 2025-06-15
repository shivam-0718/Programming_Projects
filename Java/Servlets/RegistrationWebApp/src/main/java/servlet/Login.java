package servlet;

import model.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Control in login servlet");

        // Getting the data from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create user object and authenticate
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        User authenticatedUser = user.login();

        if (authenticatedUser != null) {
            // Login successful - create session
            HttpSession session = request.getSession();
            session.setAttribute("name", authenticatedUser.getUname());
            session.setAttribute("email", authenticatedUser.getEmail());
            session.setAttribute("ucity", authenticatedUser.getUcity());
            session.setAttribute("user", authenticatedUser);

            try {
                response.sendRedirect("/RegistrationWebApp/dashboard.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Login failed - redirect back to login with error
            try {
                response.sendRedirect("/RegistrationWebApp/login.jsp?error=invalid");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}