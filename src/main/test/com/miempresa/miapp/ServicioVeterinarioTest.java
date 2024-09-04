package main.test.com.miempresa.miapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.java.com.miempresa.miapp.Mascota;
import main.java.com.miempresa.miapp.ServicioVeterinario;
import main.java.com.miempresa.miapp.Veterinario;

class ServicioVeterinarioTest {


	@Test
	void TestCalcularEdadPromedioMascotaConPromedioDiferente0() {
		ArrayList<Mascota> mascota = new ArrayList<>();
		mascota.add(new Mascota("Pepe", "perro", 5));
		mascota.add(new Mascota("Lupe", "gato", 5));

		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);
		Mockito.when(mockVeterinario.obtenerMascotas()).thenReturn(mascota);
		double promedio = servicio.calcularEdadPromedioMascotas();
		assertEquals(promedio, 5);

	}

	@Test
	void TestCalcularEdadPromedioMascotaConPromedio0() {
		ArrayList<Mascota> mascota = new ArrayList<>();

		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);

		double promedio = servicio.calcularEdadPromedioMascotas();
		assertEquals(promedio, 0);

	}
	
	@Test
	void TestEsMascotaRegistradaConMascotaRegistrada() {
		String nombreMascota = "Pepe";
		Mascota mascota = new Mascota(nombreMascota, "perro", 5);

		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		Mockito.when(mockVeterinario.buscarMascotaPorNombre(nombreMascota)).thenReturn(mascota);

		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);
		boolean estaRegistrada = servicio.esMascotaRegistrada(nombreMascota);

		assertTrue(estaRegistrada);
	}

	@Test
	void TestEsMascotaRegistradaConMascotaNoRegistrada() {
		String nombreMascota = "Pepe";

		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		Mockito.when(mockVeterinario.buscarMascotaPorNombre(nombreMascota)).thenReturn(null);

		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);
		boolean estaRegistrada = servicio.esMascotaRegistrada(nombreMascota);

		assertFalse(estaRegistrada);
	}
	
	@Test
	void TestEsMascotaRegistradaConNombreNulo() {
		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			servicio.esMascotaRegistrada(null);
		});

		assertEquals("No se admiten nombres nulos", exception.getMessage());
	}

	@Test
	void TestRegistrarMascota() {
		Mascota mascota = new Mascota("Pepe", "perro", 5);

		Veterinario mockVeterinario = Mockito.mock(Veterinario.class);
		ServicioVeterinario servicio = new ServicioVeterinario(mockVeterinario);

		servicio.registrarMascota(mascota);

		Mockito.verify(mockVeterinario).agregarMascota(mascota);
	}
	
	

}
