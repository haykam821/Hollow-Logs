package io.github.haykam821.hollowlogs;

import net.minecraft.block.LogBlock;
import net.minecraft.block.MaterialColor;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import net.minecraft.block.BlockState;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityContext;

import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;

public class HollowPillarBlock extends LogBlock {
	public static final VoxelShape X_SHAPE = VoxelShapes.union(
		VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1f, 0.0625f),
		VoxelShapes.cuboid(0f, 0f, 0.9375f, 1f, 1f, 1f),
		VoxelShapes.cuboid(0f, 0f, 0.0625f, 1f, 0.0625f, 0.9375f),
		VoxelShapes.cuboid(0f, 0.9375f, 0.0625f, 1f, 1f, 0.9375f)
	);
	public static final VoxelShape Y_SHAPE = VoxelShapes.union(
		VoxelShapes.cuboid(0f, 0f, 0f, 1f, 1f, 0.0625f),
		VoxelShapes.cuboid(0f, 0f, 0.9375f, 1f, 1f, 1f),
		VoxelShapes.cuboid(0f, 0f, 0.0625f, 0.0625f, 1f, 0.9375f),
		VoxelShapes.cuboid(0.9375f, 0f, 0.0625f, 1f, 1f, 0.9375f)
	);
	public static final VoxelShape Z_SHAPE = VoxelShapes.union(
		VoxelShapes.cuboid(0f, 0f, 0f, 1f, 0.0625f, 1f),
		VoxelShapes.cuboid(0f, 0.9375f, 0f, 1f, 1f, 1f),
		VoxelShapes.cuboid(0f, 0.0625f, 0f, 0.0625f, 0.9375f, 1f),
		VoxelShapes.cuboid(0.9375f, 0.0625f, 0f, 1f, 0.9375f, 1f)
	);

	public HollowPillarBlock(final MaterialColor endMaterialColor, Settings settings) {
		super(endMaterialColor, settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
		switch (state.get((EnumProperty<Direction.Axis>) HollowPillarBlock.AXIS)) {
			case X: {
				return HollowPillarBlock.X_SHAPE;
			}
			case Z: {
				return HollowPillarBlock.Z_SHAPE;
			}
			default: {
				return HollowPillarBlock.Y_SHAPE;
			}
		}
	}
}
