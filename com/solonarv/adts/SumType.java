package com.solonarv.adts;

public final class SumType extends Type {
    public final Type left;
    public final Type right;
    
    public SumType(Type left, Type right){
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString(){
        return "(" + this.left.toString() + " | " + this.right.toString() + ")";
    }
    
    @Override
    public boolean isSameType(Type other){
        if (other instanceof SumType){
            SumType sumOther = (SumType) other;
            return this.left.equals(sumOther.left) && this.right.equals(sumOther.right);
        } else return false;
    }
}