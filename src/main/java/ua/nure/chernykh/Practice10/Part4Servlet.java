package ua.nure.chernykh.Practice10;

import ua.nure.chernykh.Practice10.db.DBManager;
import ua.nure.chernykh.Practice10.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/practice10/login")
public class Part4Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        HttpSession session = request.getSession();
        User user = null;
        try {
            user = new DBManager().getUser(login, pass);
        } catch (SQLException e) {
            System.out.println("Could not find user: " + e.getMessage());
        }
        if(user != null)
        {
            session.setAttribute("user", user);
            response.sendRedirect(getServletContext().getContextPath()+"/practice10/part3");
        }
        else
        {
            out.println("Username or Password incorrect");
        }
    }
}