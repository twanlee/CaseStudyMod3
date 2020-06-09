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
import javax.servlet.http.HttpSession;
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
            checkLogin(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/login_form.jsp");
        dispatcher.forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.findByUsername(username);
        if (user.getPassword().equals(password) && user.getPermission().equals(Constant.ADMIN)) {
            HttpSession session = request.getSession();
            session.setAttribute("IS_LOGGED", true);
            session.setAttribute("role", user.getPermission());

            response.sendRedirect("/admin_home");

        } else if (user.getPassword().equals(password) && user.getPermission().equals(Constant.STAFF)) {
            HttpSession session = request.getSession();
            session.setAttribute("IS_LOGGED", true);
            session.setAttribute("role", user.getPermission());

            response.sendRedirect("/staff_home");
        } else if (user.getPassword().equals(password) && user.getPermission().equals(Constant.CUSTOMER)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/customer_view.jsp");
                dispatcher.forward(request,response);
        } else {
            request.setAttribute("error", "Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/login_form.jsp");
            dispatcher.forward(request, response);
        }
    }

}
