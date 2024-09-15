import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.gateway.mesa.CadastrarMesaInterface;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;
import com.fiap.tc.restaurantes.infra.repository.MesaRepository;
import com.fiap.tc.restaurantes.infra.repository.mapper.MesaEntityMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarMesaAdapter implements CadastrarMesaInterface {

    private final MesaRepository mesaRepository;
    private final MesaEntityMapper mesaEntityMapper;

    @Override
    public Mesa cadastrarMesa(Long id, Mesa mesa) {
        MesaEntity mesaEntity = mesaEntityMapper.toMesaEntity(mesa);

        mesaEntity.setMesaId(id);
        MesaEntity mesaEntitySalva = mesaRepository.save(mesaEntity);

        return mesaEntityMapper.toMesa(mesaEntitySalva);
    }
}