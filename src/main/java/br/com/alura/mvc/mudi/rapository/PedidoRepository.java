package br.com.alura.mvc.mudi.rapository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.Query;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Cacheable("listarPorStatus")
    List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username AND p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido status, @Param("username") String username);

    // @PersistenceContext
    // private EntityManager entityManager;

    // public List<Pedido> recuperarTodosOsPadidos() {

    // Query query = entityManager.createQuery("select p from Pedido p",
    // Pedido.class);

    // return query.getResultList();
    // }
}
