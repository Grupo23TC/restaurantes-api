package com.fiap.tc.restaurantes.application.restaurante;


import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
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

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class CadastrarRestauranteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CadastrarRestauranteUseCase cadastrarRestauranteUseCase;

    @Mock
    private RestauranteMapper restauranteMapper;


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
        RestauranteResponse restauranteResponse = new RestauranteResponse(
                1L, "Nome", null, "MEXICANA"
                , 1, "10 as 11"
        );

        URI uri = URI.create("http://localhost/restaurantes/" + restauranteResponse.restauranteId());

        when(cadastrarRestauranteUseCase.cadastrarRestaurante(any(Restaurante.class))).thenAnswer(answer -> answer.getArgument(0));
        when(restauranteMapper.toRestaurante(any(CadastrarRestauranteRequest.class))).thenReturn(entidade);
        when(restauranteMapper.toRestauranteResponse(any(Restaurante.class))).thenReturn(restauranteResponse);

        // Act
        mockMvc.perform(post("/restaurantes")
                .content(JsonStringHelper.asJsonString(entidade))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(header().string("Location", uri.toString()))
            .andExpect(jsonPath("$.restauranteId").value(restauranteResponse.restauranteId()))
            .andExpect(jsonPath("$.nome").value(restauranteResponse.nome()))
            .andExpect(jsonPath("$.tipoDeCozinha").value(restauranteResponse.tipoDeCozinha()))
            .andExpect(jsonPath("$.capacidade").value(restauranteResponse.capacidade()))
            .andExpect(jsonPath("$.horarioFuncionamento").value(restauranteResponse.horarioFuncionamento()));
        ;

        verify(cadastrarRestauranteUseCase, times(1)).cadastrarRestaurante(any(Restaurante.class));
        verify(restauranteMapper, times(1)).toRestaurante(any(CadastrarRestauranteRequest.class));
        verify(restauranteMapper, times(1)).toRestauranteResponse(any(Restaurante.class));
    }
}