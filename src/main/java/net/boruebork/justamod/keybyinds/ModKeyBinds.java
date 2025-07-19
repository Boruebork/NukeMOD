package net.boruebork.justamod.keybyinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

public class ModKeyBinds {
    public static final KeyMapping RELOAD_KEY = new KeyMapping("key.justamod.reload",
            InputConstants.KEY_R, "category.justamod.justkeys");
    public static void register(RegisterKeyMappingsEvent event){
        event.register(RELOAD_KEY);
    }
}
