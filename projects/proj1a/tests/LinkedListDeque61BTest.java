import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {
    // test addFirst
    @Test
    public void addFirstToEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.addFirst(1);
        assertThat(lld.toList()).containsExactly(1).inOrder();
    }
    @Test
    public void addFirstToNonemptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.isEmpty()).isFalse();
        assertThat(lld.toList()).containsExactly(3, 2, 1).inOrder();
    }

    // test addLast
    @Test
    public void addLastToEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.addLast(1);
        assertThat(lld.toList()).containsExactly(1).inOrder();
    }
    @Test
    public void addLastToNonemptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertThat(lld.isEmpty()).isFalse();
        assertThat(lld.toList()).containsExactly(1, 2, 3).inOrder();
    }

    // test removeFirst
    @Test
    public void removeFirstFromEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        assertThat(lld.removeFirst()).isNull();
        assertThat(lld.toList()).isEmpty();
    }
    @Test
    public void removeFirstFromNonemptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.isEmpty()).isFalse();
        assertThat(lld.removeFirst()).isEqualTo(3);
        assertThat(lld.toList()).containsExactly(2, 1).inOrder();
    }
    @Test
    public void removeFromNearlyEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        assertThat(lld.removeFirst()).isEqualTo(1);
        assertThat(lld.toList()).isEmpty();
    }

    // test removeLast
    @Test
    public void removeLastFromEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        assertThat(lld.removeLast()).isNull();
        assertThat(lld.toList()).isEmpty();
    }
    @Test
    public void removeLastFromNonemptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.isEmpty()).isFalse();
        assertThat(lld.removeLast()).isEqualTo(1);
        assertThat(lld.toList()).containsExactly(3, 2).inOrder();
    }
    @Test
    public void removeLastFromNearlyEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        assertThat(lld.removeLast()).isEqualTo(1);
        assertThat(lld.toList()).isEmpty();
    }

    // test add after remove
    @Test
    public void addAfterRemoveFromEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.removeFirst();
        lld.addFirst(1);
        lld.addFirst(2);
        assertThat(lld.toList()).containsExactly(2, 1).inOrder();
    }
    @Test
    public void addAfterRemoveFromNearlyEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.removeFirst();
        lld.addFirst(3);
        assertThat(lld.toList()).containsExactly(3, 1).inOrder();
    }

    // test get
    @Test
    public void getValidTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(1)).isEqualTo(2);
    }
    @Test
    public void getOobLargeTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(100000)).isNull();
    }
    @Test
    public void getOobNegTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(-1)).isNull();
    }

    // test getRecursive
    @Test
    public void getRecursiveValidTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(0)).isEqualTo(3);
    }
    @Test
    public void getRecursiveOobLargeTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(100000)).isNull();
    }
    @Test
    public void getRecursiveOobNegTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.get(-1)).isNull();
    }

    // test size
    @Test
    public void sizeTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        assertThat(lld.size()).isEqualTo(2);
    }
    @Test
    public void sizeAfterAddToEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.addFirst(1);
        assertThat(lld.size()).isEqualTo(1);
    }
    @Test
    public void sizeAfterRemoveFromEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
        lld.removeFirst();
        assertThat(lld.size()).isEqualTo(0);
    }
    @Test
    public void sizeAfterRemoveFromNearlyEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.removeFirst();
        assertThat(lld.size()).isEqualTo(0);
    }

    // test isEmpty
    @Test
    public void isEmptyTrueTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
    }
    @Test
    public void isEmptyFalseTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        assertThat(lld.isEmpty()).isFalse();
    }

    // test toList
    @Test
    public void toListEmptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        assertThat(lld.toList()).isEmpty();
    }
    @Test
    public void toListNonemptyTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertThat(lld.toList()).containsExactly(3, 2, 1).inOrder();
    }

    @Test
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back");     // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle");   // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front");    // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

        /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["back"] and ["middle", "back"] failing,
            but not ["front", "middle", "back"].
            */
    }

    @Test
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");     // after this call we expect: ["front"]
        lld1.addLast("middle");    // after this call we expect: ["front", "middle"]
        lld1.addLast("back");      // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        /* I've decided to add in comments the state after each call for the convenience of the
           person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    public void isEmptyTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.isEmpty()).isTrue();

        lld1.addLast(1);
        assertThat(lld1.isEmpty()).isFalse();

        lld1.addLast(2);
        assertThat(lld1.isEmpty()).isFalse();

        lld1.removeLast();
        lld1.removeLast();
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void sizeTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.size()).isEqualTo(0);

        lld1.addLast(10);
        assertThat(lld1.size()).isEqualTo(1);

        lld1.addLast(15);
        assertThat(lld1.size()).isEqualTo(2);

        lld1.removeLast();
        assertThat(lld1.size()).isEqualTo(1);
    }

    @Test
    public void isEmptyAndSizeTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.isEmpty()).isTrue();
        assertThat(lld1.size()).isEqualTo(0);

        lld1.addLast(1);
        assertThat(lld1.isEmpty()).isFalse();
        assertThat(lld1.size()).isEqualTo(1);

        lld1.addLast(2);
        assertThat(lld1.isEmpty()).isFalse();
        assertThat(lld1.size()).isEqualTo(2);
    }

    @Test
    public void getTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);

        assertThat(lld1.get(0)).isEqualTo(1);

        assertThat(lld1.get(1)).isEqualTo(2);

        assertThat(lld1.get(-10)).isNull();

        assertThat(lld1.get(10000)).isNull();
    }

    @Test
    public void getRecursiveTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);

        assertThat(lld1.getRecursive(0)).isEqualTo(1);

        assertThat(lld1.getRecursive(1)).isEqualTo(2);

        assertThat(lld1.getRecursive(-10)).isNull();

        assertThat(lld1.getRecursive(10000)).isNull();
    }

    @Test
    public void removeFirstTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);

        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(3, 2, 1).inOrder();

        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(2, 1).inOrder();
    }

    @Test
    public void removeLastTestBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);

        lld1.removeLast();
        assertThat(lld1.toList()).containsExactly(1, 2, 3).inOrder();

        lld1.removeLast();
        assertThat(lld1.toList()).containsExactly(1, 2).inOrder();
    }

    @Test
    public void removeFirstAndRemoveLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);

        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(2, 3, 4).inOrder();

        lld1.removeLast();
        assertThat(lld1.toList()).containsExactly(2, 3).inOrder();
    }
}
