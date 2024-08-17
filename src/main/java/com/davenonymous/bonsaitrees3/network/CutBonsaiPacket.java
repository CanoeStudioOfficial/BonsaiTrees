package com.davenonymous.bonsaitrees3.network;

import com.davenonymous.bonsaitrees3.blocks.BonsaiPotBlockEntity;
import com.davenonymous.libnonymous.base.BasePacket;
import com.davenonymous.libnonymous.serialization.Sync;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CutBonsaiPacket extends BasePacket {
	@Sync
	BlockPos pos;

	public CutBonsaiPacket(BlockPos pos) {
		super();
		this.pos = pos;
	}

	public CutBonsaiPacket(FriendlyByteBuf buf) {
		super(buf);
	}

	@Override
	public void doWork(Supplier<NetworkEvent.Context> ctx) {
		var level = ctx.get().getSender().level();
		BonsaiPotBlockEntity potBlock = (BonsaiPotBlockEntity) level.getBlockEntity(pos);
		if(potBlock.cutTree(false)) {
			potBlock.hopOutput();
		}
	}
}