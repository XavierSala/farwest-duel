package net.xaviersala.farwest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import acm.graphics.GImage;

/**
 * Comprovació del CowBoy.
 *
 * @author xavier
 *
 */
public class CowBoyTest {
    /**
     * Pantalla límits.
     */
    private static final int MAX = 800;
    /**
     * Angles d'un cercle.
     */
    private static final int ANGLESCERCLE = 360;
    /**
     * Rotació del CowBoy a cada pas.
     */
    private static final int PAS = 45;

    /**
     * Velocitat màxima
     */
    private static final int MAXVELOCITAT = 20;
    /**
     * Classe sota test.
     */
    private CowBoy wayne;
    /**
     * Generació de aleatòris.
     */
    private Random r = new Random();


    /**
     * Inicia el CowBoy.
     * @throws Exception alguna cosa ha fallat
     */
    @Before
    public final void setUp() throws Exception {
        GImage im = new GImage("cowboy.jpg");
        wayne = new CowBoy(im.getImage(),
                (double) r.nextInt(MAX), (double) r.nextInt(MAX));
    }

    /**
     * comprovo que al tocar-lo l'objecte desapareix.
     */
    @Test
    public final void testTocat() {
        assertTrue(wayne.getImatge().isVisible());
        assertTrue(wayne.tocat());
        assertTrue(!wayne.getImatge().isVisible());

    }

    /**
     * Comprovem que la part direccional funciona.
     */
    @Test
    public final void testDireccio() {
        assertTrue(wayne.getDireccio() == 0);

        int angle = r.nextInt(ANGLESCERCLE);
        wayne.setDireccio(angle);
        assertTrue(wayne.getDireccio() == angle);

        wayne.setDireccio(0);
        wayne.giraDireccio(-1 * PAS);
        assertTrue(wayne.getDireccio() == (double) (ANGLESCERCLE - PAS));

        wayne.giraDireccio(PAS);
        assertTrue(wayne.getDireccio() == 0);

        wayne.giraDireccio(PAS);
        assertTrue(wayne.getDireccio() == PAS);
    }

    /**
     * Comprovem el moviment.
     */
    @Test
    public final void testMou() {
        fail("Not yet implemented");
    }

    /**
     * Comprovem que l'objecte dispara.
     */
    @Test
    public final void testDispara() {
        fail("Not yet implemented");
    }

    /**
     * Comprova que la velocitat funciona.
     */
    @Test
    public final void testVelocitat() {
        assertTrue(wayne.getVelocitat() == 0);
        int novaVelocitat = r.nextInt(MAXVELOCITAT);
        wayne.setVelocitat(novaVelocitat);
        assertTrue(wayne.getVelocitat() == novaVelocitat);
    }

}
