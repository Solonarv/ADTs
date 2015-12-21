package com.solonarv.adts;

import java.util.function.Function;

public class Sum<T, U> implements Typed {
    private final Side theSide;
    private final T leftE;
    private final U rightE;
    
    private Sum(T left, U right, Side side){
        this.leftE = left;
        this.rightE = right;
        this.theSide = side;
    }
    
    public static <T, U> Sum<T, U> Left(T val){
        return new Sum<>(val, null, Side.LEFT);
    }
    
    public static <T, U> Sum<T, U> Right(U val){
        return new Sum<>(null, val, Side.RIGHT);
    }
    
    public Side side(){
        return this.theSide;
    }
    
    public <V> Sum<V, U> mapLeft(Function<? super T, V> f){
        if (this.theSide == Side.LEFT){
            return Left(f.apply(this.leftE));
        } else return Right(this.rightE);
    }
    
    public <V> Sum<T, V> mapRight(Function<? super U, V> f){
        if (this.theSide == Side.RIGHT){
            return Right(f.apply(this.rightE));
        } else return Left(this.leftE);
    }
    
    @SuppressWarnings("unchecked")
	public Maybe<T> left(){
        if (this.theSide == Side.LEFT){
            return new Maybe<>(this.leftE);
        } else return Maybe.Nothing;
    }
    
    @SuppressWarnings("unchecked")
	public Maybe<U> right(){
        if (this.theSide == Side.RIGHT){
            return new Maybe<>(this.rightE);
        } else return Maybe.Nothing;
    }
    
    @Override
    public Type type(){
        return new SumType(Type.getType(this.leftE), Type.getType(this.rightE));
    }
}