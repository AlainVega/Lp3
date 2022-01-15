package clases.usuario;

import clases.renumeracion.Remuneracion;

public class Administrador extends Usuario {

	public boolean autorizar_pago(Remuneracion pago) {
		boolean booleano = true;
		if (!pago.Remu_valida) {
			pago.setRemu_valida(true);
			booleano = true;
		}
		
		return booleano;
	}
}
