package crystalrevolution.gameobjs.gui;

import java.util.List;

import javax.swing.border.CompoundBorder;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ISpecialArmor;

public class InventoryBackpack implements IInventory{

	private static final String LIST_TAG = "CRYSTAL_BACKPACK";
	
	public ItemStack[] iStack = new ItemStack[104];
	public String uniqueID = "";
	
	public void writeToNBT(NBTTagCompound tagCompound) {
		NBTTagList list = new NBTTagList();
		
		for(byte b = 0; b < iStack.length; b++){
			if(iStack[b] != null && iStack[b].stackSize > 0){
				NBTTagCompound tag = new NBTTagCompound();
				list.appendTag(tag);
				tag.setByte("slot", b);
				iStack[b].writeToNBT(tag);
			}
		}
		
		tagCompound.setTag(LIST_TAG, list);
		tagCompound.setString("uniqueID", uniqueID);
		tagCompound.setInteger("invSize", getSizeInventory());
	}
	
	@Override
	public void closeInventory() {
		
	}

	@Override
	public ItemStack decrStackSize(int slot, int arg1) {
		ItemStack stack = getStackInSlot(slot);
		
		if (stack != null)
		{
			if(stack.stackSize > arg1)
			{
				stack = stack.splitStack(arg1);
				markDirty();
			}
			else
			{
				setInventorySlotContents(slot, null);
			}
		}
		
		return stack;
	}

	@Override
	public String getInventoryName() {
		return "inv.backpack.name";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public int getSizeInventory() {
		return 104;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return iStack[slot];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		
		ItemStack stack = getStackInSlot(slot);
		
		if (stack != null)
		{
			setInventorySlotContents(slot, null);
		}
		
		return stack;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack iStack) {
		return true;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p) {
		return true;
	}

	@Override
	public void markDirty() {
		
		for (int i = 0; i < 104; ++i)
		{
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
			{
				iStack[i] = null;
			}
		}
		
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		
		iStack[slot] = stack;
		
		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		
		markDirty();
		
	}

	
}
