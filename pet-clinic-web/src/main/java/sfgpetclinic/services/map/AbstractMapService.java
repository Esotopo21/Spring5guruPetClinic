package sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(this.map.values());
    }

    T findById(ID id){
        return this.map.get(id);
    }

    T save(ID id, T t){
        return this.map.put(id,t);
    }

    void delete(T t){
        this.map.entrySet().removeIf(idtEntry -> idtEntry.equals(t));
    }


}
