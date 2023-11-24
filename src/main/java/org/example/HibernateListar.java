package org.example;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;



public class HibernateListar {


    public static <T> void ejecutarConsulta(Supplier<EntityManager> entityManagerSupplier, String jpql, Class<T> resultClass, Consumer<List<T>> resultConsumer) {
        EntityManager em = entityManagerSupplier.get();
        List<T> resultados = em.createQuery(jpql, resultClass).getResultList();
        //la funcion consulta basicamente toma la consulta de la entidad segun los parametros que le pasemos
        // y la convierte en una lista para poder consumirla .
        resultConsumer.accept(resultados);
        em.close();//cierro consulta

    }
}
