package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum ReservationStatus {

    PENDING("pending"),
    APPROVED("approved"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String name;

    ReservationStatus(String name) {
        this.name = name;
    }

    public static ReservationStatus of(String statusName) {
        for (ReservationStatus status : values()) {
            if (status.getName().equals(statusName)) {
                return status;
            }
        }

        throw new IllegalArgumentException("유효하지 않은 상태입니다: " + statusName);
    }
}
