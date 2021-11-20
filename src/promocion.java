import java.util.ArrayList;
import java.util.Date;

public class promocion implements servicio_promocion {
	
	public int id;
	public String producto;
	public int id_org;
	public Date fecha_emision = new Date();
	public Date fecha_fin = new Date();
	
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
		return id_org;
	}
	public void setId_org(int id_org) {
		this.id_org = id_org;
	}
	public Date getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	@Override
	public promocion crear_promocion(promocion promo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminar_promocion(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public promocion modificar_promocion(promocion promo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Integer> buscar_promocion(String producto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Integer> buscar_promocion(int id_org) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
