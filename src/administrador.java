import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario implements servicio_usuario, servicio_organizacion, servicio_pago, servicio_promocion {

	public boolean autorizar_pago(Remuneracion pago) {
		boolean booleano = true;
		if (!pago.Remu_valida) {
			pago.setRemu_valida(true);
			booleano = true;
		}
		return booleano;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Organizacion crear_org(Organizacion nueva_organizacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar_org(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Organizacion modificar_org(Organizacion nueva_organizacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> buscar_org(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> buscar_org(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario crear_usuario(Usuario nuevo_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar_usuario(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario modificar_usuario(Usuario usuario_act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> buscar_usuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> buscar_usuario(String rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Remuneracion crear_pago(Remuneracion nuevo_pago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar_pago(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Remuneracion modificar_pago(Remuneracion pago_act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscar_pago(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscar_pago(String tipo) {
		// TODO Auto-generated method stub
		return null;
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
