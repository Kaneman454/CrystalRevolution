package crystalrevolution.gameobjs;

import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import crystalrevolution.Main;
import crystalrevolution.gameobjs.items.ItemGear;
import crystalrevolution.gameobjs.items.ItemJewel;
import crystalrevolution.gameobjs.items.armor.ItemBackpack;
import crystalrevolution.gameobjs.items.tools.ItemToolAxe;
import crystalrevolution.gameobjs.metals.ingotBrass;
import crystalrevolution.gameobjs.metals.ingotBronze;
import crystalrevolution.gameobjs.metals.ingotCobalt;
import crystalrevolution.gameobjs.metals.ingotCopper;
import crystalrevolution.gameobjs.metals.ingotIridium;
import crystalrevolution.gameobjs.metals.ingotMithril;
import crystalrevolution.gameobjs.metals.ingotOsmium;
import crystalrevolution.gameobjs.metals.ingotPalladium;
import crystalrevolution.gameobjs.metals.ingotPlatin;
import crystalrevolution.gameobjs.metals.ingotRhodium;
import crystalrevolution.gameobjs.metals.ingotTin;
import crystalrevolution.gameobjs.metals.ingotZinc;
import crystalrevolution.handlers.HarvestLevelHandler;
import crystalrevolution.utils.RegHelper;

public class ModItems {

	public static Item Backpack;

	public static ArmorMaterial backpackMaterial = EnumHelper.addArmorMaterial("backpackArmor", -1, new int[] { 0, 0, 0, 0 }, 0);
	public static int backpackRenderIndex = Main.proxy.addArmor("crystal_backpack");
	
	public static ArmorMaterial flintArmorMaterial = EnumHelper.addArmorMaterial("flintArmor", -1, new int[] { 1, 1, 1, 1}, 0);
	public static ToolMaterial flintToolMaterial = EnumHelper.addToolMaterial("flint", HarvestLevelHandler._1_flint, 78, 0.5F, 1.0F, 0);
	public static int flintRenderIndex = Main.proxy.addArmor("flint_armor");
	
	public static ArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmor", -1, new int[]{ 2, 2, 2, 2 }, 0);
	public static ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("copper", HarvestLevelHandler._3_copper, 126, 1.0F, 1.5F, 5);
	public static int copperRenderIndex = Main.proxy.addArmor("copper_armor");
		
	public static ArmorMaterial bronzeArmorMaterial = EnumHelper.addArmorMaterial("bronzeArmor", -1, new int[]{ 3, 3, 3, 3 }, 0);
	public static ToolMaterial bronzeToolMaterial = EnumHelper.addToolMaterial("bronze", HarvestLevelHandler._4_bronze, 184, 1.5F, 2.0F, 8);
	public static int bronzeRenderIndex = Main.proxy.addArmor("bronze_armor");
	
	public static ArmorMaterial cobaltArmorMaterial = EnumHelper.addArmorMaterial("cobaltArmor", -1, new int[] { 4, 4, 4, 4 }, 0);
	public static ToolMaterial cobaltToolMaterial = EnumHelper.addToolMaterial("cobalt", HarvestLevelHandler._9_cobalt, 823, 2.0F, 3.0F, 12);
	public static int cobaltRenderIndex = Main.proxy.addArmor("cobalt_armor");
	
	public static ArmorMaterial rhodiumArmorMaterial = EnumHelper.addArmorMaterial("rhodiumArmor", -1, new int[] { 5, 5, 5, 5, }, 0);
	public static ToolMaterial rhodiumToolMaterial = EnumHelper.addToolMaterial("rhodium", HarvestLevelHandler._10_rhodium, 956, 3.0F, 4.0F, 14);
	public static int rhodiumRenderIndex = Main.proxy.addArmor("rhodium_armor");
	
	public static ArmorMaterial palladiumArmorMaterial = EnumHelper.addArmorMaterial("palladiumArmor", -1, new int[] { 6, 6, 6, 6 }, 0);
	public static ToolMaterial palladiumToolMaterial = EnumHelper.addToolMaterial("", HarvestLevelHandler._11_palladium, 1080, 4.0F, 5.0F, 19);
	public static int palladiumRenderIndex = Main.proxy.addArmor("palladium_armor");
	
	public static ArmorMaterial osmiumArmorMaterial = EnumHelper.addArmorMaterial("osmiumArmor", -1, new int[] { 7, 7, 7, 7 }, 0);
	public static ToolMaterial osmiumToolMaterial = EnumHelper.addToolMaterial("osmium", HarvestLevelHandler._12_osmium, 851, 5.0F, 6.0F, 24);
	public static int osmiumRenderIndex = Main.proxy.addArmor("osmium_armor");
	
