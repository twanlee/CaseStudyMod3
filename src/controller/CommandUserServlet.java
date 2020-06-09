package controller;

import dao.impl.UserDAO;
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
                break;
        }
        response.setContentType(Constant.CONTENT_TYPE);
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
                break;
        }

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/update_user_form.jsp");
        dispatcher.forward(request,response);
    }


}
