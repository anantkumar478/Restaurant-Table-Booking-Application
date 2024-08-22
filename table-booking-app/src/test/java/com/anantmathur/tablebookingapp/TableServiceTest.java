package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.Controller.TableController;
import com.anantmathur.tablebookingapp.model.RestaurantTable;
import com.anantmathur.tablebookingapp.service.TableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TableServiceTest {

    @Mock
    private TableService tableService;

    @InjectMocks
    private TableController tableController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tableController).build();
    }

    @Test
    void testCreateTable() throws Exception {
        RestaurantTable table = new RestaurantTable(1L, 1L, 1, 4);
        when(tableService.addTable(table)).thenReturn(table);

        mockMvc.perform(post("/api/tables")
                        .contentType("application/json")
                        .content("{ \"restaurantId\": 1, \"tableNumber\": 1, \"totalSeats\": 4 }"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllTables() throws Exception {
        RestaurantTable table1 = new RestaurantTable(1L, 1L, 1, 4);
        RestaurantTable table2 = new RestaurantTable(2L, 1L, 2, 6);
        List<RestaurantTable> tables = Arrays.asList(table1, table2);

        when(tableService.getAllTables()).thenReturn(tables);

        mockMvc.perform(get("/api/tables"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetTableById() throws Exception {
        RestaurantTable table = new RestaurantTable(1L, 1L, 1, 4);

        when(tableService.getTableById(1L)).thenReturn(Optional.of(table));

        mockMvc.perform(get("/api/tables/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetTableById_NotFound() throws Exception {
        when(tableService.getTableById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/tables/1"))
                .andExpect(status().isNotFound());
    }
}
