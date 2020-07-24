import java.util.Scanner;

/**
 *
 * @author Punit
 */
public class SJF{
    
    public static void main(String[] args){
      
        // Shortest Job First
      
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Processes : ");
        int no = sc.nextInt();

        double ATAT = 0;
        double AWT = 0;
        double[] BT = new double[no];
        double[] CT = new double[no];
        double[] AT = new double[no];
        double[] TAT = new double[no];
        double[] WT = new double[no];
        int[] p = new int[no];

        
        System.out.println("Enter Burst Time of Processes : ");
        for(int i = 0;i<no;i++){
            BT[i] = sc.nextInt();
            p[i] = i+1;               //Initializing Process Numbers
        }
        
        //Arranging the Burst Time Array and the associated process numbers in Ascending Order
        double temp = 0;
        int temp2 = 0;
        for (int i = 0; i < no; i++) 
        {
            for (int j = i + 1; j < no; j++) { 
                if (BT[i] > BT[j]) 
                {
                    temp = BT[i];
                    BT[i] = BT[j];
                    BT[j] = temp;
                    
                    temp2= p[i];
                    p[i] = p[j];
                    p[j] = temp2;
                }
            }
        }
        
        //Copying the values of Burst Times values in Compute Time for temp.
        for(int i = 0;i<no;i++){
            CT[i] = BT[i];
        }
        
        //Completition Time 
        for(int i = 0;i<no;i++){
            if(i == 0){
                CT[i] = BT[i];
            }
            else{
                CT[i] = CT[i-1] + BT[i];       //imp
            }
        }
        
        
        for(int i = 0;i<no;i++){
            TAT[i] = CT[i] - AT[i];
        }
        
        for(int i = 0;i<no;i++){
            WT[i] =  TAT[i] - BT[i];
        }
        
        for(int i = 0;i<no;i++){
            ATAT = ATAT + TAT[i];
            AWT = AWT + WT[i];
            if(i == no-1){                    //Updating for Last Element 
                ATAT = ATAT/no;
                AWT = AWT/no;
            }
        }    
        
        System.out.println("Processes ||  BT  ||   CT  ||   TAT  ||   WT");
        
        for(int i = 0;i<no;i++){ 
            System.out.println("    P" + p[i] + "        " + BT[i] + "     " + CT[i] + "      " + TAT[i] + "      " + WT[i]);
        }
        
        System.out.println("ATAT : " + ATAT);
        System.out.println("AWT : " + AWT);
    }
    
}
