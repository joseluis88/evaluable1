package com.midominio.evaluable1.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asignatura {
	private int id;
	private String nombre;
	private String descripcion;
	private TipoAsignatura tipo;
	private int numeroCreditos;
	private int numeroAlumnosMatriculados;
	private static List<Asignatura> listaAsignatura = dameAsignaturas();

	public Asignatura() {
	}

	public Asignatura(int id, String nombre, String descripcion, TipoAsignatura tipo, int numeroCreditos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.numeroCreditos = numeroCreditos;
		this.numeroAlumnosMatriculados = 0; // Se inicializa con 0 alumnos matriculados
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public void setTipo(TipoAsignatura tipo) {
		this.tipo = tipo;
	}

	public int getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public int getNumeroAlumnosMatriculados() {
		return numeroAlumnosMatriculados;
	}

	public void setNumeroAlumnosMatriculados(int numeroAlumnosMatriculados) {
		this.numeroAlumnosMatriculados = numeroAlumnosMatriculados;
	}

	public static List<Asignatura> getlistaAsignatura() {
		return listaAsignatura;
	}

	private static List<Asignatura> dameAsignaturas() {
		List<Asignatura> asignaturas = new ArrayList<>();
		Random random = new Random();

		asignaturas.add(new Asignatura(1, "Matemáticas", "Asignatura de matemáticas", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(
				new Asignatura(2, "Historia", "Asignatura de historia", TipoAsignatura.LETRAS, random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(3, "Biología", "Asignatura de biología", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(
				new Asignatura(4, "Física", "Asignatura de física", TipoAsignatura.CIENCIAS, random.nextInt(10) + 3));
		asignaturas.add(
				new Asignatura(5, "Química", "Asignatura de química", TipoAsignatura.CIENCIAS, random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(6, "Literatura", "Asignatura de literatura", TipoAsignatura.LETRAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(7, "Geografía", "Asignatura de geografía", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas
				.add(new Asignatura(8, "Arte", "Asignatura de arte", TipoAsignatura.ARTISTICO, random.nextInt(10) + 3));
		asignaturas.add(
				new Asignatura(9, "Música", "Asignatura de música", TipoAsignatura.ARTISTICO, random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(10, "Informática", "Asignatura de informática", TipoAsignatura.MIXTO,
				random.nextInt(10) + 3));
		asignaturas.add(
				new Asignatura(11, "Idiomas", "Asignatura de idiomas", TipoAsignatura.MIXTO, random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(12, "Filosofía", "Asignatura de filosofía", TipoAsignatura.LETRAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(13, "Educación Física", "Asignatura de educación física", TipoAsignatura.MIXTO,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(14, "Economía", "Asignatura de economía", TipoAsignatura.SOCIALES,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(15, "Derecho", "Asignatura de derecho", TipoAsignatura.SOCIALES,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(16, "Ciencias Políticas", "Asignatura de ciencias políticas",
				TipoAsignatura.SOCIALES, random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(17, "Psicología", "Asignatura de psicología", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(18, "Sociología", "Asignatura de sociología", TipoAsignatura.SOCIALES,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(19, "Biología Marina", "Asignatura de biología marina", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(20, "Antropología", "Asignatura de antropología", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(21, "Arqueología", "Asignatura de arqueología", TipoAsignatura.CIENCIAS,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(22, "Arquitectura", "Asignatura de arquitectura", TipoAsignatura.ARTISTICO,
				random.nextInt(10) + 3));
		asignaturas.add(new Asignatura(23, "Dibujo Técnico", "Asignatura de dibujo técnico", TipoAsignatura.ARTISTICO,
				random.nextInt(10) + 3));

		return asignaturas;
	}

}