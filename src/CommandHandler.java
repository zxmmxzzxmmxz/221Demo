import java.util.stream.Stream;
import Exception.InvalidCommandException;
public class CommandHandler {
    static final String ACCEPTED_COMMANDS[] = {
            "create",
            "up",
            "down",
            "left",
            "right",
            "save",
            "load"
    };
    public static String validateCommand(String command) throws InvalidCommandException {
        if(!command.startsWith("!")){
            throw new IllegalArgumentException("Command has to start with !");
        }
        String option = command.substring(1);
        for (String acceptedCommand : ACCEPTED_COMMANDS) {
            if(acceptedCommand.equals(option)){
                return option;
            }
        }
        throw new InvalidCommandException();
    }
}
