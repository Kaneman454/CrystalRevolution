package crystalrevolution.gameobjs.container;

import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.handlers.helpers.JewelCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerJewelcraftingTable extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerJewelcraftingTable(InventoryPlayer InvP, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 3, 3);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		int i;
		int k;
		
		this.addSlotToContainer(new SlotCrafting(InvP.player, craftMatrix, craftResult, 0, 124, 36));
		
        for (i = 0; i < 3; ++i)
        {
            for (k = 0; k < 3; ++k)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, k + i * 3, 30 + k * 18, 17 + i * 18));
            }
        }

        for (i = 0; i < 3; ++i)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(InvP, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(InvP, i, 8 + i * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		if(worldObj.getBlock(posX, posY, posZ) != ModBlocks.jewelcraftingTable) {
			return false;
		}else{
			return p.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (p_82846_2_ == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
	            {
	                if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                {
	                    return null;
	                }
	            }
	            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(p_82846_1_, itemstack1);
	        }

	        return itemstack;
	    }
	
	public void onCraftMatrixChanged(IInventory iiventory) {
		craftResult.setInventorySlotContents(0, JewelCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}

	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
	
}
