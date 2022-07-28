package com.shop.demo.Service;

import com.shop.demo.Repository.UnitRepository;
import com.shop.demo.dao.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    private UnitRepository unitRepository;
    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public void saveUnit(Unit unit) {
        this.unitRepository.save(unit);
    }

    public Unit getUnitById(Long id) {
        Optional<Unit> optionalUnit = unitRepository.findById(id);
        Unit unit = null;
        if(optionalUnit.isPresent()){
            unit = optionalUnit.get();
        }else{
            throw new RuntimeException("Nie znaleziono jednostki o id: " + id);
        }
        return unit;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        unitRepository.save(new Unit(1L,"piece","pc"));
        unitRepository.save(new Unit(2L,"gram","g"));
        unitRepository.save(new Unit(3L,"teaspoon","tsp"));
    }
}
