# Unfocused Chat Delay

# How to change time:
Go to Options > Chat Settings > use **Unfocused Chat Delay** slider

![setting](https://i.imgur.com/7GcZZWk.png)

# things for me:
Need to put this thing into CLI arguments of Minecraft Client configuration
```
--tweakClass org.spongepowered.asm.launch.MixinTweaker --mixin mixins.chatdtimer.json
```