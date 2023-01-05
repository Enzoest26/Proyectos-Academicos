package arreglos;

import clases.Curso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ArregloCursos {
	private ArrayList <Curso> curso;
	//Constructor
	public ArregloCursos() {
		curso = new ArrayList <Curso> ();
		cargarCurso();
		
	}
	//Operaciones publicas basicas
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCurso();
	}
	public int tamanio() {
		return curso.size();
	}
	public Curso obtener(int i) {
		return curso.get(i);
	}
	public Curso buscar(int codigo) {
		for(int i = 0; i<tamanio();i++) {
			if(obtener(i).getcodCurso() == codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCurso();
	}
	public void actualizarArchivo() {
		grabarCurso();
	}
	public void cargarCurso() {
		try {
			BufferedReader br;
			String linea, asignatura;
			String[] s;
			int codCurso, ciclo, creditos, horas;
			br = new BufferedReader(new FileReader("curso.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				adicionar(new Curso(codCurso, asignatura,ciclo,creditos , horas));
			}
			br.close();
		}
		catch (Exception e) {	
		}
	}
	public void grabarCurso() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("curso.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea =	x.getcodCurso() + ";" +
						x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void ordernarCodigo() {
		
	}
}
