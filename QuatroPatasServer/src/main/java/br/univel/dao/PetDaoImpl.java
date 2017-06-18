package br.univel.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.univel.model.Pet;

@Stateless
@Remote(PetDao.class)
public class PetDaoImpl implements PetDao {

	@PersistenceContext(unitName = "QuatroPatasServer-persistence-unit")
	EntityManager em;

	@Override
	public Pet salvar(Pet pet) {
		em.merge(pet);
		return pet;
	}

	@Override
	public List<Pet> buscarTodos() {
		Query q = em.createQuery("from Pet");

		return q.getResultList();
	}

	@Override
	public Pet inserir(Pet pet) {
		em.persist(pet);

		return pet;
	}

	@Override
	public void remover(Pet pet) {
		em.getReference(Pet.class, pet.getId());
		em.remove(pet);
	}

}
