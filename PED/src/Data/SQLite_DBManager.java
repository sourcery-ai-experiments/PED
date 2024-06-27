/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Manuel Mora Monge
 */
public class SQLite_DBManager {
    
    private Connection conn;

    // Método para conectar a la base de datos
    public void connect(String dbName) {
        try {
            File dbFile = new File(dbName);
            boolean dbExists = dbFile.exists();

            // Cargar el driver de SQLite
            Class.forName("org.sqlite.JDBC");
            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);

            if (!dbExists) {
                System.out.println("Base de datos no encontrada. Creando una nueva base de datos.");
                //createDatabase();
                createTable(new String[][]{
                    {"ID", }
                });
            } else {
                System.out.println("Conexión establecida a la base de datos existente.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }

    // Método para crear una nueva base de datos
    private void createDatabase() {
        try (Statement stmt = conn.createStatement()) {
            // Puedes agregar sentencias SQL adicionales aquí para inicializar la base de datos
            // Por ejemplo, crear una tabla inicial
            String sql = "CREATE TABLE IF NOT EXISTS initial_table (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Base de datos creada con una tabla inicial.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para crear una tabla
    public void createTable(String[][] columns) {
    try (Statement stmt = conn.createStatement()) {
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS my_table (");
        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i][0]).append(" ").append(columns[i][1]);
            for (int j = 2; j < columns[i].length; j++) {
                sql.append(" ").append(columns[i][j]);
            }
            if (i < columns.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        stmt.executeUpdate(sql.toString());
        System.out.println("Tabla creada.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    // Método para agregar una línea a la tabla
    public void insertRow(String tableName,String[][] values) {
        try (Statement stmt = conn.createStatement()) {
            StringBuilder columns = new StringBuilder();
            StringBuilder vals = new StringBuilder();
            for (String[] value : values) {
                columns.append(value[0]).append(", ");
                vals.append("'").append(value[1]).append("', ");
            }
            // Eliminar las comas y espacios adicionales
            columns.setLength(columns.length() - 2);
            vals.setLength(vals.length() - 2);
            String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + vals + ")";
            stmt.executeUpdate(sql);
            System.out.println("Línea insertada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para borrar una línea de la tabla por ID
    public void deleteRowById(String tableName,String id) {
        try (Statement stmt = conn.createStatement()) {
            int parsedId = Integer.parseInt(id);
            String sql = "DELETE FROM " + tableName + " WHERE id = " + parsedId;
            stmt.executeUpdate(sql);
            System.out.println("Línea borrada.");
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para leer todas las líneas de la tabla
    public void readAllRows() {
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", ");
                for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + ", ");
                }
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para leer una línea de la tabla por ID
    public void readRowById(String id) {
        try (Statement stmt = conn.createStatement()) {
            int parsedId = Integer.parseInt(id);
            String sql = "SELECT * FROM my_table WHERE id = " + parsedId;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.print("ID: " + rs.getInt("id") + ", ");
                for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + ", ");
                }
                System.out.println();
            } else {
                System.out.println("Registro no encontrado.");
            }
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
