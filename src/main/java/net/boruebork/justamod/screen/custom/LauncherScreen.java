package net.boruebork.justamod.screen.custom;

import net.boruebork.justamod.JustAMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LauncherScreen extends AbstractContainerScreen<LauncherMenu> {
    private EditBox Xfield;
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID,"textures/gui/launcher/launcher_gui.png");

    public LauncherScreen(LauncherMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {

    }

    /*@Override
    protected void init() {
        super.init();

        this.Xfield = new EditBox(
                this.font,
                -200,
                160,
                50,
                30,
                Component.literal("X")

        );

    }*/

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        /*guiGraphics.drawString(
                this.font,
                this.title,
                -200,
                160,
                3
        );*/
    }
}
