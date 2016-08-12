package com.anzanama.everythinginbetween.Client.GUI;

import com.anzanama.everythinginbetween.Common.Container.ContainerPersonalGenerator;
import com.anzanama.everythinginbetween.Common.Inventory.InventoryPersonalGenerator;
import com.anzanama.everythinginbetween.Common.item.ItemPersonalGenerator;
import com.anzanama.everythinginbetween.EverythingInBetween;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


/**
 * Created by Andrew Graber on 8/11/2016.
 */
public class GUIPersonalGenerator extends GuiContainer{

    private float xSize_lo;
    private float ySize_lo;

    private static final ResourceLocation iconLocation = new ResourceLocation(EverythingInBetween.MODID, "textures/gui/container/personal_generator.png");

    private final InventoryPersonalGenerator inventory;

    EntityPlayer player;

    public GUIPersonalGenerator(ContainerPersonalGenerator containerPersonalGenerator, EntityPlayer playerIn){
        super(containerPersonalGenerator);
        this.inventory = containerPersonalGenerator.inventory;
        this.player = playerIn;
    }

    public void drawScreen(int par1, int par2, float par3){
        super.drawScreen(par1, par2, par3);
        this.xSize_lo = (float)par1;
        this.ySize_lo = (float)par2;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        String s = this.inventory.isInvNameLocalized() ? this.inventory.getInvName() : I18n.format(this.inventory.getInvName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 26, this.ySize - 96 + 4, 4210752);

        //Draw Energy Value
        s = player.getEntityData().getInteger("joules") + "J";
        this.fontRendererObj.drawString(s, 109, 39, 0xFF9966);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(iconLocation);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int dynheight = 0;
        if(inventory.getInvItem().getItem() instanceof ItemPersonalGenerator){
            dynheight = (int)((((double)(ItemPersonalGenerator.getPercentFuelUsed(inventory.getInvItem())))/100D)*33);
        }
        this.mc.getTextureManager().bindTexture(iconLocation);
        this.drawTexturedModalRect(k + 70, l + 26, 176, 0, 33, dynheight);
    }

}
