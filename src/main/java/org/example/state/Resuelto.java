package org.example.state;

import jakarta.persistence.EntityManager;
import org.example.state.IEstado;
import org.example.entety.Incidente;
import org.example.util.JpaUtil;

public class Resuelto implements IEstado {
    @Override
    public void estadoAbierto(Incidente incidente) {
        System.out.println("Incidente Resuelto , no puede ser abierto");
    }

    @Override
    public void estadoEnReparacion(Incidente incidente) {
        System.out.println("Incidente Resuelto , no puede asignarse el tecnico");
    }

    @Override
    public void estadoResuelto(Incidente incidente) {


        System.out.println("Incidente Resuelto");
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        incidente.setEstadoIncidente("Resuelto");
        em.merge(incidente);
        em.close();
    }
    public String toString() {
        return "Estado: Resuelto";
    }
}
