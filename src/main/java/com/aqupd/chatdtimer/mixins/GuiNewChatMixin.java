package com.aqupd.chatdtimer.mixins;

import static com.aqupd.chatdtimer.config.Configuration.time;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(GuiNewChat.class)
public class GuiNewChatMixin extends Gui {
  @ModifyArg(
    method = "printChatMessageWithOptionalDeletion(Lnet/minecraft/util/IChatComponent;I)V",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;setChatLine(Lnet/minecraft/util/IChatComponent;IIZ)V"),
    index = 2
  )
  private int mixin(int updateCounter){
    System.out.println(updateCounter);
    return updateCounter - 200 + time * 20;
  }
}
