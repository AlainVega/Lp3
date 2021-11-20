
public class Remuneracion {	
	
	public int id;
	public String tipo_moneda;
	public double monto;
	public String tipo_remuneracion;
	public boolean exenta_grabada;
	public boolean Remu_valida;
	public int tipo_impuesto;
	public int de_usuario;
	public int para_usuario;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo_moneda() {
		return tipo_moneda;
	}

	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getTipo_remuneracion() {
		return tipo_remuneracion;
	}

	public void setTipo_remuneracion(String tipo_remuneracion) {
		this.tipo_remuneracion = tipo_remuneracion;
	}

	public boolean isExenta_grabada() {
		return exenta_grabada;
	}

	public void setExenta_grabada(boolean exenta_grabada) {
		this.exenta_grabada = exenta_grabada;
	}

	public boolean isRemu_valida() {
		return Remu_valida;
	}

	public void setRemu_valida(boolean remu_valida) {
		Remu_valida = remu_valida;
	}

	public int getTipo_impuesto() {
		return tipo_impuesto;
	}

	public void setTipo_impuesto(int tipo_impuesto) {
		this.tipo_impuesto = tipo_impuesto;
	}

	
}
