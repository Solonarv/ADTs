package com.solonarv.adts;

public class Maybe<T> implements Typed {
    public final boolean isNothing;
    private final T value;
    
    @SuppressWarnings("rawtypes")
	public final static Maybe Nothing = new Maybe();
    
    private Maybe(){
        this.isNothing = true;
        this.value = null;
    }
    
    public Maybe(T value){
        this.isNothing = false;
        this.value = value;
    }
    
    @Override
    public MaybeType type(){
        return this.isNothing ? MaybeType.Nothing : new MaybeType(Type.getType(this.value));
    }
}