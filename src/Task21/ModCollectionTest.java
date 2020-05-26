package Task21;


import org.junit.Assert;

class ModCollectionTest {

    @org.junit.jupiter.api.Test
    void size() {
        Integer[] mas = new Integer[]{1,2,3,4};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas);
        Assert.assertEquals(arr.size(), arr1.size());
    }

    void size1() {
        Integer[] mas = new Integer[]{1,2,3,4,1};
        Long[] mas1 = new Long[]{1l,2l,3l,4l,3l};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Long> arr1 = new ModCollection<Long>(mas1);
        Assert.assertEquals(arr.size(), arr1.size());
    }

    void size2() {
        Integer[] mas = new Integer[]{1,2,3,4,1};
        String[] mas1 = new String[]{"asbd", "asasd", "asdq", "erwfs", "ferds"};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<String> arr1 = new ModCollection<String>(mas1);
        Assert.assertEquals(arr.size(), arr1.size());
    }


    @org.junit.jupiter.api.Test
    void add() {
        Integer[] mas = new Integer[]{1,2,3};
        Integer[] mas1 = new Integer[]{4314,123,3};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas1);
        Assert.assertEquals(arr.getLast(), arr1.getLast());

    }

    void add1() {
        Integer[] mas = new Integer[3];
        Integer[] mas1 = new Integer[]{1,2,3};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas1);
        arr.add(1); arr.add(2); arr.add(3);
        arr1.add(3);
        Assert.assertEquals(arr.getLast(), arr1.get(3));
    }

    void add2(){
        Integer[] mas = new Integer[3];
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        Assert.assertEquals(arr.size(), mas.length);
    }


}