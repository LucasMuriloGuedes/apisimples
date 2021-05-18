package com.apicurso.cursoapi.services;

import com.apicurso.cursoapi.dominio.Usuario;
import com.apicurso.cursoapi.exceptions.ObjectNotFoundException;
import com.apicurso.cursoapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario findById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encotrado! Id: " + id + " Tipo: " + Usuario.class.getName()));

    }

    public List<Usuario> findAll() {
        List<Usuario> list = usuarioRepository.findAll();
        return list;
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario newObj = findById(id);
        newObj.setNome(usuario.getNome());
        newObj.setLogin(usuario.getLogin());
        newObj.setSenha(usuario.getSenha());
        return usuarioRepository.save(newObj);
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return usuarioRepository.save(obj);

    }

    public void delete(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
