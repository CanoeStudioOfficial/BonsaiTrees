package org.dave.bonsaitrees.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.dave.bonsaitrees.BonsaiTrees;
import org.dave.bonsaitrees.bonsaitrees.Tags;

public class PackageHandler {
    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(Tags.MOD_ID);

    public static void init() {
        instance.registerMessage(MessageReloadTreesHandler.class, MessageReloadTrees.class, 1, Side.CLIENT);
    }
}
