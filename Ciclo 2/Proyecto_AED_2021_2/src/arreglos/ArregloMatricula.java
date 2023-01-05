package arreglos;

import clases.Matricula;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloMatricula {
	//  Atributos privados
	private ArrayList <Matricula> matricula;
	//  Constructor
	public ArregloMatricula() {
		matricula = new ArrayList <Matricula> ();
		cargarMatriculas();
	}
	//  Operaciones públicas básicas
	public void adicionar(Matricula x) {
		matricula.add(x);
		grabarMatriculas();
	}
	public int tamanio() {
		return matricula.size();
	}
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	public Matricula buscar(int numMatricula) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getNumMatricula() == numMatricula)
				return obtener(i);
		return null;
	}
	public void eliminar(Matricula x) {
		matricula.remove(x);
		grabarMatriculas();
	}
	public void actualizarArchivo() {
		grabarMatriculas();
	}
	
	private void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matriculas.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea =	x.getNumMatricula() + ";" +
						x.getCodAlumno() + ";" +
						x.getCodCurso() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarMatriculas() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numMatricula, codAlumno, codCurso;
			br = new BufferedReader(new FileReader("matriculas.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {	
		}
	}
	
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 100001;
		else
			return obtener(tamanio()-1).getNumMatricula() + 1;
	}
	public boolean procedecodAlumno(int codAlumno) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodAlumno() == codAlumno &&  obtener(i).getCodAlumno() == 0)
				return false;
		return true;
	}
	
}