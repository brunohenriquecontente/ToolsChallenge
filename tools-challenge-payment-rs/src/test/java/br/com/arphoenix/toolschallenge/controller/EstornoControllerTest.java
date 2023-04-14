package br.com.arphoenix.toolschallenge.controller;

import br.com.arphoenix.toolschallenge.dto.common.FormaPagamentoDTO;
import br.com.arphoenix.toolschallenge.dto.response.DescricaoResponseDTO;
import br.com.arphoenix.toolschallenge.dto.response.PagamentoResponseDTO;
import br.com.arphoenix.toolschallenge.dto.response.TransacaoResponseDTO;
import br.com.arphoenix.toolschallenge.enums.StatusPagamento;
import br.com.arphoenix.toolschallenge.enums.TipoPagamento;
import br.com.arphoenix.toolschallenge.repository.TransacaoRepository;
import br.com.arphoenix.toolschallenge.service.TransacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EstornoController.class)
public class EstornoControllerTest {

    @MockBean
    private TransacaoRepository transacaoRepository;

    @MockBean
    private TransacaoService transacaoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindAllPagamentosEstornados() throws Exception {

        UUID uuid = UUID.randomUUID();

        // First request
        PagamentoResponseDTO pagamentoResponseFirst = new PagamentoResponseDTO();
        TransacaoResponseDTO transacaoResponseDTOFirst = new TransacaoResponseDTO();
        transacaoResponseDTOFirst.setId(uuid);

        FormaPagamentoDTO formaPagamentoDTOFirst = new FormaPagamentoDTO();
        formaPagamentoDTOFirst.setParcelas(1);
        formaPagamentoDTOFirst.setTipo(TipoPagamento.AVISTA);

        DescricaoResponseDTO descricaoResponseDTOFirst = new DescricaoResponseDTO();
        LocalDateTime localDateTimeFirst = LocalDateTime.parse("2021-05-01T18:32:15");
        descricaoResponseDTOFirst.setDataHora(localDateTimeFirst);
        descricaoResponseDTOFirst.setValor("100,00");
        descricaoResponseDTOFirst.setEstabelecimento("Mercado Boa Vista");
        descricaoResponseDTOFirst.setStatus(StatusPagamento.CANCELADO);

        transacaoResponseDTOFirst.setCartao("5301477411370740");
        transacaoResponseDTOFirst.setFormaPagamento(formaPagamentoDTOFirst);
        transacaoResponseDTOFirst.setDescricao(descricaoResponseDTOFirst);

        pagamentoResponseFirst.setTransacao(transacaoResponseDTOFirst);

        // Second request
        PagamentoResponseDTO pagamentoResponseSecond = new PagamentoResponseDTO();
        TransacaoResponseDTO transacaoResponseDTOSecond = new TransacaoResponseDTO();
        transacaoResponseDTOSecond.setId(uuid);

        FormaPagamentoDTO formaPagamentoDTOSecond = new FormaPagamentoDTO();
        formaPagamentoDTOSecond.setParcelas(2);
        formaPagamentoDTOSecond.setTipo(TipoPagamento.AVISTA);

        DescricaoResponseDTO descricaoResponseDTOSecond = new DescricaoResponseDTO();
        LocalDateTime localDateTimeSecond = LocalDateTime.parse("2021-05-02T10:33:52");
        descricaoResponseDTOSecond.setDataHora(localDateTimeSecond);
        descricaoResponseDTOSecond.setValor("50,00");
        descricaoResponseDTOSecond.setEstabelecimento("Farmacia Popular");
        descricaoResponseDTOSecond.setStatus(StatusPagamento.CANCELADO);

        transacaoResponseDTOSecond.setCartao("4539986103818930");
        transacaoResponseDTOSecond.setFormaPagamento(formaPagamentoDTOSecond);
        transacaoResponseDTOSecond.setDescricao(descricaoResponseDTOSecond);

        pagamentoResponseSecond.setTransacao(transacaoResponseDTOSecond);

        List<PagamentoResponseDTO> pagamentoList = Stream.of(pagamentoResponseFirst, pagamentoResponseSecond).collect(Collectors.toList());

        when(transacaoService.getPagamentosEstornados()).thenReturn(pagamentoList);

        mockMvc.perform(
                        get("/estorno")
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].transacao.cartao").value(transacaoResponseDTOFirst.getCartao()))
                .andExpect(jsonPath("$[0].transacao.formaPagamento.parcelas").value(formaPagamentoDTOFirst.getParcelas()))
                .andExpect(jsonPath("$[0].transacao.formaPagamento.tipo").value(formaPagamentoDTOFirst.getTipo().toString()))
                .andExpect(jsonPath("$[0].transacao.descricao.valor").value(descricaoResponseDTOFirst.getValor()))
                .andExpect(jsonPath("$[0].transacao.descricao.dataHora").value(localDateTimeFirst.toString()))
                .andExpect(jsonPath("$[0].transacao.descricao.estabelecimento").value(descricaoResponseDTOFirst.getEstabelecimento()))
                .andExpect(jsonPath("$[1].transacao.cartao").value(transacaoResponseDTOSecond.getCartao()))
                .andExpect(jsonPath("$[1].transacao.formaPagamento.parcelas").value(formaPagamentoDTOSecond.getParcelas()))
                .andExpect(jsonPath("$[1].transacao.formaPagamento.tipo").value(formaPagamentoDTOSecond.getTipo().toString()))
                .andExpect(jsonPath("$[1].transacao.descricao.valor").value(descricaoResponseDTOSecond.getValor()))
                .andExpect(jsonPath("$[1].transacao.descricao.dataHora").value(localDateTimeSecond.toString()))
                .andExpect(jsonPath("$[1].transacao.descricao.estabelecimento").value(descricaoResponseDTOSecond.getEstabelecimento())
                );

        verify(transacaoService, times(1)).getPagamentosEstornados();

        verifyNoMoreInteractions(transacaoService);

    }

