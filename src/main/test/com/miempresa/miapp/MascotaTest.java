package main.test.com.miempresa.miapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.miempresa.miapp.Mascota;

class MascotaTest {

	  Mascota mascota;

	    @BeforeEach
	    void antes() {
	        mascota = new Mascota("toby", "perro", 10);
	    }

	    @Test
	    void testGetUsername() {
	        String nombre = mascota.getNombre();
	        assertEquals("toby", nombre);
	    }
	    
	    @Test
	    void testGetTipo() {
	    	String tipo = mascota.getTipo();
	    	assertEquals("perro", tipo);
	    }
	    
	    @Test
	    void testGetEdad() {
	    	int edad = mascota.getEdad();
	    	assertEquals(10, edad);
	    }
	
}
