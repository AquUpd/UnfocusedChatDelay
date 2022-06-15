package com.aqupd.chatdtimer;

import com.aqupd.chatdtimer.config.Configuration;
import java.io.IOException;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ChatDTimer.MOD_ID, name = ChatDTimer.MOD_NAME, version = ChatDTimer.VERSION, clientSideOnly = true)
public class ChatDTimer {

	public static final String MOD_ID = "chatdtimer";
	public static final String MOD_NAME = "Unfocused Chat Delay";
	public static final String VERSION = "1.0";
	public static final Logger LOGGER = LogManager.getLogger();
	public static String logprefix = "[AqUpd's " + MOD_NAME + "] ";

	public ChatDTimer() throws IOException {
		Configuration.loadOptions();
	}
}
