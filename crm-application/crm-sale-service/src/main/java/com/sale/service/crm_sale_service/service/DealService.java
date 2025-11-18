package com.sale.service.crm_sale_service.service;

import com.sale.service.crm_sale_service.model.Deal;
import com.sale.service.crm_sale_service.repository.DealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    private final DealRepository dealRepository;
    public DealService(DealRepository repository){
        this.dealRepository = repository;
    }

    public Deal createDeal(Deal deal){
        return this.dealRepository.save(deal);
    }

    public List<Deal> getAllDeals(){
        return this.dealRepository.findAll();
    }

    public Deal getDealById(Long id){
        return this.dealRepository.findById(id).orElse(null);
    }

    public Deal updateDeal(Long id, Deal updated){
        Deal deal = this.dealRepository.findById(id).orElse(null);
        if(deal != null){
            deal.setTitle(updated.getTitle());
            deal.setStage(updated.getStage());
            deal.setStatus(updated.getStatus());
            deal.setExpectedCloseDate(updated.getExpectedCloseDate());
            deal.setAmount(updated.getAmount());
            return this.dealRepository.save(deal);
        }
        return null;
    }

    public void delete(Long id) {
        this.dealRepository.deleteById(id);
    }

}
