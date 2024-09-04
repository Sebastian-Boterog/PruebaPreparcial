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
	

}
