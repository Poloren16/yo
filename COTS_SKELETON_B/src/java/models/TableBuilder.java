package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class TableBuilder {

    private Connection con;
    private Statement stmt;
    private boolean isConnected;
    private String message;
    protected String table;
    protected String primaryKey;
    protected String[][] columns;

    public void connect() {
        String db_name = "jurnal14"; // <-- ganti dengan nama database
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + db_name,
                    username,
                    password
            );
            stmt = con.createStatement();
            isConnected = true;
            message = "Database Terkoneksi";
        } catch (ClassNotFoundException | SQLException e) {
            isConnected = false;
            message = e.getMessage();
        }
    }

    public void disconnect() {
        try {
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            message = e.getMessage();
        }
    }

    public void createTable() {
        try {
            connect();

            String cols = "";

            // (#1.1 Membentuk kolom tabel secara dinamis)
            cols += primaryKey + " INT PRIMARY KEY AUTO_INCREMENT, ";

            for (int i = 0; i < columns.length; i++) {
                if (columns[i][0].equals(primaryKey)) continue;
                cols += columns[i][0] + " " + columns[i][1] + ", ";
            }
            
            if (cols.endsWith(", ")) {
                cols = cols.substring(0, cols.length() - 2);
            }

            String query = "CREATE TABLE IF NOT EXISTS " + table + " (" + cols + ")";
            int result = stmt.executeUpdate(query);

            message = "Table " + table + " created successfully";
        } catch (SQLException e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
