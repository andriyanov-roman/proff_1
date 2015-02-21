package shop.supplier;

import shop.db_access.SupplierDAO;

public class SupplierUtility {
    SupplierDAO supplierDAO = new SupplierDAO();

    public void addSupplier(Supplier supplier) {
        if (supplierDAO.selectAll().contains(supplier)) {
            System.out.println("Supplier exists! Try again");
        } else {
            supplierDAO.executeUpdate(supplier);
            System.out.println("Supplier is valid");
        }
    }

}
