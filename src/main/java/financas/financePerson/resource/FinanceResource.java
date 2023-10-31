package financas.financePerson.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import financas.financePerson.dto.FinanceDTO;
import financas.financePerson.service.FinanceService;

import java.util.List;


@RestController
@RequestMapping("/finance")
public class FinanceResource {

    @Autowired
    private FinanceService financeService;

    @GetMapping
    public ResponseEntity<List<FinanceDTO>> listarFinancas(){
        return this.financeService.listarFinancas();
    }
}
