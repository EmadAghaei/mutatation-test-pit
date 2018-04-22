package pit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CollectionTest {
    List<String> elemnts = null;
    @Before
    public void init() {
        //  collections = new pit.Collections();
        elemnts = new ArrayList<String>();
        elemnts.add("dog");
        elemnts.add("cat");
    }
    @Test
    public void sortTest() {
        Collections.sort(elemnts);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"cat", "dog"});
    }
    @Test
    public void binarySearchTest() {
        Collections.sort(elemnts);
       // Collections.binarySearch(elemnts, "cat");
        Assert.assertEquals(Collections.binarySearch(elemnts, "cat"), 0);
        List<String> elemnts2 = new ArrayList<String>();
        Collections.sort(elemnts2);
        //Collections.binarySearch(elemnts, "cat");
        Assert.assertEquals(Collections.binarySearch(elemnts2, "cat"), -1);

        List<String> elemnts3 = new ArrayList<String>();
        elemnts3.add("tiger");
        Collections.sort(elemnts3);
        //Collections.binarySearch(elemnts, "cat");
        Assert.assertEquals(Collections.binarySearch(elemnts3, "cat"), -1);


    }
    @Test
    public void reverseTest() {
        Collections.reverse(elemnts);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"cat", "dog"});
        elemnts.add("bee");
        elemnts.add("fish");
        elemnts.add("ant");
        elemnts.add("tiger");
        Collections.reverse(elemnts);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"tiger", "ant", "fish", "bee", "dog", "cat"});

        elemnts = new ArrayList<String>();
        elemnts.add("cat");
        elemnts.add("dog");
        elemnts.add("bee");
        elemnts.add("fish");
        elemnts.add("ant");
//        elemnts.add("tiger");
        Collections.reverse(elemnts);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{ "ant", "fish", "bee", "dog", "cat"});
    }

    @Test
    public void shuffleTest() {
        elemnts.add("bee");
        elemnts.add("fish");
        Collections.shuffle(elemnts);
        boolean bool = elemnts.toArray().equals(new String[]{"dog", "cat", "bee", "fish"});
        if (bool) {
            Collections.shuffle(elemnts);
            Assert.assertFalse(Arrays.equals(elemnts.toArray(), new String[]{"dog", "cat", "bee", "fish"}));
        }

        elemnts.add("bee");
        elemnts.add("fish");
        Collections.shuffle(elemnts);
        boolean bool2 = elemnts.toArray().equals(new String[]{"dog", "cat", "bee", "fish", "bee", "fish"});
        if (bool2) {
            Collections.shuffle(elemnts);
            Assert.assertFalse(Arrays.equals(elemnts.toArray(), new String[]{"dog", "cat", "bee", "fish", "bee", "fish"}));
        }
    }
    @Test
    public void swapTest() {
        Collections.swap(elemnts, 0, 1);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"cat", "dog"});
    }
    @Test
    public void fillTest() {
        Collections.fill(elemnts, "tiger");
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"tiger", "tiger"});
        elemnts.add("bee");
        elemnts.add("fish");
        elemnts.add("ant");
        elemnts.add("tiger");
        Collections.fill(elemnts, null);
        Assert.assertArrayEquals(elemnts.toArray(), new String[]{null, null, null, null, null, null});
    }
//    @Test
//    public void copyTest() {
//        List elementsDest = new ArrayList();
//        elementsDest.add("bee");
//        elementsDest.add("fish");
//        Collections.copy(elementsDest, elemnts);
//        Assert.assertArrayEquals(elementsDest.toArray(), new String[]{"dog", "cat"});
//    }
   @Test
    public void minAndMaxTest() {
        Assert.assertEquals(Collections.min(elemnts), "cat");
        Assert.assertEquals(Collections.max(elemnts), "dog");

    }
//    @Test
//    public void rotateTest() {
//        elemnts.add("bee");
//        elemnts.add("fish");
//        Collections.rotate(elemnts, 3);
//        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"cat", "bee", "fish", "dog"});
//        elemnts.add("ant");
//        elemnts.add("tiger");
//        Collections.rotate(elemnts, 3);
//        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"dog", "ant", "tiger", "cat", "bee", "fish",});
//    }
//    @Test
//    public void replaceAllTest() {
//        elemnts.add("dog");
//        elemnts.add("dog");
//        Collections.replaceAll(elemnts, "dog", "fish");
//        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"fish", "cat", "fish", "fish"});
//        elemnts.add("dog");
//        elemnts.add("dog");
//        Collections.replaceAll(elemnts, "dog", "fish");
//        Assert.assertArrayEquals(elemnts.toArray(), new String[]{"fish", "cat", "fish", "fish", "fish", "fish"});
//
//    }

//    @Test
//    public void indexOfSubListTest() {
//        elemnts.add("bee");
//        elemnts.add("fish");
//        List elements2 = new ArrayList();
//        elements2.add("bee");
//        elements2.add("fish");
//        int indedOf = Collections.indexOfSubList(elemnts, elements2);
//        Assert.assertEquals(indedOf, 2);
//
//    }

//    @Test
//    public void lastIndexOfSubListTest() {
//        elemnts.add("bee");
//        elemnts.add("fish");
//        elemnts.add("bee");
//        elemnts.add("fish");
//        List elements2 = new ArrayList();
//        elements2.add("bee");
//        elements2.add("fish");
//        int indedOf = Collections.lastIndexOfSubList(elemnts, elements2);
//        Assert.assertEquals(indedOf, 4);
//
//    }



}
