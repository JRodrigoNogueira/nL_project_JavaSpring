package controller;

import com.newlife.Newlife.dto.MoradorDto;
import com.newlife.Newlife.dto.MoradorForm;
import com.newlife.Newlife.dto.VeiculoDto;
import com.newlife.Newlife.service.MoradorService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("morador")
@AllArgsConstructor
public class MoradorController {

    private final MoradorService moradorService;

    private final ConversionService conversionService;

    @GetMapping("/{morador}")
    public ResponseEntity<?> getUserById(@PathVariable String morador){
        MoradorDto dto = this.moradorService.findByMorador(morador);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> criarMorador(@RequestBody MoradorForm form){
        this.moradorService.createMorador(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{morador}")
    @Transactional
    public ResponseEntity<?> atualizarMorador(@PathVariable String morador, @RequestBody MoradorForm form){
        this.moradorService.updateMorador(morador, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{morador}")
    public ResponseEntity<?> deletarMorador(@PathVariable String morador){
        this.moradorService.deleteMorador(morador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allMoradores")
    public @ResponseBody
    Page<MoradorDto> findAllPaginated(
            @RequestParam(required = false) String query,
            Pageable pageable
    ){
        if(query==null){
            return this.moradorService.findAll(pageable).map(entity -> this.conversionService.convert(entity, MoradorDto.class));
        }
        return this.moradorService.findAll(pageable,query).map(entity -> this.conversionService.convert(entity, MoradorDto.class));
    }


}
