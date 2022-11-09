package Hospital;

public class Hospital {
	
	private String nombre;

	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void main(String[] args) {

		/*
		 * Enunciado: Se desea crear una aplicacion de gestion de pacientes de un hospital
		 * 				Hospital -> Nombre, salaDeEspera, Consultas, Habitaciones
		 * 				Paciente -> Nombre Apellidos, DNI, sintomas
		 * 				Enfermo -> Nombre, Apellidos, DNI, enfermedad
		 * 				Enfermero -> Nombre, Apellidos, DNI, seccion
		 * 					* atenderPaciente() -> Va a coger a un paciente de la sala de espera y lo va a llevar a la consulta
		 * 				Doctor -> Nombre, Apellidos, DNI, especialidad
		 * 					* diagnosticar() -> devolver un enfermo
		 * 				Consulta -> Doctor, Paciente.
		 * 
		 * 				**** Se pide en el MAIN ****
		 * 				Se tiene que generar 4 pacientes y esten en la Sala de Espera
		 * 				Se tiene que generar 2 doctores, que cada uno de ellos en una consulta
		 * 				Se tiene que generar 2 enfermeros, que cogen a los pacientes de la sala de espera y los asignen a una consulta
		 * 				
		 * 				De la consulta a la que se ha asignado el paciente, el doctor le diagnostica, si el paciente esta grave
		 * 				(para averiguarlo se generara un numero aleatorio del 0 al 10) siendo >7 se ingresa al Enfermo en la
		 * 				primera habitacion vacia. 
		 * 
		 * 				Se tiene que crear un metodo fichar(), para los empleados del hospital, que serian enfermeros y los doctores
		 */
		
		Hospital hospital = new Hospital("Hospital Ibertech");
		hospital.iniciarHospital();
		
	}
	
	// Metodo para crear los doctores
	private void iniciarHospital (){
		Doctor doctor1 = new Doctor("Sergio", "Toretto", 456123, "Cardiologo");
		Doctor doctor2 = new Doctor("Guillermo", "Toretto", 789465, "Traumatologia");
		Doctor[] doctores = {doctor1, doctor2};
		doctor1.fichar(doctor1.getNombre(), doctor1.getApellidos(), doctor1.getDni());
		doctor2.fichar(doctor2.getNombre(), doctor2.getApellidos(), doctor2.getDni());
	
		// Crear los enfermeros
		Enfermero enfermero1 = new Enfermero("Antonia", "Delate", 456132, "Urgencias");
		Enfermero enfermero2 = new Enfermero("Nuria", "Belmonte", 789123, "Psiquiatria");
		Enfermero[] enfermeros = {enfermero1,enfermero2};
		enfermero1.fichar(enfermero1.getNombre(), enfermero1.getApellidos(), enfermero1.getDni());
		enfermero2.fichar(enfermero2.getNombre(), enfermero2.getApellidos(), enfermero2.getDni());
		
	
		// Metodo para crear los enfermero
		Paciente salaDeEspera1 = new Paciente("Dolores", "Fuertes", 132456, "Dolor de tripa");
		Paciente salaDeEspera2 = new Paciente("Estafilo", "Coco", 789123, "No puede mover el brazo");
		Paciente salaDeEspera3 = new Paciente("Sancho", "Panza", 654789, "Migrañas");
		Paciente salaDeEspera4 = new Paciente("Enrique", "Ortega", 321789, "COVID");
		Paciente[] salaDeEspera = {salaDeEspera1,salaDeEspera2,salaDeEspera3,salaDeEspera4};
		
		// Exponemos la sala de espera
		System.out.println("En la sala de espera estan los pacientes: ");
		for (Paciente paciente : salaDeEspera) {
			System.out.println(paciente.toString());
		}
	
		// Creamos las derivaciones a consultas
		Consulta consulta1 = enfermero1.asignarConsulta(doctor1, salaDeEspera1);
		Consulta consulta2 = enfermero2.asignarConsulta(doctor1, salaDeEspera2);
		Consulta consulta3 = enfermero1.asignarConsulta(doctor2, salaDeEspera3);
		Consulta consulta4 = enfermero2.asignarConsulta(doctor2, salaDeEspera4);
		Consulta[] consultas = {consulta1,consulta2,consulta3,consulta4};
		
		// Creamos las habitaciones
		Enfermo habitacion1 = doctor1.diagnosticar(salaDeEspera1);
		Enfermo habitacion2 = doctor1.diagnosticar(salaDeEspera2);
		Enfermo habitacion3 = doctor2.diagnosticar(salaDeEspera3);
		Enfermo habitacion4 = doctor2.diagnosticar(salaDeEspera4);
		Enfermo[] habitaciones= {habitacion1,habitacion2,habitacion3,habitacion4};
		
	}
}
