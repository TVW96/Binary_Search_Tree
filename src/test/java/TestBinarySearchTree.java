import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestBinarySearchTree {
    Main.BinarySearchTree bst;

    @BeforeEach
    public void setUp() {
        bst = new Main.BinarySearchTree();
    }

    @Test
    public void testInsert() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertFalse(bst.search(100));
    }

    @Test
    public void testDelete() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        bst.delete(20);
        bst.delete(30);

        assertFalse(bst.search(20));
        assertFalse(bst.search(30));
    }

    @Test
    public void testInorderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Output should be: 20 30 40 50 60 70 80
        bst.inorderTraversal();
    }
}
