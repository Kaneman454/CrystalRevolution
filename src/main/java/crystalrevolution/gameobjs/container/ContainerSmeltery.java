package crystalrevolution.gameobjs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;

public class ContainerSmeltery extends Container{

	private TileEntitySmeltery tileSmeltery;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
		
	public ContainerSmeltery(InventoryPlayer inventory, TileEntitySmeltery tileEntity) {
	
		this.tileSmeltery = tileEntity;
		this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));	//input
		this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));	//input
		this.addSlotToContainer(new Slot(tileEntity, 2, 15, 35));	//fuel
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, 3, 116, 35));	//output
		int i;
		
		for (i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft) 
	{
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileSmeltery.smelteryCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileSmeltery.smelteryBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileSmeltery.currentItemBurnTime);
	}

	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);
			
			if(this.lastCookTime != this.tileSmeltery.smelteryCookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.tileSmeltery.smelteryCookTime);
			}
			
			if(this.lastBurnTime != this.tileSmeltery.smelteryBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.tileSmeltery.smelteryBurnTime);
			}
			
			if(this.lastItemBurnTime != this.tileSmeltery.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, this.tileSmeltery.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.tileSmeltery.smelteryCookTime;
		this.lastBurnTime = this.tileSmeltery.smelteryBurnTime;
		this.lastItemBurnTime = this.tileSmeltery.currentItemBurnTime;
	}
	
	public void updateProgressBar(int a, int b)
	{
		if(a == 0)
		{
			this.tileSmeltery.smelteryCookTime = b;
		}
		if(a == 1)
		{
			this.tileSmeltery.smelteryBurnTime = b;
		}
		if(a == 2)
		{
			this.tileSmeltery.currentItemBurnTime = b;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
		ItemStack iStack = null;
		Slot slot = (Slot)this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack())
		{
			
			ItemStack itemstack1 = slot.getStack();
            iStack = itemstack1.copy();
			
			if(par2 == 2)
			{
				if(!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, iStack);
			}
			else if(par2 != 1 && par2 != 0)
			{
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
				{
					if(!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if(TileEntitySmeltery.isItemFuel(itemstack1))
				{
		            if (!this.mergeItemStack(itemstack1, 1, 2, false))
	                {
	                    return null;
	                }
				}
	            else if (par2 >= 3 && par2 < 30)
	            {
	                if (!this.mergeItemStack(itemstack1, 30, 39, false))
	                {
	                    return null;
	                }
	            }
	            else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
	            {
	            	return null;
	            }
			}
			else if(!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			
			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == iStack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return iStack;
		
	}
}
