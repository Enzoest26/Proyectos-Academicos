package arreglos;


import clases.Retiro;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArregloRetiro  {
	//Atributo Privado
	private ArrayList <Retiro> re;
	//Constructor
	public ArregloRetiro() {
		re = new ArrayList <Retiro> ();
		cargarRetiro();
	}
	//Operaciones publicas basicas
	public void adicionar(Retiro x) {
		re.add(x);
		grabarRetiro();
	}
	public int tamanio() {
		return re.size();
	}
	public Retiro obtener(int i) {
		return re.get(i);
	}
	public void actualizarArchivos() {
		grabarRetiro();
	}
	public Retiro buscar(int codigo) {
		for(int i = 0; i<tamanio();i++) {
			if(obtener(i).getNumRetiro() == codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	public void eliminar(Retiro x) {
		re.remove(x);
		grabarRetiro();
	}
	private void grabarRetiro() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			pw = new PrintWriter(new FileWriter("retiro.txt"));
			for(int i = 0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getNumRetiro() + ";" + 
						x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e) {
			
		}
	}
	private void cargarRetiro() {
		try {
			BufferedReader br;
			int codRetiro, codMatricula;
			String linea, fecha, hora;
			String[] s;
			br = new BufferedReader(new FileReader("retiro.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codRetiro = Integer.parseInt(s[0].trim());
				codMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(codRetiro, codMatricula, fecha, hora));
			}
			br.close();
		}
		catch(Exception e) {
			
		}
	}
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 20001;
		else
			return obtener(tamanio()-1).getNumRetiro() + 1;
	}
	
}