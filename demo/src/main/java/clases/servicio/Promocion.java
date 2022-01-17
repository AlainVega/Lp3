package clases.servicio;
import java.util.ArrayList;
import java.util.Date;

public class Promocion {
	
	public int id;
	public String producto;
	public int idOrg;
	public Date fechaEmision = new Date();
	public Date fechaFin = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getId_org() {
		return idOrg;
	}
	public void setId_org(int idOrg) {
		this.idOrg = idOrg;
	}
	public Date getFecha_emision() {
		return fechaEmision;
	}
	public void setFecha_emision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFecha_fin() {
		return fechaFin;
	}
	public void setFecha_fin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
