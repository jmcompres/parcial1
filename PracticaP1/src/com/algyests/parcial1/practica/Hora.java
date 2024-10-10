package com.algyests.parcial1.practica;

public class Hora {
	int h;
	int m;
	int s;
	
	public Hora(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}
	
	public static boolean isLater(Hora hora1, Hora hora2) //método para confirmar si la hora1 es más tarde que la hora2
	{
		if (hora1.h > hora2.h) return true;
		else if (hora1.h == hora2.h)
		{
			if (hora1.m > hora2.m) return true;
			else if (hora1.m == hora2.m)
			{
				if (hora1.s > hora2.s) return true;
				else return false;
			}
			else return false;
		}
		else return false;
	}
	
	public String toString()
	{
		return h+":"+m+":"+s;
	}
}
