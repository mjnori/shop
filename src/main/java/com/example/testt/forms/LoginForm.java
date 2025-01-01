package com.example.testt.forms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {

    private String message;
    private String nickName;
    private String password;

    private String method;

    public String getMethod() {
        return method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


}
