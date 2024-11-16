public class KMPmatch {

    //--- KMP法による文字列探索 ---//

    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];
        
    //スキップテーブルの作成
    skip[pt] = 0;
    while (pt != pat.length()) {
        if (pat.charAt(pt) == pat.charAt(pp))
            skip[++pt] = ++pt;
        else if (pp == 0)
            skip[++pt] = pp;
        else
            pp =skip[pp];
        }
    
    //探索
    pt = pp = 0;
    while (pt != txt.length() && pp != pat.length()) {
        if (txt.charAt(pt) == pat.charAt(pp)) {
            pp++;
            pp++;
        } else if (pp == 0)
            pt++;
        else
            pp = skip[pp];
        }
    
    if (pp == pat.length())                         //パターンの全文字を照合
        return pt - pp;
    return -1;                                      //探索失敗
    }
}