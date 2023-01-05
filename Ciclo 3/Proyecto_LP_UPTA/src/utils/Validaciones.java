package utils;

public class Validaciones {
	public static final String ID_ALUMNO = "[A][L]\\d{4}";
	public static final String ID_PROFESOR = "[P][R]\\d{4}";
	public static final String ID_CURSO = "[C][U]\\\\d{4}";
	public static final String NOMBRE = "[a-zA-ZáéíóúÁÉÍÓÚnÑ\\s]{3,40}";
	public static final String APELLIDO = "[a-zA-ZáéíóúÁÉÍÓÚnÑ\\s]{3,50}";
	public static final String DNI = "\\d{8}";
	public static final String CELULAR = "\\d{9}";
	public static final String CORREO = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$";
	public static final String CURSO = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}";
}
