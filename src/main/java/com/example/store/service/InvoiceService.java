package com.example.store.service;

import com.example.store.model.Invoice;
import com.example.store.model.InvoiceItem;
import com.example.store.model.Toy;
import com.example.store.repository.InvoiceRepository;
import com.example.store.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ToyRepository toyRepository;

//    Toy findById(Long id){
//
//    };

    public List<Invoice> findAll(){
       return invoiceRepository.findAll();
    };

    @Transactional
    public Invoice save(Invoice invoice){
        invoice.getInvoiceItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));
        Invoice saveedInvoce = invoiceRepository.save(invoice);
        List<InvoiceItem> invoiceItems = saveedInvoce.getInvoiceItems();

        for (InvoiceItem invoiceItem : invoiceItems) {
            Toy toy = invoiceItem.getToy();
            Optional<Toy> optionalToy = toyRepository.findById(toy.getId());
            Toy editableToy = optionalToy.get();
            editableToy.setCount(editableToy.getCount()+invoiceItem.getCount());
            toyRepository.save(editableToy);
        }

        return invoiceRepository.save(invoice);
    };

//    void deleteById(Long id);
//
//    boolean update(InvoiceDto invoiceDto, long id);
}
