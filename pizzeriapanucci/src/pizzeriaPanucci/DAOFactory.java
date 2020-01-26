package pizzeriaPanucci;

public abstract  class DAOFactory {
    public static final int MYSQL=0;
    public abstract ClienteDAO getClienteDAO();

    public static DAOFactory getDAOFactory(int database) {
        switch (database) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }

}
