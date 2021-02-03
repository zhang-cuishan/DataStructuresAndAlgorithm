package com.springchang.leetcode;

import java.util.HashMap;

class ParkingSystem {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        hashMap.put(1, big);
        hashMap.put(2, medium);
        hashMap.put(3, small);
    }

    public boolean addCar(int carType) {
        if(hashMap.get(carType) > 0) {
            hashMap.put(carType, hashMap.get(carType)-1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(2, 3, 3);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(1));

//        System.out.println(parkingSystem.addCar(1));
//        System.out.println(parkingSystem.addCar(1));
    }
}