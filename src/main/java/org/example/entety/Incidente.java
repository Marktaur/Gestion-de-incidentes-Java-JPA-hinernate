package org.example.entety;
import jakarta.persistence.*;
import org.example.state.Abierto;
import org.example.state.IEstado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
    @Column(name="Cliente_ID")
    private int Cliente;
    @Column(name="Servicio_ID")
    private int Servicio;
    @Column(name="Descripcion")
    private String descripcion;
    private boolean esComplejo;
    @Column(name="TipoProblema_ID")
    private int tipoProblema;
    @Column(name="FechaCreacion")
    private Date fechaCreacion;
    @Column(name="FechaINI")
    private Date fechaIni;
    @Column(name="FechaFIN")
    private Date fechaFin;
    @Column(name="Solucion_ID")
    private int solucion;
    @Column(name="Tecnico_ID")
    private int tecnico;
    @Column(name="TiempoOperador")
    private int tiempoEstimadoPorOperador;

    private IEstado IEstado = (org.example.state.IEstado) new Abierto();//patron state para sus 3 estados:
    //Abierto - En reparacion - Resuelto. Por default se inicializa Abierto al crear un Incidente.

    public void abierto ()
    {this.IEstado.estadoAbierto(this);}
    public void enreparacion ()
    {this.IEstado.estadoEnReparacion(this);}
    public void resuelto ()
    {this.IEstado.estadoResuelto(this);}

    @Override
    public String toString() {
        return "Incidente{" +
                "id=" + id +
                ", Cliente=" + Cliente +
                ", Servicio=" + Servicio +
                ", descripcion='" + descripcion + '\'' +
                ", esComplejo=" + esComplejo +
                ", tipoProblema=" + tipoProblema +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaIni=" + fechaIni +
                ", fechaFin=" + fechaFin +
                ", solucion=" + solucion +
                ", tecnico=" + tecnico +
                ", tiempoEstimadoPorOperador=" + tiempoEstimadoPorOperador +
                ", IEstado=" + IEstado +
                '}';
    }
}
