package ca.infoway.messagebuilder.maven.util;

import org.apache.maven.plugin.Mojo;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;

/**
 * <p>This class provides an implementation of the output UI that connects to the 
 * Maven output/log mechanism.  When the generator tools indicate that information 
 * should be displayed to the user, this class directs that output to the appropriate
 * Maven constructs.
 * 
 * @author administrator
 */
public class OutputUIImpl implements OutputUI {
	
	private final Mojo mojo;

	/**
	 * <p>Default constructor.
	 * @param mojo - the plugin that will generate the output log events.
	 */
	public OutputUIImpl(Mojo mojo) {
		this.mojo = mojo;
	}

	/**
	 * <p>Perform logging.
	 * 
	 * @param level - the log level (e.g. "INFO", "WARN", etc.)
	 * @param message - the message that should be written to the log.
	 */
	public void log(LogLevel level, String message) {
		if (level == null) {
			level = LogLevel.INFO;
		}
		switch (level) {
		case DEBUG:
			this.mojo.getLog().debug(message);
			break;
		case INFO:
			this.mojo.getLog().info(message);
			break;
		case WARN:
			this.mojo.getLog().warn(message);
			break;
		case ERROR:
		case SEVERE:
			this.mojo.getLog().error(message);
		default:
		}
	}
}