package controller.cartcontroller;

import dao.impl.CartDAO;
import dao.impl.ProductDAO;
import model.Order;
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
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "update":
                    updateCart(request,response);
                    break;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int product_id = Integer.parseInt(request.getParameter("prId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        cartDAO.updateQuantity(user_id,product_id,quantity);
        List<Order> orders = new ArrayList<>();
        orders = cartDAO.showItemByUserId(user_id);
        request.setAttribute("orders", orders);
        request.setAttribute("user_id", user_id);
        request.setAttribute("message", "Done!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/show_cart.jsp");
        dispatcher.forward(request,response);
//        showCart(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "add":
                    addToCart(request,response);
                    break;
                case "show":
                    showCart(request,response);
                    break;
                case "delete":
                    deleteItemInCart(request,response);
                    break;
                default:
                    showProductForm(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteItemInCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int product_id = Integer.parseInt(request.getParameter("prId"));
        cartDAO.deleteFromCart(user_id,product_id);
        List<Order> orders = new ArrayList<>();
        orders = cartDAO.showItemByUserId(user_id);
        request.setAttribute("orders", orders);
        request.setAttribute("user_id", user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/show_cart.jsp");
        dispatcher.forward(request,response);

    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Order> orders = new ArrayList<>();
        orders = cartDAO.showItemByUserId(userId);
        request.setAttribute("orders", orders);
        request.setAttribute("user_id", userId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/show_cart.jsp");
        dispatcher.forward(request,response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("IS_LOGGED");
        if (o != null) {
            Object o1 = session.getAttribute("user_id");
            int userId = Integer.parseInt(o1.toString());
            int productId = Integer.parseInt(request.getParameter("product_id"));
            int quantity = 1;
            int lastQuantity = cartDAO.checkItem(userId,productId);
            if(lastQuantity>0){
                cartDAO.updateQuantity(userId,productId,lastQuantity+quantity);
            }else {
                cartDAO.addToCart(userId,productId,quantity);
            }
            request.setAttribute("message","Added to cart");
            showProductForm(request,response);
        }
        else {
            response.sendRedirect("/login");
        }
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
