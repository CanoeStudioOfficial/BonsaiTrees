package org.dave.bonsaitrees.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.dave.bonsaitrees.BonsaiTrees;

public class BaseBlock extends Block {
    public BaseBlock(Material material) {
        super(material);
    }

    public BaseBlock() {
        this(Material.ROCK);
    }

    @Override
    public Block setTranslationKey(String name) {
        if(!name.startsWith(BonsaiTrees.MODID + ".")) {
            name = BonsaiTrees.MODID + "." + name;
        }
        return super.setTranslationKey(name);
    }
}
