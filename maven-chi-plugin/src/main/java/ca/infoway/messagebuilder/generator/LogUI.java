package ca.infoway.messagebuilder.generator;

/**
 * <p>A high-level logging interface.
 * 
 * <p>In practice, we intend to direct the log messages to the Maven log mechanism, but
 * we use this interface to isolate the dependency on Maven.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface LogUI {
	
	/**
	 * <p>Write a message to the log.
	 * @param level - the log level ("DEBUG", "INFO", etc.) of the message
	 * @param message - a text message to log
	 */
	public void log(LogLevel level, String message);
}
