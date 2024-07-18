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

    public void traverseAndFindLeafNodes(TreeNode root, int distance) {
        if(root == null) return;

        // add all the leaf nodes in the leafNodes list...
        if(root.left == null && root.right == null) {
            traverseFromLeafNode(root, distance, 0,  new HashSet<TreeNode>());
            return;
        }

        traverseAndFindLeafNodes(root.left,  distance);
        traverseAndFindLeafNodes(root.right, distance);
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

        parentMap = new HashMap<>();

        // storing the parents.....
        addParents(root, null);

        // storing the leaf nodes.....
        traverseAndFindLeafNodes(root, distance);

        // for(TreeNode leaf : leafNodes) {
        //     // traverse from each leaf node and get pairs...
        //     traverseFromLeafNode(leaf, distance, 0,  new HashSet<TreeNode>());
        // }
        
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
