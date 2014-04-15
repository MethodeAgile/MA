package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20, 0) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testGetY(){
		Voiture voiture = new Voiture(20, 30);
		int yVoiture = voiture.getCoordYEnMetres();
		assertEquals(30, yVoiture);
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20, 0, 150, 0);
		
		assertEquals(150,voiture.getVitesseXMetreParSecondes());
	}
	
	@Test
	public void testVitesseY() {
		Voiture voiture = new Voiture(20, 0, 150, 90);
		
		assertEquals(90,voiture.getVitesseYMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesseX() {
		Voiture voiture = new Voiture(20, 0, 100, 0);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	@Test
	public void testGetAngle(){
		Voiture voiture = new Voiture(20,30,45);
		assertEquals(45, voiture.getAngle());
	}
	
}