package LabWork_03;

import java.util.Scanner;

public class LongestCommonSubsequence_Me {
    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Заполнение таблицы динамического программирования
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую последовательность:");
        String s1 = scanner.nextLine();
        System.out.println("Введите вторую последовательность:");
        String s2 = scanner.nextLine();
        scanner.close();

        int result = lcs(s1, s2);
        System.out.println("Длина наибольшей общей последовательности: " + result);
    }
}
