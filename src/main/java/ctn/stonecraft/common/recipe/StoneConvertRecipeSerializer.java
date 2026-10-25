package ctn.stonecraft.common.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class StoneConvertRecipeSerializer implements RecipeSerializer<StoneConvertRecipe> {

    public static final MapCodec<StoneConvertRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(StoneConvertRecipe::getInput),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(StoneConvertRecipe::getResult)
    ).apply(inst, StoneConvertRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, StoneConvertRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, StoneConvertRecipe::getInput,
                    ItemStack.STREAM_CODEC, StoneConvertRecipe::getResult,
                    StoneConvertRecipe::new);

    @Override
    public MapCodec<StoneConvertRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, StoneConvertRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}