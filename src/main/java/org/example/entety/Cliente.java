package org.example.entety;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import org.example.util.JpaUtil;
import java.util.List;
import java.util.Scanner;



@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cliente_ID")
    private long id;
    private String razonS;
    private String cuit;
    @Column(name = "TipoServicio")
    private int tipoServicio;

    @Override
    public String toString() {
        return  String.format("ID = %-3d, Razon Social = '%-20s', Cuit = '%-15s', Tipo Servicio = %d",
                id, razonS, cuit, tipoServicio);}

    public Cliente() {
    }

    public static void agregarCliente() {

        listarClientes();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Cliente a agregar(Max 20 caract):");
        String razonS = teclado.nextLine();
        System.out.println("Ingrese el Cuit del Cliente a agregar(Max 15 caract):");
        String cuit = teclado.nextLine();
        System.out.println("Seleccione de la lista el tipo de servivio contratado");


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

    public static void bajaCliente() {

        listarClientes();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar:");
        Long id1 = s.nextLong();
        EntityManager em2 = JpaUtil.getEntityManager();
        try {
            Cliente cliente = em2.find(Cliente.class, id1);
            em2.getTransaction().begin();
            em2.remove(cliente);
            em2.getTransaction().commit();
        } catch (Exception e) {
            em2.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em2.close();
        }
    }
    public static void listarClientes(){

        EntityManager em1 = JpaUtil.getEntityManager();
        List<Cliente> clientes = em1.createQuery("select c from Cliente c", Cliente.class).getResultList();
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("********************** Lista de Clientes ***********************");
        System.out.println("****************************************************************");
        clientes.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em1.close();

    }

    public static void modificarCliente() {

        listarClientes();

        EntityManager em = JpaUtil.getEntityManager();
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el Id del Cliente a modificar:");
            long id = teclado.nextInt();
            Cliente b = em.find(Cliente.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del Cliente(Max 20 caract):");
            String razonS = teclado.nextLine();
            System.out.println("Ingrese el Cuit del Cliente(Max 15 caract):");
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


}

