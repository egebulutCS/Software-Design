package com.sampleapp.command;

public class CommandFactory {

    private static CommandFactory factory = null;

    private CommandFactory() {
    }

    /**
     * Get an instance of the CommandFactory
     * @return The singleton CommandFactory object
     */
    public synchronized static CommandFactory getInstance() {
        if (factory == null) {      // first time

            factory = new CommandFactory();
        }
        return factory;
    }

    /**
     * 
     * @param commandStr Identifier for the exact Command object required
     * @return The specific Command object requested
     */
    public synchronized Command createCommand(String commandStr) {
    	Command command = null;
    	String packageName = "com.sampleapp.command";
    	
    	try {
    		commandStr = packageName + commandStr + "Command";
    		Class<?> theClass = Class.forName(commandStr);
    		Object object = theClass.newInstance();
    		command = (Command) object;
    	} catch (Exception e) {
    		
    	}

    	//Return the instantiated Command object to the calling code...
    	return command;		// may be null

    }
    
}

