package com.helloworld3200.easytime;

public class TimeCommands {
	private final TimeCommand DAY = new TimeCommand(
			"day", "time set day"
	);

	private final TimeCommand NIGHT = new TimeCommand(
			"night", "time set night"
	);

	private final TimeCommand NOON = new TimeCommand(
			"noon", "time set noon"
	);

	private final TimeCommand MIDNIGHT = new TimeCommand(
			"midnight", "time set midnight"
	);

	private final TimeCommand[] TIME_COMMANDS = {DAY, NIGHT, NOON, MIDNIGHT};

	public void registerCommands() {
		for (TimeCommand cmd : TIME_COMMANDS) {
			cmd.registerCommand();
		}
	}

	public TimeCommands() {
		EasyTime.LOGGER.info("Registering time commands");
	}
}
