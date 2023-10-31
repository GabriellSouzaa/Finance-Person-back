package financas.financePerson.dto;

import lombok.Getter;
import financas.financePerson.model.Finance;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FinanceDTO {

    private String descricao;

    private BigDecimal preco;

    public FinanceDTO(Finance pizza){
        this.descricao = pizza.getDescricao();
        this.preco = pizza.getPreco();
    }
    public static List<FinanceDTO> converter(List<Finance> pizza){
        return pizza.stream().map(FinanceDTO::new).collect(Collectors.toList());
    }
}
