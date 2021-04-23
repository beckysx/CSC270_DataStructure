package Lab4_NotePad;

public class TestStack{
   
     
   public static void main(String [] args)
   {
      
      IntStack one=new IntStack();
      one.push(1);
      one.push(3);
      one.push(5);
      assert one.isEmpty()==false:"the stack is not empty now";
      assert one.top()==5:"the top data is 1,not "+one.top();
  
      IntStack two=new IntStack();
 
   
      boolean caughtException;
      caughtException = false;
      
      
      try{two.top();}
      catch(StackUnderFlowException e){
         assert(true);
         caughtException=true;
      }
      assert(caughtException):"Cannot top() empty array.";

   
      caughtException = false;    
      try{two.pop();}
      catch(StackUnderFlowException e){
         assert(true);
         caughtException=true;
      }
      assert(caughtException):"Didn't catch the error.";

   
      assert two.isEmpty();
      one.pop();
      assert one.top()==3;
      one.pop();
      assert one.top()==1;
         
   

         
   }

}