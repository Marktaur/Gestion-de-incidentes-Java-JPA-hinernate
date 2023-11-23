package org.example.entety;
import org.example.state.Abierto;
import org.example.state.IEstado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString

public class Incidente {

    //Variables para crear un Incidente:
    private int id;
    private String Cliente;
    private String Servicio;
    private boolean esComplejo;
    private String tipoProblema;
    private Date fechaCreacion;
    private Date fechaSolucion;
    private int tiempoEstimado;

    private IEstado IEstado = (org.example.state.IEstado) new Abierto();//patron state para sus 3 estados:
    //Abierto - En reparacion - Resuelto. Por default se inicializa Abierto al crear un Incidente.

    public void abierto ()
    {this.IEstado.estadoAbierto(this);}
    public void enreparacion ()
    {this.IEstado.estadoEnReparacion(this);}
    public void resuelto ()
    {this.IEstado.estadoResuelto(this);}

    public void crearTipoProblema (){}
    public void modificarTipoProblema (){}
    public void darBajaTipoProblema (){}

}
