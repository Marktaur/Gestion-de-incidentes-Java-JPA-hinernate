package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString
public class Cliente {
    private int id;
    private String razonSocial;
    private String cuit;
    private String tipoServicio;


    public void agregarCliente(){
        System.out.println("Se agrego un cliente");
    }
    public void darBajaCliente(){}
    public void modificarDatosCliente(){}

    public void AgregarServicio(){}
    public void modificarSrvicio(){}
    public void darBajaServicio(){}
}
