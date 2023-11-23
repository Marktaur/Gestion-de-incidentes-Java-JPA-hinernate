package org.example.entety;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Java elije el autoincremental
    @Column(name = "Cliente_ID")
    private long id;
    private String razonS;
    private String cuit;
    @Column(name = "TipoServicio")
    private String tipoServicio;

    public  Cliente(){};


    public void agregarCliente(){
        System.out.println("Se agrego un cliente");
    }
    public void darBajaCliente(){}
    public void modificarDatosCliente(){}

    public void AgregarServicio(){}
    public void modificarSrvicio(){}
    public void darBajaServicio(){}

    public void setNombre(String nuevoNombre) {
    }
}

