package crystalrevolution.gameobjs.items.armor;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;
import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.gameobjs.container.ContainerBackpack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBackpack extends ItemArmor implements IVisDiscountGear{

	public ItemBackpack(ArmorMaterial material, int armorType, int renderIndex, String name){
		super(material, armorType, renderIndex);
		setMaxStackSize(1);
		//setHasSubtypes(true);
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName(name);
		setTextureName("crystalrevolution:armor/" + getUnlocalizedName().substring(5));
	}
	
	public String getArmorTexture(ItemStack iStack, Entity e, int slot, String type){
		  if ((iStack.getItem() instanceof ItemBackpack)) {
			    return "crystalrevolution:" + String.format("textures/models/armor/crystal_tier%s_1.png");
			  }
		  System.out.println("Invalid Item ItemCrystalArmor");
			  return null;
	}
	
	public void onArmorTick(World world, EntityPlayer p, ItemStack iStack){
		if(world.isRemote)
			return;
		
		if(p.openContainer == null || p.openContainer instanceof ContainerPlayer) 
			return;
		
		if(!(iStack.getItem() instanceof ItemBackpack))
			return;
		
		if(ContainerBackpack.class.isAssignableFrom(p.openContainer.getClass())){
			ContainerBackpack backpack = (ContainerBackpack) p.openContainer;
			if(backpack.updateState){
				backpack.saveToNBT(iStack);
				backpack.updateState = false;
			}
			
		}
	}

	@Override
	public int getVisDiscount(ItemStack stack, EntityPlayer player, Aspect aspect) {
		return 5;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack iStack, EntityPlayer p, List list, boolean bool){
		list.add(StatCollector.translateToLocal("tc.visdiscount") + ": " + 5 + "%");
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer par3EntityPlayer)
	{
	    return super.onItemRightClick(itemStack, world, par3EntityPlayer);
	}

}
