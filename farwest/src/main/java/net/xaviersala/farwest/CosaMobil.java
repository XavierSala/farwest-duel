package net.xaviersala.farwest;

import java.awt.Image;

import acm.graphics.GImage;

/**
 * Defineix un objecte que es mou per pantalla.
 *
 * @author xavier
 *
 */
public abstract class CosaMobil extends Cosa {

    /**
     * Direcció del moviment en graus.
     */
    private double direccio;
    /**
     * Velocitat del moviment.
     */
    private double velocitat;
    /**
     * Construeix un personatge a partir del fitxer que conté la imatge.
     * @param fitxer nom del fitxer
     */
    public CosaMobil(final String fitxer) {
        super(fitxer);
        velocitat = 0;
        direccio = 0;
        // TODO Auto-generated constructor stub
    }

    /**
     * Construeix un personatge a partir de la imatge.
     * @param img nom del fitxer
     */
    public CosaMobil(final Image img) {
        super(img);
        velocitat = 0;
        direccio = 0;
    }

    /**
     * Construeix una cosa a partir d'una imatge
     * i la posiciona en les coordenades que se li
     * especifiquen.
     *
     * @param img imatge a posar
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public CosaMobil(final Image img, final double x, final double y) {
        super(img, x, y);
        velocitat = 0;
        direccio = 0;
    }

    /**
     * Els personatges es poden moure.
     */
    public void mou() {
        GImage dibuix = getImatge();
        dibuix.movePolar(velocitat, direccio);
    }

    /**
     * Defineix una nova direcció.
     * @param angle en graus de la nova direcció
     */
    public final void setDireccio(final double angle) {
        direccio = angle;
    }

    /**
     * Retorna la direcció en la que s'està movent.
     * @return la direcció en graus
     */
    public final double getDireccio() {
        return direccio;
    }

    /**
     * Defineix una nova velocitat per l'objecte.
     * @param mida velocitat en píxels
     */
    public final void setVelocitat(final double mida) {
        velocitat = mida;
    }

    /**
     * @return Obtenir la velocitat
     */
    public final double getVelocitat() {
        return velocitat;
    }
}
