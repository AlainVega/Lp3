import java.util.List;

public class Usuario implements servicio_pago{
	
	public int id;
	public String nombre;
	private String contraseña;
	private double capital;
	public String rol;
	public int miembro_organizacion;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getMiembro_organizacion() {
		return miembro_organizacion;
	}

	public void setMiembro_organizacion(int miembro_organizacion) {
		this.miembro_organizacion = miembro_organizacion;
	}

	@Override
	public Remuneracion crear_pago(Remuneracion nuevo_pago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar_pago(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Remuneracion modificar_pago(Remuneracion pago_act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscar_pago(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscar_pago(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
