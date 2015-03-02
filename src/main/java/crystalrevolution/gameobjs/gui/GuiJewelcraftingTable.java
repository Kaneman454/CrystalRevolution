package crystalrevolution.gameobjs.gui;

import org.lwjgl.opengl.GL11;

import crystalrevolution.gameobjs.container.ContainerJewelcraftingTable;
import crystalrevolution.libs.LibMisc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiJewelcraftingTable extends GuiContainer{

	private ResourceLocation texture = new ResourceLocation(LibMisc.MOD_ID + ":" + "textures/gui/container/jeweltable.png");
	
	public GuiJewelcraftingTable(InventoryPlayer InvP, World world, int x, int y, int z) {
		super(new ContainerJewelcraftingTable(InvP, world, x, y, z));
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForgroundLayer(int i, int j){
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Jewelcrafting Table"), 100, 5, 0x000000);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int i = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		drawTexturedModalRect(i, k, 0, 0, this.xSize, this.ySize);
		
	}

}
