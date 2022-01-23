package clases.pago;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public long idRemuneracion;
	public long idUsuario;
	public long idOrganizacion;
	public double subTotal;
	public double impuesto;
	public double total;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdRemuneracion() {
		return idRemuneracion;
	}
	
	public void setIdRemuneracion(long idRemuneracion) {
		this.idRemuneracion = idRemuneracion;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public long getIdOrganizacion() {
		return idOrganizacion;
	}
	
	public void setIdOrganizacion(long idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	
	public double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public double getImpuesto() {
		return impuesto;
	}
	
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
}
