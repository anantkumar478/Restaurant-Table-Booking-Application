package com.anantmathur.tablebookingapp.service;

import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public RestaurantTable addTable(RestaurantTable table) {
        return (RestaurantTable) tableRepository.save(table);
    }

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public Optional<RestaurantTable> getTableById(Long id) {
        return tableRepository.findById(id);
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
