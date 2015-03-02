package crystalrevolution.gameobjs.blocks;

import crystalrevolution.gameobjs.crystalTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOre extends Block{

	public BlockOre(Material Mat) {
		super(Mat);
		setCreativeTab(crystalTab.crystalCreativeTab);
	}

}
