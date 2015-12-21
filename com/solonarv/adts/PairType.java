package com.solonarv.adts;

public class PairType extends Type {
    public final Type left;
    public final Type right;
    
    public PairType(Type left, Type right){
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString(){
        return "(" + this.left.toString() + ", " + this.right.toString() + ")";
    }
    
    @Override
    public boolean isSameType(Type other){
        if (other instanceof PairType){
            PairType pairOther = (PairType) other;
            return this.left.equals(pairOther.left) && this.right.equals(pairOther.right);
        } else return false;
    }
}