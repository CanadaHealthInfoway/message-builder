package ca.infoway.messagebuilder.generator;

public class SysoutLogUI implements LogUI {

	public void log(LogLevel level, String message) {
		System.out.println(message);
	}
}
