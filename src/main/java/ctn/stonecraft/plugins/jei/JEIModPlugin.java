package ctn.stonecraft.plugins.jei;

import ctn.stonecraft.core.StoneCraft;
import ctn.stonecraft.init.ScBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEIModPlugin implements IModPlugin {
  @Override
  public @NotNull ResourceLocation getPluginUid() {
    return ResourceLocation.fromNamespaceAndPath(StoneCraft.ID, "jei_plugin");
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    // 注册石质工作台
    registration.addRecipeCatalyst(
      new ItemStack(ScBlocks.STONE_CRAFTING_TABLE.get()),
      RecipeTypes.CRAFTING  // 暂时使用原版工作台配方类型
    );
  }
}
