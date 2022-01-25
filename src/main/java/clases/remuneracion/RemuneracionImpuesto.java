package clases.remuneracion;

import javax.persistence.Entity;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class RemuneracionImpuesto extends Remuneracion {
	
	public String tipoImpuesto;				//Tipo de impuesto asociado a la remuneracion/
	public double porcentajeImpuesto;		//cuanto porcentaje corresponde ese impuestpo, no el valor numerico, eso se calcula en pagos.
	
	public RemuneracionImpuesto() {
		// TODO Auto-generated constructor stub
	}

	//Getters y Setters
	public String getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(String tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	public double getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}

	public void setPorcentajeImpuesto(double porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}

}
