package LabWork_03;

import java.util.*;

public class LongestCommonSubsequence {

    // Возвращает длину LCS для X[0..m-1], Y[0..n-1]
    int lcs(String X, String Y, int m, int n)
    {
        int L[][] = new int[m + 1][n + 1];

        // Следующие шаги строят L[m+1][n+1] снизу вверх
        // моды. Заметим, что L[i][j] содержит длину LCS
        // из X[0..i-1] и Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    // Полезная функция для получения максимального значения из 2 целых чисел
    int max(int a, int b) { return (a > b) ? a : b; }

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs
                = new LongestCommonSubsequence();
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is"
                + " " + lcs.lcs(S1, S2, m, n));
    }
}
