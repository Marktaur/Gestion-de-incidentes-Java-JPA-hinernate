package org.example.entety;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.util.JpaUtil;
import java.util.List;
import java.util.Scanner;

import static org.example.HibernateListar.ejecutarConsulta;

@Getter
@Setter
@AllArgsConstructor
@Data  //toString
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Java elije el autoincremental
    @Column(name = "Cliente_ID")
    private long id;
    private String razonS;
    private String cuit;
    @Column(name = "TipoServicio")
    private int tipoServicio;


    public  Cliente(){};
    public static void agregarCliente(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Cliente a agregar:");
        String razonS = teclado.nextLine();
        System.out.println("Ingrese el Cuit del Cliente a agregar:");
        String cuit = teclado.nextLine();
        System.out.println("Seleccione de la lista el tipo de servivio contratado");


        System.out.println("area de lista de servicios");

        int numeroServicio = teclado.nextInt();

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Cliente c = new Cliente();

            c.setRazonS(razonS);
            c.setCuit(cuit);
            c.setTipoServicio(numeroServicio);


            em.persist(c);
            em.getTransaction().commit();

            System.out.println("el id del cliente registrado es " + c.getId());
            c = em.find(Cliente.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void darBajaCliente(){}
    public static void modificarDatosCliente(){

        //Listar Clientes



        EntityManager em = JpaUtil.getEntityManager();
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el Id del Cliente a modificar");
            long id = teclado.nextInt();
            Cliente b = em.find(Cliente.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del Cliente:");
            String razonS = teclado.nextLine();
            System.out.println("Ingrese el Cuit del Cliente:");
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
        }
    }




    public void AgregarServicio(){}
    public void modificarSrvicio(){}
    public void darBajaServicio(){}

    public void setNombre(String nuevoNombre) {
    }
}

