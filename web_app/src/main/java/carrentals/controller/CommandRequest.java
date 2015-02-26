package carrentals.controller;

import javax.servlet.http.HttpServletRequest;

import carrentals.controller.commands.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class CommandRequest {
	private static Logger logger=Logger.getLogger(CommandRequest.class);
	
	private static CommandRequest instance = null;
	private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private CommandRequest() {
		commands.put("index", new IndexCommand());
		commands.put("cars", new CarsCommand());
		commands.put("orderlist", new OrderlistCommand());
		commands.put("order", new OrderCommand());
        commands.put("makeorder", new MakeOrderCommand());
        commands.put("profile", new ProfileCommand());
		commands.put("registrationform", new RegistrationFormCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("search", new SearchCommand());
		commands.put("searchcars", new SearchCarsCommand());
		commands.put("checklogin", new CheckLoginCommand());
		commands.put("userout", new UserOutCommand());
		commands.put("local", new LocaleCommand());
		commands.put("updateprofile", new UpdateCommand());
		commands.put("updateorder", new UpdateOrderCommand());
		
		logger.debug("CommandExtractor was create");
	}

	public static CommandRequest getInstance() {
		if (instance == null) {
			instance = new CommandRequest();
		}
		return instance;
	}
	
	public ICommand getCommand(HttpServletRequest request){
		String action=request.getParameter("command");
		
		logger.debug("action = " + action);
		
		ICommand command=commands.get(action);
		return command;
	}

}
