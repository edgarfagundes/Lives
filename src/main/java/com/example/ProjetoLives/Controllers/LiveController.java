package com.example.ProjetoLives.Controllers;

import com.example.ProjetoLives.Entities.Live;
import com.example.ProjetoLives.Servicies.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lives")
public class LiveController {

    @Autowired
    LiveService liveService;

    //lista todas as lives
    @GetMapping
    public ResponseEntity<Page<Live>> listaLive(Pageable pageable){
        Page<Live> livePage = (Page<Live>) liveService.findAll(pageable);
        if (livePage.hasContent()){
            return (ResponseEntity<Page<Live>>)
                    new ResponseEntity(livePage, HttpStatus.FOUND);
        }else {
            return (ResponseEntity<Page<Live>>)
                    new ResponseEntity(livePage, HttpStatus.NO_CONTENT);
        }
    }

    //lista uma única live pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<Live> listaLiveUnica(@PathVariable(value = "id")long id){
        Optional<Live> liveId = liveService.findById(id);
        if (liveId.isPresent()){
            return (ResponseEntity<Live>) new ResponseEntity(liveId, HttpStatus.FOUND);
        }else{
            return (ResponseEntity<Live>) new ResponseEntity(liveId, HttpStatus.NO_CONTENT);
        }
    }
    
    //Adiciona live
    @PostMapping
    public ResponseEntity<Live> adicionaLive(@RequestBody Live live){
        return (ResponseEntity<Live>) new ResponseEntity(live, HttpStatus.CREATED);
    }

    //Deleta live pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaLive(@PathVariable(value = "id") long id){
        Optional<Live> liveDelete = liveService.deleteById(id);
        if (liveService.existsById(id)){
            return new ResponseEntity(liveDelete, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(liveDelete, HttpStatus.BAD_REQUEST);
        }
    }

    //atualiza live
    @PutMapping("/{id}")
    public ResponseEntity<Live> atualizaLive(@RequestBody Live live,
                                             @PathVariable(value = "id")long id){
        Live liveAtualizada = liveService.save(live);
        if (!liveService.existsById(id)){
            return new ResponseEntity(live== null, HttpStatus.CONFLICT);
        }else{
            return new ResponseEntity(liveService.save(live), HttpStatus.OK);
        }
    }

}
