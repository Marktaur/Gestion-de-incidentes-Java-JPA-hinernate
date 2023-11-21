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


                Statement declaración = conexión.createStatement();
                ResultSet resultado = declaración.executeQuery("SELECT * FROM clientes");


                while (resultado.next()) {

                    // Obteniendo datos de la tabla clientes
                    int id = resultado.getInt("Cliente_ID");
                    String nombre = resultado.getString("razonS");
                    String nombre2 = resultado.getString("cuit");
                    int tiposerv = resultado.getInt("TipoServicio");

                    //Imprimo lo obtenido
                    System.out.println("ID: " + id + ", Nombre: " + nombre+" "+nombre2+ " "+tiposerv);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


