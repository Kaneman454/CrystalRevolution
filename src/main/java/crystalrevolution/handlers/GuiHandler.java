package crystalrevolution.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import crystalrevolution.Main;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.container.ContainerJewelcraftingTable;
import crystalrevolution.gameobjs.container.ContainerSmeltery;
import crystalrevolution.gameobjs.gui.GuiJewelcraftingTable;
import crystalrevolution.gameobjs.gui.GuiSmeltery;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;
import crystalrevolution.utils.References;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer p, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null){
			switch (ID) {
				case References.GUI_SMELTERY:
				if(tileEntity instanceof TileEntitySmeltery){
					return new ContainerSmeltery(p.inventory, (TileEntitySmeltery)tileEntity);
				}
			}
		}
		
		if(ID == References.GUI_Jewelcrafting){
			return ID == References.GUI_Jewelcrafting && world.getBlock(x, y, z) == ModBlocks.jewelcraftingTable ? new ContainerJewelcraftingTable(p.inventory, world, x, y, z) : null;
		}
		return null;
	}
		
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer p, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null){
			switch (ID) {
				case References.GUI_SMELTERY:
				if(tileEntity instanceof TileEntitySmeltery){
					return new GuiSmeltery(p.inventory, (TileEntitySmeltery)tileEntity);
				}
			}
		}
		
		if(ID == References.GUI_Jewelcrafting){
			return ID == References.GUI_Jewelcrafting && world.getBlock(x, y, z) == ModBlocks.jewelcraftingTable ? new GuiJewelcraftingTable(p.inventory, world, x, y, z) : null;
		}
		
		return null;
	}


}
