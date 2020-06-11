package controller.cartcontroller;

import dao.ICartDAO;
import dao.impl.CartDAO;
import model.Order;
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

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    ICartDAO cartDAO = new CartDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList<>();
        try {
            orders = cartDAO.showAllOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double total = 0;
        for (Order order: orders){
            total+=order.getAmount();
        }
        request.setAttribute("orders", orders);
        request.setAttribute("total", total);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/order_management.jsp");
        dispatcher.forward(request,response);
    }
}
