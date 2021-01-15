package com.xjl.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-12-28-9:52
 */
public class testmain {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(0);
        nums.add(1);
        for(int i=2;i<=30;i++){
            int num1 = nums.get(i-1);
            nums.add(nums.get(i-1)+nums.get(i-2));
        }
        System.out.println(nums);
    }
}