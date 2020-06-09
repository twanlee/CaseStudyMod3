package controller.productcontroller;

import dao.impl.ProductDAO;
import model.Product;
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

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    DBConnection connection = DBConnection.getInstance();
    ProductDAO productDAO = new ProductDAO(connection);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showProductForm(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = productDAO.selectAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/product_form.jsp");
        dispatcher.forward(request,response);
    }
}
