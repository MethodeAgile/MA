package applicationSimulateur;

import java.util.Observable;
import java.util.Observer;

import domaineConduite.Voiture;

public class VueVoiture implements Observer {

	private Voiture voiture;
	private DessinVoiture ihm;
	private int dernierePositionXEnMetre;
	private int dernierePositionYEnMetre;

	public VueVoiture(Voiture voiture, DessinVoiture ihm) {
		this.voiture = voiture;
		this.voiture.addObserver(this);
		this.ihm = ihm;
		this.dernierePositionXEnMetre = this.voiture.getCoordXEnMetres();
		this.dernierePositionYEnMetre = this.voiture.getCoordYEnMetres();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ihm.miseAJour(this.voiture.getCoordXEnMetres(),
				this.voiture.getCoordYEnMetres());
		if (this.dernierePositionXEnMetre != this.voiture.getCoordXEnMetres()
				|| this.dernierePositionYEnMetre != this.voiture.getCoordYEnMetres()) {
			this.dernierePositionXEnMetre = this.voiture.getCoordXEnMetres();
			this.dernierePositionYEnMetre = this.voiture.getCoordYEnMetres();
			ihm.repaint();
		}

	}

	/*
	 * public int transformerMetrePixel(int coordonneeXEnMetre) {
	 * 
	 * int ratioDomaineFenetre = Voiture.largeurDomaine /
	 * DessinVoiture.TailleFenetreEnPixels;
	 * 
	 * int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;
	 * 
	 * return coordonneeXEnPixels; }
	 */

}
