package com.example.EnumDemo.enumPackage;

public enum Size {
    S(0,30),M(31,49),L(50,Integer.MAX_VALUE);

    private int minRange;
    private int maxRange;

    private Size(int minRange, int maxRange){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }


}

