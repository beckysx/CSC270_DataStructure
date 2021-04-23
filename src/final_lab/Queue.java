package final_lab;
public class Queue<T>
{
   protected Node<T> front;
   protected Node<T> back;
   protected long size = 0;

   public Queue()
   {
      front = null;
      back = null;
   }
   
   public void clear(){
      front=null;
      back=null;
      size=0;
   }

   public void push(T val)
   {
      Node<T> newEle = new Node<T>();  
      if(isEmpty())
      {
         newEle.val = val;
         newEle.next = null;
         front = newEle;
         back = newEle;
      }
      else
      {     
         newEle.val = val;
         newEle.next = null;
         back.next = newEle;
         back = newEle;
      }
      size++;
   }

   public T pop()
   {
      T oldEle = front.val;
      front = front.next;
      size--;
      return oldEle;
   } 
   
   public T top()
   {  
      if(isEmpty()){
         return null;}
      else{
         return front.val;}
         
   }  
    
   public boolean isEmpty()
   {
      return front==null;
   }

}
