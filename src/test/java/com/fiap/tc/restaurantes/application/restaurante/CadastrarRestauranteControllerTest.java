package com.fiap.tc.restaurantes.application.restaurante;


import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CadastrarRestauranteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CadastrarRestauranteUseCase cadastrarRestauranteUseCase;

    @Mock
    private RestauranteMapper restauranteMapper;

    private RestauranteResponse restauranteResponse;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        CadastrarRestauranteController controller = new CadastrarRestauranteController(restauranteMapper, cadastrarRestauranteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirCadastrarRestaurante() throws Exception {
        // Arrange
        Restaurante entidade = RestauranteHelper.gerarRestauranteValido();
        restauranteResponse = new RestauranteResponse(
                1L, "Nome", null, "Mexicana"
                , 1, ""
        );

        when(cadastrarRestauranteUseCase.cadastrarRestaurante(entidade)).thenReturn(entidade);
        when(restauranteMapper.toRestauranteResponse(
                cadastrarRestauranteUseCase.cadastrarRestaurante(entidade)))
                .thenReturn(restauranteResponse);

        // Act
        mockMvc.perform(post("/restaurantes")
                .content(JsonStringHelper.asJsonString(entidade))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        verify(cadastrarRestauranteUseCase, times(1)).cadastrarRestaurante(any(Restaurante.class));
    }
}