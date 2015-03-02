package crystalrevolution.gameobjs.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import crystalrevolution.gameobjs.container.ContainerSmeltery;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;
import crystalrevolution.libs.LibMisc;

public class GuiSmeltery extends GuiContainer{
	
	 private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(LibMisc.MOD_ID + ":textures/gui/container/smeltery.png");
	    private TileEntitySmeltery tileSmeltery;
	    private static final String __OBFID = "CL_00000758";

	    public GuiSmeltery(InventoryPlayer p_i1091_1_, TileEntitySmeltery p_i1091_2_)
	    {
	        super(new ContainerSmeltery(p_i1091_1_, p_i1091_2_));
	        this.tileSmeltery = p_i1091_2_;
	    }

	    /**
	     * Draw the foreground layer for the GuiContainer (everything in front of the items)
	     */
	    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	    {
	        String s = this.tileSmeltery.hasCustomInventoryName() ? this.tileSmeltery.getInventoryName() : I18n.format(this.tileSmeltery.getInventoryName(), new Object[0]);
	        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	    }

	    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	    {
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

	        if (this.tileSmeltery.isBurning())
	        {
	            int i1 = this.tileSmeltery.getBurnTimeRemainingScaled(13);
	            this.drawTexturedModalRect(k + 37, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
	            i1 = this.tileSmeltery.getSmeltingProgressScaled(34);
	            this.drawTexturedModalRect(k + 75, l + 21, 176, 14, i1, 44);
	        }
	    }
}
