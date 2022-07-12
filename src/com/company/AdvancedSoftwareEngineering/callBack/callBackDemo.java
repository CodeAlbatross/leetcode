package com.company.AdvancedSoftwareEngineering.callBack;

public class callBackDemo {
    public static void main(String[] args) {
        new testCallBack().compute(1000, new callBack() {
            @Override
            public void onComputeEnd() {
                System.out.println("end back");
            }
        });
    }
}
