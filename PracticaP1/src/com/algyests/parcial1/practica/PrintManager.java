package com.algyests.parcial1.practica;

import java.util.Scanner;

public class PrintManager {

	public static void main(String[] args) {
		boolean active = true;
		int option;
		Scanner sc = new Scanner(System.in);
		PrintService ps = PrintService.getInstance();
		
		while (active)
		{
			System.out.println();
			System.out.println();
			System.out.println("Qué le gustaría hacer?:");
			System.out.println("(1): Enviar trabajo");
			System.out.println("(2): Observar el próximo trabajo a procesar");
			System.out.println("(3): Salir");
			System.out.println("Opción: ");
			option = sc.nextInt();
			
			switch (option)
			{
				case 1:
					String username;
					System.out.println("Digite su nombre de usuario: ");
					username = sc.next();
					int h,m,s;
					System.out.println("Digite hora/minutos/segundos separados por un espacio: ");
					h = sc.nextInt();
					m = sc.nextInt();
					s = sc.nextInt();
					Hora hora = new Hora(h,m,s);
					
					PrintJob pj = new PrintJob(username,hora);
					
					System.out.println("Le gustaría cambiar la prioridad de su envío (por defecto es media)?");
					System.out.println("(1): sí");
					System.out.println("(2): no");
					option = sc.nextInt();
					switch(option)
					{
					case 1:
						System.out.println("Nueva prioridad");
						System.out.println("(1): Alta");
						System.out.println("(2): Baja");
						option = sc.nextInt();
						switch(option)
						{
						case 1:
							pj.setPrio('H');
							break;
						case 2:
							pj.setPrio('L');
							break;
						default:
							System.out.println(option+" no era una opción");
							break;
						}
						break;
					case 2:
						break;
					default:
						System.out.println(option + " no era una opción");
						break;
					}
					ps.sendJob(pj);
					System.out.println("Trabajo enviado con éxito");
					
					break;
					
				case 2:
					PrintJob p = ps.processNextJob();
					if (p!=null)
					{
						System.out.println("Se procesó el siguiente trabajo:");
						System.out.println(p.toString());
					}
					else System.out.println("La cola de impresión está vacía");
					break;
					
				case 3:
					active = false;
					break;
				
				default:
					System.out.println("La opción "+option+" no existe");
					break;
			}
		}
	}

}
