package org.example;
import org.example.Menu;
import org.example.entety.Cliente;

import java.awt.*;
import java.util.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {
do {
    System.out.println("****************************************************************");
    System.out.println("***************** Sistema de incidentes ************************");
    System.out.println("****************************************************************");
        Scanner sc = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Clientes", "Incidentes", "Tecnicos","Reportes","Servicios","Diagnosticos","Soluciones", "Salir");
        List<String> menuClientes = Arrays.asList("Agregar nuevo cliente", "Editar cliente", "Eliminar cliente", "Salir");
        List<String> menuIncidentes = Arrays.asList("Agregar nuevo incidente", "Editar Incidente", "Asignar Tecnico","Cambiar Estado","Incidentes Resueltos","Eliminar incidente", "Salir");
        List<String> menuTecnicos = Arrays.asList("Agregar nuevo tecnico", "Editar tecnico", "Eliminar tecnico", "Salir");
        List<String> menuReportes = Arrays.asList("Reporte Diario por Tecnico", "Reporte Cantidad de incidentes ultimos N dias", "Reporte celeridad tecnico ultimos N dias","Tecnico con mayor celeridad", "Salir");
        List<String> menuTipoServicios= Arrays.asList("Agregar nuevo servicio", "Editar Servicio", "Eliminar Servicio", "Salir");
        List<String> menuTipoProblemas = Arrays.asList("Agregar nuevo Diagnostico", "Editar Diagnostico", "Eliminar Diagnostico", "Salir");
        List<String> menuTipoSolucion = Arrays.asList("Agregar nuevo Solucion", "Editar Solucion", "Eliminar Solucion", "Salir");

        boolean exit = false;
         int option = 0;

        Menu menu =  new Menu();
        option = menu.menuIterator(menuOptions,sc,exit,option);

        String nombreMenu= menuOptions.get(option-1);
        if (option == 1){
            option = menu.menuIterator(menuClientes,sc,exit,option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 2){
            option = menu.menuIterator(menuIncidentes,sc,exit,option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 3) {
            option = menu.menuIterator(menuTecnicos, sc, exit, option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 4) {
            option = menu.menuIterator(menuReportes, sc, exit, option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 5) {
            option = menu.menuIterator(menuTipoServicios, sc, exit, option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 6) {
            option = menu.menuIterator(menuTipoProblemas, sc, exit, option);
            menu.menuSec(option,nombreMenu);
        } else if (option == 7) {
            option = menu.menuIterator(menuTipoSolucion, sc, exit, option);
            menu.menuSec(option,nombreMenu);

        }else if ( option==8){break;}
    } while (5 != 8);//bucle infinito.
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("****************** Grupo 9 Comicion 117 ************************");
        System.out.println("******** Marcos Benassi - Matias Gil - Luciano Olmedo **********");
        System.out.println("****************************************************************");


}}