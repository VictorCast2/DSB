package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSalud.DSB.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel,Long>{

}
