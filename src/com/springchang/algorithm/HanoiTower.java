package com.springchang.algorithm;

/**
 * HanoiTower Algorithm
 * @author : 张翠山
 */
public class HanoiTower {

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }

    public static void move(int m,  char source, char helper, char target) {
        if(m == 1) {
            System.out.println("No."+m+": "+source+"->"+target);
        } else {
            move(m-1, source, target, helper); //A->B

            System.out.println("No."+m+": "+source+"->"+target); //A-C

            move(m-1, helper, source, target); //B->C
        }
    }
}
