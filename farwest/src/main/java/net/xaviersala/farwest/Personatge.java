package net.xaviersala.farwest;

import java.awt.Image;

/**
 * aaa.
 *
 * @author xavier
 *
 */
public abstract class Personatge extends CosaMobil {

    /**
     * Construeix el personatge a partir del nom del fitxer.
     * @param fitxer nom del fitxer que conté la imatge
     */
    public Personatge(final String fitxer) {
        super(fitxer);
    }

    /**
     * Construeix un personatge a partir d'una imatge.
     * @param img Imatge del personatge
     */
    public Personatge(final Image img) {
        super(img);
    }

    /**
     * Construeix un personatge a partir d'una imatge
     * i la posiciona en les coordenades que se li
     * especifiquen.
     *
     * @param img imatge a posar
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public Personatge(final Image img, final double x, final double y) {
        super(img, x, y);
    }


    /**
     * Dispara.
     */
    public abstract void dispara();

}
