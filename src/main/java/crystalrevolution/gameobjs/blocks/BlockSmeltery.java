package crystalrevolution.gameobjs.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.Main;
import crystalrevolution.gameobjs.ModBlocks;
import crystalrevolution.gameobjs.tileentities.TileEntitySmeltery;
import crystalrevolution.libs.LibMisc;
import crystalrevolution.utils.References;

public class BlockSmeltery extends BlockContainer implements ITileEntityProvider{

	@SideOnly(Side.CLIENT)
	public IIcon top;
	@SideOnly(Side.CLIENT)
	public IIcon front;
	
	private final Random rand = new Random();
	private final boolean isBurning;
	private static boolean isBurning2;
	
	
	public BlockSmeltery(boolean isActive) {
		super(Material.rock);
		isBurning = isActive;
		setHarvestLevel("pickaxe", 2);
		
		if(isActive){
			this.setLightLevel(0.8F);
		}
	}

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(ModBlocks.smelteryIdle);
    }
    
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }
    
    public void setDefaultDirection(World world, int x, int y, int z){
    	if(!world.isRemote){
    		Block north = world.getBlock(x, y, z - 1);
    		Block south = world.getBlock(x, y, z + 1);
    		Block east = world.getBlock(x - 1, y, z);
    		Block west = world.getBlock(x + 1, y, z);
    		
    		byte b0 = 3;
    		
            if (north.func_149730_j() && !south.func_149730_j())
            {
                b0 = 3;
            }

            if (south.func_149730_j() && !north.func_149730_j())
            {
                b0 = 2;
            }

            if (east.func_149730_j() && !west.func_149730_j())
            {
                b0 = 5;
            }

            if (west.func_149730_j() && !east.func_149730_j())
            {
                b0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
            
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
    	return meta == 0 && side == 3 ? this.front
				: side == 1 ? this.top : (side == 0 ? this.top
						: (side != meta ? this.blockIcon : this.front));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iReg){
    	this.blockIcon = iReg.registerIcon(LibMisc.MOD_ID + ":smeltery_side");
    	this.front = iReg.registerIcon(this.isBurning ? LibMisc.MOD_ID + ":smeltery_front_on" : LibMisc.MOD_ID + ":smeltery_front_off");
    	this.top = iReg.registerIcon(LibMisc.MOD_ID + ":smeltery_top");
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
    	
    	if(!player.isSneaking()){
    		player.openGui(LibMisc.MOD_ID, References.GUI_SMELTERY, world, x, y, z);
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public static void updateSmelteryBlockState(boolean bool, World world, int x, int y, int z){
    	int l = world.getBlockMetadata(x, y, z);
    	TileEntity tile = world.getTileEntity(x, y, z);
    	isBurning2 = true;
    	if(bool){
    		world.setBlock(x, y, z, ModBlocks.smelteryActive);
    	}
    	else{
    		world.setBlock(x, y, z, ModBlocks.smelteryIdle);
    	}
    	isBurning2 = false;
    	world.setBlockMetadataWithNotify(x, y, z, l, 2);
    	
    	if(tile != null){
    		tile.validate();
    		world.setTileEntity(x, y, z, tile);
    	}
    }
    
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntitySmeltery();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p, ItemStack iStack){
		int l = MathHelper.floor_double((double)(p.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(l == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(iStack.hasDisplayName()){
			((TileEntitySmeltery)world.getTileEntity(x, y, z)).setGuiDisplayName(iStack.getDisplayName());
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		
		if(!isBurning2){
			TileEntitySmeltery tileEntitySmeltery = (TileEntitySmeltery)world.getTileEntity(x, y, z);
		
			if(tileEntitySmeltery != null){
				for(int i = 0; i < tileEntitySmeltery.getSizeInventory(); ++i){
					ItemStack iStack = tileEntitySmeltery.getStackInSlot(i);
					
					if(iStack != null){
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(iStack.stackSize > 0)
						{
							int j = this.rand.nextInt(21)+10;
							
							if(j > iStack.stackSize)
							{
								j = iStack.stackSize;
							}
							
							iStack.stackSize -= j;
							EntityItem eItem = new EntityItem(world, 
									(double)((float)x + f), 
									(double)((float)y + f1), 
									(double)((float)z + f2), new ItemStack(
											iStack.getItem(), j, 
											iStack.getItemDamage()));
							
							if(iStack.hasTagCompound()){
								eItem.getEntityItem().setTagCompound(
										(NBTTagCompound)iStack
												.getTagCompound().copy());
							}
							/**
							  * float f3 = 0.05F;
							  * eItem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							  * eItem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							  * eItem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							  */
							world.spawnEntityInWorld(eItem);
						}
					}
				}
				
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isBurning)
	    {
			int direction = world.getBlockMetadata(x, y, z);
			float f = (float)x + 0.5F;
			float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
			float f2 = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;

			if (direction == 4)
			{
				world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if (direction == 5)
			{
				world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			}
			else if (direction == 2)
			{
				world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
			}
			else if (direction == 3)
			{
				world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
			}
	    }
	}
	
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z,
			int k) {
		return Container.calcRedstoneFromInventory((IInventory) world
				.getTileEntity(x, y, z));
	}
	
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(ModBlocks.smelteryIdle);
    }
}
