/**
 *
 */
package net.xaviersala.farwest;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

/**
 * @author xavier
 *
 */
public class ArmariImatges {

    /**
     * Singleton.
     */
    private static ArmariImatges instance;

    /**
     * Lloc on es pinten les imatges.
     */
    private App pantalla;
    /**
     * Llista de objectes del joc.
     */
     private ArrayList<Cosa>personatges;

    /**
     * Lloc on es guarden les imatges.
     */
    private Hashtable<String, GImage> armari;
    /**
     * Crea l'armari d'imatge.
     */
    private ArmariImatges() {
        armari = new Hashtable<String, GImage>();
        personatges = new  ArrayList<Cosa>();
    }

    /**
     * Obtenir la instancia de l'armari.
     * @return retorna una instància a l'armari
     */
    public static ArmariImatges getInstance() {
        if (instance == null) {
            instance = new ArmariImatges();
        }
        return instance;
    }

    /**
     * Referència a l'escriptori.
     * @param ref Pantalla on s'escriurà
     */
    public void setPantalla(final App ref) {
        pantalla = ref;
    }

    /**
     * @return the pantalla
     */
    public App getPantalla() {
        return pantalla;
    }

    /**
     * Afegir personatge al joc.
     * @param tipus personatge
     */
    public void addPersonatge(final Cosa tipus) {
        personatges.add(tipus);
        pantalla.add(tipus.getImatge());
    }

    /**
     * Afegir un Cowboy.
     * @param quina per definir quina imatge del cowboy afegim
     * @param x posició x
     * @param y posició y
     * @return posició on s'afegeix
     */
    public int addCowBoy(final String quina, final double x, final double y) {
        CowBoy c = new CowBoy(getImatge(quina), x, y);
        personatges.add(c);
        pantalla.add(c.getImatge());
        return personatges.size() - 1;
    }

    /**
     * Afegeix una bala a l'escenari.
     * @param quin Imatge de la bala
     * @param x posició x
     * @param y posició y
     * @param d direcció
     * @return Retorna la bala generada
     */
    public Bala addBala(final String quin, final double x, final double y,
            final double d) {
        Bala b = new Bala(getImatge(quin), x, y, d);
        pantalla.add(b.getImatge());
        return b;
    }

    /**
     * Treure bala.
     * @param b bala a treure
     */
    public void removeBala(final Bala b) {
        pantalla.remove(b.getImatge());
    }

    /**
     * Obtenir el CosaMobil (x).
     * @param i quin volem obtenir
     * @return Retorna l'objecte especificat
     */
    public Cosa getPersonatge(final int i) {
        return personatges.get(i);
    }

    /**
     * Treure imatge de la pantalla.
     * @param g Imatge a treure
     */
    public void removePersonatge(final Cosa g) {
        // TODO treure el element de l'arraylist
        pantalla.remove(g.getImatge());
    }

    /**
     * Comprova si la bala xoca amb un 'personatge'.
     * @param bala La bala que comprovem
     * @return si ha xocat
     */
    public boolean balaXoca(final Bala bala) {
        GRectangle rectBala = bala.getRectanglePosicio();

        for (Cosa personatge: personatges) {
            if (personatge.getRectanglePosicio().intersects(rectBala)) {
                personatge.tocat();
                return true;
            }
        }
        return false;
    }

    /**
     * Afegeix una imatge a l'armari.
     * @param nom nom de la imatge
     */
    public final void setImatge(final String nom) {
        armari.put(nom, new GImage(nom));
    }

    /**
     * Retorna la imatge.
     * @param nom imatge que es vol recuperar
     * @return Imatge a recuperar
     */
    public final Image getImatge(final String nom) {
        return armari.get(nom).getImage();
    }

    /**
     * Moure tots els personatges.
     */
    public final void mou() {
        for (Iterator< Cosa > it = personatges.iterator(); it.hasNext();) {
            Cosa p = it.next();
            if (p instanceof CosaMobil) {
                ((CosaMobil) p).mou();
            }
        }
    }
}
