//Author: Faidh Adams 215060148

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Sale;
import za.ac.cput.factory.SaleFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

public class SaleRepositoryTest {
    private static SaleRepository saleRepository;
    private Sale sale;

    @BeforeEach
    void setUp() {
        saleRepository = new SaleRepository();
        sale = SaleFactory.createSale(GenericHelper.generateId(), GenericHelper.generateId(),GenericHelper.generateId());
    }

    @Test
    void create() {
        Sale created = saleRepository.create(sale);
        assertEquals(created.getSaleId(), sale.getSaleId());
        System.out.println("Created: " + created.getSaleId() + " = Sale: " + sale.getSaleId());
    }

    @Test
    void read() {
        Sale read = saleRepository.read(sale.getSaleId());
        System.out.println("Sale being read: " + read);
    }

    @Test
    void update() {
        Sale updated = new Sale.Builder().copy(sale).setSaleId("0001").build();
        saleRepository.update(updated);
        System.out.println("Updated (" + updated.getSaleId() + "): " + updated.getSaleId()
                + " = Sale: (" + sale.getSaleId() + "): " + sale.getSaleId());
    }

    @Test
    void delete() {
        saleRepository.delete(sale.getSaleId());
        System.out.println("Deleted: " + sale.getSaleId());
    }
}
