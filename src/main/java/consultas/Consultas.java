package consultas;

import entities.EmpleadoEntity;
import entities.ObraEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import libs.Leer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Consultas {
    public static void insertarObra(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        //comenzamos a crear el contexto de persistencia
        transaction.begin();

        //introduzco los datos en la tabla de Obra
        ObraEntity nuevaObra = new ObraEntity();
        nuevaObra.setNombre(Leer.pedirCadena("Introduce nombre de obra nueva: "));
        nuevaObra.setDireccion(Leer.pedirCadena("Introduce direccion de la obra: "));
        nuevaObra.setEntrega(Date.valueOf(LocalDate.now()));

        em.persist(nuevaObra);
        transaction.commit();
        System.out.println("Obra insertada correctamente.");
    }

    public static void cambiarObra(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        // comenzamos a crear el contexto de persistencia
        transaction.begin();

        try {
            //muestro la lista de obras
            List<ObraEntity> obras = em.createQuery("from ObraEntity", ObraEntity.class).getResultList();
            for (ObraEntity obra : obras) {
                System.out.println(obra.getId() + ". " + obra.getNombre());
            }

            String obraBuscada = Leer.pedirCadena("Introduce el título de la obra para modificar el empleado: ");
            Query queryObra = em.createQuery("from ObraEntity where nombre = ?1").setParameter(1, obraBuscada);

            ObraEntity obra = (ObraEntity) queryObra.getSingleResult();

            if (obra != null) {
                //muestro la lista de empleados
                List<EmpleadoEntity> empleados = em.createQuery("from EmpleadoEntity", EmpleadoEntity.class).getResultList();
                for (EmpleadoEntity empleado : empleados) {
                    System.out.println(empleado.getId() + ". " + empleado.getNombre());
                }

                //obtengo el empleado actual asignado a la obra
                Query queryEmpleado = em.createQuery("from EmpleadoEntity where idObra = ?1").setParameter(1, obra.getId());
                EmpleadoEntity empleadoActual = (EmpleadoEntity) queryEmpleado.getSingleResult();

                //modifico los datos del empleado asignado a la obra
                String nuevoEmpleado = Leer.pedirCadena("Introduce el nuevo nombre del empleado: ");
                empleadoActual.setNombre(nuevoEmpleado);

                em.persist(empleadoActual);
                System.out.println("Los datos del empleado asociado a la obra actualizados");
            } else {
                System.out.println("No se encontro la obra con el nombre proporcionado");
            }
        } catch (NoResultException e) {
            System.out.println("No se encontro la obra con el titulo proporcionado");
        }

        // al hacer el commit, los cambios se pasan a la base de datos
        transaction.commit();
    }
}
