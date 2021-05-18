package com.apicurso.cursoapi.resources;

import com.apicurso.cursoapi.dominio.Usuario;
import com.apicurso.cursoapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
      List<Usuario> list = usuarioService.findAll();
      return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
        Usuario newObj = usuarioService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }
}
