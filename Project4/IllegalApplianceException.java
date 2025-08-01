/**
 * @author Fahmin Rahman
 * This java file creates a unique exception for serial number. This is basially act
 * like the IllegalArgumentException but with a different label. This is beneficial
 * to separate the different forms or error handeling, which will
 * have different message, hence a clearer understanding of what error ia happening.
 */
public class IllegalApplianceException extends IllegalArgumentException {
    public IllegalApplianceException (String s){
        super(s); //takes the serialnumber from parent classes to act like the IllegalArgumentException
    }
}
