package com.gideon.btgpactual.listener.dto;

import java.math.BigDecimal;

public record OrderItenEvent(String produto,
                             Integer quantidade,
                             BigDecimal preco) {
}