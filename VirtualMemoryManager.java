import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

public class VirtualMemoryManager{
    public static void main(String args[]){
        
        Scanner scanner = new Scanner(in);
        int opt;
        int stats[] = null; //To hold statistics init = ni;
        
        out.println("Select Your Preffered Simulation Type");
        out.println("1. Physical Memory Size = 256");
        out.println("2. Physical Memory Size = 128");
        out.println("3. Read/Write bits in address file");
        out.println("4. Close & Exit");
        
        opt = scanner.nextInt();
        while(opt != 1 && opt !=2 && opt !=3 && opt!=4){
            out.println("You have selected an Invalid input. Please Try again.");
            opt = scanner.nextInt();
        }
        
        VirtualMemoryManagerRW obj;
        
        switch(opt){
            case 1: obj = new VirtualMemoryManagerRW(args[0], 256, false);
                    stats = obj.run();
                    break;
            case 2: obj = new VirtualMemoryManagerRW(args[0], 128, false);
                    stats = obj.run();
                    break;   
            case 3: obj = new VirtualMemoryManagerRW(args[0], 256, true);
                    stats = obj.run();
                    break;
            case 4: return;
            default:
                    break;
        }
        
        //Calculating Statistics Here
        double tlbHitRate = (double)stats[1]/(double)stats[0]*100;
        double pageFaultRate = (double)stats[2]/(double)stats[0]*100;
        double writeBackRate = (double)stats[3]/(double)stats[0]*100;
        
        System.out.println("\nStatistics");
        System.out.println("Total Operations Calc = " + stats[0]);
        System.out.println("TLB Hit Rate = " + stats[1] + " >> " + Double.toString(tlbHitRate)+"%");
        System.out.println("Page Faults Rate = " + stats[2] + " >> " + Double.toString(pageFaultRate)+"%");
        if(stats[3]!=0){
                System.out.println("WriteBacks = " + stats[3] + " >> " + Double.toString(writeBackRate)+"%");
        }
            
    }
}