
import consultas.Consultas;
import consultas.EmfSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import libs.Leer;

public class Main {

    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Dar de alta nueva obra");
            System.out.println("2. Cambiar obra asignada a un empleado");

            opcion = Leer.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    Consultas.insertarObra(em);
                    break;
                case 2:
                    Consultas.cambiarObra(em);
                    break;
                default:
                    System.out.println("La opcion seleccionada no existe");
            }
        } while (!salir);
        desconectar();
    }

    private static void desconectar() {
        em.close();
        emf.close();
    }
}