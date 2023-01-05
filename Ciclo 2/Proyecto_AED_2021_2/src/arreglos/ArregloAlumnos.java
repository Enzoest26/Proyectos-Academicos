package arreglos;

import clases.Alumno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloAlumnos {
	//Atributo privado
	private ArrayList <Alumno> alu;
	//Constructor
	public ArregloAlumnos() {
		alu = new ArrayList <Alumno> ();
		cargarAlumnos();
	}
	//Operaciones publicas basicas
	public void adicionar(Alumno x) {
		alu.add(x);
		grabarAlumnos();
	}
	public int tamanio() {
		return alu.size();
	}
	public Alumno obtener(int i) {
		return alu.get(i);
	}
	public void actualizarArchivo() {
		grabarAlumnos();
	}
	public Alumno buscar(int codigo) {
		for(int i = 0; i<tamanio();i++) {
			if(obtener(i).getCodAlumno() == codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	public void eliminar(Alumno x) {
		alu.remove(x);
		grabarAlumnos();
	}
	
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea =	x.getCodAlumno() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni;
			String[] s;
			int codAlumno, edad, celular, estado;
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {	
		}
	}
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 20001;
		else
			return obtener(tamanio()-1).getCodAlumno() + 1;
	}
	public int validarDni(String dni) {
		for(int i = 0; i<tamanio();i++) {
			if(dni == obtener(i).getDni()) {
				return 1;
			}
		}
		return -1;
	}
}
