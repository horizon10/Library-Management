import java.sql.*;

public class SqlConnect {
    //burayı kendiniz belirleyin
    private final String dburl = "";
    private final String username = "";
    private final String password = "";

    public String executeSelect(String query) {
        String result = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            // Sorgudan gelen veriyi al
            if (rs.next()) {
                result = rs.getString(1); // İlk sütunu alıyoruz
            }
            // ResultSet, Statement ve Connection kapatılmalı
            rs.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result; // Veriyi geri döndür
    }

    public void executeUpdate(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
