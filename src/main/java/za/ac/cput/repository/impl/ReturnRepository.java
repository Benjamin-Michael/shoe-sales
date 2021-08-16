//Author: Faidh Adams 215060148
package za.ac.cput.repository.impl;
import za.ac.cput.entity.Return;
import java.util.HashSet;
import java.util.Set;

public class ReturnRepository implements IReturnRepository{
    private Set<Return> ReturnDb = null;
    private static ReturnRepository repository = null;

    public ReturnRepository() {
        ReturnDb = new HashSet<Return>();
    }

    public static ReturnRepository getRepository() {
        if(repository == null)
            repository = new ReturnRepository();
        return repository;
    }

    //Create
    @Override
    public Return create(Return returns) {
        this.ReturnDb.add(returns);
        return returns;
    }

    //Read
    @Override
    public Return read(String returnId) {
        Return returns = null;

        for (Return r : this.ReturnDb) {
            if (r.getReturnId().equalsIgnoreCase(returnId)) {
                returns = r;
                break;
            }
        }

        return returns;
    }

    //Update
    @Override
    public Return update(Return returns) {
        Return r = read(returns.getReturnId());

        if (r != null) {
            this.ReturnDb.remove(r);
            this.ReturnDb.add(returns);
        }

        return returns;
    }

    //Delete
    @Override
    public boolean delete(String returnId) {
        Return returns = read(returnId);

        if (returns != null)
            this.ReturnDb.remove(returns);
        return true;
    }

    @Override
    public Set<Return> getAll() {
        return ReturnDb;
    }

}
