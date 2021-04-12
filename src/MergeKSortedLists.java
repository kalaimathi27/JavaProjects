import java.util.*;
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = null;
        ListNode first = null;
        ListNode last = null;
        ListNode prev = null;

        SortedMap<Integer, ListNode[]> listMap = new TreeMap<Integer, ListNode[]>();
        for(int i = 0;i < lists.length; i++){
            ListNode list = lists[i];
            while(list != null){
                if(!listMap.containsKey(list.val)){
                    first = list;
                    last = null;
                    listMap.put(list.val, new ListNode[]{first, last});
                }
                else{
                    ListNode[] item = listMap.get(list.val);
                    first = item[0];
                    last = item[1];

                    if(item[1] == null){
                        item[1] = list;
                        item[0].next = item[1];
                    }
                    else{
                        last.next = list;
                        item[1] = list;
                    }
                    listMap.put(list.val, item);
                }
                list = list.next;
            }
        }
        for(Integer s : listMap.keySet()){
            ListNode[] item = listMap.get(s);
            if(prev == null){
                start = item[0];
            }
            else{
                prev.next = item[0];
            }
            if(item[1] == null){
                prev = item[0];
            }
            else {
                prev = item[1];
            }
        }
        return start;
    }
}
