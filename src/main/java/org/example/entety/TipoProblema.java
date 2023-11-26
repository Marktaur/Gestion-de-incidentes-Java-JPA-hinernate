
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
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Problema_ID")
    private long id;
    @Column(name = "TipoProblema")
    private String tipoProblema;
    @Column(name = "TiempoRespuestaEstimado")
    private String tiempoRespuestaEstimado;


    @Override
    public String toString() {
        return String.format("ID = %-3d, Tipo de diagnostico = '%-20s',Tiempo de respuesta estimada ='%-5s' Minutos", id, tipoProblema, tiempoRespuestaEstimado);
    }

    public TipoProblema() {
    }

    public static void agregarTipoProblema() {

        listarTipoProblema();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Diagnostico a agregar(Max 20 caract):");

        String problema;
        do {
            problema = teclado.nextLine();
            if (problema.length() > 20) {
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");

            }
        } while (problema.length() > 20);
        System.out.println("Ingrese un tiempo  estimado de solucion(Max 99999 minutos):");

        String problema1;
        do {
            problema1 = teclado.nextLine();
            if (problema1.length() > 5) {
                System.out.println("Error maximo 99999 minutos, vuelva a ingresar");
                ;
            }
        } while (problema1.length() > 5);


        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            TipoProblema c = new TipoProblema();
            c.setTipoProblema(problema);
            c.setTiempoRespuestaEstimado(problema1);

            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id del tipo de diagnostico registrado es " + c.getId());
            c = em.find(TipoProblema.class, c.getId());
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
        System.out.println("*************** Lista de Problemas Tecnicas ********************");
        System.out.println("****************************************************************");
        tipo.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();
    }


    public static void bajaSTipoProblema() {

        listarTipoProblema();

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del diagnostico a eliminar:");
        Long id1 = s.nextLong();
        if (id1 != 1) {

            EntityManager em2 = JpaUtil.getEntityManager();
            try {
                TipoProblema tipo = em2.find(TipoProblema.class, id1);
                em2.getTransaction().begin();
                em2.remove(tipo);
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
            System.out.println("Ingrese el Id del diagnostico a modificar");
            long id = teclado.nextInt();
            TipoProblema c = em1.find(TipoProblema.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del diagnostico(Max 20 caract):");
            String problema;
            do {
                problema = teclado.nextLine();
                if (problema.length() > 20) {
                    System.out.println("Error Max 20 caracteres, vuelva a ingresar");
                    ;
                }
            } while (problema.length() > 20);
            System.out.println("Ingrese un tiempo  estimado de solucion(Max 99999 minutos):");

            String problema1;
            do {
                problema1 = teclado.nextLine();
                if (problema1.length() > 5) {
                    System.out.println("Error maximo 99999 minutos, vuelva a ingresar");
                    ;
                }
            } while (problema1.length() > 5);


            EntityManager em = JpaUtil.getEntityManager();
            try {
                em.getTransaction().begin();

                c.setTipoProblema(problema);
                c.setTiempoRespuestaEstimado(problema1);

                em1.merge(c);
                em1.getTransaction().commit();
                System.out.println("el id del diagnostico registrado es " + c.getId());
                c = em1.find(TipoProblema.class, c.getId());
                System.out.println(c);
            } catch (Exception e) {
                em1.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em1.close();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

