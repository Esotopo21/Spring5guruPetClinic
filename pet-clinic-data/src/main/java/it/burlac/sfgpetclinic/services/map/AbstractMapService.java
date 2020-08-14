package it.burlac.sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(this.map.values());
    }

    T findById(Long id){
        return this.map.get(id);
    }

    T save(T entity){
        if(entity != null){
            if (entity.getId() == null){
                entity.setId(getNextId());
            }
            this.map.put(entity.getId(), entity);
            return entity;
        }else {
            throw new RuntimeException("Object can't be null");
        }
    }

    void deleteById(ID id){
        this.map.remove(id);
    }

    void delete(BaseEntity entity){
        this.map.entrySet().removeIf(idtEntry -> idtEntry.equals(entity));
    }

    private Long getNextId(){
        Long nextId =  null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }


}
