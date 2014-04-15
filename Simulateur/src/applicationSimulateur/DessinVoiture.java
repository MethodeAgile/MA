package applicationSimulateur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import domaineConduite.Voiture;

public class DessinVoiture extends JFrame implements KeyListener {

	public static final int TailleFenetreEnPixels = 500;
	private int majCoordX;
	private int majCoordY;
	
	
	private Voiture voiture;

	public DessinVoiture(Voiture voiture) {
		super();
		
		this.majCoordX = voiture.getCoordXEnMetres();
		this.majCoordY = voiture.getCoordYEnMetres();
		this.setTitle("Simulateur de Voiture");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.voiture = voiture;this.addKeyListener(this);
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(graphics);
	}

	public void dessinerVoiture(Graphics graphics) {
		graphics.fillRect(majCoordX, majCoordY, 40, 20);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			voiture.accelerer();
			break;
		case KeyEvent.VK_DOWN:
			voiture.decelerer();
			break;
		case KeyEvent.VK_LEFT:
			voiture.tournerGauche();
			break;
		case KeyEvent.VK_RIGHT:
			voiture.tournerDroite();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }

	public void miseAJour(int coordXEnMetres, int coordYEnMetres) {
		this.majCoordX = coordXEnMetres;
		this.majCoordY = coordYEnMetres;
	}

}
