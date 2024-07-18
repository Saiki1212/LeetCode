/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // class Pair {
    //     int x, y;
    //     Pair(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }
    // }

    public void traverseAndFindLeafNodes(List<TreeNode> leafNodes, TreeNode root) {
        if(root == null) return;

        // add all the leaf nodes in the leafNodes list...
        if(root.left == null && root.right == null) {
            leafNodes.add(root);
            return;
        }

        traverseAndFindLeafNodes(leafNodes, root.left);
        traverseAndFindLeafNodes(leafNodes, root.right);
    }

    public void addParents(TreeNode root, TreeNode parent) {
        if(root == null) return;

        if( !parentMap.containsKey(root)) {
            parentMap.put(root, parent);
        }

        addParents(root.left, root);
        addParents(root.right, root);

    }

    public void traverseFromLeafNode(TreeNode leaf, int distance, int track, Set<TreeNode> visitedNodes) {
        if(leaf == null || visitedNodes.contains(leaf)) return;
        visitedNodes.add(leaf);

        if(leaf.left == null && leaf.right == null && track != 0) {
            pairsOfLeafNodes += 1;
            // System.out.println(pairsOfLeafNodes + " ---- " + leaf.val);
            return;
        }

        if(track < distance) {
            track++;
            traverseFromLeafNode(parentMap.get(leaf), distance, track, visitedNodes);
            traverseFromLeafNode(leaf.left, distance, track, visitedNodes);
            traverseFromLeafNode(leaf.right, distance, track, visitedNodes);
        }
    }

    int pairsOfLeafNodes = 0;
    Map<TreeNode, TreeNode> parentMap;

    public int countPairs(TreeNode root, int distance) {
        List<TreeNode> leafNodes = new ArrayList<>();

        parentMap = new HashMap<>();

        addParents(root, null);
        traverseAndFindLeafNodes(leafNodes, root);

        for(TreeNode leaf : leafNodes) {
            traverseFromLeafNode(leaf, distance, 0,  new HashSet<TreeNode>());
        }
        
        
        return pairsOfLeafNodes/2;

    }
}


//      1(0, 0)
//   /     \
// 2(1,-1)   3(1, 1)
//   \
//     4(2, 0)


//     [ (2,0), (1,1) ].....

//     1, 2, 0, 4, 5, 6 , -1
