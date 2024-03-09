package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "maquinaria", schema = "constructoraH", catalog = "")
public class MaquinariaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic
    @Column(name = "id_obra")
    private int idObra;
    @Basic
    @Column(name = "matricula")
    private String matricula;
    @Basic
    @Column(name = "modelo")
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", updatable = false, insertable = false)
    private EmpleadoEntity empleadoByIdEmpleado;
    @ManyToOne
    @JoinColumn(name = "id_obra", referencedColumnName = "id", updatable = false, insertable = false)
    private ObraEntity obraByIdObra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaquinariaEntity that = (MaquinariaEntity) o;

        if (id != that.id) return false;
        if (idEmpleado != that.idEmpleado) return false;
        if (idObra != that.idObra) return false;
        if (matricula != null ? !matricula.equals(that.matricula) : that.matricula != null) return false;
        if (modelo != null ? !modelo.equals(that.modelo) : that.modelo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idEmpleado;
        result = 31 * result + idObra;
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        return result;
    }

    public EmpleadoEntity getEmpleadoByIdEmpleado() {
        return empleadoByIdEmpleado;
    }

    public void setEmpleadoByIdEmpleado(EmpleadoEntity empleadoByIdEmpleado) {
        this.empleadoByIdEmpleado = empleadoByIdEmpleado;
    }

    public ObraEntity getObraByIdObra() {
        return obraByIdObra;
    }

    public void setObraByIdObra(ObraEntity obraByIdObra) {
        this.obraByIdObra = obraByIdObra;
    }
}
