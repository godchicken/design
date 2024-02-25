package com.godchicken.nftdiggest.core.constant;

import lombok.Getter;

@Getter
public enum Platform {
    U_BAN_QUAN("优版权","uBanQuan")
    ;

    Platform(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private String value;
}
