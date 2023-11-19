package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sistema de incidentes OPEN");
        Scanner sc = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Clientes", "Incidentes", "Tecnicos", "Salir");
        List<String> menuClientes = Arrays.asList("Agregar nuevo cliente", "Editar cliente", "Eliminar cliente", "Salir");
        List<String> menuIncidentes = Arrays.asList("Agregar nuevo incidente", "Editar incidente", "Eliminar incidente", "Salir");
        List<String> menuTecnicos = Arrays.asList("Agregar nuevo tecnico", "Editar tecnico", "Eliminar tecnico", "Salir");

        boolean exit = false;
        int option = 0;

        Menu menu = new Menu();
        option = menu.menuIterator(menuOptions, sc, exit, option);

        String nombreMenu = menuOptions.get(option - 1);
        if (option == 1) {
            option = menu.menuIterator(menuClientes, sc, exit, option);
            menu.menuSec(option, nombreMenu);
        } else if (option == 2) {
            option = menu.menuIterator(menuIncidentes, sc, exit, option);
            menu.menuSec(option, nombreMenu);
        } else if (option == 3) {
            option = menu.menuIterator(menuTecnicos, sc, exit, option);
            menu.menuSec(option, nombreMenu);
        }
    }
}

        /*

         List<String> menuOptions = new ArrayList<String>();
        menuOptions.add("Opción 1");
        menuOptions.add("Opción 2");
        menuOptions.add("Opción 3");
        menuOptions.add("Salir");

        List<String> menuOptionsTecnicos = new ArrayList<>();
        menuOptionsTecnicos.add("Opción 1");
        menuOptionsTecnicos.add("Opción 2");
        menuOptionsTecnicos.add("Opción 3");
        menuOptionsTecnicos.add("Opción 4");
        menuOptionsTecnicos.add("Opción 5");
        menuOptionsTecnicos.add("Salir");
*/



 /*
        System.out.println("Sistema de incidentes OPEN");
        Scanner sc = new Scanner(System.in);
        menu(sc);



    Cliente Macdonals;

    {
        Macdonals = new Cliente(1, "Arcos Dorados S.a", "3044545455", "tango");
    }

    Incidente primerIncidente = new

    // como hago para crear un cliente o un incidente cuando ya tengo creado anteriormente
    //deberia avisar de alguna manera cual es el ultimo o antes de crear tirar un listado para no pisar

    }

    public static void menu(Scanner sc){
        //crea menu
        System.out.println("Menu:\n");
        System.out.println("A - Cliente");
        System.out.println("B - Incidente");
        System.out.println("C - Tecnico");

        //elijo opcion

        String valueMenu = sc.next().toUpperCase();
        String value ="";

        // controlo que solo acceda a las opciones correctas
        correctValueMenu(sc,valueMenu);

        switch (valueMenu) {

            case "A":
                menuCliente(sc,value);
                break;
            case "B":
                menuIncidente(sc,value);
                break;
            case "C":
                menuTecnico(sc,value);
                break;
        }
    }

    public static void menuCliente(Scanner sc, String value){
        System.out.println("Menu Clintes:\n");
        System.out.println("A - Agregar nuevo cliente");
        System.out.println("B - Editar cliente");
        System.out.println("C - Eliminar cliente");

        correctValueMenu(sc,value);


        switch (value) {

            case "A":
                System.out.println("Se agrego un cliente");
                Cliente cliente = new Cliente(1,"1","1","1");
                System.out.println("Se agrego un cliente");
                cliente.agregarCliente();
                System.out.println("Se agrego un cliente");
                break;
            case "B":

                break;
            case "C":

                break;
        }



    }

    public static void menuIncidente(Scanner sc, String value){
        System.out.println("Menu Incidente:\n");
        System.out.println("A - Agregar nuevo Incidente");
        System.out.println("B - Editar Incidente");
        System.out.println("C - Eliminar Incidente");
    }

    public static void menuTecnico(Scanner sc, String value){
        System.out.println("Menu Tecnico:\n");
        System.out.println("A - Agregar nuevo Tecnico");
        System.out.println("B - Editar Tecnico");
        System.out.println("C - Eliminar Tecnico");
    }

    public static void correctValueMenu(Scanner sc,String valueMenu){
        if(!(valueMenu.equals("A"))&&!(valueMenu.equals("B"))&&!(valueMenu.equals("C"))) {
        do {
            System.out.println("Ingrese opcion 'A, B o C'");
            valueMenu = sc.next().toUpperCase();
        } while ((valueMenu.equals(""))||!(valueMenu.equals("A")) && !(valueMenu.equals("B")) && !(valueMenu.equals("C")));
    }

     */






