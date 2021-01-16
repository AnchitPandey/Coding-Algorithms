/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        
      TreeMap<Integer, Integer> mapper = new TreeMap<Integer, Integer>(Collections.reverseOrder());
      while (poly1 != null)
        {  
            mapper.put (poly1.power, mapper.getOrDefault(poly1.power, 0) + poly1.coefficient);
            poly1 = poly1.next;
        }
        while (poly2 != null)
        {       
            mapper.put (poly2.power, mapper.getOrDefault(poly2.power, 0) + poly2.coefficient);
            poly2 = poly2.next;
        }
        PolyNode root = new PolyNode ();
        PolyNode travel = root;
        PolyNode temp = root;
        for (Map.Entry<Integer,Integer> me: mapper.entrySet()){
            
            if (me.getValue() ==0)
                continue;
            temp = travel;
            travel.power = me.getKey();
            travel.coefficient = me.getValue();
            travel = new PolyNode();        
            temp.next = travel;
        }     
        temp.next = null;
        if (root.coefficient ==0)
            return null;
        return root;
    }
}
