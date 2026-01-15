//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package trDataAccess.Interfaces;

import java.util.List;

public interface trIDAO<T> {

    public boolean create(T entity)    throws Exception;
    public List<T> readAll()           throws Exception;   
    public boolean update(T entity)    throws Exception;
    public boolean delete(int id)  throws Exception;
    
    public T       readBy(Integer id)  throws Exception;

}
