package org.example.entety;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.state.Abierto;
import org.example.state.IEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.util.JpaUtil;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "incidentes")

public class Incidente {

    //Variables para crear un Incidente:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Incidente_ID")
    private int id;
    @Column(name = "Cliente_ID")
    private int cliente;
    @Column(name = "Descripcion")
    private String descripcion;
    private boolean esComplejo;
    @Column(name = "TipoProblema_ID")
    private int tipoProblema;
    @Column(name = "FechaCreacion")
    private Date fechaCreacion;
    @Column(name = "FechaINI")
    private Date fechaIni;
    @Column(name = "FechaFIN")
    private Date fechaFin;
    @Column(name = "Solucion_ID")
    private int solucion;
    @Column(name = "Tecnico_ID")
    private int tecnico;
    @Column(name = "TiempoOperador")
    private int tiempoEstimadoPorOperador;

    public Incidente() {
    }


    public static void verIncidente() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del incidente a buscar:");
        int idBuscado = scanner.nextInt();

        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Utiliza el ID proporcionado para buscar el incidente en la base de datos
            Incidente incidente = em.find(Incidente.class, idBuscado);

            if (incidente != null) {
                // Imprime los datos del incidente encontrado
                System.out.println("****************************************************************");
                System.out.println("Datos del incidente N° : " + idBuscado + ":");
                System.out.println(incidente.toStringFort());
                System.out.println("****************************************************************");
            } else {
                System.out.println("No se encontró un N° incidente valido.");
            }
        } finally {
            em.close();
        }
    }

    @Transient
    private IEstado estado =  new Abierto();//patron state para sus 3 estados:
    //Abierto - En reparacion - Resuelto. Por default se inicializa Abierto al crear un Incidente.

    public Incidente(IEstado estado) {
        this.estado = estado;
    }



    public void setEstado(IEstado estado) {
        this.estado = estado;
    }
    public void Abierto() {
        this.estado.estadoAbierto(this);}
    public void estadoEnReparacion(){
        this.estado.estadoEnReparacion(this);}
    public void estadoResuelto (){
        this.estado.estadoResuelto(this);}


