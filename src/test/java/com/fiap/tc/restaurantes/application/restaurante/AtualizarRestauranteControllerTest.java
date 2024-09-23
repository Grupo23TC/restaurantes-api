package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.AtualizarRestauranteUseCase;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AtualizarRestauranteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AtualizarRestauranteUseCase atualizarRestauranteUseCase;

    @Mock
    private RestauranteMapper restauranteMapper;

    private RestauranteResponse restauranteResponse;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        AtualizarRestauranteController controller = new AtualizarRestauranteController(restauranteMapper, atualizarRestauranteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirAtualizarRestaurante() throws Exception {
        // Arrange
        Long id = 1L;
        Restaurante entidade = RestauranteHelper.gerarRestauranteValido();
        RestauranteResponse response = RestauranteHelper.gerarRestauranteResponse();

        when(atualizarRestauranteUseCase.atualizarRestaurante(id, entidade)).thenReturn(entidade);
        when(restauranteMapper.toRestauranteResponse(
                atualizarRestauranteUseCase.atualizarRestaurante(id, entidade)))
                .thenReturn(restauranteResponse);

        // Act
        mockMvc.perform(put("/restaurantes/{id}", id)
                .content(JsonStringHelper.asJsonString(response))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        verify(atualizarRestauranteUseCase, times(1)).atualizarRestaurante(any(Long.class), any(Restaurante.class));
    }

}