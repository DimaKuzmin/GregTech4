package gregtechmod.api.util;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class GT_Shapeless_Recipe extends ShapelessOreRecipe {
	public GT_Shapeless_Recipe(ItemStack aResult, Object... aRecipe) {
		super(aResult, aRecipe);
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting aGrid) {
		ItemStack rStack = super.getCraftingResult(aGrid);
		if (rStack != null) {
			int tCharge = 0;
			for (int i = 0; i < aGrid.getSizeInventory(); i++) tCharge += GT_ModHandler.dischargeElectricItem(aGrid.getStackInSlot(i), Integer.MAX_VALUE, Integer.MAX_VALUE - 1, true, false, true, true);
			GT_ModHandler.chargeElectricItem(rStack, tCharge, Integer.MAX_VALUE, true, false);
		}
		return rStack;
	}
}
