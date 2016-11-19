package org.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.opendevup.dao.EtudiantRepository;
import org.opendevup.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(TpSpringMvcApplication.class, args);
		EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
		/*Page<Etudiant> etds = etudiantRepository.chercherEtudiants("%i%",new PageRequest(0, 5));
		etds.forEach(e->System.out.println(e.getNom()));*/
		Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0, 5));
		etds.forEach(e->System.out.println(e.getEmail()));
	}
}
