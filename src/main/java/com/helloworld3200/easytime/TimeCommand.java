package com.helloworld3200.easytime;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class TimeCommand {
	public static final int CMD_PERM_LEVEL = 2;

	public final String cmdName;
	public final String cmdTimeRedirect;

	int executeCommand(CommandContext<ServerCommandSource> context) {
		// Redirect to the time command with the appropriate time argument
		ServerCommandSource source = context.getSource();

		CommandManager cmdManager = source.getServer().getCommandManager();

		cmdManager.executeWithPrefix(source, cmdTimeRedirect);
		// don't broadcast back to source because the /time set <redirect> will do that already

		return 1;
	}

	void registerCommand() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, env) -> dispatcher.register(CommandManager.literal(cmdName)
                .requires(source -> source.hasPermissionLevel(CMD_PERM_LEVEL))
                .executes(this::executeCommand)
        ));

        EasyTime.LOGGER.info("Successfully registered command: {} with redirect as {}", cmdName, cmdTimeRedirect);
	}

	TimeCommand(String cmdName, String cmdTimeRedirect, boolean... registerImmediateOpt) {
		this.cmdName = cmdName;
		this.cmdTimeRedirect = cmdTimeRedirect;

		// Prepare optional arg registerImmediateArg to default to true if not provided
		final boolean registerImmediate = registerImmediateOpt.length == 0 || registerImmediateOpt[0];
		if (registerImmediate) {
			registerCommand();
		}
	}
}
