package net.xaviersala.farwest;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representa un cowboy en pantalla...
 *
 *  - Conté un carregador de bales de 6 llocs que es representa com a bales
 * @author xavier
 *
 */
public class CowBoy extends Personatge {
    /**
     * Armari d'imatges.
     */
    private ArmariImatges armari = ArmariImatges.getInstance();
    /**
     * número màxim de bales del carregador.
     */
    private static final int MAXIMBALES = 6;
    /**
     * Carregador de bales.
     */
    private ArrayList<Bala> carregador;
    /**
     * Construeix un cowboy a partir de la seva imatge.
     * @param fitxer fitxer que conté una imatge del cowboy
     */
    public CowBoy(final String fitxer) {
        super(fitxer);
        inicia();
    }

    /**
     * Construeix un Cowvoy a partir d'una imatge.
     * @param img Imatge del personatge
     */
    public CowBoy(final Image img) {
        super(img);
        inicia();
    }

    /**
     * Construeix un Cowboy a partir d'una imatge
     * i la posiciona en les coordenades que se li
     * especifiquen.
     *
     * @param img imatge a posar
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public CowBoy(final Image img, final double x, final double y) {
        super(img, x, y);
        inicia();
    }

    /**
     * Inicia els Cowboys.
     */
    private void inicia() {
        carregador = new ArrayList<Bala>();
        setTipus("Cowboy");
    }

    @Override
    public final void dispara() {
        if (carregador.size() < MAXIMBALES) {
            // Crear una bala i posar la imatge a pantalla
            Bala b = armari.addBala("bala.jpg", getEsquerra(), getDalt(),
                    getDireccio());
            // Avançar fins que surt
            while (b.getRectanglePosicio().intersects(getRectanglePosicio())) {
                b.mou();
            }
            carregador.add(b);
        }
        // Fer clic
    }

    @Override
    public final void mou() {
        super.mou();
        for (Iterator< Bala > it = carregador.iterator(); it.hasNext();) {
            Bala bala = it.next();
            bala.mou();

            if (!bala.dinsPantalla(armari.getPantalla().getWidth(),
                    armari.getPantalla().getHeight())
                    || armari.balaXoca(bala)) {
                armari.removeBala(bala);
                it.remove();
            }
        }

    }

    @Override
    public final boolean tocat() {
        // Eliminar-lo
        getImatge().setVisible(false);
        return true;

    }


}
