package clases.promocion;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Promocion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String producto;
	public int idOrg;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy" ,timezone = "UTC-3") 
	public LocalDate fechaEmision;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy" ,timezone = "UTC-3")
	public LocalDate fechaFin;
	
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
