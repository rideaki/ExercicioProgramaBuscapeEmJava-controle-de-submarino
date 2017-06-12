package com.buscape.submarino.entity.enums;

/**
 * @author Reginaldo
 */
public enum ROTACAO {
    L, R;

    /**
     * Retorna <code>true</code> se contem comando, <code>false</code> caso contrario.
     * @param char comando
     * @return {@link Boolean}
     */
    public static boolean contem(char comando) {
        ROTACAO c = retornaRotacao(comando);
        return c != null;
    }

    /**
     * Retorna o movimento de acordo com o comando
     * @param char comando
     * @return MOVIMENTO movimento
     */
    public static ROTACAO retornaRotacao(char comando) {
        try {
            return valueOf(String.valueOf(comando));
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }
}
