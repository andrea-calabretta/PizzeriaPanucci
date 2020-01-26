package pizzeriaPanucci;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySQLClienteDAOImpl implements ClienteDAO {

    /** La query per l'inserimento di un nuovo cliente */
    private static final String CREATE_QUERY = "INSERT INTO Clienti (nome, cognome, email, indirizzo) VALUES (?,?,?,?)";
    /** La query per la lettura di un singolo cliente. */
    private static final String READ_QUERY = "SELECT id, nome, cognome, email, indirizzo FROM Clienti WHERE id = ?";
    /** La query per la lettura di tutti i clienti. */
    private static final String READ_ALL_QUERY = "SELECT id, nome, cognome, email, indirizzo FROM Clienti";
    /** La query per l'aggiornamento di un singolo cliente. */
    private static final String UPDATE_QUERY = "UPDATE Clienti SET nome=? , cognome=? WHERE id = ?";
    /** La query per la cancellazione di un singolo cliente. */
    private static final String DELETE_QUERY = "DELETE FROM Clienti WHERE id = ?";

    public List<Cliente> getAllClienti() {

        List customers = new LinkedList<Cliente>();
        Cliente customer = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            while (result.next()) {
                customer=new Cliente(result.getString(2) ,result.getString(3) ,result.getString(4) ,result.getString(5));
                customer.setId(result.getInt(1));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return customers;
    }

    public Cliente getCliente(int id) {
        Cliente customer= null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            if (result.next() && result != null) {
                customer=new Cliente(result.getString(2) ,result.getString(3) ,result.getString(4) ,result.getString(5));
                customer.setId(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return customer;
    }

    public int createCliente(Cliente c) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getCognome());
            preparedStatement.setString(3, c.getEmail());
            preparedStatement.setString(4, c.getIndirizzo());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();

            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return -1;
    }


    public boolean updateCliente(Cliente c) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, c.getId());
            preparedStatement.setString(2, c.getNome());
            preparedStatement.setString(3, c.getCognome());


            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteCliente(Cliente c) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, c.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    }

}
