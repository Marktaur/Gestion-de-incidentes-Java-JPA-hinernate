package org.example.state;
import jakarta.persistence.Transient;
import org.example.entety.Incidente;

public interface IEstado {



    //uso del patron State para los 3 estados de un incidente
    //Abierto : indica que fue creado
    //EnReparacion : indica que ya fue asignado un tecnico y esta en reparacion
    //Resuelto: indica que el incidente fue resuelto
    public void estadoAbierto (Incidente incidente);
    public void estadoEnReparacion (Incidente incidente);
    public void estadoResuelto(Incidente incidente);
}
