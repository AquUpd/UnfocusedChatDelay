package com.aqupd.chatdtimer.config;

import static com.aqupd.chatdtimer.ChatDTimer.LOGGER;
import static com.aqupd.chatdtimer.ChatDTimer.logprefix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuration {
  public static int time = 10;
  private static final File configFile = new File("./config/AqMods/ChatDTimer.properties");

  public static void setTime(int t){
    time = t;
    saveOptions();
  }

  public static void loadOptions() throws IOException {
    if (!configFile.exists() || configFile.length() == 0) saveOptions();

    BufferedReader bufferedreader = new BufferedReader(new FileReader(configFile));
    String s;

    while ((s = bufferedreader.readLine()) != null) {
      String[] astring = s.split(":");
      if (astring[0].equals("time")) time = Integer.parseInt(astring[1]);
    }
  }

  public static void saveOptions() {
    try {
      Files.createDirectories(Paths.get("./config/AqMods/"));

      if (!configFile.exists()) configFile.createNewFile();
      if (configFile.exists()) {
        PrintWriter printwriter = new PrintWriter(new FileWriter(configFile));
        printwriter.println("time:" + time);
        printwriter.close();
      }
    } catch (Exception exception) {
      LOGGER.error(logprefix + "Failed to save options", exception);
    }
  }
}
