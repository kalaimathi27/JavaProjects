import java.util.*;

class RandomizedSet {
    List<Integer> randSet;
    Map<Integer, Integer> randMap;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.randSet = new ArrayList<Integer>();
        this.randMap = new HashMap<Integer, Integer>();
        this.rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not
     * already contain the specified element. */
    public boolean insert(int val) {
        if(!randSet.contains(val)){
            randMap.put(val, randSet.size());
            randSet.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randSet.contains(val)){
            int index = randMap.get(val);
            int lastelmt = randSet.get(randSet.size()-1);
            randSet.set(index, lastelmt);
            randMap.put(lastelmt, index);
            randMap.remove(val);
            randSet.remove(randSet.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(randSet.size());
        if(index != 0){
            index -= 1;
        }
        return randSet.get(index);
    }

    public static void main(String[] args){
         RandomizedSet obj = new RandomizedSet();
         System.out.println(obj.insert(1));
         System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */