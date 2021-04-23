package Lab2_Array_Based_intList;

public class TestList{
   
   private static void testgetMaxSize(){
      
      IntList one = new IntList(10);
      
      assert one.getMaxSize()==10:"max size should be 10 not"+ one.getMaxSize();
      
      IntList two=new IntList(3);
      assert two.getMaxSize()==3:"Max size should be 3 not"+two.getMaxSize();
   
   }
   
   private static void testgetPos(){
      
      IntList one=new IntList(5);
      int num=1;
      for(int i=0;i<5;i++){
         one.insertBefore(num,i);
         num+=1;
         //[1,2,3,4,5]
      }
      
      assert one.getPos(2)==3:"Postion 2 should be 2 not"+one.getPos(2);
      assert one.getPos(5)==-1:"Postion 5 should be -1 not"+one.getPos(10);
      assert one.getPos(-1)==-1:"Position -1 nonexist should be -1 not"+one.getPos(-1);
         
   }
   
   private static void testremove(){
   
      IntList one=new IntList(5);
      int num=1;
      for(int i=0;i<5;i++){
         one.insertBefore(num,i);
         num+=1;
         //[1,2,3,4,5]
      }
      
      assert !one.remove(-1):"can't remove position -1";
      assert !one.remove(5):"can't remove position 5";
      one.remove(1);
      assert one.length()==4:"the length now is 4 not"+one.length();
      assert one.getPos(0)==1:"position 0 is 1 not"+one.getPos(0);
      assert one.getPos(1)==3:"position 1 is 3 not"+one.getPos(1);
      assert one.getPos(2)==4:"position 2 is 4 not"+one.getPos(2);
      assert one.getPos(3)==5:"position 3 is 5 not"+one.getPos(3);
      assert one.getPos(4)==-1:"position 4 is -1 not"+one.getPos(4);
     
      IntList two=new IntList(3);
      assert !two.remove(0):"can't remove position 0";
      
      IntList three=new IntList(1);
      three.insertBefore(1,0);
      assert !three.remove(-1):"can't remove position -1";
      assert !three.remove(1):"can't remove positon 1";
      three.remove(0);
      assert three.length()==0:"the length now should be 0 not"+three.length();
      assert three.getPos(0)==-1:"the postion 0 should be -1 not"+three.getPos(0);
      
      
         
   }
   
   private static void testinsertBefore(){
   
      IntList one=new IntList(5);
      int num=1;
      for(int i=0;i<4;i++){
         one.insertBefore(num,i);
         num+=1;
         //[1,2,3,4]
      }
      
           
      assert !one.insertBefore(2,-1):"can't insert number before position -1";
      assert !one.insertBefore(3,5):"can't insert number before position 5 ";
      one.insertBefore(7,2);//[1,2,7,3,4]
      assert one.getPos(0)==1:"position 0 is 1 not"+one.getPos(0);
      assert one.getPos(1)==2:"position 1 is 2 not"+one.getPos(1);
      assert one.getPos(2)==7:"position 2 is 7 not"+one.getPos(2);
      assert one.getPos(3)==3:"position 3 is 3 not"+one.getPos(3);
      assert one.getPos(4)==4:"position 4 is 4 not"+one.getPos(4);
      
      assert !one.insertBefore(8,0):"can't insert 8 before position 0";
      
   }
   
   public static void main(String [] args)
   {
   
      testgetMaxSize();
      testgetPos();
      testremove();
      testinsertBefore();
         
   }

   
}