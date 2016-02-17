package kiviat.rp.tb;


public class KiviattException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par defaut
	 */
	public KiviattException() {
        super("Exception during Kiviatt use !");
    }
    
	/**
	 * Constructeur de la classe
	 * @param message Message de l'exception
	 */
    public KiviattException(String message) {
        super(message);
    }
    
}
