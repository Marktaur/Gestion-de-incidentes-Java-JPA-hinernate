package org.example.entety;

import jakarta.persistence.*;
import org.example.state.Abierto;
import org.example.state.IEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.util.JpaUtil;

import java.text.SimpleDateFormat;
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
    private int Cliente;
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
/*

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

*/
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
                    ,Cliente, descripcion, esComplejo, tipoProblema,
            fechaCreacion, fechaIni, fechaFin, solucion, tecnico, tiempoEstimadoPorOperador);

}
    @Override
    public String toString() {
        return String.format("Incidente{\n" +
                        "id=%d,\n" +
                        "Cliente=%d,\n" +
                        "descripcion='%s',\n" +
                        "esComplejo=%b,\n" +
                        "tipoProblema=%d,\n" +
                        "fechaCreacion=%s,\n" +
                        "fechaIni=%s,\n" +
                        "fechaFin=%s,\n" +
                        "solucion=%d,\n" +
                        "tecnico=%d,\n" +
                        "tiempoEstimadoPorOperador=%d\n" +
                        '}', id, Cliente, descripcion, esComplejo, tipoProblema,
                fechaCreacion, fechaIni, fechaFin, solucion, tecnico, tiempoEstimadoPorOperador);

    }


    public String toStringMini() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("  %-3d, '%-10s','%-20s','%-5s',     %d",
                id, dateFormat.format(fechaCreacion), Cliente, esComplejo,tipoProblema );}


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
}
