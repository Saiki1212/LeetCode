class Solution {
    public int[][] floodFill(int[][] image, int x, int y, int color) {
        if(image[x][y] == color) return image;
        
        changeColor(image, x, y, color, image[x][y]);
        return image;
    }

    public static void changeColor(int[][] image, int x, int y, int color, int ini) {
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != ini) return;
        image[x][y] = color;
        changeColor(image, x-1, y, color, ini);
        changeColor(image, x, y-1, color, ini);
        changeColor(image, x, y+1, color, ini);
        changeColor(image, x+1, y, color, ini);
    }

}