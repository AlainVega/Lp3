package clases.usuario;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

//Clase base para los diferentes usuarios que estaran en el sistema.

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Usuario {
	//Generacion del id de la clase, si es que el id recibido es null, con su respectiva estrategia.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String nombre;
	public String correo;
	private String contrasena;
	private double capital = 0;
	protected String rol;		//Los valores posibles del campo rol son: SP (SPonsor), IM (IMplementador), BR (BRainstormer), AI (Angel Investor).
	public long organizacionId;		// id de la organizacion a la que el usuario pertenece.
	
	//Se especifica el formato de la fecha para poder cargar en los campos correspondientes.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public LocalDate membresiaFechaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public LocalDate membresiaFechaExpiracion;

	//Getters y Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public long getOrganizacionId() {
		return organizacionId;
	}
	
	public void setOrganizacionId(long organizacionId) {
		this.organizacionId = organizacionId;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getMembresiaFechaInicio() {
		return membresiaFechaInicio;
	}

	public void setMembresiaFechaInicio(LocalDate membresiaFechaInicio) {
		this.membresiaFechaInicio = membresiaFechaInicio;
	}

	public LocalDate getMembresiaFechaExpiracion() {
		return membresiaFechaExpiracion;
	}

	public void setMembresiaFechaExpiracion(LocalDate membresiaFechaExpiracion) {
		this.membresiaFechaExpiracion = membresiaFechaExpiracion;
	}
}
