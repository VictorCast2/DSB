package com.DevSalud.DSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSalud.DSB.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel,Long>{

}
