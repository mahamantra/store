package com.example.store.service;

import com.example.store.model.BaseEntity;
import com.example.store.model.Invoice;
import com.example.store.model.InvoiceItem;
import com.example.store.model.Toy;
import com.example.store.repository.InvoiceRepository;
import com.example.store.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ToyRepository toyRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }


    @Transactional
    public void save(Invoice invoice) {
        List<InvoiceItem> invoiceItems = invoice.getInvoiceItems();

        List<Toy> toys = invoiceItems.stream()
                .map(InvoiceItem::getToy)
                .collect(Collectors.toList());

        List<Long> idList = toys.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toList());

        List<Toy> existToys = toyRepository.findByIdIn(idList);

        checkToys(toys, existToys);

        invoiceItems.forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        invoiceRepository.save(invoice);

        for (InvoiceItem invoiceItem : invoiceItems) {
            Toy toy = invoiceItem.getToy();
            for (Toy existToy : existToys) {
                if (toy.equals(existToy)) {
                    existToy.setCount(existToy.getCount() + invoiceItem.getCount());
                }
            }
        }

        toyRepository.saveAll(existToys);
    }

    private void checkToys(List<Toy> toys, List<Toy> existToys){
        for (Toy toy : toys) {
            if(!existToys.contains(toy)){
                throw new RuntimeException("Toy with id=" + toy.getId() + " not found");
            }
        }
    }
}
