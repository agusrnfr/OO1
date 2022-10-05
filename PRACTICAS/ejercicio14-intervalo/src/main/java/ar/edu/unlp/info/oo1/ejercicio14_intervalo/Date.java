package ar.edu.unlp.info.oo1.ejercicio14_intervalo;

import java.time.LocalDate;

public interface Date {
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays();
	public boolean includesDate(LocalDate other); // esto se repite asi que podria ser una clase abstracta
}
