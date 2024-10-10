package com.algyests.parcial1.practica;

public class PrintJob {
	String usuario;
	Hora hora;
	char prioridad;
	
	public PrintJob(String usuario, Hora hora) {
		super();
		this.usuario = usuario;
		this.hora = hora;
		this.prioridad = 'M'; //prioridad Media por defecto
	}
	
	public String toString()
	{
		return usuario+" - "+hora.toString()+" - "+prioridad;
	}
	
	public void setPrio(char prio)
	{
		this.prioridad = prio;
	}
}
