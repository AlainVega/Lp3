import java.util.List;

public class Administrador extends Usuario implements Crud_usuario {

	public boolean autoriza_pago(int id) {
		boolean resultado = false;
		return resultado;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario crear_usuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar_usuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario modificar_usuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscar_usuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
