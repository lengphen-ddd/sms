/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isoft.model;

/**
 *
 * @author ERROR
 */
public class Country {
    private int countryid;
    private String name;
    private String code;
    private String name1;
    private byte islocked;

    public Country(int countryid, String name, String code, String name1, byte islocked) {
        this.countryid = countryid;
        this.name = name;
        this.code = code;
        this.name1 = name1;
        this.islocked = islocked;
    }
    
    

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public byte getIslocked() {
        return islocked;
    }

    public void setIslocked(byte islocked) {
        this.islocked = islocked;
    }
    
    
}
