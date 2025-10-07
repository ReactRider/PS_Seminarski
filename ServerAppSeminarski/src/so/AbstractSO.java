package so;

import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.RepositoryGeneric;

public abstract class AbstractSO {
    protected final Repository repository;
    
    public AbstractSO() {
        this.repository = new RepositoryGeneric();
    }
    
    public Object execute(Object o) throws Exception {
        try {
            preconditions(o);
            startTransaction();
            Object obj = executeOperation(o);
            commitTransaction();
            return obj;
        } catch(Exception ex) {
            rollbackTransaction();
            return ex;
        }
    }
    
    protected abstract void preconditions(Object o) throws Exception;
    
    private void startTransaction() throws Exception {
        ((DbRepository)repository).connect();
    }
    
    protected abstract Object executeOperation(Object o) throws Exception;
    
    protected void commitTransaction() throws Exception {
        ((DbRepository)repository).commit();
    }
    
    protected void rollbackTransaction() throws Exception {
        ((DbRepository)repository).rollback();
    }
    
}
