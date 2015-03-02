package crystalrevolution.gameobjs.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crystalrevolution.gameobjs.crystalTab;
import crystalrevolution.libs.LibMisc;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemJewel extends Item{

	@SideOnly(Side.CLIENT)
	public IIcon[] icons = new IIcon[6];	
	public static String[] names = {"Amber", "Amethyst", "Apatite", "Emerald", "Ruby", "Sapphire" };
	
	public ItemJewel() {
		super();
		setHasSubtypes(true);
		setUnlocalizedName("gem");
		setCreativeTab(crystalTab.crystalCreativeTab);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < names.length; i ++) {
	    	
	        this.icons[i] = reg.registerIcon(LibMisc.MOD_ID + ":gem" + names[i]);
	    }

	}
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > 5)
	        meta = 0;

	    return this.icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < names.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    switch (stack.getItemDamage()) {
	    case 0:
	        return this.getUnlocalizedName() + "Amber";
	    case 1:
	        return this.getUnlocalizedName() + "Amethyst";
	    case 2:
	        return this.getUnlocalizedName() + "Apatite";
	    case 3:
	        return this.getUnlocalizedName() + "Emerald";
	    case 4:
	        return this.getUnlocalizedName() + "Ruby";
	    case 5:
	        return this.getUnlocalizedName() + "Sapphire";
	    default:
	        return this.getUnlocalizedName();
	    }
	}
}
