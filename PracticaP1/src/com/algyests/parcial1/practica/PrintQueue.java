package com.algyests.parcial1.practica;

public class PrintQueue {
	Nodo head;

	public PrintQueue() {
		this.head = null;
	}
	
	public PrintJob dequeue()
	{
		if (this.head != null)
		{
			PrintJob p = this.head.data;
			this.head = head.next;
			return p;
		}
		return null;
	}
	
	public void enqueue(PrintJob data)
	{
		if (head == null)
		{
			Nodo h = new Nodo(null,data);
			head = h;
			return;
		}
		
		int prio = valuePrio(data.prioridad); //valor numérico para dar valor a la prioridad
		
		Hora h = data.hora;
		
		Nodo n; //nodo índice para el recorrido
		for (n = head; n!=null; n = n.next)
		{
			int nprio = valuePrio(n.data.prioridad);
			if (prio<nprio) continue;
			else if (nprio == prio)
			{
				Hora nhora = n.data.hora;
				if (Hora.isLater(h, nhora)) continue;
				else
				{
					Nodo neonodo = new Nodo(n,data); //si se encuentra su lugar, en función de la prioridad y la hora
					if (n == head) head = neonodo;
					return;
				}
			}
			else
			{
				Nodo neonodo = new Nodo(n,data); //si se encuentra su lugar, en función de la prioridad y la hora
				if (n == head) head = neonodo;
				return;
			}
		}
		Nodo neonodo = new Nodo(null,data); //si no se encuentra su lugar, entonces se inserta al final
		n.next = neonodo;
		return;
	}
	
	private int valuePrio(char prio)
	{
		if (prio == 'H') return 3;
		else if (prio == 'M') return 2;
		else return 1;
	}
}
