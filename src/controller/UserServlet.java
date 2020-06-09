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
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    DBConnection connection = DBConnection.getInstance();
    UserDAO userDAO;
    @Override
    public void init(){
        userDAO = new UserDAO(connection);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showUserForm(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> users = userDAO.selectAll();
        request.setAttribute("users",users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/user_form.jsp");
        dispatcher.forward(request,response);
    }
}
