package packTest;

import static org.junit.Assert.*;

import org.junit.Test;

import packGestores.GestorNivel;
import packModelo.DatosJuego;

public class NivelTest {

	@Test
	public void testModificarDatosNivelFacil() {
		// 0 = facil
		GestorNivel.getGestorNivel().modificarDatosNivel(0);
		assertEquals(180, DatosJuego.DINERO_INICIAL);
		assertEquals(9, DatosJuego.FILAS_TABLERO);
		assertEquals(9, DatosJuego.COLUMNAS_TABLERO);
		assertEquals(4, DatosJuego.INI_MISIL);
		assertEquals(2, DatosJuego.INI_MISIL_NS);
		assertEquals(2, DatosJuego.INI_MISIL_EO);
		assertEquals(1, DatosJuego.INI_MISIL_BOOM);
		assertEquals(3, DatosJuego.INI_ESCUDO);
		assertEquals(3, DatosJuego.INI_USOS_RADAR);
		
		// fail("Not yet implemented");
	}

	@Test
	public void testModificarDatosNivelNormal() {
		// 1 = normal
		GestorNivel.getGestorNivel().modificarDatosNivel(1);
		assertEquals(150, DatosJuego.DINERO_INICIAL);
		assertEquals(10, DatosJuego.FILAS_TABLERO);
		assertEquals(10, DatosJuego.COLUMNAS_TABLERO);
		assertEquals(3, DatosJuego.INI_MISIL);
		assertEquals(1, DatosJuego.INI_MISIL_NS);
		assertEquals(1, DatosJuego.INI_MISIL_EO);
		assertEquals(0, DatosJuego.INI_MISIL_BOOM);
		assertEquals(2, DatosJuego.INI_ESCUDO);
		assertEquals(2, DatosJuego.INI_USOS_RADAR);


		// fail("Not yet implemented");
	}

	@Test
	public void testModificarDatosNivelDificil() {
		// 2 = dificil
		GestorNivel.getGestorNivel().modificarDatosNivel(2);
		assertEquals(130, DatosJuego.DINERO_INICIAL);
		assertEquals(12, DatosJuego.FILAS_TABLERO);
		assertEquals(12, DatosJuego.COLUMNAS_TABLERO);
		assertEquals(2, DatosJuego.INI_MISIL);
		assertEquals(0, DatosJuego.INI_MISIL_NS);
		assertEquals(0, DatosJuego.INI_MISIL_EO);
		assertEquals(0, DatosJuego.INI_MISIL_BOOM);
		assertEquals(1, DatosJuego.INI_ESCUDO);
		assertEquals(1, DatosJuego.INI_USOS_RADAR);

		
		// fail("Not yet implemented");
	}

}
