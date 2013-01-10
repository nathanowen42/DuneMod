package net.minecraft.src;

public class DuneCircleArrayMaker {

	public static int[][] circleFilled(int radius) {

		int diamiter = radius * 2; // gets a value with witch to define the
									// dimensions of the array
		int[][] stincle = new int[diamiter + 2][diamiter + 2];
		for (int i = 0; i < diamiter; i++) {
			for (int t = 0; t < diamiter; t++) {
				stincle[i][t] = 0;
				// sets all values of the array to 0;
			}
		}
		// the following creates the circle in an efficient manner
		int x, y, r2;
		int xCenter = radius;
		int yCenter = radius;
		r2 = (radius) * (radius);
		stincle[xCenter][yCenter + radius] = 1;
		stincle[xCenter][yCenter - radius] = 1;
		stincle[xCenter + radius][yCenter] = 1;
		stincle[xCenter - radius][yCenter] = 1;
		y = radius;
		x = 1;
		y = (int) Math.round(Math.sqrt(r2 - 1) + 0.5);
		while (x < y) {
			stincle[xCenter + x][yCenter + y] = 1;
			stincle[xCenter + x][yCenter - y] = 1;
			stincle[xCenter - x][yCenter + y] = 1;
			stincle[xCenter - x][yCenter - y] = 1;
			stincle[xCenter + y][yCenter + x] = 1;
			stincle[xCenter + y][yCenter - x] = 1;
			stincle[xCenter - y][yCenter + x] = 1;
			stincle[xCenter - y][yCenter - x] = 1;
			x += 1;
			y = (int) Math.round(Math.sqrt(r2 - x * x) + 0.5);
		}
		if (x == y) {
			stincle[xCenter + x][yCenter + y] = 1;
			stincle[xCenter + x][yCenter - y] = 1;
			stincle[xCenter - x][yCenter + y] = 1;
			stincle[xCenter - x][yCenter - y] = 1;
		}
		// end creating circle
		// the following is intended to look on each row for the beginning and end of the circle and fill the circle
		for (int i = 0; i < diamiter + 1; i++) {
			int first = 0;
			int last = 0;
			boolean firstDone = false;
			for (int t = 0; t < diamiter + 1; t++) {
				if (stincle[i][t] == 1) {
					if (!(firstDone)) {
						first = t;
						firstDone = true;
					}
					last = t;
				}
			}
			for (int m = 0; m < (last - first); m++) {
				stincle[i][m + first] = 1; // fills circle with 1's representing blocks
			}
		}
		return stincle;
	}

	public static int[][] circleOutline(int radius) {

		int diamiter = radius * 2; // gets a value with witch to define the dimensions of the array
		int[][] stincle = new int[diamiter + 2][diamiter + 2];
		for (int i = 0; i < diamiter; i++) {
			for (int t = 0; t < diamiter; t++) {
				stincle[i][t] = 0;
				// sets all values of the array to 0;
			}
		}
		// the following creates the circle in an efficient manner
		int x, y, r2;
		int xCenter = radius;
		int yCenter = radius;
		r2 = (radius) * (radius);
		stincle[xCenter][yCenter + radius] = 1;
		stincle[xCenter][yCenter - radius] = 1;
		stincle[xCenter + radius][yCenter] = 1;
		stincle[xCenter - radius][yCenter] = 1;
		y = radius;
		x = 1;
		y = (int) Math.round(Math.sqrt(r2 - 1) + 0.5);
		while (x < y) {
			stincle[xCenter + x][yCenter + y] = 1;
			stincle[xCenter + x][yCenter - y] = 1;
			stincle[xCenter - x][yCenter + y] = 1;
			stincle[xCenter - x][yCenter - y] = 1;
			stincle[xCenter + y][yCenter + x] = 1;
			stincle[xCenter + y][yCenter - x] = 1;
			stincle[xCenter - y][yCenter + x] = 1;
			stincle[xCenter - y][yCenter - x] = 1;
			x += 1;
			y = (int) Math.round(Math.sqrt(r2 - x * x) + 0.5);
		}
		if (x == y) {
			stincle[xCenter + x][yCenter + y] = 1;
			stincle[xCenter + x][yCenter - y] = 1;
			stincle[xCenter - x][yCenter + y] = 1;
			stincle[xCenter - x][yCenter - y] = 1;
		}
		// end creating circle
		return stincle;
	}
}
