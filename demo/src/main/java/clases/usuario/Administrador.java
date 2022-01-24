package clases.usuario;

import javax.persistence.Entity;

import clases.remuneracion.Remuneracion;

//Se marca como entidad a la clase, para que pueda ser visible al scaneo definido en archivo Lp3TpfApplication.java
@Entity
public class Administrador extends Usuario {
	/*
	public boolean autorizar_pago(Remuneracion pago) {
		boolean booleano = true;
		if (!pago.RemuValida) {
			pago.setRemuValida(true);
			booleano = true;
		}
		
		return booleano;
	}*/
}
