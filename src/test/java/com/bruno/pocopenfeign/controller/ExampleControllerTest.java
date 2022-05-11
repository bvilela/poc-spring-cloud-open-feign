package com.bruno.pocopenfeign.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bruno.pocopenfeign.builders.JsonPlaceholderResponseDtoBuilder;
import com.bruno.pocopenfeign.builders.ViaCepResponseDtoBuilder;
import com.bruno.pocopenfeign.dto.JsonPlaceholderRequestDTO;
import com.bruno.pocopenfeign.service.JsonPlaceholderService;
import com.bruno.pocopenfeign.service.ViaCepService;
import com.google.gson.Gson;

class ExampleControllerTest {

    @Mock
	private ViaCepService viaCepService;
	
    @Mock
	private JsonPlaceholderService jsonPlaceholderService;

    @Spy
    @InjectMocks
    private ExampleController controller;
    
	@Autowired
	private MockMvc mockMvc;
    
    private final String cepMock = "01001000";

    @BeforeEach
    public void setup() {
        controller = new ExampleController(viaCepService, jsonPlaceholderService);
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldBuscarCep() throws Exception {
    	var dto = ViaCepResponseDtoBuilder.withRandomData();
        when(viaCepService.buscarCep(any(String.class))).thenReturn(dto);
		mockMvc.perform(get("/busca-cep/".concat(cepMock))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.cep", is(dto.cep())))
				.andExpect(jsonPath("$.logradouro", is(dto.logradouro())))
				.andExpect(jsonPath("$.complemento", is(dto.complemento())))
				.andExpect(jsonPath("$.bairro", is(dto.bairro())))
				.andExpect(jsonPath("$.localidade", is(dto.localidade())))
				.andExpect(jsonPath("$.uf", is(dto.uf())))
				.andExpect(jsonPath("$.ibge", is(dto.ibge())));
    }
    
    @Test
    void shouldCriarPost() throws Exception {
    	var dto = JsonPlaceholderResponseDtoBuilder.withRandomData();
        when(jsonPlaceholderService.post(any(JsonPlaceholderRequestDTO.class))).thenReturn(dto);
		mockMvc.perform(post("/criar-post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(dto))).andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.id").isNotEmpty())
				.andExpect(jsonPath("$.title", is(dto.title())))
				.andExpect(jsonPath("$.body", is(dto.body())))
				.andExpect(jsonPath("$.userId", is(dto.userId())));
    }
	
}
