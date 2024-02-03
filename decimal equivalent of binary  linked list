class Solution
{
   long DecimalValue(Node head)
   {
       long ans =0;
       while(head!=null){
           ans = (ans<<1)%1000000007;
           ans = (ans + head.data)%1000000007;
           head = head.next;
       }
       return ans;
     
   }
}
