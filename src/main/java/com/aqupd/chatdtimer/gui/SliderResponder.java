package com.aqupd.chatdtimer.gui;

import static com.aqupd.chatdtimer.config.Configuration.setTime;

import net.minecraft.client.gui.GuiPageButtonList;

public class SliderResponder implements GuiPageButtonList.GuiResponder {
  @Override
  public void func_175321_a(int id, boolean idk) {}
  @Override
  public void onTick(int id, float value) {
    switch (id) {
      case 1:
        setTime((int) value);
    }
  }

  @Override
  public void func_175319_a(int id, String text) {}
}
