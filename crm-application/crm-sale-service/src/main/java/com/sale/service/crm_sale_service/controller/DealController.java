package com.sale.service.crm_sale_service.controller;

import com.sale.service.crm_sale_service.model.Deal;
import com.sale.service.crm_sale_service.service.DealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final DealService dealService;
    public DealController(DealService service){
        this.dealService = service;
    }

    @GetMapping
    public List<Deal> getAllDeals(){
        return this.dealService.getAllDeals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deal> getDealById(@PathVariable Long id){
        Deal deal = this.dealService.getDealById(id);
        return deal == null? ResponseEntity.notFound().build(): ResponseEntity.ok(deal);
    }

    @PostMapping
    public Deal create(@RequestBody Deal deal){
        return this.dealService.createDeal(deal);
    }

    @PutMapping("/{id}")
    public Deal updateDeal(@PathVariable Long id, @RequestBody Deal deal){
        return this.dealService.updateDeal(id, deal);
    }

    @DeleteMapping("/{id}")
    public void deleteDeal(@PathVariable Long id){
        this.dealService.delete(id);
    }
}
