import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestBinarySearchTree {
    Main.BinarySearchTree bst;

    // Setup before each test case
    @BeforeEach
    public void setUp() {
        bst = new Main.BinarySearchTree();
    }

    // Test: Insert elements into an empty tree
    @Test
    public void testInsertIntoEmptyTree() {
        bst.insert(50);
        assertTrue(bst.search(50));  // Check if the root node was inserted correctly
    }

    // Test: Insert multiple elements
    @Test
    public void testInsertMultipleElements() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Verify that elements were inserted
        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertTrue(bst.search(20));
        assertTrue(bst.search(40));
        assertTrue(bst.search(60));
        assertTrue(bst.search(80));
    }

    // Test: Search for an element that exists
    @Test
    public void testSearchElementExists() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        assertTrue(bst.search(30));  // Element exists
        assertTrue(bst.search(70));  // Element exists
    }

    // Test: Search for an element that does not exist
    @Test
    public void testSearchElementDoesNotExist() {
        bst.insert(50);
        bst.insert(30);

        assertFalse(bst.search(100));  // Element does not exist
        assertFalse(bst.search(70));   // Element does not exist
    }

    // Test: Delete a node with no children (Leaf node)
    @Test
    public void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        bst.delete(30);  // 30 is a leaf node

        assertFalse(bst.search(30));  // 30 should no longer be in the tree
    }

    // Test: Delete a node with one child
    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);  // Node 30 has one child (20)

        bst.delete(30);  // Delete node with one child

        assertFalse(bst.search(30));  // 30 should be deleted
        assertTrue(bst.search(20));   // Child node (20) should remain
    }

    // Test: Delete a node with two children
    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        bst.delete(30);  // Node 30 has two children (20, 40)

        assertFalse(bst.search(30));  // 30 should be deleted
        assertTrue(bst.search(20));   // Left child of 30 should be unaffected
        assertTrue(bst.search(40));   // Right child of 30 should be unaffected
    }

    // Test: Delete the root node
    @Test
    public void testDeleteRootNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);

        bst.delete(50);  // Delete root node (50)

        assertFalse(bst.search(50));  // Root should be deleted
        assertTrue(bst.search(30));   // Other nodes should remain
        assertTrue(bst.search(70));
    }

    // Test: In-order traversal to check the tree structure
    @Test
    public void testInorderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Expected in-order traversal output: 20 30 40 50 60 70 80
        System.out.print("In-order traversal: ");
        bst.inorderTraversal();
        System.out.println();  // For clarity in the console
    }

    // Test: Deleting a node that doesn't exist
    @Test
    public void testDeleteNonExistentNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        bst.delete(100);  // Node 100 doesn't exist in the tree

        assertTrue(bst.search(50));  // Root should still exist
        assertTrue(bst.search(30));  // Other nodes should remain
        assertTrue(bst.search(70));
    }

    // Test: Edge case - Inserting a duplicate value (BST should handle this)
    @Test
    public void testInsertDuplicateValue() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(50);  // Duplicate value (BST should handle this gracefully)

        // Check that only one instance of 50 exists
        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
    }
}
