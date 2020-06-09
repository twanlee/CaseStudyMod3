package controller;

import dao.impl.UserDAO;
import model.User;
import utils.Constant;
import utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private DBConnection connection = DBConnection.getInstance();
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertUser(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/register_form.jsp");
        dispatcher.forward(request,response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = Constant.CUSTOMER;
        User user = new User(username,password,permission);
        User user_check = userDAO.findByUsername(username);
        if(user_check==null){
            userDAO.insertUser(user);
            request.setAttribute("message","Register Successful!");
        }else {
            request.setAttribute("error","Username has been used!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/register_form.jsp");
        dispatcher.forward(request,response);
    }
}
