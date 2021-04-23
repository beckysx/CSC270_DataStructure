package final_lab;

public class Stack<T>
{  
   
   protected Node<T> top;
   public long size=0;
   
   public Stack()
   {
      this.top = null;
   }

   public void push(T val)
   {
      Node<T> temp=new Node<T>();
      temp.val=val;
      temp.next=top;
      top=temp;
      size++;
   }

   public T pop()
   {
      T rmValue=top.val;
      top=top.next; 
      size--;        
      return rmValue;
   }
   
   public T top()
   {
                 
      return top.val;
   }
   
   public void clear(){
      top=null;
      size=0;
   }
   
    //reports if the stack is empty
   public boolean isEmpty()
   {
      return top==null;
   }


}

