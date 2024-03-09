package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "obra", schema = "constructoraH", catalog = "")
public class ObraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "entrega")
    private Date entrega;
    @OneToMany(mappedBy = "obraByIdObra")
    private Collection<EmpleadoEntity> empleadosById;
    @OneToMany(mappedBy = "obraByIdObra")
    private Collection<MaquinariaEntity> maquinariasById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObraEntity that = (ObraEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (entrega != null ? !entrega.equals(that.entrega) : that.entrega != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (entrega != null ? entrega.hashCode() : 0);
        return result;
    }

    public Collection<EmpleadoEntity> getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(Collection<EmpleadoEntity> empleadosById) {
        this.empleadosById = empleadosById;
    }

    public Collection<MaquinariaEntity> getMaquinariasById() {
        return maquinariasById;
    }

    public void setMaquinariasById(Collection<MaquinariaEntity> maquinariasById) {
        this.maquinariasById = maquinariasById;
    }
}
