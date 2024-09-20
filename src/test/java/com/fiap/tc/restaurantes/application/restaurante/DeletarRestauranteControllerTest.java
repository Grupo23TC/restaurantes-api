package com.fiap.tc.restaurantes.application.restaurante;


import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.tc.restaurantes.utils.generic.JsonStringHelper;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeletarRestauranteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DeletarRestauranteUseCase deletarRestauranteUseCase;

    @Mock
    private RestauranteMapper restauranteMapper;

    private RestauranteResponse restauranteResponse;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        DeletarRestauranteController controller = new DeletarRestauranteController(restauranteMapper, deletarRestauranteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirDeletarRestaurante() throws Exception {
        // Arrange
        Long id = 1L;
        RestauranteResponse restauranteDeletado = RestauranteHelper.gerarRestauranteResponse();

        when(deletarRestauranteUseCase.deletarRestaurante(any(Long.class))).thenReturn(true);

        // Act & Assert
        mockMvc.perform(delete("/restaurantes/{id}", id)
                        .content(JsonStringHelper.asJsonString(restauranteDeletado))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());

        verify(deletarRestauranteUseCase, times(1)).deletarRestaurante(id);
    }
}