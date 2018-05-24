package test.level;

public class TileCoordinate {
	
	private double x,y;
	private final int TILE_SIZE = 16;
	
	public TileCoordinate(int x, int y) {
		this.x = (double)x * TILE_SIZE;
		this.y = (double)y * TILE_SIZE; 	
		}
	
	public TileCoordinate(double x, double y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE; 	
		}
	
	public int x() {
		return (int)x;
	}
	
	public int y() {
		return (int)y;
	}
	
	public int[] xy() {
		int temp[] = new int[2];
		temp[0] = (int)x;
		temp[1] = (int)y;
		return temp;
	}

}
