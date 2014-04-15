package applicationSimulateur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import domaineConduite.Voiture;

public class DessinVoiture extends JFrame implements KeyListener{

	public static final int TailleFenetreEnPixels = 500;
	
	private int xPixelVoiture;
	private Voiture voiture;

	public DessinVoiture(Voiture voiture) {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.voiture = voiture;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
		graphics.fillRect(xPixelVoiture, 200, 40, 20);
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
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

}
