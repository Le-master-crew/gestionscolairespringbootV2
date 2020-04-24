package eu.ensup.gestionscolairespringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.ensup.gestionscolairespringboot.domaine.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Integer>{

	public Direction findByLoginAndPassword(String login,String password);
}
