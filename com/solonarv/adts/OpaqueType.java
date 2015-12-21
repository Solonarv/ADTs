package com.solonarv.adts;

import java.util.HashMap;
import java.util.Map;

public class OpaqueType extends Type {
    private static Map<Class<?>, OpaqueType> pool = new HashMap<>();
    
    private Class<?> cls;
    
    private OpaqueType(Class<?> cls){
        this.cls = cls;
    }
    
    public static OpaqueType instance(Class<?> cls){
        OpaqueType type = pool.get(cls);
        if (type == null){
            type = new OpaqueType(cls);
            pool.put(cls, type);
        }
        return type;
    }
    
    @Override
    public String toString(){
        return this.cls.getName();
    }
    
    @Override
    public boolean isSameType(Type other){
        if (other instanceof OpaqueType){
            OpaqueType opaqueOther = (OpaqueType) other;
            return this.cls.equals(opaqueOther.cls);
        } else return false;
    }
}