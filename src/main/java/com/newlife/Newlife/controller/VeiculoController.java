package controller;

import com.newlife.Newlife.dto.VeiculoDto;
import com.newlife.Newlife.dto.VeiculoForm;
import com.newlife.Newlife.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("veiculo")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping()
    public ResponseEntity<?> getUserById(@RequestParam String placa){
        VeiculoDto dto = this.veiculoService.findByPlaca(placa);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> criarVeiculo(@RequestBody VeiculoForm form){
        this.veiculoService.createVeiculo(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{placa}")
    @Transactional
    public ResponseEntity<?> atualizarVeiculo(@PathVariable String placa, @RequestBody VeiculoForm form){
        this.veiculoService.updateVeiculo(placa, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{placa}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable String placa){
        this.veiculoService.deleteVeiculo(placa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
