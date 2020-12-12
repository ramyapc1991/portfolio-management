package com.turvo.portfolio.management.controller;

import com.turvo.portfolio.management.model.Holding;
import com.turvo.portfolio.management.model.Pricing;
import com.turvo.portfolio.management.resources.HoldingDetails;
import com.turvo.portfolio.management.resources.PricingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/netValue")
public class NetValueController {

    @Autowired
    private HoldingDetails holdingDetails;

    @Autowired
    private PricingDetails pricing;

    @GetMapping("/getDetails")
    public Map<String, Double> getNetValue() {
        List<Holding> holdingList = holdingDetails.getHoldingData();
        List<Pricing> pricingList = pricing.getPriceDetails();
        Map<String, Double> res = getNetValue(holdingList, pricingList);
        return res;
    }

    private Map<String, Double> getNetValue(List<Holding> holdingList, List<Pricing> pricingList) {
        Map<String, Double> map = new HashMap<String, Double>();

        for (Holding holdingData : holdingList) {
            for (Pricing pricingData : pricingList) {
                String hlDate = holdingData.getDate();
                if (hlDate.equals(pricingData.getDate())) {
                    if (holdingData.getSecurity().equals(pricingData.getSecurity())) {
                        Double val = holdingData.getQuantity() * pricingData.getPrice();
                        if (map.containsKey(hlDate)) {
                            Double mapValue = map.get(hlDate);
                            map.replace(hlDate, mapValue + val);
                        } else
                            map.put(hlDate, val);
                    }
                }

            }
        }
        return map;
    }

}
