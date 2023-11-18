package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString
public class areaRecursosHumanos {

    private String nombre;
    private int especialidad;
    private String mail;
    private String tel;


    public void emitirReporteDiarioTecnico(){}
    public void darAltaTecnico(){}
    public void darBajaTecnico(){}
    public void modificarTecnico(){}
    public void medioNotificacion(){}


}
