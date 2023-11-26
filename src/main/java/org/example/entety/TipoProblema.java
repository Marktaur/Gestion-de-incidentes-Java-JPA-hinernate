
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
@Table(name = "tipoproblema")
public class TipoProblema{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Java elije el autoincremental
    @Column(name = "Problema_ID")
    private long id;
    @Column(name ="TipoProblema")
    private String tipoProblema;
    @Column(name ="TiempoRespuestaEstimado")
    private int tiempoRespuestaEstimado;


    @Override
    public String toString() {
        return String.format("ID = %-3d, Tipo de diagnostico = '%-20s',Tiempo de respuesta estimada ='%-5s' Minutos", id, tipoProblema,tiempoRespuestaEstimado);
    }

    public TipoProblema() {
    }

    public static void agregarTipoProblema() {

        listarTipoProblema();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre de la Solucion a agregar(Max 20 caract):");

        String soluciones1;
        do {
            soluciones1 = teclado.nextLine();
            if (soluciones1.length() > 20) {
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");
                ;
            }
        } while (soluciones1.length() > 20);


        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Solucion c = new Solucion();
            c.setSolucion(soluciones1);

            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id de la solucion registrada es " + c.getId());
            c = em.find(Solucion.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void listarTipoProblema() {

        EntityManager em3 = JpaUtil.getEntityManager();
        List<TipoProblema> tipo = em3.createQuery("select c from TipoProblema c", TipoProblema.class).getResultList();
        //Listar Diagnosticos
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("*************** Lista de Soluciones Tecnicas *******************");
        System.out.println("****************************************************************");
        tipo.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();
    }


    public static void bajaSTipoProblema() {

        listarTipoProblema();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id de la Solucion a eliminar:");
        Long id1 = s.nextLong();
        if (id1 != 1) {

            EntityManager em2 = JpaUtil.getEntityManager();
            try {
                Solucion solucion2 = em2.find(Solucion.class, id1);
                em2.getTransaction().begin();
                em2.remove(solucion2);
                em2.getTransaction().commit();
            } catch (Exception e) {
                em2.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em2.close();
            }
        } else System.out.println("El Registro 1 no puede ser borrado solo modificado");
    }// se agrega esto para evitar error a la hora de elegir en tecnicos una especilidad 0

    public static void modificarTipoProblema() {

        listarTipoProblema();

        EntityManager em1 = JpaUtil.getEntityManager();

        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("Ingrese el Id de la Solucion a modificar");
            long id = teclado.nextInt();
            Solucion c = em1.find(Solucion.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre de la Solucion(Max 20 caract):");
            String soluciones1;
            do {
                soluciones1 = teclado.nextLine();
                if (soluciones1.length() > 20) {
                    System.out.println("Error Max 20 caracteres, vuelva a ingresar");
                    ;
                }
            } while (soluciones1.length() > 20);
            System.out.println();
            em1.getTransaction().begin();
            c.setSolucion(soluciones1);

            em1.merge(c);
            em1.getTransaction().commit();
            System.out.println("el id de la Solucion registrada es " + c.getId());
            c = em1.find(Solucion.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em1.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em1.close();
        }


    }
}

