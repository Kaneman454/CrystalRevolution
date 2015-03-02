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
import net.minecraft.util.MathHelper;

public class ItemGear extends Item{

	@SideOnly(Side.CLIENT)
	public IIcon[] icons = new IIcon[15];
	public static String[] names = {"Wooden", "Flint", "Stone", "Copper", "Tin", "Zinc",
									"Bronze", "Brass", "Cobalt", "Rhodium", "Palladium",
									"Osmium", "Iridium", "Platin", "Mithril"};
	
	public ItemGear() {
		super();
		setHasSubtypes(true);
		setCreativeTab(crystalTab.crystalCreativeTab);
		setUnlocalizedName("gear");
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < names.length; i ++) {
	    	
	        this.icons[i] = reg.registerIcon(LibMisc.MOD_ID + ":gear" + names[i]);
	    }

	}
	@Override
	public IIcon getIconFromDamage(int meta) {
	  	
		if(meta > 14)
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
	        return this.getUnlocalizedName() + "Wooden";
	    case 1:
	        return this.getUnlocalizedName() + "Flint";
	    case 2:
	        return this.getUnlocalizedName() + "Stone";
	    case 3:
	        return this.getUnlocalizedName() + "Copper";
	    case 4:
	        return this.getUnlocalizedName() + "Tin";
	    case 5:
	        return this.getUnlocalizedName() + "Zinc";
	    case 6:
	        return this.getUnlocalizedName() + "Bronze";
	    case 7:
	        return this.getUnlocalizedName() + "Brass";
	    case 8:
	        return this.getUnlocalizedName() + "Cobalt";
	    case 9:
	        return this.getUnlocalizedName() + "Rhodium";
	    case 10:
	        return this.getUnlocalizedName() + "Palladium";
	    case 11:
	        return this.getUnlocalizedName() + "Osmium";
	    case 12:
	        return this.getUnlocalizedName() + "Iridium";
	    case 13:
	        return this.getUnlocalizedName() + "Platin";
	    case 14:
	        return this.getUnlocalizedName() + "Mithril";
	    default:
	        return this.getUnlocalizedName();
	    }
	}
}
