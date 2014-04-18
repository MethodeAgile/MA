package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int coordYEnMetres;
	private int vitesseXMetreParSecondes;
	private int vitesseYMetreParSecondes;

	private int angle;
	private int vitesse;

	public static final int largeurDomaine = 1000;
	
	public static final int CONSTANTE_ACCELERATION = 5;
	public static final int CONSTANTE_ROTATION = 5;
	public static final int MIN_VITESSE = 0;
	public static final int MAX_VITESSE = 200;
	public static final int MAX_ANGLE = 180;
	public static final int MIN_ANGLE = -180;

	public Voiture(int coordXEnMetres, int coordYEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseXMetreParSecondes = 0;
		this.vitesseYMetreParSecondes = 0;
		this.vitesse = 0;
		this.angle = 0;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres, int vitesseXMetreParSecondes, int vitesseYMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseXMetreParSecondes = vitesseXMetreParSecondes;
		this.vitesseYMetreParSecondes = vitesseYMetreParSecondes;
		this.vitesse = 0;
		this.angle = 0;
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres, int angle) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.angle = angle;
		this.vitesse = 0;
	}

	public int getCoordXEnMetres() {
		return this.coordXEnMetres;
	}

	public int getCoordYEnMetres() {
		return this.coordYEnMetres;
	}

	public int getVitesseXMetreParSecondes() {
		return this.vitesseXMetreParSecondes;
	}

	public int getVitesseYMetreParSecondes() {
		return this.vitesseYMetreParSecondes;
	}
	
	public void avancerEnFonctionDeLaVitesseEtAngle() {
		miseAJourPosition();
		notificationObservateurs();
	}

	private void miseAJourPosition() {
		this.coordXEnMetres += ((Double)(Math.cos(this.angle / 180.00 * Math.PI) * this.vitesse)).intValue();
		this.coordYEnMetres += ((Double)(Math.sin(this.angle / 180.00 * Math.PI) * this.vitesse)).intValue();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getAngle() {
		return this.angle;
	}

	public void accelerer() {
		this.vitesse += CONSTANTE_ACCELERATION;
		if(this.vitesse > MAX_VITESSE){
			this.vitesse = MAX_VITESSE;
		}
	}

	public void decelerer() {
		this.vitesse -= CONSTANTE_ACCELERATION;
		if(this.vitesse < MIN_VITESSE){
			this.vitesse = MIN_VITESSE;
		}
	}

	public void tournerGauche() {
		this.angle -= CONSTANTE_ROTATION;
		if(this.angle < MIN_ANGLE){
			this.angle = MIN_ANGLE;
		}
	}

	public void tournerDroite() {
		this.angle += CONSTANTE_ROTATION;
		if(this.angle > MAX_ANGLE){
			this.angle = MAX_ANGLE;
		}
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}
}