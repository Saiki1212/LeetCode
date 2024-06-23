class Solution {
    static class Point {
        int x, y, p;
        Point (int xp, int yp, int pp) {
            x = xp;
            y = yp;
            p = pp;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Point> pointList = new ArrayList<>();
        
        AddToList(root, pointList, 0, 0);

        pointList.sort((a, b) -> {
            if (a.y != b.y) {
                return a.y - b.y;
            } else if (a.x != b.x) {
                return a.x - b.x;
            } else {
                return a.p - b.p;
            }
        });

        int i=0;
        int n = pointList.size();
        while(i<n) {
            List<Integer> temp = new ArrayList<>();
            int pre = pointList.get(i).y;
            while(i<n && pointList.get(i).y == pre) {
                temp.add(pointList.get(i).p);
                i++;
            }
            list.add(temp);
        }


        return list;

    }

    public static void AddToList(TreeNode root, List<Point> list, int x, int y) {
        if(root == null) return;
        list.add(new Point(x, y, root.val));
        AddToList(root.left, list, x+1, y-1);
        AddToList(root.right, list, x+1, y+1);
    }
}
