package com.erendev.keys;

import io.realm.RealmObject;

public class PasswordModel extends RealmObject {


    String pName, usrPwd, usrDesc;



    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getUsrDesc() {
        return usrDesc;
    }

    public void setUsrDesc(String usrDesc) {
        this.usrDesc = usrDesc;
    }
}
