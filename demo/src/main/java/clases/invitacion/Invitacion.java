package clases.invitacion;
import java.util.Date;

public class Invitacion {
	
	public String deUsuario;
	public String paraUsuario;
	public Date fechaCreacion = new Date();
	public Date fechaExpiracion = new Date();
	
	
	public boolean expiro() {
		java.util.Date hoy = new java.util.Date(); // saco la fecha de hoy
		if ( hoy.after(fechaExpiracion)  ||  hoy.before(fechaCreacion)) { // si no estoy en el rango de vida de la invitacion
			return true;
		} else {
			return false;
		}
	}
//	/etc/init.d/ 
	public String getDeUsuario() {
		return deUsuario;
	}

	public void setDeUsuario(String deUsuario) {
		this.deUsuario = deUsuario;
	}

	public String getParaUsuario() {
		return paraUsuario;
	}

	public void setParaUsuario(String paraUsuario) {
		this.paraUsuario = paraUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
}
