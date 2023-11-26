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
@Table(name = "especialidadesTecnicas")
public class EspecialidadesTecnicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Especial_ID")
    private long id;
    @Column(name = "Especial")
    private  String especial;

    @Override
    public String toString() {
        return  String.format("ID = %-3d, Especialidad = '%-20s'", id, especial);
    }

    public EspecialidadesTecnicas() {
    }

    public static void agregarEspecialidad() {

        listarEspecialidades();



        System.out.println();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el Nombre de la Especiliadad a agregar(Max 20 caract):");
        String especial;
        do{ especial = teclado.nextLine();
            if (especial.length()>20){
                System.out.println("Error Max 20 caracteres, vuelva a ingresar");;}
        } while (especial.length() > 20);


        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            EspecialidadesTecnicas c = new EspecialidadesTecnicas();
            c.setEspecial(especial);

            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id de la especialidad registrada es " + c.getId());
            c = em.find(EspecialidadesTecnicas.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void listarEspecialidades() {
        //Lista especialidades
        EntityManager em3 = JpaUtil.getEntityManager();
        List<EspecialidadesTecnicas> espTecnico = em3.createQuery("select c from EspecialidadesTecnicas c", EspecialidadesTecnicas.class).getResultList();
        //Listar Especialidades
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("************* Lista de Especialidades Tecnicas *****************");
        System.out.println("****************************************************************");
        espTecnico.forEach(System.out::println);
        System.out.println("****************************************************************");
        System.out.println();
        em3.close();
    }

    public static void bajaEspecialidad() {

        listarEspecialidades();
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id de la especialidad a eliminar:");
        Long id1 = s.nextLong();
        if( id1!=1){

        EntityManager em2 = JpaUtil.getEntityManager();
        try {
            EspecialidadesTecnicas espTecnico1 = em2.find(EspecialidadesTecnicas.class, id1);
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

    public static void modificarEspecialidad() {

        listarEspecialidades();

        EntityManager em1 = JpaUtil.getEntityManager();

        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println();
            System.out.println("Ingrese el Id de la especilidad a modificar:");
            long id = teclado.nextInt();
            EspecialidadesTecnicas c = em1.find(EspecialidadesTecnicas.class, id);
            teclado.nextLine();
            System.out.println("Ingrese el Nombre de la Especilidad(Max 20 caract):");

            String especial1;
            do{ especial1 = teclado.nextLine();
                if (especial1.length()>20){
                    System.out.println("Error Max 20 caracteres, vuelva a ingresar");}
            } while (especial1.length() > 20);


            System.out.println();
            em1.getTransaction().begin();
            c.setEspecial(especial1);

            em1.merge(c);
            em1.getTransaction().commit();
            System.out.println("el id de la especialidad registrada es " + c.getId());
            c = em1.find(EspecialidadesTecnicas.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em1.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em1.close();
        }


    }
}
