import java.util.List;

public interface servicio_pago {

	public Remuneracion crear_pago(Remuneracion nuevo_pago);
	public void eliminar_pago(int id);
	public Remuneracion modificar_pago(Remuneracion pago_act);
	public List<String> buscar_pago(int id);
	public List<String> buscar_pago(String tipo);
	
}
