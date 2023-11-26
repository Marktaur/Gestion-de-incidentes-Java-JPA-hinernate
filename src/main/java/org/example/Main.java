package org.example;
import org.example.entety.Cliente;
import org.example.entety.EspecialidadesTecnicas;
import org.example.entety.Tecnicos;

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int option = 0;
        do {
            System.out.println("****************************************************************");
            System.out.println("***************** Sistema de incidentes ************************");
            System.out.println("****************************************************************");
            Scanner sc = new Scanner(System.in);

            List<String> menuOptions = Arrays.asList("Clientes", "Incidentes", "Tecnicos", "Reportes", "Servicios", "Diagnosticos", "Soluciones","Especialidades Tecnicas", "Salir");
            List<String> menuClientes = Arrays.asList("Listar Clientes","Agregar nuevo cliente", "Editar cliente", "Eliminar cliente", "Salir");
            List<String> menuIncidentes = Arrays.asList("Listar Incidentes Abiertos","Visualizar Incidente por N°","Agregar nuevo incidente", "Editar Incidente", "Asignar Tecnico", "Cambiar Estado", "Incidentes Resueltos", "Eliminar incidente", "Salir");
            List<String> menuTecnicos = Arrays.asList("Listar Tecnicos","Agregar nuevo tecnico", "Editar tecnico", "Eliminar tecnico", "Salir");
            List<String> menuReportes = Arrays.asList("Reporte Diario por Tecnico", "Reporte Cantidad de incidentes ultimos N dias", "Reporte celeridad tecnico ultimos N dias", "Tecnico con mayor celeridad", "Salir");
            List<String> menuTipoServicios = Arrays.asList("Listar Servicios","Agregar nuevo servicio", "Editar Servicio", "Eliminar Servicio", "Salir");
            List<String> menuTipoProblemas = Arrays.asList("Listar Diagnosticos","Agregar nuevo Diagnostico", "Editar Diagnostico", "Eliminar Diagnostico", "Salir");
            List<String> menuTipoSolucion = Arrays.asList("Listar Soluciones","Agregar nuevo Solucion", "Editar Solucion", "Eliminar Solucion", "Salir");
            List<String> menuEspecialidad = Arrays.asList("Listar Especilidades Tecnicas","Agregar nueva Especialidad", "Editar Especiliadad", "Eliminar Especilidad", "Salir");

            boolean exit = false;


            Menu menu = new Menu();
            option = menu.menuIterator(menuOptions, sc, exit, option);

            String nombreMenu = menuOptions.get(option - 1);
            switch (option) {
                case 1:
                    option = menu.menuIterator(menuClientes, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 2:
                    option = menu.menuIterator(menuIncidentes, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 3:
                    option = menu.menuIterator(menuTecnicos, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 4:
                    option = menu.menuIterator(menuReportes, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 5:
                    option = menu.menuIterator(menuTipoServicios, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 6:
                    option = menu.menuIterator(menuTipoProblemas, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 7:
                    option = menu.menuIterator(menuTipoSolucion, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 8:option = menu.menuIterator(menuEspecialidad, sc, exit, option);
                    menu.menuSec(option, nombreMenu);
                    break;
                case 9:
                    break;
            }
        } while (option != 9);
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("****************** Grupo 9 Comicion 117 ************************");
        System.out.println("*************** Marcos Benassi - Matias Gil ********************");
        System.out.println("****************************************************************");


    }
}