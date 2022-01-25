package clases.pago;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Pago {

	//Generacion del id de la clase, si es que el id recibido es null, con su respectiva estrategia.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public long idRemuneracion;		//id de la remuneracion asociada
	public long idUsuario;			//id de quien paga
	public long idOrganizacion;		//id a quien paga
	public double subTotal;			//monto si posible impuesto
	public double impuesto;			//valor numerico del impuesto, si es que hay impuesto asociado a la remuneracion
	public double total;			//la suma de subtotal e impuesto
	
	//Getters y Setters
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
