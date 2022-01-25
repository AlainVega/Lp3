package clases.remuneracion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Remuneracion {	
	
	//Generacion del id de la clase, si es que el id recibido es null, con su respectiva estrategia.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String nombreRemuneracion;		//que tipo de remuneracion es.
	public String tipoMoneda;				//que tipo de moneda esta asociada.
	public double montoTotal;				//cual es el monto asociado a esta remuneracion.
	
	//Getters y Setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombreRemuneracion() {
		return nombreRemuneracion;
	}
	
	public void setNombreRemuneracion(String nombreRemuneracion) {
		this.nombreRemuneracion = nombreRemuneracion;
	}
	
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

}
