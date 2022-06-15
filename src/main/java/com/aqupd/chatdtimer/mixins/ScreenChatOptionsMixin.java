package com.aqupd.chatdtimer.mixins;

import static com.aqupd.chatdtimer.config.Configuration.time;

import com.aqupd.chatdtimer.gui.SliderResponder;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenChatOptions.class)
public class ScreenChatOptionsMixin extends GuiScreen {

  @Inject(
    method = "initGui()V",
    at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z", ordinal = 2)
  )
  private void mixin(CallbackInfo ci){
    int i = 10;
    this.buttonList.add(
      new GuiSlider(
        new SliderResponder(),
        1,
        this.width / 2 - 155 ,
        this.height / 6 + 24 * (i >> 1),
        I18n.format("chatdtimer.delay.slider"),
        0,
        60,
        time,
        (id, name, value) -> name + ": " + String.format("%d", (int) value) + "s"
        )
    );
  }

  @ModifyArg(
    method = "initGui()V",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiButton;<init>(IIILjava/lang/String;)V"),
    index = 2
  )
  private int mixin(int y){
    return y + 24;
  }
}
