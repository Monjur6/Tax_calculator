package com.domain;

public class Imodel {
    private String gender;
    private int b_sal;
    private int h_rent;
    private int m_allowance;
    private int conveyance;
    private int f_bonus;
    private int others;

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public int getB_sal(){
        return b_sal;
    }
    public void setB_sal(int b_sal){
        this.b_sal = b_sal;
    }

    public int getH_rent(){
        return h_rent;
    }
    public void setH_rent(int h_rent){
        this.h_rent = h_rent;
    }
    public int getM_allowance(){
        return m_allowance;
    }
    public void setM_allowance(int m_allowance){
        this.m_allowance = m_allowance;
    }
    public int getConveyance(){
        return conveyance;
    }
    public void setConveyance(int conveyance){
        this.conveyance = conveyance;
    }
    public int getF_bonus(){
        return  f_bonus;
    }
    public void setF_bonus(int f_bonus){
        this.f_bonus = f_bonus;
    }
    public int getOthers(){
        return others;
    }
    public void setOthers(int others){
        this.others = others;
    }
}
