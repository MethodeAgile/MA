package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domaineConduite.Voiture;

public class TestVoiture {

	@Test
	public void testConstructeurADeuxParamètres() {
		Voiture voiture = new Voiture(30,40);
		assertEquals(30, voiture.getCoordXEnMetres());
		assertEquals(40, voiture.getCoordYEnMetres());
		assertEquals(0, voiture.getAngle());
		assertEquals(0, voiture.getVitesse());
	}
	
	@Test
	public void testConstructeurATroisParamètres() {
		Voiture voiture = new Voiture(30,40,10);
		assertEquals(30, voiture.getCoordXEnMetres());
		assertEquals(40, voiture.getCoordYEnMetres());
		assertEquals(10, voiture.getAngle());
		assertEquals(0, voiture.getVitesse());
	}
	
	@Test
	public void testConstructeurAQuatreParamètres() {
		Voiture voiture = new Voiture(30,40,10,0);
		assertEquals(30, voiture.getCoordXEnMetres());
		assertEquals(40, voiture.getCoordYEnMetres());
		assertEquals(10, voiture.getVitesseXMetreParSecondes());
		assertEquals(0, voiture.getVitesseYMetreParSecondes());
	}
	
	@Test
	public void testSetAngle() {
		Voiture voiture = new Voiture(20, 0);
		voiture.setAngle(20);
		assertEquals(20, voiture.getAngle());

	}

	
	@Test
	public void testGetX() {
		Voiture voiture = new Voiture(20, 0);

		int xVoiture = voiture.getCoordXEnMetres();

		assertEquals(20, xVoiture);

	}

	@Test
	public void testGetY() {
		Voiture voiture = new Voiture(20, 30);
		int yVoiture = voiture.getCoordYEnMetres();
		assertEquals(30, yVoiture);
	}

	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20, 0, 150, 0);

		assertEquals(150, voiture.getVitesseXMetreParSecondes());
	}

	@Test
	public void testVitesseY() {
		Voiture voiture = new Voiture(20, 0, 150, 90);

		assertEquals(90, voiture.getVitesseYMetreParSecondes());
	}

	@Test
	public void testMiseAjourPositionEnFonctionVitesseEtAngleNull() {
		Voiture voiture = new Voiture(0, 0);
		
		voiture.setVitesse(10);
		voiture.setAngle(0);
		voiture.avancerEnFonctionDeLaVitesseEtAngle();
		assertEquals(10, voiture.getCoordXEnMetres());
		assertEquals(0, voiture.getCoordYEnMetres());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionAngleEtVitesseNull() {
		Voiture voiture = new Voiture(0, 0);
		voiture.setVitesse(0);
		voiture.setAngle(10);
		voiture.avancerEnFonctionDeLaVitesseEtAngle();
		assertEquals(0, voiture.getCoordXEnMetres());
		assertEquals(0, voiture.getCoordYEnMetres());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionAngleEtVitesse() {
		Voiture voiture = new Voiture(0, 0);
		voiture.setVitesse(10);
		voiture.setAngle(90);
		voiture.avancerEnFonctionDeLaVitesseEtAngle();
		assertEquals(0, voiture.getCoordXEnMetres());
		assertEquals(10, voiture.getCoordYEnMetres());
	}

	@Test
	public void testGetAngle() {
		Voiture voiture = new Voiture(20, 30, 45);
		assertEquals(45, voiture.getAngle());
	}

	@Test
	public void testGetVitesse() {
		Voiture voiture = new Voiture(0, 0);
		voiture.setVitesse(50);
		assertEquals(50, voiture.getVitesse());

	}

	@Test
	public void testAcceleration() {
		Voiture voiture = new Voiture(0, 0);
		int acceleration = voiture.getVitesse();
		voiture.accelerer();
		assertEquals(acceleration + Voiture.CONSTANTE_ACCELERATION,
				voiture.getVitesse());
	}

	@Test
	public void testDeceleration() {
		Voiture voiture = new Voiture(0, 0);
		voiture.setVitesse(50);
		int deceleration = voiture.getVitesse();
		voiture.decelerer();
		assertEquals(deceleration - Voiture.CONSTANTE_ACCELERATION,
				voiture.getVitesse());
	}

	@Test
	public void testRotationDroite() {
		Voiture voiture = new Voiture(0, 0);
		voiture.setAngle(50);
		int angle = voiture.getAngle();
		voiture.tournerDroite();
		assertEquals(angle + Voiture.CONSTANTE_ROTATION, voiture.getAngle());
	}

	@Test
	public void testRotationGauche() {
		Voiture voiture = new Voiture(0, 0);
		int angle = voiture.getAngle();
		voiture.tournerGauche();
		assertEquals(angle - Voiture.CONSTANTE_ROTATION, voiture.getAngle());
	}
	
	@Test
	public void testSetVitesse(){
	    Voiture voiture = new Voiture(0, 0);
        voiture.setVitesse(50);
        assertEquals(50, voiture.getVitesse());
	}

}