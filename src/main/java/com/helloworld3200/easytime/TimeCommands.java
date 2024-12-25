package com.helloworld3200.easytime;


public class TimeCommands {
	private static final TimeCommand DAY = new TimeCommand(
			"day", "time set day"
	);

	private static final TimeCommand NIGHT = new TimeCommand(
			"night", "time set night"
	);

	private static final TimeCommand NOON = new TimeCommand(
			"noon", "time set noon"
	);

	private static final TimeCommand MIDNIGHT = new TimeCommand(
			"midnight", "time set midnight"
	);

	private static final TimeCommand[] TIME_COMMANDS = {DAY, NIGHT, NOON, MIDNIGHT};

	public void registerCommands() {
		for (TimeCommand cmd : TIME_COMMANDS) {
			cmd.registerCommand();
		}


	}
}
