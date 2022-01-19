package clases.remuneracion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Remuneracion {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String nombreRemuneracion;
	public String tipoMoneda;
	public double montoTotal;
	
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
