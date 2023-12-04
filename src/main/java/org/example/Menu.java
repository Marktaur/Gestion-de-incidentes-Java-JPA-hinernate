package org.example;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.entety.*;
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
                    exit = true;
                } else if (option == options.size()) {
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    exit = true;
                } else {System.out.println("Opción no válida. Intente de nuevo.");
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
                   case "Clientes" -> Cliente.listarClientes();
                    case "Incidentes" -> Incidente.listarIncidentes();
                   case "Tecnicos" -> Tecnicos.listarTecnicos();
                   case "Especialidades Tecnicas" -> EspecialidadesTecnicas.listarEspecialidades();
                   //case "Reportes" -> Cliente.reportes1();
                   case "Servicios" -> TipoServicio.listarTipoServicio();
                   case "Diagnosticos" -> TipoProblema.listarTipoProblema();
                   case "Soluciones" -> Solucion.listarSolucion();
               }
               break;

           case 2:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.agregarCliente();
                  case "Incidentes" -> Incidente.verIncidente();
                   case "Tecnicos" -> Tecnicos.agregarTecnico();
                   case "Especialidades Tecnicas" -> EspecialidadesTecnicas.agregarEspecialidad();
                   //case "Reportes" -> Cliente.reportes1();
                   case "Servicios" -> TipoServicio.agregarTipoServicio();
                   case "Diagnosticos" -> TipoProblema.agregarTipoProblema();
                   case "Soluciones" -> Solucion.agregarSolucion();
               }

               break;


           case 3:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.modificarCliente();
                   case "Incidentes" -> Incidente.agregarIncidente();
                   case "Tecnicos" -> Tecnicos.modificarTecnico();
                   case "Especialidades Tecnicas" -> EspecialidadesTecnicas.modificarEspecialidad();
                   //case "Reportes" -> Cliente.reportes2();
                   case "Servicios" -> TipoServicio.modificarTipoServicio();
                   case "Diagnosticos" -> TipoProblema.modificarTipoProblema();
                   case "Soluciones" -> Solucion.modificarSolucion();
               }

               break;

           case 4:
               switch (nombreMenu) {
                   case "Clientes" -> Cliente.bajaCliente();
                  case "Incidentes" -> Incidente.modificarIncidente();
                   case "Tecnicos" -> Tecnicos.bajaTecnico();
                   case "Especialidades Tecnicas" -> EspecialidadesTecnicas.bajaEspecialidad();
                  // case "Reportes" -> Cliente.reportes3();
                   case "Servicios" -> TipoServicio.bajaTipoServicio();
                   case "Diagnosticos" -> TipoProblema.bajaSTipoProblema();
                   case "Soluciones" -> Solucion.bajaSolucion();
               }

               break;

           case 5:
               Incidente.asignarTecnico();
               break;
           case 6:
               Incidente.cambiarEstado();
               break;
           case 7:
               Incidente.mostrarIncidentesResueltos();
               break;
           case 8:
               Incidente.bajaIncidente();
               break;
           case 9:
               break;







        }
    }
}


