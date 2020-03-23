package ua.nure.chernykh.Practice10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/practice10/part3")
public class Part3Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/part3.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();

        List<String> names =  (List) session.getAttribute("names");
        if(names == null) {
            names = new ArrayList<String>();
            session.setAttribute("names", names);
        }

        if (request.getParameter("confirmButton") != null) {
            names.clear();
        } else {
            names.add(name);
        }
        session.setAttribute("names", names);
//        request.getRequestDispatcher("/part3.jsp").forward(request, response);
        response.sendRedirect(getServletContext().getContextPath()+"/practice10/part3");
    }
}
