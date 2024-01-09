

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        Node temp=head;

        if(head==null||head.next==null)

        return head;

        Node prev=null;

        while(temp!=null)

        {

            prev=temp.prev;

            temp.prev=temp.next;

            temp.next=prev;

            temp=temp.prev;

        }

        return prev.prev;
    }
}
