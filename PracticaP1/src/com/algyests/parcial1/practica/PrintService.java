package com.algyests.parcial1.practica;

public class PrintService {
	private static PrintService instance = null;
	PrintQueue queue;
	
	private PrintService()
	{
		this.queue = new PrintQueue();
	}
	
	public static PrintService getInstance()
	{
		if (instance == null) instance = new PrintService();
		return instance;
	}
	
	public PrintJob processNextJob()
	{
		return queue.dequeue();
	}
	
	public void sendJob(PrintJob p)
	{
		queue.enqueue(p);
		return;
	}
}
