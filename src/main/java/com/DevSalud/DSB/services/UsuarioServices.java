package com.DevSalud.DSB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.model.UsuarioModel;
import com.DevSalud.DSB.repository.UsuarioRepository;

@Service
public class UsuarioServices {
    @Autowired
    private  UsuarioRepository usuarioRepository;

    //*El metodo listarUsuario no se si hay que ponerlo telo encargado victor and yublian */

    //*Metodo para guardar los usuarios */
    public UsuarioModel guardarUsuarios(UsuarioModel usuariomodel){
        return usuarioRepository.save(usuariomodel);
    }

    //*Metodo para buscar a un usuario por id */
    public UsuarioModel  buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //*Metodo para actualizar a un usuario */
    public UsuarioModel actualizarUsuario(UsuarioModel usuariomodel){
        return usuarioRepository.save(usuariomodel);
    }

    //*Metodo que elimina a un usuario */
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }



}
