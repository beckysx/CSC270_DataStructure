package Lab4_NotePad;

import java.util.Stack;

public class History
{
   protected Stack<Boolean> undel=new Stack<Boolean>();//undo
   protected Stack<Integer> unpos=new Stack<Integer>();
   protected Stack<String> unChange=new Stack<String>();
   
   protected Stack<Boolean> redel=new Stack<Boolean>();//redo
   protected Stack<Integer> repos=new Stack<Integer>();
   protected Stack<String> reChange=new Stack<String>();
   
   

    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {
      
      undel.push(deletion);
      unpos.push(position);
      unChange.push(Change);
      redel.clear();
      repos.clear();
      reChange.clear();
      
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
      
      
      boolean del=undel.pop();
      int pos=unpos.pop();
      String change=unChange.pop();
      
      
      
      if(del){
         redel.push(false);
         reChange.push(change);
         repos.push(pos);
         note.insert(pos,change);
      }
      else {
         redel.push(true);
         reChange.push(change);
         repos.push(pos);
         note.remove(pos,change.length());
      }
      
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
        int pos=repos.pop();
        boolean del=redel.pop();
        String change=reChange.pop(); 
         
         if(del){
            undel.push(false);
            unChange.push(change);
            unpos.push(pos);
            note.insert(pos,change);
         }
         else {
            undel.push(true);
            unChange.push(change);
            unpos.push(pos);
            note.remove(pos,change.length());
         }
      
         	
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       return !unpos.empty();
       
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
       return !repos.empty();
   }
	

}


