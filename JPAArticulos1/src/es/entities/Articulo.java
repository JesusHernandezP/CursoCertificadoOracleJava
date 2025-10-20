package es.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULOS")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByIdprod", query = "SELECT a FROM Articulo a WHERE a.idprod = :idprod")
    , @NamedQuery(name = "Articulo.findByCategoria", query = "SELECT a FROM Articulo a WHERE a.categoria = :categoria")
    , @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPROD")
    private Integer idprod;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private double precio;

    public Articulo() {

    }

    public Articulo(Integer idprod) {
        this.idprod = idprod;
    }

    public Articulo(Integer idprod, String categoria, String descripcion, double precio) {
        this.idprod = idprod;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdprod() {
        return idprod;
    }

    public void setIdprod(Integer idprod) {
        this.idprod = idprod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprod != null ? idprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idprod == null && other.idprod != null) || (this.idprod != null && !this.idprod.equals(other.idprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id:" + idprod + " Categoria:" + categoria + " Descripcion:" + descripcion + " Precio:" + precio;
    }

}
