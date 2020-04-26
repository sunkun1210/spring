package com.example.sort.leetCode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result =addTwoNumber(l1,l2,0);
        int i=0;
        if (l1.val+l2.val>=10)i=1;
        if (l1.val+l2.val<10)i=0;
        while(l1.next!=null||l2.next!=null){
            ListNode temp =result;
            if (result.next!=null) temp =result.next;
            if (l1.next!=null){
                l1=l1.next;
            }else{
                l1=new ListNode(0);
            }
            if (l2.next!=null){
                l2=l2.next;
            }else{
                l2=new ListNode(0);
            }
            ListNode temp2=addTwoNumber(l1,l2,i);
            temp.next =temp2;
            if(l1!=null&&l2!=null){
                if (l1.val+l2.val>=10)i=1;
                if (l1.val+l2.val<10)i=0;
            }
        }
        if (i==1){
            ListNode end = new ListNode(1);
            result.next=end;
        }
        return result;
    }

    public  static ListNode addTwoNumber(ListNode l1, ListNode l2,int i) {
        ListNode result = new ListNode(0);
        int val1= 0;
        int val2= 0;
        if (l1!=null){
            val1= l1.val;
        }
        if (l2!=null){
            val2=  l2.val;
        }
        int val=val1+val2+i;
        result.val=val%10;
        return result;
    }


    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        //   ListNode node12 = new ListNode(4);
        //  ListNode node13 = new ListNode(3);
        //  node11.next=node12;
        //  node12.next=node13;

        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(4);
        node21.next=node22;
        // node22.next=node23;
        ListNode result= addTwoNumbers(node11,node21);
        System.out.println(result);
    }
    @Override
    public String toString() {

        String str=this.val+"";
        ListNode ll=this.next;
        while (ll!=null){
            str=str+"-->"+ll.val;
            ll=ll.next;
        }

        return str;
    }
}
