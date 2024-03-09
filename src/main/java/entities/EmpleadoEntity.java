package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empleado", schema = "constructoraH", catalog = "")
public class EmpleadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "dni")
    private String dni;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "sueldo")
    private Double sueldo;

    @ManyToOne
    @JoinColumn(name = "id_obra", referencedColumnName = "id", nullable = false)
    private ObraEntity obraByIdObra;

    @OneToMany(mappedBy = "empleadoByIdEmpleado")
    private Collection<MaquinariaEntity> maquinariasById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ObraEntity getObraByIdObra() {
        return obraByIdObra;
    }

    public void setObraByIdObra(ObraEntity obraByIdObra) {
        this.obraByIdObra = obraByIdObra;
    }

    public Collection<MaquinariaEntity> getMaquinariasById() {
        return maquinariasById;
    }

    public void setMaquinariasById(Collection<MaquinariaEntity> maquinariasById) {
        this.maquinariasById = maquinariasById;
    }

    // Optionally, you can override equals and hashCode methods if needed

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(dni, that.dni)) return false;
        if (!Objects.equals(nombre, that.nombre)) return false;
        if (!Objects.equals(sueldo, that.sueldo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, sueldo);
    }
}
