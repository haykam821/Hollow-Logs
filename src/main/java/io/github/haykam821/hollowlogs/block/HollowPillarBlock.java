package io.github.haykam821.hollowlogs.block;

import static net.minecraft.state.property.Properties.WATERLOGGED;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class HollowPillarBlock extends PillarBlock implements Waterloggable {
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

	public HollowPillarBlock(Settings settings) {
		super(settings);
		this.setDefaultState(super.getDefaultState().with(WATERLOGGED, false));
	}

	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
		return super.getPlacementState(ctx).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) {
			world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
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
