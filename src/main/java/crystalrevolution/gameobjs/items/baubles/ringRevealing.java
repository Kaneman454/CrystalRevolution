package crystalrevolution.gameobjs.items.baubles;

import java.util.List;

import thaumcraft.api.IGoggles;
import thaumcraft.api.nodes.IRevealer;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
@Optional.InterfaceList({
	@Optional.Interface(iface = "api.baubles.IBauble", modid = "Baubles")})	
public class ringRevealing extends Item implements IBauble{

	public ringRevealing() {
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("ringRevealing");
		setTextureName("crystalrevolution:" + getUnlocalizedName().substring(5));
	}
		
	@Override
	@Optional.Method(modid = "Baubles")
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	@Optional.Method(modid = "Baubles")
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	@Optional.Method(modid = "Baubles")
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	@Optional.Method(modid = "Baubles")
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

	@Override
	@Optional.Method(modid = "Baubles")
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	@Optional.Method(modid = "Baubles")
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
