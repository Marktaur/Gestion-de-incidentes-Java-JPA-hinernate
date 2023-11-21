package entidades;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class PruebaConexionJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            System.out.println("prueba de coneccion");
            // Nombre de la unidad de persistencia, debe coincidir con el nombre en persistence.xml
            String persistenceUnitName = "EntidadSitemasGestion";
            System.out.println("prueba de coneccion 2");

            // Crear el EntityManagerFactory
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            System.out.println("prueba de coneccion 3");
            // Crear el EntityManager
            em = emf.createEntityManager();

            // Realizar una consulta simple a la entidad Clientes
            clientes cliente = em.find(clientes.class, 1L); // Suponiendo que 1L es el ID del cliente

            // Imprimir los resultados
            if (cliente != null) {
                System.out.println("Cliente encontrado: " + cliente.getRazonS());
            } else {
                System.out.println("Cliente no encontrado.");
            }

        } catch (Exception e) {
            // Imprimir mensaje si hay un error en la conexión
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}