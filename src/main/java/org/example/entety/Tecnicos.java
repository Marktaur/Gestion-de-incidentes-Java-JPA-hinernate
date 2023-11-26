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
@Table(name = "tecnicos")
public class Tecnicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Java elije el autoincremental
    @Column(name = "Tecnico_ID")
    private long id;
    @Column(name = "Nombre")
    private  String nombre;
    @Column(name = "Especialidad")
    private int especialidad;
    @Column(name = "Mail")
    private String mailTel;

    @Override
    public String toString() {

        return String.format("ID = %-3d, Nombre = '%-20s', Especialidad = %-15d, Mail/Tel = '%s'",
                id, nombre, especialidad, mailTel);
    }

    public Tecnicos() {
    }

    public static void agregarTecnico() {

        listarTecnicos();
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.println("Ingrese el Nombre del Tecnico a agregar(Max 20 caract):");
        String nombre;
        do{ nombre = teclado.nextLine();
            if (nombre.length()>20){
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");;}
        } while (nombre.length() > 20);

        EspecialidadesTecnicas.listarEspecialidades();

        System.out.println("Seleccione un ID de especialidad de la lista a agregar");
        int especialidad = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el Mail o Tel del tecnico(Max 20 caract):");
        String mailTel;
        do{ mailTel = teclado.nextLine();
            if (mailTel.length()>20){
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");;}
        } while (mailTel.length() > 20);


        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Tecnicos c = new Tecnicos();
            c.setNombre(nombre);
            c.setEspecialidad(especialidad);
            c.setMailTel(mailTel);


            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id del Tecnico registrado es " + c.getId());
            c = em.find(Tecnicos.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();

            e.printStackTrace();
        } finally {
            em.close();

        }
    }

    public static void bajaTecnico() {

        listarTecnicos();

        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("Ingrese el id del Tecnico a eliminar:");
        Long id1 = s.nextLong();
        EntityManager em2 = JpaUtil.getEntityManager();
        try {
            Tecnicos tecnico1 = em2.find(Tecnicos.class, id1);
            em2.getTransaction().begin();
            em2.remove(tecnico1);
            em2.getTransaction().commit();
        } catch (Exception e) {
            em2.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em2.close();
        }
    }
    public static void listarTecnicos(){
        EntityManager em3 = JpaUtil.getEntityManager();
        List<Tecnicos> tecnico = em3.createQuery("select c from Tecnicos c", Tecnicos.class).getResultList();
        //Listar Tecnicos
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("********************** Lista de Tecnicos ***********************");
        System.out.println("****************************************************************");
        tecnico.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();

    }

    public static void modificarTecnico() {


        listarTecnicos();

        EntityManager em = JpaUtil.getEntityManager();

        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("Ingrese el Id del Tecnico a modificar");
            long id = teclado.nextInt();
            Tecnicos b = em.find(Tecnicos.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre del Tecnico(Max 20 caract):");
            String nombre;
            do{ nombre = teclado.nextLine();
                if (nombre.length()>20){
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");}
            } while (nombre.length() > 20);


            System.out.println();

            ///Lista especialidades
            EspecialidadesTecnicas.listarEspecialidades();
            System.out.println("Seleccione un ID de especialidad de la lista a agregar");

            int especialidad = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Ingrese el Mail o Tel del tecnico(Mac 20 caract):");
            String mailTel;


            do{ mailTel = teclado.nextLine();
                if (mailTel.length()>20){
                    System.out.println("Error Max 20 caracteres, vuelva a ingresar");;}
            } while (mailTel.length() > 20);

            em.getTransaction().begin();


            b.setNombre(nombre);
            b.setEspecialidad(especialidad);
            b.setMailTel(mailTel);


            em.merge(b);
            em.getTransaction().commit();
            System.out.println("el id del Tecnico registrado es " + b.getId());
            b = em.find(Tecnicos.class, b.getId());
            System.out.println(b);
        } catch (Exception e) {
            em.getTransaction().rollback();

            e.printStackTrace();
        } finally {
            em.close();

        }
    }



}