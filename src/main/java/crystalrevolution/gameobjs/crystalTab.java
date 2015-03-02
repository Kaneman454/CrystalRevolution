package crystalrevolution.gameobjs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import scala.actors.threadpool.Arrays;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class crystalTab extends CreativeTabs{

	public static CreativeTabs crystalCreativeTab = new crystalTab();


	
	public crystalTab() {
		super("crystaltab");
	}


	
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.smelteryIdle);
	}  
	
}
