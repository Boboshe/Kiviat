package kiviat.rp.tb;


public class KiviattIllegalArgumentException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par defaut
	 */
	public KiviattIllegalArgumentException() {
        super("Invalid argument during use of Kiviatt");
    }
    
	/**
	 * Constructeur de la classe
	 * @param message Message de l'exception
	 */
    public KiviattIllegalArgumentException(String message) {
        super(message);
    }
}
