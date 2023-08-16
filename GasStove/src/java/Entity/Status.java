/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author int.thong.nk
 */
public class Status {
    private int statusCode;
    private String mess;

    public Status() {
    }

    public Status(int statusCode, String mess) {
        this.statusCode = statusCode;
        this.mess = mess;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    @Override
    public String toString() {
        return "Status{" + "statusCode=" + statusCode + ", mess=" + mess + '}';
    }
    
    
}
