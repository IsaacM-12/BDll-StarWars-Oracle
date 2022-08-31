package com.BDll.BDStarWars.interfaces;


import com.BDll.BDStarWars.models.Type;

import java.util.List;

public interface IType {
    public List<Type> findAllTypes();
    public Type findByTypeId(int id);
    public void deleteType(int id);
    public void updateType(Type type);
    public void insertType(Type type);
}
