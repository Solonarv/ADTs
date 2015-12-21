package com.solonarv.adts;

class Pair<T, U> implements Typed {
    public final T left;
    public final U right;
    
    public Pair(T left, U right){
        this.left = left;
        this.right = right;
    }
    
    public Pair<U, T> flip(){
        return new Pair<>(this.right, this.left);
    }
    
    public Sum<T, U> select(Side side){
        switch(side){
        case LEFT:
            return Sum.Left(this.left);
        case RIGHT:
            return Sum.Right(this.right);
        default: return null;
        }
    }
    
    @Override
    public boolean equals(Object other){
        if (other instanceof Pair){
            @SuppressWarnings("rawtypes")
			Pair p = (Pair) other;
            return this.left.equals(p.left) && this.right.equals(p.right);
        }
        return false;
    }
    
    @Override
    public Type type(){
        return new PairType(Type.getType(this.left), Type.getType(this.right));
    }
}