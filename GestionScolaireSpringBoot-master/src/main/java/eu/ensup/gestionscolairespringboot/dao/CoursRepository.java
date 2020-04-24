/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensup.gestionscolairespringboot.dao;

import eu.ensup.gestionscolairespringboot.domaine.Cours;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lorris
 */
public interface CoursRepository extends JpaRepository<Cours, Integer>{
    
	public List<Cours> findAll();
}
