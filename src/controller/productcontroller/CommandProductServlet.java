package controller.productcontroller;

import dao.impl.ProductDAO;
import model.Product;
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

@WebServlet(name = "CommandProductServlet", urlPatterns = "/products_command")
public class CommandProductServlet extends HttpServlet {
    DBConnection connection = DBConnection.getInstance();
    ProductDAO productDAO = new ProductDAO(connection);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(Constant.END_CODING);
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "import":
                    importProduct(request, response);
                    break;
                case "export":
                    exportProduct(request, response);
                    break;
                case "addProduct":
                    addProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "search":
                    break;
                default:
                    showProductForm(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType(Constant.CONTENT_TYPE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "import":
                    showImportForm(request, response);
                    break;
                case "export":
                    showExportForm(request, response);
                    break;
                case "addProduct":
                    showAddForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                case "search":
                    showSearchForm(request,response);
                    break;
                default:
                    showProductForm(request,response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        showProductForm(request,response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String des = request.getParameter("description");
        String img = request.getParameter("image");
        Product product = new Product(id,name, brand, price, quantity, des, img);
        productDAO.updateProduct(product);
        request.setAttribute("message", "Update product successfully!");
        Product _product = productDAO.findById(id);
        showUpdateForm(request,response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/update_product_form.jsp");
        dispatcher.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        Double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String des = request.getParameter("description");
        String img = request.getParameter("image");
        Product product = new Product(name, brand, price, quantity, des, img);
        productDAO.addProduct(product);
        request.setAttribute("message", "Add new product successfully!");
        showAddForm(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/add_product_form.jsp");
        dispatcher.forward(request, response);
    }

    private void exportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("addValue"));
        Product product = productDAO.findById(id);
        int sumQuantity = product.getQuantity() - quantity;
        if (sumQuantity < 0) {
            request.setAttribute("message", "Out of stock!");
            showExportForm(request,response);
        } else {
            productDAO.importProduct(id, sumQuantity);
            request.setAttribute("message", "Export completed!");
            showExportForm(request,response);
        }
    }

    private void showExportForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/export_product_form.jsp");
        dispatcher.forward(request, response);
    }

    private void importProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("addValue"));
        Product product = productDAO.findById(id);
        int sumQuantity = product.getQuantity() + quantity;
        request.setAttribute("product", product);
        productDAO.importProduct(id, sumQuantity);
        Product afterProduct = productDAO.findById(id);
        request.setAttribute("message", "Import completed!");
        showImportForm(request,response);
    }

    private void showImportForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/import_product_form.jsp");
        dispatcher.forward(request, response);
    }
    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products = productDAO.selectAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/product_form.jsp");
        dispatcher.forward(request,response);
    }
}
