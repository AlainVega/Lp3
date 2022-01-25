package clases.invitacion;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Invitacion {
	
	//Generacion del id de la clase, si es que el id recibido es null, con su respectiva estrategia.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public Long idDeUsuario;
	public Long idParaUsuario;
	//Definimos el formato de las fechas, que recibiremosm, para su posterior asignacion.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public LocalDate fechaCreacion = LocalDate.now();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	public LocalDate fechaExpiracion = LocalDate.now().plusDays(30);
	boolean expirado;		//booleano que nos sirve para determinar si la invitacion ya caduco.

	public Invitacion() {
		
	}
	
	//Getters y Setters
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Long getIdDeUsuario() {
		return idDeUsuario;
	}

	public void setIdDeUsuario(Long idDeUsuario) {
		this.idDeUsuario = idDeUsuario;
	}

	public Long getIdParaUsuario() {
		return idParaUsuario;
	}

	public void setIdParaUsuario(Long idParaUsuario) {
		this.idParaUsuario = idParaUsuario;
	}

	public boolean isExpirado() {
		return expirado;
	}

	public void setExpirado(boolean expirado) {
		this.expirado = expirado;
	}
	
}
