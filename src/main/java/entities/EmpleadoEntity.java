package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado", schema = "constructoraH", catalog = "")
public class EmpleadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_obra")
    private int idObra;
    @Basic
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "sueldo")
    private Double sueldo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != that.id) return false;
        if (idObra != that.idObra) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (sueldo != null ? !sueldo.equals(that.sueldo) : that.sueldo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idObra;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (sueldo != null ? sueldo.hashCode() : 0);
        return result;
    }
}
