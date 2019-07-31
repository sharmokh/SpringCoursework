package com.sharmokh.mongorecipeapp.services;

import com.sharmokh.mongorecipeapp.commands.UnitOfMeasureCommand;
import com.sharmokh.mongorecipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.sharmokh.mongorecipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    // Streem conversion of Unit of Measure to Unit of Measure Command
    @Override
    public Set<UnitOfMeasureCommand> listAllUnitOfMeasures() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                            .spliterator(), false)
                            .map(unitOfMeasureConverter::convert)
                            .collect(Collectors.toSet());
    }
}
