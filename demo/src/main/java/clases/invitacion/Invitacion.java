package clases.invitacion;
import java.util.Date;

public class Invitacion {
	
	public String de_usuario;
	public String para_usuario;
	public Date fecha_creacion = new Date();
	public Date fecha_expiracion = new Date();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean expiro() {
		java.util.Date hoy = new java.util.Date(); // saco la fecha de hoy
		if ( hoy.after(fecha_expiracion)  ||  hoy.before(fecha_creacion)) { // si no estoy en el rango de vida de la invitacion
			return true;
		} else {
			return false;
		}
	}
//	/etc/init.d/ 
	public String getDe_usuario() {
		return de_usuario;
	}

	public void setDe_usuario(String de_usuario) {
		this.de_usuario = de_usuario;
	}

	public String getPara_usuario() {
		return para_usuario;
	}

	public void setPara_usuario(String para_usuario) {
		this.para_usuario = para_usuario;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(Date fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}
	
}
