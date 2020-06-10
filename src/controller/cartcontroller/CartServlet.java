package controller.cartcontroller;

import dao.impl.CartDAO;
import dao.impl.ProductDAO;
import model.Product;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/carts")
public class CartServlet extends HttpServlet {
    DBConnection connection = DBConnection.getInstance();
    ProductDAO productDAO = new ProductDAO(connection);
    CartDAO cartDAO = new CartDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        request.setAttribute("message", "Added to cart!");
        try {
            switch (action) {
                case "add":
                    addToCart(request,response);
                    break;
                case "show":
                    break;
                case "delete":
                    break;
                default:
                    showProductForm(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("product_id"));
        cartDAO.addToCart(userId,productId);
        showProductForm(request,response);
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = productDAO.selectAll();

        HttpSession session = request.getSession();
        Object o = session.getAttribute("user_name");
        String userName = o.toString();
        Object o1 = session.getAttribute("user_id");
        int userId = Integer.parseInt(o1.toString());
        request.setAttribute("username", userName);
        request.setAttribute("user_id", userId);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/customer_view.jsp");
        dispatcher.forward(request, response);
    }
}
