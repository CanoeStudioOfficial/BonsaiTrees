package org.dave.bonsaitrees.base;

import net.minecraft.item.Item;
import org.dave.bonsaitrees.BonsaiTrees;
import org.dave.bonsaitrees.bonsaitrees.Tags;

public class BaseItem extends Item {
    public BaseItem() {
        super();
    }

    @Override
    public Item setTranslationKey(String name) {
        if (!name.startsWith(Tags.MOD_ID + ".")) {
            name = Tags.MOD_ID + "." + name;
        }
        return super.setTranslationKey(name);
    }
}