	public static ArmorMaterial iridiumArmorMaterial = EnumHelper.addArmorMaterial("iridiumArmor", -1, new int[] { 8, 8, 8, 8 }, 0);
	public static ToolMaterial iridiumToolMaterial = EnumHelper.addToolMaterial("iridium", HarvestLevelHandler._13_iridium, 978, 6.0F, 7.0F, 26);
	public static int iridiumRenderIndex = Main.proxy.addArmor("iridium_armor");
	
	public static ArmorMaterial platinArmorMaterial = EnumHelper.addArmorMaterial("platinArmor", -1, new int[] { 9, 9, 9, 9 }, 0);
	public static ToolMaterial platinToolMaterial = EnumHelper.addToolMaterial("platin", HarvestLevelHandler._14_platin, 1340, 7.0F, 8.0F, 22);
	public static int platinRenderIndex = Main.proxy.addArmor("platin_armor");
	
	public static ArmorMaterial mithrilArmorMaterial = EnumHelper.addArmorMaterial("mithrilArmor", -1, new int[] { 10, 10, 10, 10 }, 0);
	public static ToolMaterial mithrilToolMaterial = EnumHelper.addToolMaterial("mithril", HarvestLevelHandler._15_mithril, 1849, 8.0F, 9.0F, 29);
	public static int mithrilRenderIndex = Main.proxy.addArmor("mithril_armor");
	
	//Verbrauchsmetalle
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotZinc;
	public static Item ingotBronze;
	public static Item ingotBrass;
	public static Item ingotCobalt;
	public static Item ingotRhodium;
	public static Item ingotPalladium;
	public static Item ingotOsmium;
	public static Item ingotIridium;
	public static Item ingotPlatin;
	public static Item ingotMithril;

	//Materialien
	public static Item gears;
	
	//Gems
	public static Item gems;
	
	//Werkzeuge
	public static Item flintAxe;
	public static Item flintHoe;
	public static Item flintPickaxe;
	public static Item flintShovel;
	public static Item flintSword;
	
	public static Item bronzeAxe;
	public static Item bronzeHoe;
	public static Item bronzePickaxe;
	public static Item bronzeShovel;
	public static Item bronzeSword;
	
	public static Item cobaltAxe;
	public static Item cobaltHoe;
	public static Item cobaltPickaxe;
	public static Item cobaltShovel;
	public static Item cobaltSword;

	public static Item osmiumAxe;
	public static Item osmiumHoe;
	public static Item osmiumPickaxe;
	public static Item osmiumShovel;
	public static Item osmiumSword;
	
	public static Item mithrilAxe;
	public static Item mithrilHoe;
	public static Item mithrilPickaxe;
	public static Item mithrilShovel;
	public static Item mithrilSword;
	
	public static void ladeItems() {
		
		//Armor
		
		Backpack = new ItemBackpack(backpackMaterial, backpackRenderIndex, 1, "backpack");
		// RegHelper.registerItem(Backpack);
		
		//Ingots
		
		ingotCopper = new ingotCopper();
		RegHelper.registerItem(ingotCopper);
		ingotTin= new ingotTin();
		RegHelper.registerItem(ingotTin);
		ingotZinc= new ingotZinc();
		RegHelper.registerItem(ingotZinc);
		ingotBronze= new ingotBronze();
		RegHelper.registerItem(ingotBronze);
		ingotBrass= new ingotBrass();
		RegHelper.registerItem(ingotBrass);
		ingotCobalt= new ingotCobalt();
		RegHelper.registerItem(ingotCobalt);
		ingotRhodium= new ingotRhodium();
		RegHelper.registerItem(ingotRhodium);
		ingotPalladium= new ingotPalladium();
		RegHelper.registerItem(ingotPalladium);
		ingotOsmium= new ingotOsmium();
		RegHelper.registerItem(ingotOsmium);
		ingotIridium= new ingotIridium();
		RegHelper.registerItem(ingotIridium);
		ingotPlatin= new ingotPlatin();
		RegHelper.registerItem(ingotPlatin);
		ingotMithril= new ingotMithril();
		RegHelper.registerItem(ingotMithril);
		//Materialien
		
		gears = new ItemGear();
		RegHelper.registerItem(gears);
		
		//Gems
		gems = new ItemJewel();
		RegHelper.registerItem(gems);
		
		//tools
		flintAxe = new ItemToolAxe(bronzeToolMaterial);
		
	}

}
