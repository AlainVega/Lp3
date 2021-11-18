import java.util.List;

public interface Crud_pago {

	public Remuneracion crear_pago();
	public void eliminar_pago();
	public Remuneracion modificar_pago();
	public List<String> buscar_pago();
	
}
