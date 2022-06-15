package controller;

import com.newlife.Newlife.dto.VeiculoDto;
import com.newlife.Newlife.dto.VeiculoForm;
import com.newlife.Newlife.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("veiculo")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    private final ConversionService conversionService;


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
    public ResponseEntity<?> atualizarVeiculo(@RequestParam String placa, @RequestBody VeiculoForm form){
        this.veiculoService.updateVeiculo(placa, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{placa}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Long id){
        this.veiculoService.deleteVeiculo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/allVeiculos")
    public @ResponseBody
    Page<VeiculoDto> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ){
        if(query==null){
            return this.veiculoService.findAll(pageable).map(entity -> this.conversionService.convert(entity, VeiculoDto.class));
        }
        return this.veiculoService.findAll(pageable,query).map(entity -> this.conversionService.convert(entity, VeiculoDto.class));
    }



}
