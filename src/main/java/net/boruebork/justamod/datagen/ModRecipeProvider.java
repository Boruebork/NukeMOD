package net.boruebork.justamod.datagen;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.block.ModBlocks;
import net.boruebork.justamod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_TITANIUM,
                ModBlocks.TITANIUM_ORE, ModBlocks.TUNGSTEN_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM.get())
                .unlockedBy("has_titanium", has(ModItems.TITANIUM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK)
                .unlockedBy("has_titanium_block", has(ModBlocks.TITANIUM_BLOCK)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MODERN_ALLOY_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.MODERN_ALLOY.get())
                .unlockedBy("has_modern_alloy", has(ModItems.MODERN_ALLOY)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MODERN_ALLOY.get())
                .pattern("TTI")
                .pattern("TIW")
                .pattern("IWW")
                .define('T', ModItems.TITANIUM.get())
                .define('W', ModItems.TUNGSTEN_INGOT.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_titanium", has(ModItems.TITANIUM))
                .unlockedBy("has_tungsten", has(ModItems.TUNGSTEN_INGOT))
                .unlockedBy("has_tungsten", has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENRICHED_URANIUM_BLOCK.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.ENRICHED_URANIUM_DUST.get())
                .unlockedBy("has_eu", has(ModItems.ENRICHED_URANIUM_DUST));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NUCLEAR_WARHEAD.get())
                .pattern("MMM")
                .pattern("MEM")
                .pattern("MBM")
                .define('M', ModItems.MODERN_ALLOY.get())
                .define('B', ModBlocks.MODERN_ALLOY_BLOCK.get())
                .define('E', ModBlocks.ENRICHED_URANIUM_BLOCK.get())
                .unlockedBy("has_eub", has(ModBlocks.ENRICHED_URANIUM_BLOCK));



    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, JustAMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}