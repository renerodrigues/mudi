package br.com.alura.mvc.mudi.rapository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.Query;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long>{

    List<Pedido> findByStatus(StatusPedido status);

    // @PersistenceContext
    // private EntityManager entityManager;

    // public List<Pedido> recuperarTodosOsPadidos() {
       
    //     Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);

    //     return query.getResultList();
    // }
}
