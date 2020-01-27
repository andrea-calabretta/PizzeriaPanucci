package pizzeriaPanucci;

import java.util.List;

public interface ClienteDAO {
    public List<Cliente> getAllClienti();
    public Cliente getCliente(int id);
    public int insertCliente(Cliente c);
    public boolean updateCliente(Cliente c);
    public boolean deleteCliente(int idCliente);

}
