package controller;

import dao.impl.UserDAO;
import model.User;
import utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private DBConnection connection = DBConnection.getInstance();
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(connection);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkLogin(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/login_form.jsp");
        dispatcher.forward(request,response);
    }
    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.findByUsername(username);
        if(user.getPassword().equals(password)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/admin_view.jsp");
            dispatcher.forward(request,response);
        }else {
            request.setAttribute("error","Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/login_form.jsp");
            dispatcher.forward(request,response);
        }
    }

}
