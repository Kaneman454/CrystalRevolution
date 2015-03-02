package crystalrevolution.gameobjs.tileentities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.gameobjs.blocks.BlockSmeltery;
import crystalrevolution.handlers.helpers.SmelteryRecipeHandler;

public class TileEntitySmeltery extends TileEntity implements ISidedInventory, IInventory{

	private static final int[] slotsTop = new int[] {0, 1};
	private static final int[] slotsBottom = new int[] {3};
	private static final int[] slotsSides = new int[] {2};
	
	private ItemStack[] slot = new ItemStack[4];
	
	public int smelteryBurnTime;
	public int currentItemBurnTime;
	public int smelteryCookTime;
	
	private String smelteryName;
	
	 /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.slot.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int p_70301_1_)
    {
        return this.slot[p_70301_1_];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.slot[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.slot[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.slot[p_70298_1_];
                this.slot[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.slot[p_70298_1_].splitStack(p_70298_2_);

                if (this.slot[p_70298_1_].stackSize == 0)
                {
                    this.slot[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.slot[p_70304_1_] != null)
        {
            ItemStack itemstack = this.slot[p_70304_1_];
            this.slot[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.slot[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.smelteryName : "container.smeltery";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.smelteryName != null && this.smelteryName.length() > 0;
    }

    public void func_145951_a(String p_145951_1_)
    {
        this.smelteryName = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.slot = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.slot.length)
            {
                this.slot[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.smelteryBurnTime = p_145839_1_.getShort("BurnTime");
        this.smelteryCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.slot[2]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.smelteryName = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.smelteryBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.smelteryCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.slot.length; ++i)
        {
            if (this.slot[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.slot[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.smelteryName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getSmeltingProgressScaled(int p_145953_1_)
    {
        return this.smelteryCookTime * p_145953_1_ / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.smelteryBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.smelteryBurnTime > 0;
    }
    
    public boolean isSmelting()
    {
    	return this.smelteryCookTime > 0;
    }
    
    public void updateEntity()
    {
    	 boolean flag = this.isBurning();
         boolean flag1 = false;

         if (this.isBurning())
         {
             --this.smelteryBurnTime;
         }

         if (!this.worldObj.isRemote)
         {
             if (this.smelteryBurnTime != 0 || this.slot[1] != null && this.slot[0] != null && this.slot[1] != null)
             {
                 if (this.smelteryBurnTime == 0 && this.canSmelt())
                 {
                     this.currentItemBurnTime = this.smelteryBurnTime = getItemBurnTime(this.slot[2]);

                     if (this.smelteryBurnTime > 0)
                     {
                         flag1 = true;

                         if (this.slot[2] != null)
                         {
                             --this.slot[2].stackSize;

                             if (this.slot[2].stackSize == 0)
                             {
                                 this.slot[2] = slot[2].getItem().getContainerItem(slot[2]);
                             }
                         }
                     }
                 }

                 if (this.isBurning() && this.canSmelt())
                 {
                     ++this.smelteryCookTime;

                     if (this.smelteryCookTime == 200)
                     {
                         this.smelteryCookTime = 0;
                         this.smeltItem();
                         flag1 = true;
                     }
                 }
                 else
                 {
                     this.smelteryCookTime = 0;
                 }
             }

             if (flag != this.smelteryBurnTime > 0)
             {
                 flag1 = true;
                 BlockSmeltery.updateSmelteryBlockState(this.smelteryBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
             }
         }

         if (flag1)
         {
             this.markDirty();
         }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.slot[0] == null || this.slot[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = SmelteryRecipeHandler.getSmeltingResult(this.slot[0].getItem(), this.slot[1].getItem());
            
            if (itemstack == null) 
            {
            	return false;
            }
            if (this.slot[3] == null)
            {
            	return true;
            }
            if (!this.slot[3].isItemEqual(itemstack))
            {
            	return false;
            }
            if (this.slot[3].stackSize < getInventoryStackLimit() && this.slot[3].stackSize < this.slot[3].getMaxStackSize())
            {
            	return true;
            }
            else
            {
            	return this.slot[3].stackSize < itemstack.getMaxStackSize();
            }
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = SmelteryRecipeHandler.getSmeltingResult(this.slot[0].getItem(), this.slot[1].getItem());

            if (this.slot[3] == null)
            {
            	this.slot[3] = itemstack.copy();
            }
            else if (this.slot[3].isItemEqual(itemstack))
            {
            	this.slot[3].stackSize += itemstack.stackSize;
            }
            
            for(int i = 0; i < 2; i++)
            {
            	if(this.slot[i].stackSize <= 0)
            	{
            		this.slot[i] = new ItemStack(this.slot[i].getItem().setFull3D());
            	}
            	else
            	{
            		this.slot[i].stackSize--;
            	}
            	
            	if(this.slot[i].stackSize <= 0)
            	{
            		this.slot[i] = null;
            	}
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_)
    {
        return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
    {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_)
    {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
    }
    
	public void setGuiDisplayName(String displayName) {
		this.smelteryName = displayName;
	}
}
