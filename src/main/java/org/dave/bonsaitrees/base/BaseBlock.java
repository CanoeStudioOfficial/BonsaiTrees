package org.dave.bonsaitrees.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.dave.bonsaitrees.BonsaiTrees;
import org.dave.bonsaitrees.bonsaitrees.Tags;

public class BaseBlock extends Block {
    public BaseBlock(Material material) {
        super(material);
    }

    public BaseBlock() {
        this(Material.ROCK);
    }

    @Override
    public Block setTranslationKey(String name) {
        if(!name.startsWith(Tags.MOD_ID + ".")) {
            name = Tags.MOD_ID + "." + name;
        }
        return super.setTranslationKey(name);
    }
}
