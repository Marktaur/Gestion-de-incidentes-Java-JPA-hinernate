package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class testConeccionMysql{
        public static void main(String[] args) {
            // Configuración de la conexión a la base de datos
            String url = "jdbc:mysql://127.0.0.1:3306/sistemagestion";
            String usuario = "root";
            String contrasenia = "";

            // Establecer la conexión
            try (Connection conexión = DriverManager.getConnection(url, usuario, contrasenia)) {
                System.out.println("Conexión exitosa");

                // Crear una declaración
                Statement declaración = conexión.createStatement();

                // Ejecutar una consulta
                ResultSet resultado = declaración.executeQuery("SELECT * FROM clientes");

                // Procesar el resultado
                while (resultado.next()) {
                    // Obtener datos
                    int id = resultado.getInt("columna_id");
                    String nombre = resultado.getString("columna_nombre");

                    // Hacer algo con los datos (por ejemplo, imprimirlos)
                    System.out.println("ID: " + id + ", Nombre: " + nombre);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


