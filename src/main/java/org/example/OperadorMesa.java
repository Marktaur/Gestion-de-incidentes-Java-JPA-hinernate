package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString
public class OperadorMesa {
    private String nombreOperador;
    private int colchonHoras;


    public void asignarIncidente(){}
    public void desAsignarIncidente(){}
    public void crearIncidente(){}
    public void modificarIncidente(){}
    public void darDeBajaIncidente(){}
    public void enviarNotificacion(){} //Envio de notidicacion de asignacion o designacion al tecnico

}
