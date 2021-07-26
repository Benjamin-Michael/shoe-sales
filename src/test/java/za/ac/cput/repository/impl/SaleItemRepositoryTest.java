//Author: Faidh Adams 215060148

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.SaleItem;
import za.ac.cput.factory.SaleItemFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

public class SaleItemRepositoryTest {
    private static SaleItemRepository saleItemRepository;
    private SaleItem saleItem;

    @BeforeEach
    void setUp() {
        saleItemRepository = new SaleItemRepository();
        saleItem = SaleItemFactory.createSaleItem(GenericHelper.generateId(), GenericHelper.generateId());
    }

    @Test
    void create() {
        SaleItem created = saleItemRepository.create(saleItem);
        assertEquals(created.getSaleItemId(), saleItem.getSaleItemId());
        System.out.println("Created: " + created.getSaleItemId() + " = SaleItem: " + saleItem.getSaleItemId());
    }

    @Test
    void read() {
        SaleItem read = saleItemRepository.read(saleItem.getSaleItemId());
        System.out.println("SaleItem being read: " + read);
    }

    @Test
    void update() {
        SaleItem updated = new SaleItem.Builder().copy(saleItem).setShoeId("0001").build();
        saleItemRepository.update(updated);
        System.out.println("Updated (" + updated.getSaleItemId() + "): " + updated.getShoeId()
                + " = SaleItem: (" + saleItem.getSaleItemId() + "): " + saleItem.getShoeId());
    }

    @Test
    void delete() {
        saleItemRepository.delete(saleItem.getShoeId());
        System.out.println("Deleted: " + saleItem.getShoeId());
    }
}
