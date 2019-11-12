package com.moxin.design_pattern.principle.singleresponsbility;

/**
 * Created by geely
 */
public class Method {

    private void updateUserInfo(String userName,String address) {
        userName = "geely";
        address = "beijing";
    }

    // 不符合单一职责
    private void updateUserInfo(String userName,String... properties) {
        userName = "geely";
//        address = "beijing";
    }

    private void updateUsername(String userName) {
        userName = "geely";
    }
    private void updateUserAddress(String address) {
        address = "beijing";
    }

    // 不推荐使用，不符合单一职责
    private void updateUserInfo(String userName,String address,boolean bool) {
        if(bool){
            //todo something1
        }else{
            //todo something2
        }

        userName = "geely";
        address = "beijing";
    }


}
