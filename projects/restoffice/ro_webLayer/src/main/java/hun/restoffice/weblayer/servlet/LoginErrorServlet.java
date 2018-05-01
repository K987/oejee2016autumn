package hun.restoffice.weblayer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet("/LoginError")
public class LoginErrorServlet extends HttpServlet {

    @Override

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final String userName = request.getParameter("j_username");
        request.setAttribute("username", userName);
        request.setAttribute("error", "Login  failed");
        RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
        view.forward(request, response);
    }

}
