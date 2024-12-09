public class Main {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public static class BinarySearchTree {
        private TreeNode root;

        public BinarySearchTree() {
            root = null;
        }

        // Insert a value into the BST
        public void insert(int value) {
            root = insertRec(root, value);
        }

        private TreeNode insertRec(TreeNode root, int value) {
            if (root == null) {
                root = new TreeNode(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        // Search for a value in the BST
        public boolean search(int value) {
            return searchRec(root, value) != null;
        }

        private TreeNode searchRec(TreeNode root, int value) {
            if (root == null || root.value == value) {
                return root;
            }

            if (value < root.value) {
                return searchRec(root.left, value);
            } else {
                return searchRec(root.right, value);
            }
        }

        // Delete a value from the BST
        public void delete(int value) {
            root = deleteRec(root, value);
        }

        private TreeNode deleteRec(TreeNode root, int value) {
            if (root == null) {
                return root;
            }

            if (value < root.value) {
                root.left = deleteRec(root.left, value);
            } else if (value > root.value) {
                root.right = deleteRec(root.right, value);
            } else {
                // Node with only one child or no child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // Node with two children: Get the inorder successor (smallest in the right subtree)
                root.value = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRec(root.right, root.value);
            }

            return root;
        }

        // Get the smallest value node
        private int minValue(TreeNode root) {
            int minValue = root.value;
            while (root.left != null) {
                minValue = root.left.value;
                root = root.left;
            }
            return minValue;
        }

        // In-order traversal of the tree
        public void inorderTraversal() {
            inorderRec(root);
        }

        private void inorderRec(TreeNode root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.value + " ");
                inorderRec(root.right);
            }
        }
    }

}
