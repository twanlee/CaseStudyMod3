package utils;

public class Constant {
    public static final String ADMIN = "Admin";
    public static final String STAFF = "Staff";
    public static final String CUSTOMER = "Customer";
    public static final String SELECT_ALL_USER = "call select_all()";
    public static final String INSERT_USER = "call insert_user(?,?,?)";
    public static final String FIND_BY_USERNAME = "call find_user_by_username(?)";
    public static final String FIND_BY_ID = "call find_user_by_id(?)";
    public static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    public static final String END_CODING = "utf-8";
    public static final String UPDATE_USER = "call update_user(?,?,?,?)";
    public static final String DELETE_USER = "call delete_user(?)";
    public static final String SELECT_ALL_PRODUCT = "call select_all_product()";
    public static final String FIND_PRODUCT_BY_ID = "call find_product_by_id(?)";
    public static final String FIND_PRODUCT_BY_NAME = "select * from products where product_name like ?;";
    public static final String INSERT_PRODUCT = "call insert_product(?,?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "call update_product(?,?,?,?,?,?,?)";
    public static final String DELETE_PRODUCT = "call delete_product(?)";
    public static final String IMPORT_PRODUCT = "call edit_quantity_product(?,?)";
    public static final String ADD_TO_CART = "call add_to_items(?,?,?)";
    public static final String DELETE_PRODUCT_CART = "call delete_to_cart(?,?)";
    public static final String UPDATE_QUANTITY_CART = "call update_to_cart(?,?,?)";
    public static final String CHECK_ITEM = "call check_item(?,?)";
    public static final String SHOW_ITEM_BY_USER_ID = "call show_item_by_id(?)";
    public static final String SHOW_ALL_ORDER = "select i.item_id,u.user_name,p.product_id,p.product_name,i.quantity,p.product_price,i.order_date from users u join items i on u.user_id = i.user_id join products p on p.product_id=i.product_id;";



}
