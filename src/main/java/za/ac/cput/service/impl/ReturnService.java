//Author: Faidh Adams 215060148
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Return;
import za.ac.cput.repository.impl.ReturnRepository;
import java.util.Set;

@Service
public class ReturnService implements IReturnService{

    private static ReturnService returnService = null;
    private ReturnRepository returnRepository = null;

    private ReturnService(){
        this.returnRepository = ReturnRepository.getRepository();
    }

    public static ReturnService getService(){
        if(returnService == null)
            returnService = new ReturnService();
        return returnService;
    }

    @Override
    public Return create(Return returns){
        return this.returnRepository.create(returns);
    }

    @Override
    public Return read(String returnId) {
        return this.returnRepository.read(returnId);
    }

    @Override
    public Return update(Return returns) {
        return this.returnRepository.update(returns);
    }

    @Override
    public boolean delete(String returnId) {
        return this.returnRepository.delete(returnId);
    }

    @Override
    public Set<Return> getAll(){
        return this.returnRepository.getAll();
    }
}
