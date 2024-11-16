    //線形探索(番兵法)//
    import java.util.Scanner;
    class SeqSearchSen{
        //配列aの先頭n個の要素からkeyと一致する要素を線形探索(番兵法)//
        static int seqSearchSen(int[]a, int n, int key) {
            int i = 0;
            a[n] = key;//番兵を追加
    
            while (true){
                if (a[i] == key) //探索成功
                break;
                i++;
            }
        return i == n ? -1: i;
        }
    
        public static void main(String[] args) {
            Scanner stdIn = new Scanner(System.in);

            System.out.print("要素数:");
            int num = stdIn.nextInt();
            int[] x = new int[num+1];
            
            for (int i = 0; i<num; i++){
                System.out.print("x["+ i +"]:");
                x[i] = stdIn.nextInt();
            }
     
            System.out.print("探す値");
            int ky = stdIn.nextInt();

            for (int j = 0; j < num; j++) {
                System.out.println("   |  0  1  2  3  4  5  6 ");
                System.out.println("---+------------------------");
                System.out.print("   | "  );
                System.out.println(" *");
            
                for (int m = 0; m < num; m++) {
                    System.out.println("   |");
                }

            }

             int idx = seqSearchSen(x,num,ky);
                if (idx == -1)
                 System.out.println("その値は存在しません");
                else
                System.out.println("その値はx["+idx+"]にあります");
        }
    }