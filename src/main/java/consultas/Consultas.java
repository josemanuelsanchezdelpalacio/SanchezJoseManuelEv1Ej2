package consultas;

import entities.EmpleadoEntity;
import entities.ObraEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import libs.Leer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Consultas {
    public static void insertarObra(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            //introduzco los datos en la tabla de Obra
            ObraEntity nuevaObra = new ObraEntity();
            nuevaObra.setNombre(Leer.pedirCadena("Introduce nombre de obra nueva: "));
            nuevaObra.setDireccion(Leer.pedirCadena("Introduce dirección de la obra: "));

            String fechaStr = Leer.pedirCadena("Introduce fecha de entrega (formato yyyy-MM-dd): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaEntrega = new Date(dateFormat.parse(fechaStr).getTime());
            nuevaObra.setEntrega(fechaEntrega);

            em.persist(nuevaObra);
            transaction.commit();
            System.out.println("Obra insertada correctamente.");
        } catch (ParseException e) {
            System.err.println("Error al parsear la fecha. Asegúrate de usar el formato yyyy-MM-dd.");
        }
    }

    public static void cambiarObra(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();

        try {
            //comenzamos a crear el contexto de persistencia
            transaction.begin();

            //muestro lista empleados
            List<EmpleadoEntity> empleados = em.createQuery("from EmpleadoEntity", EmpleadoEntity.class).getResultList();
            System.out.println("Empleados disponibles:");
            for (EmpleadoEntity empleado : empleados) {
                System.out.println("ID EMPLEADO: " + empleado.getId() + ". NOMBRE EMPLEADO: " + empleado.getNombre() + ". ID OBRA ASIGNADA: " + empleado.getIdObra());
            }

            //busco el empleado para modificar su idObra
            int empleadoBuscado = Leer.pedirEntero("Introduce el ID del empleado para modificar la obra asignada: ");
            Query queryEmpleado = em.createQuery("from EmpleadoEntity where id = ?1").setParameter(1, empleadoBuscado);

            EmpleadoEntity empleadoActual = (EmpleadoEntity) queryEmpleado.getSingleResult();

            if (empleadoActual != null) {
                //muestro lista obras
                List<ObraEntity> obras = em.createQuery("from ObraEntity", ObraEntity.class).getResultList();
                System.out.println("Obras disponibles:");
                for (ObraEntity obra : obras) {
                    System.out.println("ID OBRA: " + obra.getId() + ". NOMBRE OBRA: " + obra.getNombre());
                }

                //busco el nombre de la obra
                String obraBuscada = Leer.pedirCadena("Introduce el ID de la obra para asignar al empleado: ");
                Query queryObra = em.createQuery("from ObraEntity where id = ?1").setParameter(1, obraBuscada);

                ObraEntity obra = (ObraEntity) queryObra.getSingleResult();
                empleadoActual.setIdObra(obra.getId());

                em.persist(empleadoActual);
                System.out.println("Los datos de la obra asociada al empleado han sido actualizados");
            } else {
                System.out.println("No se encontró el empleado con el ID proporcionado");
            }

            //al hacer el commit, los cambios se pasan a la base de datos
            transaction.commit();

        } catch (NoResultException e) {
            System.out.println("No se encontró el empleado con el ID proporcionado");
        }
    }
}
