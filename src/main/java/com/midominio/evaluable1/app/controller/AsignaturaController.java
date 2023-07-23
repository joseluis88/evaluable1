package com.midominio.evaluable1.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.midominio.evaluable1.app.model.Asignatura;
import com.midominio.evaluable1.app.model.TipoAsignatura;

@Controller
public class AsignaturaController {

	// private List<Asignatura> asignaturas = new ArrayList<>();

	// Controlador de la página de las asignaturas matriculadas, diseñado para que
	// si se matriculan de alguna asignatura solo aparezcan las matriculadas
	@GetMapping("/asignatura/listado/con")
	public String listadoConAlumnos(Model model) {
		List<Asignatura> asignaturasSinAlumnos = Asignatura.getlistaAsignatura().stream()
				.filter(asignatura -> asignatura.getNumeroAlumnosMatriculados() > 0).collect(Collectors.toList());
		model.addAttribute("asignaturas", asignaturasSinAlumnos);
		/*
		 * List<Asignatura> listaAsignaturas = Asignatura.getlistaAsignatura();
		 * model.addAttribute("asignaturas", listaAsignaturas);
		 */
		return "asignatura/asignatura-listado-con";
	}

	// Controlador de la página de las asignaturas sin matriculadas, diseñado para
	// que
	// si se matriculan de alguna asignatura desaparezcan las matriculadas
	@GetMapping("/asignatura/listado/sin")
	public String listadoSinAlumnos(Model model) {
		List<Asignatura> asignaturasSinAlumnos = Asignatura.getlistaAsignatura().stream()
				.filter(asignatura -> asignatura.getNumeroAlumnosMatriculados() == 0).collect(Collectors.toList());
		model.addAttribute("asignaturas", asignaturasSinAlumnos);
		return "asignatura/asignatura-listado-sin";
	}

	// Controlador de la página de las asignaturas matriculadas, diseñado para que
	// si se matriculan de alguna asignatura solo aparezcan las matriculadas
	@GetMapping("/asignatura/listado/conaltasybajas")
	public String listadoConAltasYBaja(Model model) {
		List<Asignatura> listaAsignaturas = Asignatura.getlistaAsignatura();
		model.addAttribute("asignaturas", listaAsignaturas);
		return "asignaturas";
	}

	// Alta de asignaturas
	@GetMapping({ "alta/{idAsignaturaPath}", "alta/{idAsignaturaPath}/" })
	public String altaID(@PathVariable(name = "idAsignaturaPath") Integer idAsignatura, Model model) {

		List<Asignatura> listaAsignaturas = Asignatura.getlistaAsignatura();

		int alumnosMatriculados = listaAsignaturas.get(idAsignatura - 1).getNumeroAlumnosMatriculados();
		alumnosMatriculados++;
		listaAsignaturas.get(idAsignatura - 1).setNumeroAlumnosMatriculados(alumnosMatriculados);

		model.addAttribute("titulo", "Alta Asignaturas");
		model.addAttribute("cabecera", "Bienvenidos a la web de asignaturas");
		model.addAttribute("asignaturas", Asignatura.getlistaAsignatura());

		return "asignaturas";
	}

	// Bajas de asignaturas
	@GetMapping({ "baja/{idAsignaturaPath}", "baja/{idAsignaturaPath}/" })
	public String bajaID(

			@PathVariable(name = "idAsignaturaPath") Integer idAsignatura, Model modelo) {

		int alumnosMatriculados = Asignatura.getlistaAsignatura().get(idAsignatura - 1).getNumeroAlumnosMatriculados();

		if (alumnosMatriculados > 0) {
			alumnosMatriculados--;
			Asignatura.getlistaAsignatura().get(idAsignatura - 1).setNumeroAlumnosMatriculados(alumnosMatriculados);
		}

		modelo.addAttribute("titulo", "Baja Asignaturas");
		modelo.addAttribute("cabecera", "Bienvenidos a la web de asignaturas");
		modelo.addAttribute("asignaturas", Asignatura.getlistaAsignatura());

		return "asignaturas";
	}

	@GetMapping("/asignatura/listado/conaltasybajas/{tipo}")
	public String listadoFiltrado(@RequestParam(name = "tipo", required = false) String tipoFiltro, Model model) {
		List<Asignatura> asignaturasFiltradas = new ArrayList<>();
		List<Asignatura> listaAsignaturas = Asignatura.getlistaAsignatura();

		if (tipoFiltro != null && !tipoFiltro.isEmpty()) {
			TipoAsignatura tipoSeleccionado = TipoAsignatura.valueOf(tipoFiltro);
			asignaturasFiltradas = listaAsignaturas.stream()
					.filter(asignatura -> asignatura.getTipo() == tipoSeleccionado).collect(Collectors.toList());
		} else {
			// Si no se selecciona ninguna opción, mostrar todas las asignaturas
			asignaturasFiltradas = listaAsignaturas;
		}

		model.addAttribute("asignaturas", asignaturasFiltradas);
		return "asignatura/asignatura-listado-filtrado";
	}

}
