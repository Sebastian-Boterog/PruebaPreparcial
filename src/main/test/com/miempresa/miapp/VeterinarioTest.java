package main.test.com.miempresa.miapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.miempresa.miapp.Mascota;
import main.java.com.miempresa.miapp.Veterinario;

class VeterinarioTest {


    private Veterinario veterinario;

    @BeforeEach
    void Antes() {
        veterinario = new Veterinario();
    }

    @Test
    void testAgregarMascota() {
        Mascota mascota = new Mascota("Rex", "perro", 4);
        veterinario.agregarMascota(mascota);

        assertEquals(1, veterinario.obtenerMascotas().size(), "El número de mascotas debería ser 1");

        Mascota mascotaAgregada = veterinario.obtenerMascotas().get(0);
        assertEquals("Rex", mascotaAgregada.getNombre(), "El nombre de la mascota debería ser Rex");
        assertEquals("perro", mascotaAgregada.getTipo(), "El tipo de la mascota debería ser perro");
        assertEquals(4, mascotaAgregada.getEdad(), "La edad de la mascota debería ser 4");
    }
    
    @Test
    void testBuscarMascotaPorNombre() {
        Mascota mascota1 = new Mascota("Rex", "perro", 4);
        Mascota mascota2 = new Mascota("Lupe", "gato", 3);
        veterinario.agregarMascota(mascota1);
        veterinario.agregarMascota(mascota2);

        Mascota resultado = veterinario.buscarMascotaPorNombre("Rex");
        assertNotNull(resultado, "La mascota debería ser encontrada");
        assertEquals("Rex", resultado.getNombre(), "El nombre de la mascota debería ser Rex");

        resultado = veterinario.buscarMascotaPorNombre("Toby");
        assertNull(resultado, "La mascota no debería ser encontrada");
    }
    
    

}
