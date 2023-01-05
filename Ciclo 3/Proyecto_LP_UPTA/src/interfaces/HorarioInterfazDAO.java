package interfaces;

import java.util.ArrayList;

import entidad.Horario;

public interface HorarioInterfazDAO {

	public ArrayList<Horario> listarHorarios();
	public Horario obtenerID(String hora);
}
