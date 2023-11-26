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
@Table(name = "tiposervicio")
public class TipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Servicio_ID")
    private long id;
    @Column(name = "TipoServ")
    private  String tipoServ;

    @Override
    public String toString() {
        return  String.format("ID = %-3d, Tipo de Servicio = '%-20s'", id, tipoServ);
    }

    public TipoServicio() {
    }

    public static void agregarTipoServicio() {

        listarTipoServicio();



        System.out.println();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del tipo de servicio a agregar(Max 20 caract):");
        String especial;
        do{ especial = teclado.nextLine();
            if (especial.length()>20){
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");;}
        } while (especial.length() > 20);


        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            TipoServicio c = new TipoServicio();
            c.setTipoServ(especial);

            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id del Tipo de servicio  registrado es " + c.getId());
            c = em.find(TipoServicio.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void listarTipoServicio() {
        //Lista especialidades
        EntityManager em3 = JpaUtil.getEntityManager();
        List<TipoServicio> tipo = em3.createQuery("select c from TipoServicio c", TipoServicio.class).getResultList();
        //Listar Especialidades
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("**************** Lista de Tipos de Servicio ********************");
        System.out.println("****************************************************************");
        tipo.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();
    }

    public static void bajaTipoServicio() {

        listarTipoServicio();
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del Tipo de Servicio a eliminar:");
        Long id1 = s.nextLong();
        if( id1!=1){

            EntityManager em2 = JpaUtil.getEntityManager();
            try {
                TipoServicio espTecnico1 = em2.find(TipoServicio.class, id1);
                em2.getTransaction().begin();
                em2.remove(espTecnico1);
                em2.getTransaction().commit();
            } catch (Exception e) {
                em2.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em2.close();
            }}else System.out.println("El Registro 1 no puede ser borrado solo modificado");
    }// se agrega esto para evitar error a la hora de elegir en tecnicos una especilidad 0

    public static void modificarTipoServicio() {

        listarTipoServicio();

        EntityManager em1 = JpaUtil.getEntityManager();

        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("Ingrese el Id del tipo de Servicio a modificar:");
            long id = teclado.nextInt();
            TipoServicio c = em1.find(TipoServicio.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del tipo de Servicio(Max 20 caract):");

            String especial1;
            do{ especial1 = teclado.nextLine();
                if (especial1.length()>20){
                    System.out.println("Error Max 20 caracteres, vuelva a ingresar");}
            } while (especial1.length() > 20);


            System.out.println();
            em1.getTransaction().begin();
            c.setTipoServ(especial1);

            em1.merge(c);
            em1.getTransaction().commit();
            System.out.println("el id del tipo de servicio registrada es " + c.getId());
            c = em1.find(TipoServicio.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em1.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em1.close();
        }


    }
}