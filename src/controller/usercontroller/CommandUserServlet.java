package controller.usercontroller;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommandUserServlet", urlPatterns = "/command")
public class CommandUserServlet extends HttpServlet {
    DBConnection connection = DBConnection.getInstance();
    UserDAO userDAO;
    @Override
    public void init(){
        userDAO = new UserDAO(connection);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(Constant.END_CODING);
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "update":
                try {
                    updateUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
        response.setContentType(Constant.CONTENT_TYPE);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");

            User user = new User(id,username,password,permission);
            userDAO.updateUser(user);
            request.setAttribute("message","Update completed!");
            request.setAttribute("user",user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/update_user_form.jsp");
            dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null) action="";
        switch (action){
            case "update":
                try {
                    showUpdateForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users");
        dispatcher.forward(request,response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user=userDAO.findById(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/update_user_form.jsp");
        dispatcher.forward(request,response);
    }


}
