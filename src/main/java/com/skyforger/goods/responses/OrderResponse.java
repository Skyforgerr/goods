package com.skyforger.goods.responses;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class OrderResponse {
    private Long orderId;
    private String userEmail;
    List<String> goodsInfo;

    public OrderResponse(Long orderId, String userEmail, List<String> goodsInfo) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.goodsInfo = goodsInfo;

    }
}
