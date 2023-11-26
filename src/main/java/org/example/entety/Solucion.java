
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
@Table(name = "solucion")
public class Solucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Solucion_ID")
    private long id;
    private String solucion;


    @Override
    public String toString() {
        return String.format("ID = %-3d, Especialidad = '%-20s'", id, solucion);
    }

    public Solucion() {
    }

    public static void agregarSolucion() {

        listarSolucion();

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

    public static void listarSolucion() {
        //Lista soluciones
        EntityManager em3 = JpaUtil.getEntityManager();
        List<Solucion> solu = em3.createQuery("select c from Solucion c", Solucion.class).getResultList();
        //Listar Especialidades
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("*************** Lista de Soluciones Tecnicas *******************");
        System.out.println("****************************************************************");
        solu.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();
    }


    public static void bajaSolucion() {

        listarSolucion();

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

    public static void modificarSolucion() {

        listarSolucion();

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

