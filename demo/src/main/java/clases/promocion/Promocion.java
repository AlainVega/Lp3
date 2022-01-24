package clases.promocion;
import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Promocion {
	
	//Generacion del id de la clase, si es que el id recibido es null, con su respectiva estrategia.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String producto;
	public int idOrg;
	//Definimos formato de la fecha, que recibiremos, para su posterior asignacion a estos atributos.
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy" ,timezone = "UTC-3") 
	public LocalDate fechaEmision;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy" ,timezone = "UTC-3")
	public LocalDate fechaFin;
	
	//Getters y Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getIdOrg() {
		return idOrg;
	}
	public void setIdOrg(int idOrg) {
		this.idOrg = idOrg;
	}
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
