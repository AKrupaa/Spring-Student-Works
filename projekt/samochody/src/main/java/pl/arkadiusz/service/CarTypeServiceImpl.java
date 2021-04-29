package pl.arkadiusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.CarTypesRepository;
import pl.arkadiusz.domain.CarTypeDomain;

import java.util.List;

@Transactional
@Service("carTypeService")
public class CarTypeServiceImpl implements CarTypeService {

    CarTypesRepository repository;

    @Autowired
    public CarTypeServiceImpl(CarTypesRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarTypeDomain getType(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<CarTypeDomain> getTypes() {
        return repository.findAll();
    }

    @Override
    public CarTypeDomain getCarTypeByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public void removeType(String description) {
        repository.removeByDescription(description);
    }

    @Override
    public void removeType(long id) {
        repository.delete(id);
    }

    @Override
    public void editType(CarTypeDomain carTypeDomain) {
        repository.save(carTypeDomain);
    }

    @Override
    public void addType(CarTypeDomain carTypeDomain) {
        repository.save(carTypeDomain);
    }
}
