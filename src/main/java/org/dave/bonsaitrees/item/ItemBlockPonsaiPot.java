package org.dave.bonsaitrees.item;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.dave.bonsaitrees.BonsaiTrees;
import org.dave.bonsaitrees.base.IMetaBlockName;
import org.dave.bonsaitrees.block.BlockBonsaiPot;
import org.dave.bonsaitrees.init.Blockss;
import org.dave.bonsaitrees.misc.ConfigurationHandler;
import org.dave.bonsaitrees.render.PotColorizer;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBlockPonsaiPot extends ItemBlock {
    public ItemBlockPonsaiPot(Block block) {
        super(block);

        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String superName = super.getUnlocalizedName(stack);
        String specialName = ((IMetaBlockName)this.block).getSpecialName(stack);
        if(specialName.length() > 0) {
            return superName + "." + specialName;
        }

        return superName;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        boolean isHopping = Blockss.bonsaiPot.getStateFromMeta(stack.getMetadata()).getValue(BlockBonsaiPot.IS_HOPPING);
        if(GuiScreen.isShiftKeyDown()) {
            if(stack.hasTagCompound() && stack.getTagCompound().hasKey("color")) {
                EnumDyeColor color = EnumDyeColor.byMetadata(stack.getTagCompound().getInteger("color"));
                tooltip.add(PotColorizer.textFormattingForDye(color) + I18n.format("item.fireworksCharge." + color.getUnlocalizedName()));
            }
            if(isHopping) {
                tooltip.add(TextFormatting.YELLOW + I18n.format("tooltip.bonsaitrees.autoexport"));
            } else {
                tooltip.add(TextFormatting.YELLOW + I18n.format("tooltip.bonsaitrees.use_jei_for_compatible_sapling"));
            }
        } else {
            tooltip.add(TextFormatting.GRAY + I18n.format("tooltip." + BonsaiTrees.MODID + ".hold_shift_hint"));

            if(isHopping && ConfigurationHandler.GeneralSettings.disableHoppingBonsaiPot) {
                tooltip.add(TextFormatting.RED + I18n.format("tooltip." + BonsaiTrees.MODID + ".warn_hopping_pots_disabled"));
            }
        }
    }
}
