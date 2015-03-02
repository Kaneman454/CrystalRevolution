package crystalrevolution.gameobjs.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import crystalrevolution.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;



public class BlockJewelcraftTable extends Block{

	 @SideOnly(Side.CLIENT)
	 private IIcon top;
	
	public BlockJewelcraftTable() {
		super(Material.wood);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.top : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(LibMisc.MOD_ID + ":" + "JewelcraftingSide");
        this.top = p_149651_1_.registerIcon(LibMisc.MOD_ID + ":" + "JewelcraftingTop");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int meta, float xPos, float yPos, float zPos)
    {

    	if(!p.isSneaking()){
    		p.openGui(LibMisc.MOD_ID, References.GUI_Jewelcrafting, world, x, y, z);
    		return true;
    	}else{
    		return false;
    	}
    	
    }
	

}
