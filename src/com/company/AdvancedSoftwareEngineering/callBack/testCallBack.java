package com.company.AdvancedSoftwareEngineering.callBack;

public class testCallBack {
    public void compute(int n, callBack callBack){
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        callBack.onComputeEnd();
    }
}
