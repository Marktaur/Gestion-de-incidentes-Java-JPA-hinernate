package org.example;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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
        if (option == 1) {
            System.out.println("Se ha agregado como nuevo " + nombreMenu);
        } else if (option == 2) {
            System.out.println("Se ha editado el " + nombreMenu);
        } else if (option == 3) {
            System.out.println("Se ha eliminado el " + nombreMenu);
        }
    }
}
/*
    public void menuIncidente(int option){
        if (option == 1){
            System.out.println("Se ha agregado como nuevo cliente");
        } else if (option == 2){
            System.out.println("Se ha editado el cliente");
        } else if (option == 3){
            System.out.println("Se ha eliminado el cliente");
        }
    }

    public void menuTecnico(int option){
        if (option == 1){
            System.out.println("Se ha agregado como nuevo cliente");
        } else if (option == 2){
            System.out.println("Se ha editado el cliente");
        } else if (option == 3){
            System.out.println("Se ha eliminado el cliente");
        }
    }
*/



