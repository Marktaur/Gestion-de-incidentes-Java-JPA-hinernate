package org.example;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.entety.Cliente;
import org.jetbrains.annotations.NotNull;

import static org.example.Main.*;

@Getter
@Setter
@Data
@AllArgsConstructor
public class Menu {


    public void displayMenu(@NotNull List<String> options) {
        System.out.println("Menú:");
        for (int i = 0; i < options.size() - 1; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println(options.size() + ". " + options.get(options.size() - 1));
    }

    public int menuIterator(List<String> options, @NotNull Scanner sc, boolean exit, int option) {
        exit = false;
        option = 0;
        do {
            try {
                displayMenu(options);
                System.out.print("Seleccione una opción: ");
                option = sc.nextInt();

                if (option >= 1 && option <= options.size() - 1) {
                    //System.out.println("Menu de " + options.get(option-1));
                    exit = true;
                    //System.out.println("Ha seleccionado: " + menuOptions.get(option - 1));
                    // Lógica específica para la opción seleccionada
                } else if (option == options.size()) {
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    exit = true;
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero.");
                sc.nextLine(); // Limpiar el búfer del scanner para evitar un bucle infinito
            }

        } while (exit != true);

        return option;
    }

    public void menuSec(int option, String nombreMenu) {
       switch (option) {

           case 1:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.agregarCliente();
                  /* case "Incidentes" -> Cliente.agregarIncidente();
                   case "Tecnicos" -> Cliente.agregarTecnico();
                   case "Reportes" -> Cliente.reportes1();
                   case "Servicios" -> Cliente.agregarServicio();
                   case "Diagnosticos" -> Cliente.agregarDiagnostico();
                   case "Soluciones" -> Cliente.agregarSolucion();*/
               }
               System.out.println("Se ha agregado como nuevo " + nombreMenu);
               break;


           case 2:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.modificarCliente();
                   /*case "Incidentes" -> Cliente.modificarIncidente();
                   case "Tecnicos" -> Cliente.modificarTecnico();
                   case "Reportes" -> Cliente.reportes2();
                   case "Servicios" -> Cliente.modificarServicio();
                   case "Diagnosticos" -> Cliente.modificarDiagnostico();
                   case "Soluciones" -> Cliente.modificarSolucion();*/
               }
               System.out.println("Se ha editado el " + nombreMenu);
               break;

           case 3:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.bajaCliente();
                  /* case "Incidentes" -> Cliente.bajaIncidente();
                   case "Tecnicos" -> Cliente.bajaTecnico();
                   case "Reportes" -> Cliente.reportes3();
                   case "Servicios" -> Cliente.bajaServicio();
                   case "Diagnosticos" -> Cliente.bajaDiagnostico();
                   case "Soluciones" -> Cliente.bajaSolucion();*/
               }
               System.out.println("Se ha eliminado el " + nombreMenu);
               break;

           case 4:








        }
    }
}


