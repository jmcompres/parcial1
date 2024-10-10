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
			System.out.println("Qu� le gustar�a hacer?:");
			System.out.println("(1): Enviar trabajo");
			System.out.println("(2): Observar el pr�ximo trabajo a procesar");
			System.out.println("(3): Salir");
			System.out.println("Opci�n: ");
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
					
					System.out.println("Le gustar�a cambiar la prioridad de su env�o (por defecto es media)?");
					System.out.println("(1): s�");
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
							System.out.println(option+" no era una opci�n");
							break;
						}
						break;
					case 2:
						break;
					default:
						System.out.println(option + " no era una opci�n");
						break;
					}
					ps.sendJob(pj);
					System.out.println("Trabajo enviado con �xito");
					
					break;
					
				case 2:
					PrintJob p = ps.processNextJob();
					if (p!=null)
					{
						System.out.println("Se proces� el siguiente trabajo:");
						System.out.println(p.toString());
					}
					else System.out.println("La cola de impresi�n est� vac�a");
					break;
					
				case 3:
					active = false;
					break;
				
				default:
					System.out.println("La opci�n "+option+" no existe");
					break;
			}
		}
	}

}