    @Test
    void shouldEstornarPagamento() throws Exception {
        // RESPONSE
        UUID uuid = UUID.randomUUID();
        PagamentoResponseDTO pagamentoResponse = new PagamentoResponseDTO();
        TransacaoResponseDTO transacaoResponseDTO = new TransacaoResponseDTO();
        transacaoResponseDTO.setId(uuid);

        FormaPagamentoDTO formaPagamentoResponseDTO = new FormaPagamentoDTO();
        formaPagamentoResponseDTO.setParcelas(1);
        formaPagamentoResponseDTO.setTipo(TipoPagamento.AVISTA);

        DescricaoResponseDTO descricaoResponseDTO = new DescricaoResponseDTO();
        LocalDateTime localDateTimeResponse = LocalDateTime.parse("2021-05-01T18:32:15");
        descricaoResponseDTO.setDataHora(localDateTimeResponse);
        descricaoResponseDTO.setValor("100,00");
        descricaoResponseDTO.setEstabelecimento("Mercado Boa Vista");
        descricaoResponseDTO.setStatus(StatusPagamento.CANCELADO);

        transacaoResponseDTO.setCartao("5301477411370740");
        transacaoResponseDTO.setFormaPagamento(formaPagamentoResponseDTO);
        transacaoResponseDTO.setDescricao(descricaoResponseDTO);

        pagamentoResponse.setTransacao(transacaoResponseDTO);


        when(transacaoService.updateById(uuid)).thenReturn(pagamentoResponse);

        mockMvc.perform(
                put("/estorno/{id}", uuid)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.transacao.id").value(uuid.toString()))
                .andExpect(jsonPath("$.transacao.descricao.status").value(StatusPagamento.CANCELADO.toString()));

        verify(transacaoService, times(1)).updateById(uuid);

        verifyNoMoreInteractions(transacaoService);
    }
}
