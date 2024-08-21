package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.repository.TableRepository;
import com.anantmathur.tablebookingapp.service.TableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TableServiceTest {

    @Mock
    private TableRepository tableRepository;

    @InjectMocks
    private TableService tableService;

    private RestaurantTable table;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        table = new RestaurantTable(1L, 1L, 5, 4);
    }

    @Test
    void testAddTable() {
        when(tableRepository.save(any(RestaurantTable.class))).thenReturn(table);
        RestaurantTable createdTable = tableService.addTable(table);
        assertNotNull(createdTable);
        assertEquals(1L, createdTable.getTableId());
    }

    @Test
    void testGetAllTables() {
        List<RestaurantTable> tables = Arrays.asList(table);
        when(tableRepository.findAll()).thenReturn(tables);
        List<RestaurantTable> foundTables = tableService.getAllTables();
        assertFalse(foundTables.isEmpty());
        assertEquals(1, foundTables.size());
    }

    @Test
    void testGetTableById() {
        when(tableRepository.findById(1L)).thenReturn(Optional.of(table));
        Optional<RestaurantTable> foundTable = tableService.getTableById(1L);
        assertTrue(foundTable.isPresent());
        assertEquals(1L, foundTable.get().getTableId());
    }

    @Test
    void testDeleteTable() {
        doNothing().when(tableRepository).deleteById(1L);
        tableService.deleteTable(1L);
        verify(tableRepository, times(1)).deleteById(1L);
    }
}
