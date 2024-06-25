class Solution {
    public int[][] floodFill(int[][] image, int x, int y, int color) {
        // if(color == 0) return image;
        
        changeColor(image, x, y, new int[]{-1, 0, 0, 1}, new int[]{0, -1, 1, 0});
        for(int i = 0; i<image.length; i++) {
            for(int j = 0; j<image[0].length; j++) {
                if(image[i][j] == -1) image[i][j] = color;
            }
        }

        return image;
    }

    public static void changeColor(int[][] image, int x, int y, int [] rowMat, int [] colMat) {
        int currentValue = image[x][y];
        image[x][y] = -1;
        for(int i = 0; i<4; i++) {
            int xx = x + rowMat[i];
            int yy = y + colMat[i];
            if(xx < 0 || yy < 0 || xx >= image.length || yy >= image[0].length || image[xx][yy] != currentValue) continue;
            changeColor(image, xx, yy, rowMat, colMat);
        }
    }

}