package clases.remuneracion;

import javax.persistence.Entity;

@Entity
public class RemuneracionImpuesto extends Remuneracion {

	public String tipoImpuesto;
	public double porcentajeImpuesto;
	
	public RemuneracionImpuesto() {
		// TODO Auto-generated constructor stub
	}

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
