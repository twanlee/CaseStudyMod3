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
                    exportProduct(request,response);
                    break;
                case "update":
                    break;
                case "delete":
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
                case "update":
                    break;
                case "delete":
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void exportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("addValue"));
        Product product = productDAO.findById(id);
        int sumQuantity = product.getQuantity()-quantity;
        if(sumQuantity<0){
            request.setAttribute("message","Out of stock!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/import_product_form.jsp");
            dispatcher.forward(request, response);
        }else {
            productDAO.importProduct(id, sumQuantity);
            Product afterProduct = productDAO.findById(id);
            request.setAttribute("product",afterProduct);
            request.setAttribute("message", "Export completed!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/import_product_form.jsp");
            dispatcher.forward(request, response);
        }
    }
    private void showExportForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/export_product_form.jsp");
        dispatcher.forward(request, response);
    }
    private void importProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("addValue"));
        Product product = productDAO.findById(id);
        int sumQuantity = product.getQuantity()+quantity;
        request.setAttribute("product",product);
        productDAO.importProduct(id,sumQuantity);
        Product afterProduct = productDAO.findById(id);
        request.setAttribute("product",afterProduct);
        request.setAttribute("message","Import completed!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/import_product_form.jsp");
        dispatcher.forward(request, response);
    }
    private void showImportForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin_view/import_product_form.jsp");
        dispatcher.forward(request, response);
    }
}
