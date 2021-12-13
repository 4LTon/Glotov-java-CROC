import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:h2:tcp://localhost/~/test/test";
    public static final String JDBC_DRIVER = "org.h2.Driver";

    public static final String USER = "sa";
    public static final String PASS = "";

    /** Main **/
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            createTables(connection);
            initTables(args[0], connection);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /** Метод, создающий таблицы
     * <P>
     * Реализация таблиц будет Многие ко Многим с промежуточной таблицей PURCHASE
     *
     * Один товар (по артиклу) может быть заказан несколькими покупателями,
     * a покупатель может купить несколько товаров (по артиклу) **/
    public static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {

            String CREATE_PRODUCTS = "CREATE TABLE Products(" +
                    "ArticleID VARCHAR(255) PRIMARY KEY, " +
                    "Name VARCHAR(255) NOT NULL, " +
                    "Cost INT NOT NULL" +
                    ");\n";
            String CREATE_BUYERS = "CREATE TABLE Buyers(" +
                    "ID INT PRIMARY KEY, " +
                    "Name VARCHAR(255) NOT NULL" +
                    ");\n";
            String CREATE_PURCHASE = "CREATE TABLE Purchase(" +
                    "buyer_id INT," +
                    "product_id VARCHAR(255)," +
                    "FOREIGN KEY (buyer_id) REFERENCES Buyers(ID)," +
                    "FOREIGN KEY (product_id) REFERENCES Products(ArticleID)" +
                    ");\n";

            String DBs = CREATE_PRODUCTS + CREATE_BUYERS + CREATE_PURCHASE;

            String drop_DBs = "DROP TABLE IF EXISTS Products;\n" +
                    "DROP TABLE IF EXISTS Buyers;\n" +
                    "DROP TABLE IF EXISTS Purchase\n;";

            statement.executeUpdate(drop_DBs);  // удаляем существующие таблицы
            statement.executeUpdate(DBs);   // создаем таблицы
        }
    }

    /** Метод заполняет таблицу **/
    public static void initTables(String pathCSV, Connection connection) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader(pathCSV));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            int id = Integer.parseInt(fields[0]);
            String name = fields[1];
            String article = fields[2];
            String product = fields[3];
            int cost = Integer.parseInt(fields[4]);

            if (!check(connection, "SELECT * FROM Buyer WHERE name = ?", name))
                insertBuyer(connection,id, name);
            if (!check(connection, "SELECT * FROM Product WHERE article = ?", article))
                insertProduct(connection, article, product, cost);
            insertPurchase(connection, id, article);
        }
    }

    /** Метод проверяет существутет ли значение по запросу **/
    public static boolean check(Connection connection, String sql, String thing) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, thing);
            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            }
        }
    }

    /** Метод добавляет покупателя в таблицу **/
    public static void insertBuyer(Connection connection, int ID, String name) throws SQLException {
        String sql = "INSERT INTO Buyers values(?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);
            statement.setString(2, name);
            statement.execute();
        }
    }

    /** Метод добавляет новый продукт к таблице **/
    public static void insertProduct(Connection connection, String article, String productName, int cost) throws SQLException {
        String sql = "INSERT INTO Products VALUES(?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, article);
            statement.setString(2, productName);
            statement.setInt(3, cost);
            statement.execute();
        }
    }

    /** Метод добавляет новую покупку в таблцу **/
    public static void insertPurchase(Connection connection, int ID, String article) throws SQLException {
        String sql = "INSERT INTO Purchase VALUERS(?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);
            statement.setString(2, article);
            statement.execute();
        }
    }


}
