import java.util.Scanner;

public class SeqSearch2{
    //---配列aの先頭n個の要素からkeyと一致する要素を線形探索---//
    static int seqSearch(int[]a,int n,int key){
        int i = 0;

        while (true){
            if (i ==n)
            return -1;
            if (a[i] == key)
            return i;
            i++;
        }
    }

    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("要素数:");
        int num = stdIn.nextInt();
        int[]x = new int[num];

    
        for (int i = 0;i<num;i++){
            System.out.print("x["+ i +"]:");
            x[i] = stdIn.nextInt();
        }

        System.out.print("探す値");

        long startTime = System.currentTimeMillis();
        
        int ky = stdIn.nextInt();
        int idx = seqSearch(x,num,ky);
        if (idx == -1)
            System.out.println("その値は存在しません");
            else
            System.out.println("その値はx["+idx+"]にあります");
            
            long endTime = System.currentTimeMillis();

            System.out.println("開始時刻：" + startTime + " ms");
            System.out.println("終了時刻：" + endTime + " ms");
            System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}