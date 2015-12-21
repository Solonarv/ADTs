package com.solonarv.adts;

public class MaybeType extends Type {
    public static final MaybeType Nothing = new MaybeType();
    
    private final Type elemType;
    
    private MaybeType(){
        this.elemType = null;
    }
    
    public MaybeType(Type elemType){
        this.elemType = elemType;
    }
    
    @Override
    public String toString(){
        return this == Nothing ? "(forall T. Maybe<T>)" : "Maybe<" + this.elemType + ">";
    }
    
    @Override
    public boolean isSameType(Type other){
        if (other instanceof MaybeType){
            MaybeType maybeOther = (MaybeType) other;
            return this == Nothing
                    || maybeOther == Nothing
                    || this.elemType == maybeOther.elemType;
        } else return false;
    }
}