public String toStringFort() {
    return String.format(
                    "Cliente =%d,\n" +
                    "Descripcion ='%s',\n" +
                    "Complejidad =%b,\n" +
                    "Diagnostico =%d,\n" +
                    "Fecha de Creacion =%s,\n" +
                    "Fecha de inicio =%s,\n" +
                    "Fecha de fin =%s,\n" +
                    "Solucion =%d,\n" +
                    "Tecnico Asignado =%d,\n" +
                    "Tiempo Estimado Por Operador =%d Minutos"
                    ,cliente, descripcion, esComplejo, tipoProblema,
            fechaCreacion, fechaIni, fechaFin, solucion, tecnico, tiempoEstimadoPorOperador);

}
    @Override
    public String toString() {
        return String.format("Incidente{\n" +
                        "id=%d,\n" +
                        "cliente=%d,\n" +
                        "descripcion='%s',\n" +
                        "esComplejo=%b,\n" +
                        "tipoProblema=%d,\n" +
                        "fechaCreacion=%s,\n" +
                        "fechaIni=%s,\n" +
                        "fechaFin=%s,\n" +
                        "solucion=%d,\n" +
                        "tecnico=%d,\n" +
                        "tiempoEstimadoPorOperador=%d\n" +
                        '}', id, cliente, descripcion, esComplejo, tipoProblema,
                fechaCreacion, fechaIni, fechaFin, solucion, tecnico, tiempoEstimadoPorOperador);

    }


    public String toStringMini() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("  %-3d, '%-10s','%-20s','%-5s',     %d",
                id, dateFormat.format(fechaCreacion), cliente, esComplejo,tipoProblema );}


    public static void listarIncidentes(){

        EntityManager em1 = JpaUtil.getEntityManager();
        List<Incidente> incidentes = em1.createQuery("select c from Incidente c", Incidente.class).getResultList();
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("**************** Lista de Incidentes abiertos ******************");
        System.out.println("****************************************************************");
        System.out.println("N° Inc -  Fecha   -      Cliente     - Complejidad - Diagnostico");
        incidentes.forEach(incidente -> System.out.println(incidente.toStringMini()));
        System.out.println("****************************************************************");
        System.out.println();
        em1.close();
    }


    public static void agregarIncidente() {

        listarIncidentes();
        System.out.println();
        org.example.entety.Cliente.listarClientes();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione el ID del cliente");
        int cliente = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese una descripcion del diagnostico(Max 50 caract):");
        String desDiagnostico;
        do{ desDiagnostico = teclado.nextLine();
            if (desDiagnostico.length()>50){
                System.out.println("Error Max 50 caracteres, vuelva a ingresar");}
        } while (desDiagnostico.length() > 50);

        boolean complejo;
        do {
            System.out.println("Ingrese 'true' si es complejo o 'false' si no lo es:");

            if (teclado.hasNextBoolean()) {
                complejo = teclado.nextBoolean();
                break; // Salir del bucle si el valor es booleano
            } else {
                System.out.println("Error: Ingrese un valor booleano válido.");
                teclado.next(); // Consumir el token incorrecto
            }
        } while (true);


        org.example.entety.TipoProblema.listarTipoProblema();
        System.out.println("Seleccione el ID del Tipo de diagnostico");
        int tipodiagnostico = teclado.nextInt();




        teclado.nextLine();

        String problema1;
        do {
            System.out.println("Ingrese el tiempo estimado de resolucion(max 99999 minutos):");
            problema1 = teclado.nextLine();
            if (problema1.length() > 5) {
                System.out.println("Error maximo 99999 minutos, vuelva a ingresar");
                ;
            }
        } while (problema1.length() > 5);

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Incidente c = new Incidente();
            c.Abierto();
            c.setCliente(cliente);
            c.setDescripcion(desDiagnostico);
            c.setTipoProblema(tipodiagnostico);
            c.setEsComplejo(complejo);
            c.setFechaCreacion(new Date());
            c.setTiempoEstimadoPorOperador(Integer.parseInt(problema1));
            c.setSolucion(1);
            c.setTecnico(1);


            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id del incidente registrado es " + c.getId());
            c = em.find(Incidente.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void bajaIncidente() {

        listarIncidentes();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del incidente a eliminar:");
        Long id1 = s.nextLong();
        EntityManager em2 = JpaUtil.getEntityManager();
        try {
            Incidente inc = em2.find(Incidente.class, id1);
            em2.getTransaction().begin();
            em2.remove(inc);
            em2.getTransaction().commit();
        } catch (Exception e) {
            em2.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em2.close();
        }
    }
    public static void asignarTecnico(){

        Tecnicos.listarTecnicos();

        EntityManager em = JpaUtil.getEntityManager();
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("Ingrese el Id de un tecnico que no este ocupado");
            System.out.println("**** false = Libre  /  true = Trabajando ******");
            System.out.println();
            int tecnicoOcupado = teclado.nextInt();
            listarIncidentes();
            System.out.println();
            System.out.println("Ingrese el id del incidente a asignar tecnico");
            System.out.println();
            long id = teclado.nextInt();
            Incidente b = em.find(Incidente.class, id);
            teclado.nextLine();

            em.getTransaction().begin();
            b.setTecnico(tecnicoOcupado);

            em.merge(b);
            em.getTransaction().commit();

            System.out.println(b);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }



    public static void cambiarEstado(){
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Scanner teclado = new Scanner(System.in);
            listarIncidentes();
            System.out.println();
            System.out.println("Ingrese el id del incidente a Solucionar / Cerrar");
            System.out.println();
            long id = teclado.nextInt();
            Incidente b = em.find(Incidente.class, id);
            teclado.nextLine();
            Solucion.listarSolucion();
            System.out.println("Seleccione el tipo de solucion");
            int solu = teclado.nextInt();
            System.out.println();
            System.out.println("Ingrese la fecha y hora de Inicio de reparacion yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date ini = null;
            Date fin = null;
            teclado.nextLine();
            try {
                String fechaInicioStr = teclado.nextLine();
                ini = sdf.parse(fechaInicioStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha y hora incorrecto. Asegúrate de usar el formato correcto.");
            }
            System.out.println("Ingrese la fecha y hora de Fin de reparacion yyyy-MM-dd HH:mm:ss");

            teclado.nextLine();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                String fechaFinStr = teclado.nextLine();
                 fin = sdf2.parse(fechaFinStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha y hora incorrecto. Asegúrate de usar el formato correcto.");
            }
            teclado.nextLine();
            System.out.println("Cerrando Incidente");
            em.getTransaction().begin();
            b.setSolucion(solu);
            b.setFechaIni(ini);
            b.setFechaFin(fin);

            em.merge(b);
            em.getTransaction().commit();

            System.out.println(b);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }


    }

    public static void mostrarIncidentesResueltos () {
        System.out.println("Area de incidentes resueltos");
    }


    public static void modificarIncidente() {
        System.out.println("Area de modificacion de incidentes");

       /* listarIncidentes();

        EntityManager em = JpaUtil.getEntityManager();
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el Id del Cliente a modificar:");
            long id = teclado.nextInt();
            Cliente b = em.find(Cliente.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del Cliente(Max 20 caract):");
            String razonS = teclado.nextLine();
            System.out.println("Ingrese el Cuit del Cliente(Max 15 caract):");
            String cuit = teclado.nextLine();
            //aca hay que Visualizar y dar a elejir una lista de servicios.
            System.out.println("Seleccione de la lista el tipo de servivio contratado");
            int numeroServicio = teclado.nextInt();
            em.getTransaction().begin();
            b.setRazonS(razonS);
            b.setCuit(cuit);
            b.setTipoServicio(numeroServicio);
            em.merge(b);
            em.getTransaction().commit();

            System.out.println(b);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }*/
    }


}



