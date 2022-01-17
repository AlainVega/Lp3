package clases.renumeracion;

public class Remuneracion {	
	
	public int id;
	public String tipoMoneda;
	public double monto;
	public String tipoRemuneracion;
	public boolean exentaGrabada;
	public boolean RemuValida;
	public int tipoImpuesto;
	public int deUsuario;
	public int paraUsuario;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getTipoRemuneracion() {
		return tipoRemuneracion;
	}

	public void setTipoRemuneracion(String tipoRemuneracion) {
		this.tipoRemuneracion = tipoRemuneracion;
	}

	public boolean isExentaGrabada() {
		return exentaGrabada;
	}

	public void setExenta_grabada(boolean exentaGrabada) {
		this.exentaGrabada = exentaGrabada;
	}

	public boolean isRemuValida() {
		return RemuValida;
	}

	public void setRemuValida(boolean RemuValida) {
		this.RemuValida = RemuValida;
	}

	public int getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(int tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	
}
