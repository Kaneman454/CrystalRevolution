package crystalrevolution.gameobjs.container;

import crystalrevolution.gameobjs.gui.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerBackpack extends Container{

	InventoryBackpack backpack;
	public boolean updateState;
	
	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return false;
	}
	
	public void saveToNBT(ItemStack iStack) {
		if(!iStack.hasTagCompound()){
			iStack.setTagCompound(new NBTTagCompound());
		}
		
		backpack.writeToNBT(iStack.getTagCompound());
	}

}
